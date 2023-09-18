package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.MotoristaResumidoResponse;
import br.com.cwi.api.mapper.ListarMotoristasMapper;
import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarMotoristasService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<MotoristaResumidoResponse> listar() {
        return motoristaRepository.findByVeiculoIsNotNull().stream()
                .map(ListarMotoristasMapper::toResponse)
                .collect(toList());
    }
}
