package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.MotoristaResumidoResponse;
import br.com.cwi.api.domain.Motorista;

public class ListarMotoristasMapper {

    public static MotoristaResumidoResponse toResponse(Motorista entity) {
        return MotoristaResumidoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .saldo(entity.getSaldo())
                .score(entity.getScore())
                .modelo(entity.getVeiculo().getModelo())
                .build();
    }
    
}
