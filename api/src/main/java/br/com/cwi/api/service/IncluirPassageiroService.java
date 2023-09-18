package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.PassageiroRepository;
import br.com.cwi.api.service.validators.ValidaCpfUnicoService;
import br.com.cwi.api.service.validators.ValidaIdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.IdResponseMapper.toResponse;
import static br.com.cwi.api.mapper.IncluirPassageiroMapper.toEntity;

@Service
public class IncluirPassageiroService {

    @Autowired
    private ValidaCpfUnicoService validaCpfUnicoService;

    @Autowired
    private ValidaIdadeService validaIdadeService;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Transactional
    public IdResponse incluir(IncluirPassageiroRequest request) {

        validaCpfUnicoService.validarPassageiro(request.getCpf());
        validaIdadeService.validarPassageiro(request.getDataNascimento());

        Passageiro passageiro = toEntity(request);
        passageiro.setScore(5);

        passageiroRepository.save(passageiro);

        return toResponse(passageiro.getId());
    }
}
