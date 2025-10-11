package com.example.integration.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeiDto implements Serializable {

    private Integer ano;
    private String documento;
    private String numero;
    private String ato;
    private String ementa;
    private String area;
    private String assunto;
    private String link;

}
