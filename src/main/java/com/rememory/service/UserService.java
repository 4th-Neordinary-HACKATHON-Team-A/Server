package com.rememory.service;

import com.rememory.domain.user.UserRepository;
import com.rememory.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserSaveRequestDto requestDto){
        userRepository.save(requestDto.toEntity());
    }
}
