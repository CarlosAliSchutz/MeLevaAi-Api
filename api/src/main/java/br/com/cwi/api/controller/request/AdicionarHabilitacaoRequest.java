package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AdicionarHabilitacaoRequest {

    @NotBlank(message = "Este campo é obrigatório")
    private String numero;
    @NotNull(message = "Este campo é obrigatório")
    private Categoria categoria;
    @NotNull(message = "Este campo é obrigatório")
    private LocalDate dataVencimento;
    @NotNull(message = "Este campo é obrigatório")
    private Long motoristaId;
}
