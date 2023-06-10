package com.rememory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotBlank(message = "내용을 작성해주세요")
    @Size(min = 1, max = 200)
    private String text;

    @NotNull(message = "작성자를 작성해주세요.")
    private Long userId;

    @NotNull(message = "게시글을 작성해주세요.")
    private Long postId;
}