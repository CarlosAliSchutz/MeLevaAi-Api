package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.FinalizarCorridaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.domain.enums.StatusCorrida;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.repository.PassageiroRepository;
import br.com.cwi.api.service.validators.BuscarCorridaService;
import br.com.cwi.api.service.validators.BuscarPassageiroService;
import br.com.cwi.api.validator.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class FinalizarCorridaService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private Validacoes validacoes;

    @Transactional
    public FinalizarCorridaResponse finalizar(Long id) {

        Corrida corrida = buscarCorridaService.porId(id);
        Passageiro passageiro = corrida.getPassageiro();
        Motorista motorista = corrida.getMotorista();

        validacoes.corridaNaoIniciada(corrida);
        validacoes.corridaFinalizada(corrida);

        corrida.setHoraChegada(LocalDateTime.now());
        corrida.setStatus(StatusCorrida.FINALIZADA);

        int duracaoCorrida = UtilsCorridaService.calcularDuracaoCorrida(corrida.getHoraInicio(), corrida.getHoraChegada());
        BigDecimal valorCorrida = UtilsCorridaService.getPrecoCorrida(duracaoCorrida);
        BigDecimal carteiraPasseiro = UtilsCorridaService.cobrancaCorrida(passageiro.getSaldo(), valorCorrida);
        BigDecimal carteiraMotorista = UtilsCorridaService.cobrancaCorridaMotorista(motorista.getSaldo(), valorCorrida);
        validacoes.saldoInsuficiente(passageiro.getSaldo(),valorCorrida);

        passageiro.setSaldo(carteiraPasseiro);
        motorista.setSaldo(carteiraMotorista);

        corridaRepository.save(corrida);
        passageiroRepository.save(passageiro);

        return FinalizarCorridaResponse.builder()
                .tempoCorrida(duracaoCorrida)
                .valorCorrida(valorCorrida)
                .corridaId(corrida.getId())
                .build();
    }
}
