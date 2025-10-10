package com.example.integration.client.ia;

import com.example.integration.client.RobustClient;
import com.example.integration.client.ia.request.IaPostData;
import com.example.integration.client.ia.request.IaQuestionData;
import com.example.integration.client.ia.response.IaPostResponse;
import com.example.integration.client.ia.response.IaQuestionResponse;
import org.springframework.stereotype.Component;

@Component
public class RobustIaClient extends RobustClient {

    private static final String IA_CLIENT_NAME = "api-client";
    private static final String COOKIE = ".Tunnels.Relay.WebForwarding.Cookies=CfDJ8Cs4yarcs6pKkdu0hlKHsZuICq9AqnXqIrID6BdRqBdKctDZcUnNkhFuf8-k7_w4ysOoGJseYj5ZrDCaeBAmrQYFfbXAtIAHOi1lAiiFt2FKOqtfi9jsyUzUYoHMtABUUbte3yOE8732AIEW8g7wCmLZIEbg2c6-yAK2dUqT-dlR0oIDJvb3cNv7zveFK6rucGNS6B3jqv_pqOvab8JZFpcSvKP-tF1QUyKmxxoK20IWem0jdCGOemhNYU50s4VyeVnsivOgEIcFnpenMHzsQhfokh8uUclObgGuNS-ZCPaMHxKjpwFJpBKeW3YpLgobYdLu16yQob4CO-RmR-xZBfsZra38Kf2G5P20j-iiZ18-6IxHlSFMSymhOnZjq-MUd9DbABn_3Hf2mVl8q3V6PoiuIW-h6CXr0udLkh0pKd8eKL6mfgIRwmqVufa1U9OzWinIZZI6S773aAbY7xpuDKVQI8UVskKLDxq100mG0iL-GgiGC4IlH7aM4gdaLrXN9F0PROVmikyacm79dP-19-_wAQWrT5kMVsByGpgqZKKvvHsQwhsq0Sd6n00lMOa7e3xY1s8aBN6XhGMTuQG8huI-glgjjVeIp088-dBTGvX-VwUm5GGedf0WpCaa0X9_DHlUYjOrmOFSPJyIxmDMmYViIpDPAPyyRyDSRq8C-NKGvXSZYy42HTa36v0JOsj5_dICt0ksXq4UitvxBA0AjC_Y4EBjSFcnMGfGKteHhQQhHpCv0oq2rLZlHVYp0d6E3txIYvQcw_FmVfKgcRmRLWRzpEBC_BNb_ghHt4YdajRH1nv-LoLqTsx0mqT1SHz6Fyads0H43aio7hb398ZMtcqmQY0U-azyOS-sTlY42MP4BlYoVa36Ap_OjxsXvP-yKaOzLL7zizO9oKOZm2RPdJ-G5W04HlGbzkAMkELhQJb6";
    private final IaClient iaClient;

    public RobustIaClient(IaClient iaClient) {
        super(IA_CLIENT_NAME);
        this.iaClient = iaClient;
    }

    public IaPostResponse suggestPost(String authorization, IaPostData data) {
        return super.robustCall(() -> iaClient.suggestPost(COOKIE, authorization, data));
    }

    public IaQuestionResponse sendQuestion(String authorization, IaQuestionData data) {
        return super.robustCall(() -> iaClient.sendQuestion(COOKIE, authorization, data));
    }

}
