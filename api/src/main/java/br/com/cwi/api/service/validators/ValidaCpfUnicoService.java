package br.com.cwi.api.service.validators;

import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class ValidaCpfUnicoService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public void validarPassageiro(String cpf) {
        if(passageiroRepository.existsByCpf(cpf)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Já existe um passageiro com este cpf");
        }
    }

    public void validarMotorista(String cpf) {
        if(motoristaRepository.existsByCpf(cpf)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Já existe um motorista com este cpf");
        }
    }

}
