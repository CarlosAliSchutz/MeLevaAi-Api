package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotoristaResumidoResponse {

    private Long id;
    private String nome;
    private BigDecimal saldo;
    private float score;
    private String modelo;
}
