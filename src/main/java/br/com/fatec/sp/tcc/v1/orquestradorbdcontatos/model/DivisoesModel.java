package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "divisoes")
public class DivisoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_divisao")
	private Long id;
	@Column(name = "nome_divisao")
	private String nomeDivisao;
	@Column(name = "dt_criacao")
	private LocalDate dataCriacao;
	@Column(name = "dt_ultima_alteracao")
	private LocalDate dataUltimaAlteracao;

}
