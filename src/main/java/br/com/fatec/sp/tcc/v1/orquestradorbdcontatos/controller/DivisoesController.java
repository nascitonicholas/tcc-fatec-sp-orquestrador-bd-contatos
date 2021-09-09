package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.AbstractController;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.SaidaDefault;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DeleteDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.DivisoesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisoes")
public class DivisoesController implements AbstractController<SaidaDefault> {

    private final String MESSAGE_SUCESSO = "Divisões retornadas com sucesso.";
    private final String MESSAGE_SUCESSO_ID = "Divisão encontrada com sucesso.";
    private final String MESSAGE_SUCESSO_CRIACAO = "Divisões cadastradas com sucesso.";

    @Autowired
    private DivisoesFacade divisoesFacade;

    @GetMapping
    public ResponseEntity<?> getDivisoes() {
        List<DivisoesResponse> response = divisoesFacade.getDivisoes();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO).build(), HttpStatus.OK);
    }

    @GetMapping("/{id_divisao}")
    public ResponseEntity<?> getDivisoesById(@PathVariable("id_divisao") Long id) {
        DivisoesResponse response = divisoesFacade.getDivisoesById(id);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO_ID).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postDivisoes(@RequestBody CriacaoDivisoesRequest divisaoRequest) {
        divisoesFacade.postDivisoes(divisaoRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_CRIACAO).build(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDivisoes(@RequestBody DeleteDivisoesRequest divisaoRequest) {
        divisoesFacade.deleteDivisoes(divisaoRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MESSAGE_SUCESSO_CRIACAO).build(), HttpStatus.NO_CONTENT);
    }

}
