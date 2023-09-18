package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.SacarContaVirtualMotoristaRequest;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.service.validators.BuscarMotoristaService;
import br.com.cwi.api.validator.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class SacarCreditoMotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private Validacoes validacoes;

    @Transactional
    public MensagemResponse sacar(Long id, SacarContaVirtualMotoristaRequest request) {

        Motorista motorista = buscarMotoristaService.porId(id);
        validacoes.validaSeValorEMaiorQueZero(request.getSaldo());
        BigDecimal saldoAtual = motorista.getSaldo();

        motorista.setSaldo(saldoAtual.subtract(request.getSaldo()));
        validacoes.sacarValorMaiorQueSaldo(saldoAtual, request.getSaldo());
        motoristaRepository.save(motorista);

        MensagemResponse response = new MensagemResponse();
        response.setMensagem(motorista.getNome() + " sacou R$" + request.getSaldo() + " de sua conta virtual. Saldo atual: " + motorista.getSaldo());

        return response;
    }
}
