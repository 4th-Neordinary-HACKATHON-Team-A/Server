package com.rememory.dto;

import com.rememory.domain.user.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    @NotBlank(message = "닉네임을 작성해주세요")
    private String nickname;

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .build();
    }
}
