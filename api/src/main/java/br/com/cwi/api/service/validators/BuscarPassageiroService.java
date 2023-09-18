package br.com.cwi.api.service.validators;

import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.api.domain.enums.StatusCorrida.INICIADA;
import static br.com.cwi.api.domain.enums.StatusCorrida.SOLICITADA;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarPassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public Passageiro validar(Long id) {

        Passageiro passageiro = porId(id);

        boolean estaOcupado = passageiro.getCorridas().stream()
                .anyMatch(corrida -> corrida.getStatus() == SOLICITADA || corrida.getStatus() == INICIADA);

        if (estaOcupado) {
            throw new ResponseStatusException(BAD_REQUEST, "Este passageiro já possui uma corrida em andamento.");
        }

        return passageiro;
    }

    public Passageiro porId(Long id) {
        return passageiroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Passageiro não encontrado"));
    }
}
