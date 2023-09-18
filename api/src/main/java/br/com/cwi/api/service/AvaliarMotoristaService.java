package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AvaliarMotoristaRequest;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.service.validators.BuscarCorridaService;
import br.com.cwi.api.service.validators.ValidaSeCorridaPodeSerAvaliadaService;
import br.com.cwi.api.validator.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AvaliarMotoristaService {

    @Autowired
    private ValidaSeCorridaPodeSerAvaliadaService validaSeCorridaPodeSerAvaliadaService;

    @Autowired
    private Validacoes validacoes;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private CorridaRepository corridaRepository;

    @Transactional
    public MensagemResponse avaliarMotorista(AvaliarMotoristaRequest request) {
        validacoes.validaSeScoreEstaEntreUmECinco(request.getScore());
        Corrida corrida = buscarCorridaService.porId(request.getCorridaId());
        validaSeCorridaPodeSerAvaliadaService.validarMotorista(corrida);
        validaSeCorridaPodeSerAvaliadaService.validarCorrida(corrida);

        Motorista motorista = corrida.getMotorista();
        corrida.setScoreMotorista(request.getScore());
        float scoreMotorista = calcularMedia(motorista);
        motorista.setScore(scoreMotorista);

        corridaRepository.save(corrida);

        MensagemResponse response = new MensagemResponse();
        response.setMensagem("Você avaliou " + motorista.getNome() + " com nota " + request.getScore());

        return response;
    }

    private float calcularMedia (Motorista motorista ){
        List<Corrida> arrayComScore = motorista.getCorridas().stream()
                .filter(corrida -> corrida.getScoreMotorista() != null)
                .collect(toList());

        float totalScore = arrayComScore.stream()
                .map(Corrida::getScoreMotorista)
                .reduce(0, Integer::sum);

        return totalScore / (arrayComScore.toArray().length);
    }
}
