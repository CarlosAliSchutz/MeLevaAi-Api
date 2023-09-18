package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListarCorridaResponse {

    private long id;
    private String passageiro;
    private String motorista;
    private String status;
}
