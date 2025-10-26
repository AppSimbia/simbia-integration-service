package com.example.integration.controller;

import com.example.integration.client.cep.response.CepData;
import com.example.integration.client.cnpj.response.WsData;
import com.example.integration.client.ia.request.IaPostData;
import com.example.integration.client.ia.request.IaQuestionData;
import com.example.integration.client.ia.response.IaPostResponse;
import com.example.integration.client.ia.response.IaQuestionResponse;
import com.example.integration.dto.LeiDto;
import com.example.integration.service.CepService;
import com.example.integration.service.CnpjService;
import com.example.integration.service.IaService;
import com.example.integration.service.LeisService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final CnpjService cnpjService;
    private final LeisService leisService;
    private final IaService iaService;
    private final CepService cepService;

    @GetMapping("/leis")
    public List<LeiDto> readCsv() throws CsvValidationException, IOException {
        return leisService.readCsv();
    }

    @GetMapping("/cnpj/{cnpj}")
    public WsData getEnterpriseByCnpj(@PathVariable @CNPJ String cnpj){
        return cnpjService.getEnterpriseByCnpj(cnpj);
    }

    @PostMapping("/chat/questions")
    public IaQuestionResponse sendQuestion(@RequestBody IaQuestionData data) {
        return iaService.sendQuestion(data);
    }

    @PostMapping("/chat/post")
    public IaPostResponse suggestPost(@RequestBody IaPostData data) {
        return iaService.suggestPost(data);
    }

    @GetMapping("/cep/{cep}")
    public CepData getCepData(@PathVariable String cep) {
        return cepService.getCepData(cep);
    }

}
