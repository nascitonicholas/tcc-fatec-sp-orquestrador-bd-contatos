package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriacaoSecoesRequest {

    @JsonProperty("lista_secoes")
    private List<Request> request = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @JsonProperty("nome_secao")
        private String nomeSecao;

    }
}
