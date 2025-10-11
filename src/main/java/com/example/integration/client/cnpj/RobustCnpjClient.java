package com.example.integration.client.cnpj;

import com.example.integration.client.RobustClient;
import com.example.integration.client.cnpj.response.WsData;
import org.springframework.stereotype.Component;

@Component
public class RobustCnpjClient extends RobustClient{

    private static final String CNPJ_CLIENT_NAME = "cnpj";

    private final CnpjClient cnpjClient;

    public RobustCnpjClient(CnpjClient cnpjClient) {
        super(CNPJ_CLIENT_NAME);
        this.cnpjClient = cnpjClient;
    }

    public WsData getEnterpriseByCnpj(String cnpj) {
        return super.robustCall(() -> cnpjClient.getDataByCnpj(cnpj));
    }
}
