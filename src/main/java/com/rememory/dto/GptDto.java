package com.rememory.dto;

import com.theokanning.openai.completion.CompletionResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;

public class GptDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GptImageResponseDto {
        private CompletableFuture<CompletionResult> completableResult;
        private String url;
    }
}
