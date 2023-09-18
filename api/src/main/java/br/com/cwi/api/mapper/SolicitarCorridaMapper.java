package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.SolicitarCorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class SolicitarCorridaMapper {
    public static Corrida toEntity(SolicitarCorridaRequest request) {
        return Corrida.builder()
                .inicioX(request.getInicioX())
                .inicioY(request.getInicioY())
                .fimX(request.getFimX())
                .fimY(request.getFimY())
                .build();
    }

    public static SolicitarCorridaResponse toResponse(Corrida entity) {
        return SolicitarCorridaResponse.builder()
                .id(entity.getId())
                .nome(entity.getMotorista().getNome())
                .modelo(entity.getMotorista().getVeiculo().getModelo())
                .build();
    }
}
