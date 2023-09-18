package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AvaliarMotoristaRequest;
import br.com.cwi.api.controller.request.DepositarCreditoPassageiroRequest;
import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.controller.response.MensagemResponse;
import br.com.cwi.api.controller.response.PassageiroResumidoResponse;
import br.com.cwi.api.controller.response.SolicitarCorridaResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private ListarPassageirosService listarPassageirosService;

    @Autowired
    private IncluirPassageiroService incluirPassageiroService;

    @Autowired
    private SolicitarCorridaService solicitarCorridaService;

    @Autowired
    private DepositarCreditoPassageiroService depositarCreditoPassageiroService;

    @Autowired
    private AvaliarMotoristaService avaliarMotoristaService;

    @GetMapping
    public Page<PassageiroResumidoResponse> listar(Pageable pageable) {
        return listarPassageirosService.listar(pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse incluir(@Valid @RequestBody IncluirPassageiroRequest request) {
        return incluirPassageiroService.incluir(request);
    }

    @PostMapping("/{id}/solicitarCorrida")
    public SolicitarCorridaResponse solicitarCorrida(@PathVariable Long id,@Valid @RequestBody SolicitarCorridaRequest request) {
        return solicitarCorridaService.solicitarCorrida(id, request);
    }

    @PutMapping("/{id}/depositarCredito")
    public MensagemResponse depositarCredito(@PathVariable Long id, @Valid @RequestBody DepositarCreditoPassageiroRequest request) {
        return depositarCreditoPassageiroService.depositarCredito(id, request);
    }

    @PutMapping("avaliarMotorista")
    public MensagemResponse avaliarMotorista(@Valid @RequestBody AvaliarMotoristaRequest request) {
        return avaliarMotoristaService.avaliarMotorista(request);
    }

}
