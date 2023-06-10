package com.rememory.controller;

import com.rememory.dto.UserSaveRequestDto;
import com.rememory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rememory/user")
public class UserApiController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserSaveRequestDto requestDto){
        userService.save(requestDto);
        return ResponseEntity.ok().build();
    }
}
