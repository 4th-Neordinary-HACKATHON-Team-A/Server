package com.rememory.service.dalle;

import com.rememory.dto.DalleDto.DalleRequestDto;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class DalleService {

    @Value("${openai.dalle-api-key}")
    private String apiKey;

    public ImageResult getDalleResponse(DalleRequestDto request) throws Exception {
        Duration duration = Duration.ofMinutes(5);
        OpenAiService service = new OpenAiService(apiKey, duration);

        CreateImageRequest createImageRequest
                = CreateImageRequest.builder()
                                    .prompt(request.getPrompt()).build();

        return service.createImage(createImageRequest);

    }
}
