package com.example.integration.client.cnpj.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WsData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<Email> emails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Email implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private String domain;
        private String ownership;
        private String address;
    }

}
