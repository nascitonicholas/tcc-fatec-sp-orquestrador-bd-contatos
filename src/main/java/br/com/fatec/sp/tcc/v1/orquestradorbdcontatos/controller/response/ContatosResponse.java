package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatosResponse {

    @JsonProperty("id_contato")
    private Long id;
    @JsonProperty("divisao")
    private ContatosDivisoesResponse divisoesModel;
    @JsonProperty("secao")
    private ContatosSecoesResponse secoesModel;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("data_criacao")
    private String dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;


}
