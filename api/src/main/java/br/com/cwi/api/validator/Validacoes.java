package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.enums.StatusCorrida;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class Validacoes {

    public void validaSeValorEMaiorQueZero(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new ResponseStatusException(BAD_REQUEST, "Valor deve ser maior que zero.");
        }
    }

    public void corridaNaoIniciada(Corrida corrida) {
        if (corrida.getStatus() == StatusCorrida.SOLICITADA) {
            throw new ResponseStatusException(BAD_REQUEST, "Corrida ainda não iniciada.");
        }
    }

    public void corridaFinalizada(Corrida corrida) {
        if (corrida.getStatus() == StatusCorrida.FINALIZADA) {
            throw new ResponseStatusException(BAD_REQUEST, "Corrida já finalizada.");
        }
    }

    public void corridaIniciou(Corrida corrida) {
        if (corrida.getStatus() != StatusCorrida.SOLICITADA) {
            throw new ResponseStatusException(BAD_REQUEST, "Corrida já iniciada.");
        }
    }

    public void saldoInsuficiente(BigDecimal saldoPassageiro, BigDecimal custoCorrida) {
        if (saldoPassageiro.compareTo(custoCorrida) == -1) {
            throw new ResponseStatusException(BAD_REQUEST, "Valor na carteira é inferior ao necessáro.");
        }
    }

    public void validaSeScoreEstaEntreUmECinco(float score) {
        if(!(score >=1 && score <= 5))
            throw new ResponseStatusException(BAD_REQUEST, "Nota deve ser entre 1 e 5.");
    }

    public void sacarValorMaiorQueSaldo(BigDecimal saldoMotorista, BigDecimal valorSacado) {
        if (saldoMotorista.compareTo(valorSacado) == -1) {
            throw new ResponseStatusException(BAD_REQUEST, "Valor do saque é maior do que o saldo.");
        }
    }
}
