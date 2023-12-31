package com.rememory.controller;

import com.rememory.dto.ImageSaveRequestDto;
import com.rememory.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/image")
public class ImageApiController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid ImageSaveRequestDto requestDto) {
        return new ResponseEntity<>(this.imageService.imageSave(requestDto), HttpStatus.CREATED);

    }
}
