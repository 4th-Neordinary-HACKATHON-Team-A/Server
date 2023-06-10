package com.rememory.service;

import com.rememory.domain.comment.Comment;
import com.rememory.domain.comment.CommentRepository;
import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import com.rememory.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto){
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
