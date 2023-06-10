package com.rememory.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaveRequestDto {
    @NotBlank(message = "이미지 URL을 작성해주세요.")
    private String imageSrc;

    @NotBlank(message = "작성자를 작성해주세요.")
    private Long userId;
}
