package com.rememory.controller;

import com.rememory.dto.PostSaveRequestDto;
import com.rememory.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/post")
public class PostApiController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PostSaveRequestDto requestDto){
        postService.save(requestDto);
        return ResponseEntity.ok().build();
    }
}
