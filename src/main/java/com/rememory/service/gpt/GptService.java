package com.rememory.service.gpt;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import com.rememory.dto.DalleDto;
import com.rememory.service.dalle.DalleService;
import com.theokanning.openai.image.ImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

@Service
public class GptService {

    @Autowired
    private DalleService dalleService;

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

    public ImageResult promptToGpt(String summary) throws Exception {
        String strQuestion =  "\"" + summary + "\"" +
                "\n\n 위 문장을 영어로 번역해줘.";
        System.out.println("프롬프트 확인: " + strQuestion);

        CompletableFuture<CompletionResult> response =
                getGptResponse(strQuestion);
        String prompt = "Generate an image of \"" + response.get().getChoices().get(0).getText().replaceAll("\n", "") + "\"";

        return dalleService.getDalleResponse(new DalleDto.DalleRequestDto(prompt));
    }
}
