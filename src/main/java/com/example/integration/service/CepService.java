package com.example.integration.service;

import com.example.integration.client.cep.RobustCepClient;
import com.example.integration.client.cep.response.CepData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final RobustCepClient robustCepClient;

    public CepData getCepData(String cep) {
        return robustCepClient.getCepData(cep);
    }

}
