package com.rememory.controller;

import com.rememory.dto.PostSaveRequestDto;
import com.rememory.dto.UserSaveRequestDto;
import com.rememory.service.PostService;
import com.rememory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/post")
public class PostApiController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PostSaveRequestDto requestDto){
        Long postId = postService.save(requestDto);
        return ResponseEntity.created(URI.create("/detail"+postId)).build();
    }
}
