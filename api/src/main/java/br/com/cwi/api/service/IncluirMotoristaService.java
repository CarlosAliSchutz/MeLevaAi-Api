package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.service.validators.ValidaCpfUnicoService;
import br.com.cwi.api.service.validators.ValidaIdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.IdResponseMapper.toResponse;
import static br.com.cwi.api.mapper.IncluirMotoristaMapper.toEntity;

@Service
public class IncluirMotoristaService {

    @Autowired
    private ValidaCpfUnicoService validaCpfUnicoService;

    @Autowired
    private ValidaIdadeService validaIdadeService;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public IdResponse incluir(IncluirMotoristaRequest request) {

        validaCpfUnicoService.validarMotorista(request.getCpf());
        validaIdadeService.validarMotorista(request.getDataNascimento());

        Motorista motorista = toEntity(request);
        motorista.setScore(5);

        motoristaRepository.save(motorista);

        return toResponse(motorista.getId());
    }
}
