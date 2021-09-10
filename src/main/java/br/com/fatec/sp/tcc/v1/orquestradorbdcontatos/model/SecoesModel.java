package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "secoes")
public class SecoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secao")
    private Long id;
    @Column(name = "nome_secao")
    private String nomeSecao;
    @Column(name = "dt_criacao")
    private String dataCriacao;
    @Column(name = "dt_ultima_alteracao")
    private String dataUltimaAlteracao;

}
