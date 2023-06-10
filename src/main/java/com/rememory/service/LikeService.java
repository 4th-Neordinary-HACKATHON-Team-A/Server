package com.rememory.service;

import com.rememory.domain.like.Like;
import com.rememory.domain.like.LikeRepository;
import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikeService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

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
}

