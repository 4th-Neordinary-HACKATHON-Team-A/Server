package com.rememory.dto;

import com.rememory.domain.user.User;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    @NotBlank(message = "닉네임을 작성해주세요")
    @UniqueElements(message = "중복된 닉네임입니다")
    private String nickname;

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .build();
    }
}
