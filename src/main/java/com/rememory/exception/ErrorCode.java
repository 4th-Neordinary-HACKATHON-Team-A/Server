package com.rememory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND("해당하는 회원이 존재하지 않습니다."),
    IMAGE_NOT_FOUND("해당하는 이미지가 존재하지 않습니다."),
    POST_NOT_FOUND("해당하는 게시글이 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR("서버 오류가 발생했습니다.");

    private final String errorMessage;

}
