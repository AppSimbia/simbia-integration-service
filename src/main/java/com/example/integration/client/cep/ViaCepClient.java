package com.example.integration.client.cep;

import com.example.integration.client.cep.response.ViaCepData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep-client", url = "${viacep.client.url}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepData getDataByCep(@PathVariable("cep") String cep);

}
