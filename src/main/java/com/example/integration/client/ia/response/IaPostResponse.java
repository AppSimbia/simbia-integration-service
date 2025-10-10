package com.example.integration.client.ia.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IaPostResponse {

    private String msg;
    private List<Long> data;

}
