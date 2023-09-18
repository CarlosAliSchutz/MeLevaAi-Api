package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarCorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class ListarCorridaMapper {

    public static ListarCorridaResponse toResponse(Corrida entity) {
        return ListarCorridaResponse.builder()
                .id(entity.getId())
                .passageiro(entity.getPassageiro().getNome())
                .motorista(entity.getMotorista().getNome())
                .status(entity.getStatus().name())
                .build();
    }
}
