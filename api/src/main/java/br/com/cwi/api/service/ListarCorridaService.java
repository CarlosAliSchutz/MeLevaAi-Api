package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.ListarCorridaResponse;
import br.com.cwi.api.mapper.ListarCorridaMapper;
import br.com.cwi.api.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarCorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    public List<ListarCorridaResponse> listar() {
        return corridaRepository.findAll().stream()
                .map(ListarCorridaMapper::toResponse)
                .collect(toList());
    }
}
