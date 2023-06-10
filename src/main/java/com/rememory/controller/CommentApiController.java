package com.rememory.controller;

import com.rememory.dto.CommentSaveRequestDto;
import com.rememory.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/comment")
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CommentSaveRequestDto requestDto){
        commentService.save(requestDto);
        return ResponseEntity.ok().build();
    }
}
