package com.example.integration.client.ia;

import com.example.integration.client.ia.request.IaPostData;
import com.example.integration.client.ia.request.IaQuestionData;
import com.example.integration.client.ia.response.IaPostResponse;
import com.example.integration.client.ia.response.IaQuestionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ia-client", url = "/api")
public interface IaClient {

    @PostMapping("/match/suggest")
    IaPostResponse suggestPost(
            @RequestHeader("Cookie") String cookie,
            @RequestHeader("Authorization") String authorization,
            @RequestBody IaPostData data);

    @PostMapping("/chat/question")
    IaQuestionResponse sendQuestion(
            @RequestHeader("Cookie") String cookie,
            @RequestHeader("Authorization") String authorization,
            @RequestBody IaQuestionData data);

}
