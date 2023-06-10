package com.rememory.service;

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
import com.rememory.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long savePost(PostSaveRequestDto requestDto){
        User user = this.userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 정보가 존재하지 않습니다."));

        Image image = this.imageRepository.findById(requestDto.getImageId())
                .orElseThrow(() -> new RuntimeException("이미지 정보가 존재하지 않습니다."));

        return this.postRepository.save(
                Post.builder()
                        .title(requestDto.getTitle())
                        .content(requestDto.getContent())
                        .category(requestDto.getCategory())
                        .user(user)
                        .image(image)
                        .build()
        ).getId();
    }

    @Transactional
    public void registerLike(Long postId, Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 정보가 존재하지 않습니다."));

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글 정보가 존재하지 않습니다."));

        post.increaseLike();

        this.likeRepository.save(
                Like.builder()
                        .isLiked(true)
                        .build()
        );
    }

    @Transactional
    public Long saveComment(CommentSaveRequestDto requestDto){
        User user = this.userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 정보가 존재하지 않습니다."));

        Post post = this.postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new RuntimeException("게시글 정보가 존재하지 않습니다."));

        return commentRepository.save(
                Comment.builder()
                        .text(requestDto.getText())
                        .user(user)
                        .post(post)
                        .build()
        ).getId();
    }
}
