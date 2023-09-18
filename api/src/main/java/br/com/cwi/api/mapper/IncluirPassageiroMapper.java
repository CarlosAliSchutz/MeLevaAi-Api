package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.domain.Passageiro;

public class IncluirPassageiroMapper {
    public static Passageiro toEntity(IncluirPassageiroRequest request) {
        return Passageiro.builder()
                .nome(request.getNome())
                .dataNascimento(request.getDataNascimento())
                .cpf(request.getCpf())
                .saldo(request.getSaldo())
                .build();
    }
}
