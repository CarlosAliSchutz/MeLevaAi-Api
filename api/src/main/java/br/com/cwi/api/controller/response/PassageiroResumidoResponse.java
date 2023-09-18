package br.com.cwi.api.controller.response;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassageiroResumidoResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private float score;
    private BigDecimal saldo;
}
