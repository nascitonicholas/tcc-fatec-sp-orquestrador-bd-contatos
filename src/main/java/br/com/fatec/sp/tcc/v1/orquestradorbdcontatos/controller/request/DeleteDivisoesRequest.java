package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDivisoesRequest {

    @JsonProperty("lista_divisoes")
    private List<DivisaoRequest> divisao;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DivisaoRequest {

        @JsonProperty("id_divisao")
        private Long id;

    }

}
