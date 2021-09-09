package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.AbstractController;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.SaidaDefault;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.AtualizaDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DeleteDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensEnum;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.DivisoesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisoes")
public class DivisoesController implements AbstractController<SaidaDefault> {

    @Autowired
    private DivisoesFacade divisoesFacade;

    @GetMapping
    public ResponseEntity<?> getDivisoes() {
        List<DivisoesResponse> response = divisoesFacade.getDivisoes();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MensagensEnum.MESSAGE_SUCESSO_LISTA.getMessage()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id_divisao}")
    public ResponseEntity<?> getDivisoesById(@PathVariable("id_divisao") Long id) {
        DivisoesResponse response = divisoesFacade.getDivisoesById(id);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MensagensEnum.MESSAGE_SUCESSO_ID.getMessage()).build(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putDivisoes(@RequestBody AtualizaDivisoesRequest divisaoRequest) {
        divisoesFacade.putDivisoes(divisaoRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MensagensEnum.MESSAGE_SUCESSO_ATUALIZACAO.getMessage()).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postDivisoes(@RequestBody CriacaoDivisoesRequest divisaoRequest) {
        divisoesFacade.postDivisoes(divisaoRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MensagensEnum.MESSAGE_SUCESSO_CRIACAO.getMessage()).build(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDivisoes(@RequestBody DeleteDivisoesRequest divisaoRequest) {
        divisoesFacade.deleteDivisoes(divisaoRequest);
        return saidaSimplificada(SaidaDefault.builder().message(MensagensEnum.MESSAGE_SUCESSO_DELETADAS.getMessage()).build(), HttpStatus.NO_CONTENT);
    }

}
