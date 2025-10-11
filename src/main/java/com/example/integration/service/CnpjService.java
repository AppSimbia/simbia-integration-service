package com.example.integration.service;

import com.example.integration.client.cnpj.RobustCnpjClient;
import com.example.integration.client.cnpj.response.WsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CnpjService {

    @Autowired
    private RobustCnpjClient robustCnpjClient;

    @Cacheable("enterprise")
    public WsData getEnterpriseByCnpj(String cnpj){
        return robustCnpjClient.getEnterpriseByCnpj(sanitizeCnpj(cnpj));
    }

    private String sanitizeCnpj(String cnpj){
        return cnpj.replaceAll("[^0-9]", "");
    }
}
