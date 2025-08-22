package com.example.integration.controller;

import com.example.integration.client.cnpj.response.WsData;
import com.example.integration.service.CnpjService;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CnpjController {

    @Autowired
    private CnpjService service;

    @GetMapping()
    public WsData getEnterpriseByCnpj(@RequestParam @CNPJ String cnpj){
        return service.getEnterpriseByCnpj(cnpj);
    }
}
