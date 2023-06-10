package com.rememory.service;

import com.rememory.domain.image.Image;
import com.rememory.domain.image.ImageRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import com.rememory.dto.ImageSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void save(ImageSaveRequestDto requestDto){
        User user = this.userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 정보가 존재하지 않습니다."));

        this.imageRepository.save(
                Image.builder()
                        .imageSrc(requestDto.getImageSrc())
                        .user(user)
                        .build()
        );
    }
}
