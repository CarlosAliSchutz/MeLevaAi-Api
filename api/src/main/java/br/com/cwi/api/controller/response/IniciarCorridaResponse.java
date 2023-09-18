package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IniciarCorridaResponse {

    private double tempoChegadaEstimado;
    private BigDecimal valorEstimado;
}
