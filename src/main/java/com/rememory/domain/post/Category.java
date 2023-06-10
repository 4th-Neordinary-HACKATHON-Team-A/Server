package com.rememory.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    Person("인물"),
    Place("장소"),
    Action("행동"),
    Mood("기분"),
    Time("시간"),
    Weather("날씨")
    ;

    private final String Category;
}
