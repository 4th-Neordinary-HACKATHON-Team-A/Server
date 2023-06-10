package com.rememory.service;

import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.UserRepository;
import com.rememory.dto.PostSaveRequestDto;
import com.rememory.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }
}
