package com.example.integration.controller;

import com.example.integration.client.cnpj.response.WsData;
import com.example.integration.dto.LeiDto;
import com.example.integration.service.CnpjService;
import com.example.integration.service.LeisService;
import com.opencsv.exceptions.CsvValidationException;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RequestController {

    private final CnpjService cnpjService;
    private final LeisService leisService;

    public RequestController(CnpjService cnpjService, LeisService leisService) {
        this.cnpjService = cnpjService;
        this.leisService = leisService;
    }

    @GetMapping("/leis")
    public List<LeiDto> readCsv() throws CsvValidationException, IOException {
        return leisService.readCsv();
    }

    @GetMapping("/{cnpj}")
    public WsData getEnterpriseByCnpj(@PathVariable @CNPJ String cnpj){
        return cnpjService.getEnterpriseByCnpj(cnpj);
    }
}
