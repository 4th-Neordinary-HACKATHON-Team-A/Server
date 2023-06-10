package com.rememory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class DalleDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DalleRequestDto {
        @NotBlank(message = "명령어를 입력해주세요")
        private String prompt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DalleResponseDto {
        private String url;
    }
}

