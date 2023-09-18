package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IncluirVeiculoRequest {

    @NotBlank(message = "Este campo é obrigatório")
    private String placa;
    @NotBlank(message = "Este campo é obrigatório")
    private String modelo;
    @NotBlank(message = "Este campo é obrigatório")
    private String cor;
    @NotBlank(message = "Este campo é obrigatório")
    private String foto;
    @NotNull(message = "Este campo é obrigatório")
    private Categoria categoria;

    @NotNull(message = "Este campo é obrigatório")
    private Long motoristaId;
}
