package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriacaoContatosRequest {

    @JsonProperty("lista_contatos")
    private List<Request> request;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @JsonProperty("id_contato")
        private Long id;

        @JsonProperty("id_nova_divisao")
        private Long idDivisao;

        @JsonProperty("id_nova_secao")
        private Long idSecao;

        @JsonProperty("telefone")
        private String telefone;

        @JsonProperty("email")
        private String email;

    }

}
