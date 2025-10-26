package com.example.integration.client.cep;

import com.example.integration.client.cep.response.NominatimData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nominatim-client", url = "${nominatim.client.url}")
public interface NominatimClient {

    @GetMapping("/search")
    List<NominatimData> getDataByAddress(@RequestParam("q") String address,
                                         @RequestParam("format") String format);

}
