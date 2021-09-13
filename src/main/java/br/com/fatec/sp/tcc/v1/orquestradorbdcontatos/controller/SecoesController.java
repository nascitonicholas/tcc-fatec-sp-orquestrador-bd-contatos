package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.AbstractController;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.SaidaDefault;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.AtualizaSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DeleteSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.SecoesResponse;
import static br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensEnum.*;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.SecoesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secoes")
public class SecoesController implements AbstractController<SaidaDefault> {

    @Autowired
    private SecoesFacade secoesFacade;

    @GetMapping
    public ResponseEntity<?> get() {
        List<SecoesResponse> response = secoesFacade.get();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO_LISTA.getMessage()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id_secao}")
    public ResponseEntity<?> getById(@PathVariable("id_divisao") Long id) {
        SecoesResponse response = secoesFacade.getById(id);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO_ID.getMessage()).build(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody AtualizaSecoesRequest secoesRequest) {
        secoesFacade.put(secoesRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_ATUALIZACAO.getMessage()).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CriacaoSecoesRequest secoesRequest) {
        secoesFacade.post(secoesRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_CRIACAO.getMessage()).build(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody DeleteSecoesRequest secoesRequest) {
        secoesFacade.delete(secoesRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_DELETADAS.getMessage()).build(), HttpStatus.NO_CONTENT);
    }

}
