package com.rememory.controller;

import com.rememory.dto.MainDto.MainRequestDto;
import com.rememory.dto.PostResponseDto;
import com.rememory.service.MainService;
import com.rememory.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rememory")
@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;
    private final PostService postService;

    @GetMapping("/index")
    public List<MainRequestDto> getMainPage() {
        return mainService.getMainPage();
    }

    @GetMapping("/index/{categoryId}")
    public List<PostResponseDto> getPostList(@PathVariable Long categoryId) {
        return postService.findByCategory(categoryId);
    }
}
