package com.rememory.controller;

import com.rememory.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rememory/post/{postId}/{userId}/like")
@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Void> registerLike(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "userId") Long userId
    ) {
        this.likeService.registerLike(postId, userId);
        return ResponseEntity.ok().build();
    }
}
