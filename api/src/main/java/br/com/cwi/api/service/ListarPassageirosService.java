package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.PassageiroResumidoResponse;
import br.com.cwi.api.mapper.ListarPassageirosMapper;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPassageirosService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public Page<PassageiroResumidoResponse> listar(Pageable pageable) {
        return passageiroRepository.findPassageirosDisponiveis(pageable)
                .map(ListarPassageirosMapper::toResponse);
    }
}
