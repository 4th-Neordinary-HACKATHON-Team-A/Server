package com.rememory.dto;

import com.rememory.domain.post.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private Long userId;
    private String imageSrc;

    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.userId = entity.getUser().getId();
        this.imageSrc = entity.getImage().getImageSrc();
    }
}
