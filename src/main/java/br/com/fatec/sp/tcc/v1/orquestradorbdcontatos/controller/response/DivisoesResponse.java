package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DivisoesResponse {

    @JsonProperty("id_divisao")
    private Long id;
    @JsonProperty("nome_divisao")
    private String nomeDivisao;
    @JsonProperty("data_criacao")
    private LocalDate dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private LocalDate dataUltimaAlteracao;

}
