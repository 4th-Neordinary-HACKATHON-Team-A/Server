package com.rememory.service;

import com.rememory.domain.image.Image;
import com.rememory.domain.image.ImageRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import com.rememory.dto.ImageSaveRequestDto;
import com.rememory.exception.CustomException;
import com.rememory.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void imageSave(ImageSaveRequestDto requestDto) {
        User user = this.userRepository.findById(requestDto.getUserId())
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        imageRepository.save(
                Image.builder()
                     .imageSrc(requestDto.getImageSrc())
                     .user(user)
                     .build()
        );
    }
}
