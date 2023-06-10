package com.rememory.controller;
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