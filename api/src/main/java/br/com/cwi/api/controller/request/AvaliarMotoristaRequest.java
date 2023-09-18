package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AvaliarMotoristaRequest {

    @NotNull(message = "Informe a nota do motorista")
    private Integer score;

    @NotNull(message = "Informe o id da corrida")
    private Long corridaId;
}
