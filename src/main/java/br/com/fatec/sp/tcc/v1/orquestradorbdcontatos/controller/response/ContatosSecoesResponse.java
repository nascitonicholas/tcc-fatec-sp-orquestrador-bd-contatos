package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatosSecoesResponse {

    @JsonProperty("id_secao")
    private Long id;
    @JsonProperty("nome_secao")
    private String nomeSecao;
    @JsonProperty("data_criacao")
    private String dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;

}
