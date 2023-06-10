package com.rememory.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FAMILY("가족"),
    LOVE("연애"),
    FAREWELL("이별"),
    TRAVEL("여행"),
    ANNIVERSARY("기념일"),
    FRIENDSHIP("우정"),
    FOOD("맛집"),
    ACHIEVEMENT("성취"),
    GROWING_PAINS("성장통"),
    MYSTERY("신비"),
    CONFUSION("혼란"),
    SHAMEFUL_PAST("흑역사");
    private final String Category;
}
