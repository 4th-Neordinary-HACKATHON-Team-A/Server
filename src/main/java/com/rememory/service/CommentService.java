package com.rememory.service;

import com.rememory.domain.comment.CommentRepository;
import com.rememory.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto){
        return commentRepository.save(requestDto.toEntity()).getId();
    }
}
