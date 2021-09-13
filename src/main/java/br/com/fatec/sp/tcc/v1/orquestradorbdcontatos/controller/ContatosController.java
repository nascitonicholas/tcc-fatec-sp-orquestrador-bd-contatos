package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.AbstractController;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.SaidaDefault;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.*;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.SecoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.ContatosFacade;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.SecoesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensEnum.*;

@RestController
@RequestMapping("/contatos")
public class ContatosController implements AbstractController<SaidaDefault> {

    @Autowired
    private ContatosFacade contatosFacade;

    @GetMapping
    public ResponseEntity<?> get() {
        List<ContatosResponse> response = contatosFacade.get();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO_LISTA.getMessage()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id_contato}")
    public ResponseEntity<?> getById(@PathVariable("id_contato") Long id) {
        ContatosResponse response = contatosFacade.getById(id);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO_ID.getMessage()).build(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody AtualizaContatosRequest atualizaContatosRequest) {
        contatosFacade.put(atualizaContatosRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_ATUALIZACAO.getMessage()).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CriacaoContatosRequest contatosRequest) {
        contatosFacade.post(contatosRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_CRIACAO.getMessage()).build(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody DeleteContatosRequest contatosRequest) {
        contatosFacade.delete(contatosRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_DELETADAS.getMessage()).build(), HttpStatus.NO_CONTENT);
    }

}
