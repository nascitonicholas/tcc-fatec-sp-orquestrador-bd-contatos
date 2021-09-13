package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSecoesRequest {

    @JsonProperty("lista_secoes")
    private List<Request> request;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @JsonProperty("id_secao")
        private Long id;

    }

}
