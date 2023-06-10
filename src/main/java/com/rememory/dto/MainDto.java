package com.rememory.dto;

import lombok.*;

public class MainDto {

    @Data
    @AllArgsConstructor
    public static class MainRequestDto {
        private Long postId;
        private String nickname;
        private String title;
        private String category;
        private String imageSrc;
        private int afterCreated;
    }

}
