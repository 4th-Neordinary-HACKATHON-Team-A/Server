package com.rememory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class DalleDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DalleRequestDto {

        @NotBlank
        private String prompt;

        private int n = 1;

        @NotBlank
        private String size;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DalleResponseDto {

        private Long created;
        private ArrayList<UrlResponseDto> data;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UrlResponseDto {
        private String url;
    }
}
