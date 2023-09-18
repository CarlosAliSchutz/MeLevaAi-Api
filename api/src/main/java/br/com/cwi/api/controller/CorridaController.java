package br.com.cwi.api.controller;

import br.com.cwi.api.controller.response.FinalizarCorridaResponse;
import br.com.cwi.api.controller.response.IniciarCorridaResponse;
import br.com.cwi.api.controller.response.ListarCorridaResponse;
import br.com.cwi.api.service.FinalizarCorridaService;
import br.com.cwi.api.service.IniciarCorridaService;
import br.com.cwi.api.service.ListarCorridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private IniciarCorridaService iniciarCorridaService;

    @Autowired
    private FinalizarCorridaService finalizarCorridaService;

    @Autowired
    private ListarCorridaService listarCorridaService;

    @GetMapping
    public List<ListarCorridaResponse> listar() {
        return listarCorridaService.listar();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public IniciarCorridaResponse iniciarCorrida(@PathVariable Long id) {
        return iniciarCorridaService.iniciar(id);
    }

    @PutMapping("/{id}/finalizar")
    @ResponseStatus(HttpStatus.OK)
    public FinalizarCorridaResponse finalizarCorrida(@PathVariable Long id) {
        return finalizarCorridaService.finalizar(id);
    }
}
