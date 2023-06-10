package com.rememory.dto;

import com.rememory.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    @NotBlank(message = "닉네임을 작성해주세요")
    @Size(min = 1, max = 255)
    private String nickname;

    public User toEntity() {
        return User.builder()
                   .nickname(nickname)
                   .build();
    }
}
