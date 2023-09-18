package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.domain.Motorista;

public class IncluirMotoristaMapper {
    public static Motorista toEntity(IncluirMotoristaRequest request) {
        return Motorista.builder()
                .nome(request.getNome())
                .dataNascimento(request.getDataNascimento())
                .cpf(request.getCpf())
                .saldo(request.getSaldo())
                .build();
    }
}
