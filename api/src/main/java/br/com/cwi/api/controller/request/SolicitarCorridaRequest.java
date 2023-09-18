package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SolicitarCorridaRequest {

    @NotNull(message = "Este campo é obrigatório.")
    private double inicioX;
    @NotNull(message = "Este campo é obrigatório.")
    private double inicioY;
    @NotNull(message = "Este campo é obrigatório.")
    private double fimX;
    @NotNull(message = "Este campo é obrigatório.")
    private double fimY;
}
