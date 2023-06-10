package com.rememory.service;

import com.rememory.domain.image.Image;
import com.rememory.domain.image.ImageRepository;
import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
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

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
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
}
