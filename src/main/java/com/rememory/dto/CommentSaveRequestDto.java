package com.rememory.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotBlank(message = "내용을 작성해주세요")
    @Min(1)
    @Max(200)
    private String text;

    @NotBlank(message = "작성자를 작성해주세요.")
    private Long userId;

    @NotBlank(message = "게시글을 작성해주세요.")
    private Long postId;
}