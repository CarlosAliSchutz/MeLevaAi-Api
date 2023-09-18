package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.IniciarCorridaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.enums.StatusCorrida;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.service.validators.BuscarPassageiroService;
import br.com.cwi.api.validator.Validacoes;
import br.com.cwi.api.service.validators.BuscarCorridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class IniciarCorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private Validacoes validacoes;

    @Transactional
    public IniciarCorridaResponse iniciar(Long idCorrida) {

        Corrida corrida = buscarCorridaService.porId(idCorrida);

        validacoes.corridaFinalizada(corrida);
        validacoes.corridaIniciou(corrida);

        double distancia = UtilsCorridaService.getDistanciaCorrida(corrida.getInicioX(),
                corrida.getInicioY(), corrida.getFimX(), corrida.getFimY());

        int chegadaEstimado = UtilsCorridaService.getTempoChegadaEstimada(distancia);
        BigDecimal valorEstimado = UtilsCorridaService.getPrecoCorrida(chegadaEstimado);

        corrida.setHoraInicio(LocalDateTime.now());
        corrida.setStatus(StatusCorrida.INICIADA);

        corridaRepository.save(corrida);

        return IniciarCorridaResponse.builder()
                .tempoChegadaEstimado(chegadaEstimado)
                .valorEstimado(valorEstimado)
                .build();
    }
}
