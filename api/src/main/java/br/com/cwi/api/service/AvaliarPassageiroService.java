package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AvaliarPassageiroRequest;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Passageiro;
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
public class AvaliarPassageiroService {

    @Autowired
    private ValidaSeCorridaPodeSerAvaliadaService validaSeCorridaPodeSerAvaliadaService;

    @Autowired
    private Validacoes validacoes;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private CorridaRepository corridaRepository;

    @Transactional
    public MensagemResponse avaliarPassageiro(AvaliarPassageiroRequest request) {
        validacoes.validaSeScoreEstaEntreUmECinco(request.getScore());
        Corrida corrida = buscarCorridaService.porId(request.getCorridaId());
        validaSeCorridaPodeSerAvaliadaService.validarPassageiro(corrida);
        validaSeCorridaPodeSerAvaliadaService.validarCorrida(corrida);

        Passageiro passageiro = corrida.getPassageiro();
        corrida.setScorePassageiro(request.getScore());
        float scorePassageiro = calcularMedia(passageiro);
        passageiro.setScore(scorePassageiro);

        corridaRepository.save(corrida);

        MensagemResponse response = new MensagemResponse();
        response.setMensagem("Você avaliou " + passageiro.getNome() + " com nota " + request.getScore());

        return response;
    }

    private float calcularMedia (Passageiro passageiro ){
        List<Corrida> arrayComScore = passageiro.getCorridas().stream()
                .filter(corrida -> corrida.getScorePassageiro() != null)
                .collect(toList());

        float totalScore = arrayComScore.stream()
                .map(Corrida::getScorePassageiro)
                .reduce(0, Integer::sum);

        return totalScore / (arrayComScore.toArray().length);
    }
}
