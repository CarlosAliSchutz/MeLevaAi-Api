package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AdicionarHabilitacaoRequest;
import br.com.cwi.api.controller.request.AvaliarPassageiroRequest;
import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.controller.request.SacarContaVirtualMotoristaRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.controller.response.MotoristaResumidoResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private AvaliarPassageiroService avaliarPassageiroService;

    @Autowired
    private SacarCreditoMotoristaService sacarCreditoMotoristaService;

    @Autowired
    private ListarMotoristasService listarMotoristasService;

    @Autowired
    private IncluirMotoristaService incluirMotoristaService;

    @Autowired
    private AdicionarHabilitacaoService adicionarHabilitacaoService;

    @GetMapping
    public List<MotoristaResumidoResponse> listar() {
        return listarMotoristasService.listar();
    }

    @PutMapping("avaliarPassageiro")
    @ResponseStatus(HttpStatus.OK)
    public MensagemResponse avaliarPassageiro(@Valid @RequestBody AvaliarPassageiroRequest request) {
        return avaliarPassageiroService.avaliarPassageiro(request);
    }

    @PutMapping("{id}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public MensagemResponse sacarCredito(@PathVariable Long id, @Valid @RequestBody SacarContaVirtualMotoristaRequest request) {
        return sacarCreditoMotoristaService.sacar(id, request);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse incluir(@Valid @RequestBody IncluirMotoristaRequest request) {
        return incluirMotoristaService.incluir(request);
    }

    @PostMapping("/habilitacao")
    @ResponseStatus(CREATED)
    public IdResponse adicionarHabilitacao(@Valid @RequestBody AdicionarHabilitacaoRequest request) {
        return adicionarHabilitacaoService.adicionarHabilitacao(request);
    }
}
