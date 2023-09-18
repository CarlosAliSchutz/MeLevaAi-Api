package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.IncluirVeiculoRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.service.IncluirVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private IncluirVeiculoService incluirVeiculoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse incluir(@Valid @RequestBody IncluirVeiculoRequest request) {
        return incluirVeiculoService.incluir(request);
    }
}
