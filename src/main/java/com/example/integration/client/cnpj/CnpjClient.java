package com.example.integration.client.cnpj;

import com.example.integration.client.cnpj.response.WsData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cnpj-client", url = "https://open.cnpja.com/")
public interface CnpjClient {

    @GetMapping("office/{cnpj}")
    WsData getDataByCnpj(@PathVariable("cnpj") String cnpj);
}
