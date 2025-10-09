package com.example.integration.service;

import com.example.integration.client.ia.RobustIaClient;
import com.example.integration.client.ia.request.IaPostData;
import com.example.integration.client.ia.request.IaQuestionData;
import com.example.integration.client.ia.response.IaPostResponse;
import com.example.integration.client.ia.response.IaQuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class IaService {

    @Value("${AUTHENTICATION_KEY}")
    private static String AUTHORIZATION_KEY;

    private final RobustIaClient robustIaClient;
    private final RedisTemplate<String, String> redisTemplate;

    public IaPostResponse suggestPost(IaPostData data) {
        final String authorization = createOrGetAuthorization(AUTHORIZATION_KEY);
        return robustIaClient.suggestPost(authorization, data);
    }

    public IaQuestionResponse sendQuestion(IaQuestionData data) {
        final String authorization = createOrGetAuthorization(AUTHORIZATION_KEY);
        return robustIaClient.sendQuestion(authorization, data);
    }

    private String createOrGetAuthorization(String key) {
        String authorization = redisTemplate.opsForValue().get(key);
        if (authorization == null) {
            authorization = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(key, authorization);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return authorization;
    }

}
