package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirVeiculoRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Veiculo;
import br.com.cwi.api.repository.VeiculoRepository;
import br.com.cwi.api.service.validators.BuscarMotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.IdResponseMapper.toResponse;
import static br.com.cwi.api.mapper.IncluirVeiculoMapper.toEntity;

@Service
public class IncluirVeiculoService {

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public IdResponse incluir(IncluirVeiculoRequest request) {

        Motorista motorista = buscarMotoristaService.porId(request.getMotoristaId());
        buscarMotoristaService.verificaSeJaTemCarro(motorista);
        buscarMotoristaService.validaCategoria(motorista, request.getCategoria());

        Veiculo veiculo = toEntity(request);
        veiculo.setMotorista(motorista);

        veiculoRepository.save(veiculo);

        return toResponse(veiculo.getId());
    }
}
