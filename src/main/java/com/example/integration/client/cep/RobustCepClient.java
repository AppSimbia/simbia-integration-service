package com.example.integration.client.cep;

import com.example.integration.client.RobustClient;
import com.example.integration.client.cep.response.CepData;
import com.example.integration.client.cep.response.NominatimData;
import com.example.integration.client.cep.response.ViaCepData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobustCepClient extends RobustClient {

    private static final String CEP_CLIENT = "cep-client";
    private final ViaCepClient cepClient;
    private final NominatimClient nominatimClient;

    public RobustCepClient(ViaCepClient cepClient, NominatimClient nominatimClient) {
        super(CEP_CLIENT);
        this.cepClient = cepClient;
        this.nominatimClient = nominatimClient;
    }

    public CepData getCepData(String cep) {
        ViaCepData viaCepData = super.robustCall(() -> cepClient.getDataByCep(cep));
        CepData cepData =  CepData.builder()
            .logradouro(viaCepData.getLogradouro())
            .bairro(viaCepData.getBairro())
            .localidade(viaCepData.getLocalidade())
            .uf(viaCepData.getUf())
            .estado(viaCepData.getEstado())
            .regiao(viaCepData.getRegiao())
            .build();
        List<NominatimData> nominatimList = super.robustCall(() -> nominatimClient.getDataByAddress(cep, "json"));
        if (!nominatimList.isEmpty()) {
            NominatimData nominatimData = nominatimList.getFirst();
            cepData.setLat(nominatimData.getLat());
            cepData.setLon(nominatimData.getLon());
        }

        return cepData;
    }
}
