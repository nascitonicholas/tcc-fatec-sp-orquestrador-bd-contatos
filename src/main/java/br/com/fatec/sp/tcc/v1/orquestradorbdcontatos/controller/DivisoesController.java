package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.AbstractController;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.config.SaidaDefault;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade.DivisoesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/divisoes")
public class DivisoesController implements AbstractController<SaidaDefault> {

    private final String MESSAGE_SUCESSO = "Divisões retornadas com sucesso.";

    @Autowired
    private DivisoesFacade divisoesFacade;

    @GetMapping
    public ResponseEntity<?> getDivisoes() {
        List<DivisoesResponse> response = divisoesFacade.getDivisoes();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message(MESSAGE_SUCESSO).build(), HttpStatus.OK);
    }

}
