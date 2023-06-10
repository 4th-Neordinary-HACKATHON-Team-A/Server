package com.rememory.controller;

import com.rememory.dto.MainDto.*;
import com.rememory.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rememory")
@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @GetMapping("")
    public List<MainRequestDto> getMainPage() {
        return mainService.getMainPage();
    }
}
