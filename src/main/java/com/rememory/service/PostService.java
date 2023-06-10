package com.rememory.service;

import com.rememory.domain.category.Category;
import com.rememory.domain.category.CategoryRepository;
import com.rememory.domain.comment.Comment;
import com.rememory.domain.comment.CommentRepository;
import com.rememory.domain.image.Image;
import com.rememory.domain.image.ImageRepository;
import com.rememory.domain.like.Like;
import com.rememory.domain.like.LikeRepository;
import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import com.rememory.dto.CommentSaveRequestDto;
import com.rememory.dto.PostResponseDto;
import com.rememory.dto.PostSaveRequestDto;
import com.rememory.exception.CustomException;
import com.rememory.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void savePost(PostSaveRequestDto requestDto) {

        User user = this.userRepository.findById(requestDto.getUserId())
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Image image = this.imageRepository.findById(requestDto.getImageId())
                                          .orElseThrow(() -> new CustomException(ErrorCode.IMAGE_NOT_FOUND));

        Category category = this.categoryRepository.findById(requestDto.getCategoryId())
                                                   .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));
        this.postRepository.save(
                Post.builder()
                    .title(requestDto.getTitle())
                    .content(requestDto.getContent())
                    .category(category)
                    .user(user)
                    .image(image)
                    .build()

        );
    }

    @Transactional
    public List<PostResponseDto> findByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                                                   .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        return postRepository.findByCategory(category).stream()
                             .map(PostResponseDto::new)
                             .collect(Collectors.toList());
    }

    @Transactional
    public void registerLike(Long postId, Long userId) {
        User user = this.userRepository.findById(userId)
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Post post = this.postRepository.findById(postId)
                                       .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        post.increaseLike();

        this.likeRepository.save(
                Like.builder()
                    .isLiked(true)
                    .user(user)
                    .post(post)
                    .build()
        );
    }

    @Transactional
    public void saveComment(CommentSaveRequestDto requestDto) {
        User user = this.userRepository.findById(requestDto.getUserId())
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Post post = this.postRepository.findById(requestDto.getPostId())
                                       .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        this.commentRepository.save(
                Comment.builder()
                       .text(requestDto.getText())
                       .user(user)
                       .post(post)
                       .build()
        );
    }
}
