package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinalizarCorridaResponse {

    private int tempoCorrida;
    private BigDecimal valorCorrida;
    private Long corridaId;
}
