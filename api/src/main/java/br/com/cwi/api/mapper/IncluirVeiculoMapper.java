package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirVeiculoRequest;
import br.com.cwi.api.domain.Veiculo;

public class IncluirVeiculoMapper {
    public static Veiculo toEntity(IncluirVeiculoRequest request) {
        return Veiculo.builder()
                .placa(request.getPlaca())
                .modelo(request.getModelo())
                .cor(request.getCor())
                .foto(request.getFoto())
                .categoria(request.getCategoria())
                .build();
    }
}
