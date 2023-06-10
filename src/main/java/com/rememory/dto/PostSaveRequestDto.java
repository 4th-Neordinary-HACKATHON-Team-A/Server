package com.rememory.dto;

import com.rememory.domain.image.Image;
import com.rememory.domain.post.Category;
import com.rememory.domain.post.Post;
import com.rememory.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDto {
    @NotBlank(message = "제목을 작성해주세요.")
    private String title;

    @NotBlank(message = "내용을 작성해주세요.")
    private String content;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private Category category;

    @NotBlank(message = "작성자를 작성해주세요.")
    private User user;

    @NotBlank(message = "이미지를 작성해주세요.")
    private Image image;

    public Post toEntity() {
        return Post.builder()
                   .title(title)
                   .content(content)
                   .category(category)
                   .user(user)
                   .image(image)
                   .build();
    }
}
