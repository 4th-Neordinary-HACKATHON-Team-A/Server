package com.rememory.service.gpt;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

@Service
public class GptService {
    @Value("${openai.gpt-api-key}")
    private String apiKey;

    public CompletableFuture<CompletionResult> getGptResponse(String prompt) throws Exception {
        Duration timeout = Duration.ofMinutes(5);
        OpenAiService service = new OpenAiService(apiKey, timeout);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .maxTokens(3500)
                .echo(false)
                .build();

        return CompletableFuture.supplyAsync(() -> {
            try {
                return service.createCompletion(completionRequest);
            } catch (Exception e) {
                return null;
            }
        });

    }
}
