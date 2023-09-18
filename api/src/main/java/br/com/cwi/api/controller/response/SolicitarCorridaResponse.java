package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitarCorridaResponse {

    private Long id;
    private String nome;
    private String modelo;
    private Integer tempoEstimado;
}
