package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.AdicionarHabilitacaoRequest;
import br.com.cwi.api.domain.LicencaMotorista;

public class AdicionarHabilitacaoMapper {
    public static LicencaMotorista toEntity(AdicionarHabilitacaoRequest request) {
        return LicencaMotorista.builder()
                .numero(request.getNumero())
                .categoria(request.getCategoria())
                .dataVencimento(request.getDataVencimento())
                .build();
    }
}
