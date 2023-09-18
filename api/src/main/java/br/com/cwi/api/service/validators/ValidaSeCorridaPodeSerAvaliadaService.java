package br.com.cwi.api.service.validators;

import br.com.cwi.api.domain.Corrida;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.api.domain.enums.StatusCorrida.FINALIZADA;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaSeCorridaPodeSerAvaliadaService {

    public void validarMotorista(Corrida corrida) {
        if (corrida.getScoreMotorista() != null) {
            throw new ResponseStatusException(BAD_REQUEST, "Você já avaliou essa corrida");
        }
    }

    public void validarPassageiro(Corrida corrida) {
        if (corrida.getScorePassageiro() != null) {
            throw new ResponseStatusException(BAD_REQUEST, "Você já avaliou essa corrida");
        }
    }

    public void validarCorrida(Corrida corrida) {
        if(corrida.getStatus() != FINALIZADA) {
            throw new ResponseStatusException(BAD_REQUEST, "Para avaliar a corrida precisa ter sido finalizada");
        }
    }
}
