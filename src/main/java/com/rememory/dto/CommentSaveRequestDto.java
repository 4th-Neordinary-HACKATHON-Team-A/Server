package com.rememory.dto;

import com.rememory.domain.comment.Comment;
import com.rememory.domain.post.Post;
import com.rememory.domain.user.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotBlank(message = "내용을 작성해주세요")
    private String text;

    @NotBlank(message = "작성자를 작성해주세요.")
    private User user;

    @NotBlank(message = "게시글을 작성해주세요.")
    private Post post;

    public Comment toEntity() {
        return Comment.builder()
                .text(text)
                .user(user)
                .post(post)
                .build();
    }
}
