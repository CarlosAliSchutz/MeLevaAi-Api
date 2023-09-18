package br.com.cwi.api.service.validators;

import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class ValidaIdadeService {

    public static final int IDADE_MINIMA_MOTORISTA = 18;
    public static final int IDADE_MINIMA_PASSAGEIRO = 16;
    private final LocalDate DATA_ATUAL = LocalDate.now();


    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public void validarPassageiro(LocalDate nascimento) {
        int idade = getIdade(nascimento);

        if(idade < IDADE_MINIMA_PASSAGEIRO){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "O passageiro deve possuir mais de 16 anos");
        }
    }

    public void validarMotorista(LocalDate nascimento) {
        int idade = getIdade(nascimento);

        if(idade < IDADE_MINIMA_MOTORISTA){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "O motorista deve possuir mais de 18 anos");
        }
    }

    private int getIdade(LocalDate nascimento) {
        Period periodo = Period.between(nascimento, DATA_ATUAL);
        return periodo.getYears();
    }
}
