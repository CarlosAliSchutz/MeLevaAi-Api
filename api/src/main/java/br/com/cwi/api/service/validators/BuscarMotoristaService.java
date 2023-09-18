package br.com.cwi.api.service.validators;

import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.enums.Categoria;
import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarMotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista porId(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Motorista não encontrado."));
    }

    public void verificaSeJaTemCarro(Motorista motorista) {
        if (motorista.getVeiculo() != null) {
            throw new ResponseStatusException(BAD_REQUEST, motorista.getNome() + " já tem carro.");
        }
    }

    public void validaCategoria(Motorista motorista, Categoria categoria) {
        if (motorista.getLicencaMotorista().getCategoria() != categoria) {
            throw new ResponseStatusException(BAD_REQUEST, "Motorista não é habilitado para dirigir este carro.");
        }
    }

    public void verificaSeJaTemHabilitacao(Motorista motorista) {
        if (motorista.getLicencaMotorista() != null) {
            throw new ResponseStatusException(BAD_REQUEST, motorista.getNome() + " já tem habilitação.");
        }
    }
}
