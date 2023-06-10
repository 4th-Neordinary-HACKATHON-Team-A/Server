package com.rememory.controller;


import com.rememory.dto.GptDto.*;
import com.rememory.service.dalle.DalleService;
import com.rememory.service.gpt.GptService;
import com.rememory.service.gpt.vo.GptReqVo;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("rememory/gpt")
public class GptController {

    @Autowired
    private GptService gptService;
    @Autowired
    private DalleService dalleService;

    @PostMapping("/summary")
    public CompletableFuture<CompletionResult> summaryToGpt(@RequestBody GptReqVo gptReqVo) throws Exception {
        String strQuestion = "\"" + gptReqVo.getSentence() + "\"" +
                            "\n\n 위 문장을 200자 내외로 요약해줘.";
        System.out.println("프롬프트 확인: " + strQuestion);

        CompletableFuture<CompletionResult> result =
                gptService.getGptResponse(strQuestion);
        System.out.println(result.get().getChoices().get(0).getText());

        return result;
    }

    @PostMapping("")
    public GptImageResponseDto requestToGpt(@RequestBody GptReqVo gptReqVo) throws Exception {
        String strQuestion = "\"" + gptReqVo.getSentence() + "\"" +
                "\n\n 위 문장을 200자 내외로 요약해줘.";
        System.out.println("프롬프트 확인: " + strQuestion);

        CompletableFuture<CompletionResult> summaryRespons =
                gptService.getGptResponse(strQuestion);
        CompletionChoice choice = summaryRespons.get().getChoices().get(0);
        String summary = choice.getText().replaceAll("\n", "");
        System.out.println(summary);

        String url = String.valueOf(gptService.promptToGpt(summary).getData().get(0));
        GptImageResponseDto result = GptImageResponseDto.builder()
                .choice(choice)
                .imageUrl(url)
                .build();

        return result;
    }
}