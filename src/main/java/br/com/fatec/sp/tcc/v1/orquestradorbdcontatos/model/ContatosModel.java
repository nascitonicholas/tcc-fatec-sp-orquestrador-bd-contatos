package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "contatos")
public class ContatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_divisao")
    private DivisoesModel divisoesModel;
    @ManyToOne
    @JoinColumn(name = "id_secoes")
    private SecoesModel secoesModel;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "dt_criacao")
    private LocalDate dataCriacao;
    @Column(name = "dt_ultima_alteracao")
    private LocalDate dataUltimaAlteracao;

}
