package com.rememory.controller;

import com.rememory.domain.post.Post;
import com.rememory.dto.CommentSaveRequestDto;
import com.rememory.dto.PostResponseDto;
import com.rememory.dto.PostSaveRequestDto;
import com.rememory.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/post")
public class PostApiController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody @Valid PostSaveRequestDto requestDto) {
        this.postService.savePost(requestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{postId}/{userId}/like")
    public ResponseEntity<Void> registerLike(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "userId") Long userId
    ) {
        this.postService.registerLike(postId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> createComment(@RequestBody @Valid CommentSaveRequestDto requestDto) {
        this.postService.saveComment(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rememory/index/:categoryId")
    public List<PostResponseDto> getPostList(@PathVariable Long categoryId){
        return postService.findByCategory(categoryId);
    }

}