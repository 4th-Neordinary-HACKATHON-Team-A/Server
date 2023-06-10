package com.rememory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaveRequestDto {
    @NotBlank(message = "이미지 URL을 작성해주세요.")
    private String imageSrc;

    @NotNull(message = "작성자를 작성해주세요.")
    private Long userId;
}
