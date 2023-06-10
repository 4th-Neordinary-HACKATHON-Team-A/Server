package com.rememory.dto;

import com.rememory.domain.post.Category;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDto {
    @NotBlank(message = "제목을 작성해주세요.")
    @Size(max = 45)
    private String title;

    @NotBlank(message = "내용을 작성해주세요.")
    @Size(max = 200)
    private String content;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private Category category;

    @NotBlank(message = "작성자를 작성해주세요.")
    private Long userId;

    @NotBlank(message = "이미지를 작성해주세요.")
    private Long imageId;
}
