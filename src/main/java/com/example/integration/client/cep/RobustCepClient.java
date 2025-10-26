package com.example.integration.client.cep;

import com.example.integration.client.RobustClient;
import com.example.integration.client.cep.response.CepData;
import com.example.integration.client.cep.response.NominatimData;
import com.example.integration.client.cep.response.ViaCepData;
import org.springframework.stereotype.Component;

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
        NominatimData nominatimData = super.robustCall(() -> nominatimClient.getDataByAddress(
                formatAddressForNominatim(viaCepData),
                "json"
        ).getFirst());
        return new CepData(
                viaCepData.getLogradouro(),
                viaCepData.getBairro(),
                viaCepData.getLocalidade(),
                viaCepData.getUf(),
                viaCepData.getEstado(),
                viaCepData.getRegiao(),
                nominatimData.getLat(),
                nominatimData.getLon()
        );
    }

    private String formatAddressForNominatim(ViaCepData viaCepData) {
        return String.format("%s, %s, %s, %s",
                viaCepData.getLogradouro(),
                viaCepData.getBairro(),
                viaCepData.getLocalidade(),
                viaCepData.getUf()
        );
    }
}
