package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.SolicitarCorridaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.mapper.SolicitarCorridaMapper;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.service.validators.BuscarPassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.cwi.api.domain.enums.StatusCorrida.SOLICITADA;
import static br.com.cwi.api.service.UtilsCorridaService.calcularTempoChegada;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class SolicitarCorridaService {

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CorridaRepository corridaRepository;

    @Transactional
    public SolicitarCorridaResponse solicitarCorrida(Long id, SolicitarCorridaRequest request) {

        Passageiro passageiro = buscarPassageiroService.validar(id);

        Corrida corrida = SolicitarCorridaMapper.toEntity(request);
        corrida.setStatus(SOLICITADA);
        corrida.setPassageiro(passageiro);
        corrida.setMotorista(encontrarMotorista());

        corridaRepository.save(corrida);

        SolicitarCorridaResponse response = SolicitarCorridaMapper.toResponse(corrida);
        response.setTempoEstimado(calcularTempoChegada());

        return response;
    }

    public Motorista encontrarMotorista() {
        List<Motorista> motoristas = motoristaRepository.motoristasFiltradosDisponiveis();

        if (motoristas.size() == 0) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Nenhum motorista encontrado.");
        }

        return motoristas.get(0);
    }
}
