package com.rememory.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotBlank(message = "내용을 작성해주세요")
    private String text;

    @NotBlank(message = "작성자를 작성해주세요.")
    private Long userId;

    @NotBlank(message = "게시글을 작성해주세요.")
    private Long postId;
}