package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.DepositarCreditoPassageiroRequest;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.PassageiroRepository;
import br.com.cwi.api.service.validators.BuscarPassageiroService;
import br.com.cwi.api.validator.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositarCreditoPassageiroService {

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private Validacoes validacoes;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Transactional
    public MensagemResponse depositarCredito(Long id, DepositarCreditoPassageiroRequest request) {

        Passageiro passageiro = buscarPassageiroService.porId(id);
        validacoes.validaSeValorEMaiorQueZero(request.getSaldo());
        passageiro.setSaldo(passageiro.getSaldo().add(request.getSaldo()));
        passageiroRepository.save(passageiro);

        MensagemResponse response = new MensagemResponse();
        response.setMensagem(passageiro.getNome() + " depositou R$" + request.getSaldo() + " em sua conta. Saldo atual: " + passageiro.getSaldo());

        return response;
    }
}
