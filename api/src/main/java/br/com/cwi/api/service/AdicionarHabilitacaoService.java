package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AdicionarHabilitacaoRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.LicencaMotorista;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.LicencaMotoristaRepository;
import br.com.cwi.api.service.validators.BuscarMotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.AdicionarHabilitacaoMapper.toEntity;
import static br.com.cwi.api.mapper.IdResponseMapper.toResponse;

@Service
public class AdicionarHabilitacaoService {

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private LicencaMotoristaRepository licencaMotoristaRepository;

    @Transactional
    public IdResponse adicionarHabilitacao(AdicionarHabilitacaoRequest request) {

        Motorista motorista = buscarMotoristaService.porId(request.getMotoristaId());
        buscarMotoristaService.verificaSeJaTemHabilitacao(motorista);

        LicencaMotorista licencaMotorista = toEntity(request);
        licencaMotorista.setMotorista(motorista);

        licencaMotoristaRepository.save(licencaMotorista);

        return toResponse(licencaMotorista.getId());
    }
}
