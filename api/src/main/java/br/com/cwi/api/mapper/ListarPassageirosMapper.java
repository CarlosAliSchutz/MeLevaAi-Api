package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.PassageiroResumidoResponse;
import br.com.cwi.api.domain.Passageiro;

public class ListarPassageirosMapper {

    public static PassageiroResumidoResponse toResponse(Passageiro entity) {
        return PassageiroResumidoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .saldo(entity.getSaldo())
                .cpf(entity.getCpf())
                .dataNascimento(entity.getDataNascimento())
                .score(entity.getScore())
                .build();
    }
}
