package com.rememory.service;

import com.rememory.domain.user.UserRepository;
import com.rememory.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    public void userSave(UserSaveRequestDto requestDto) {
        userRepository.save(requestDto.toEntity());
    }
}
