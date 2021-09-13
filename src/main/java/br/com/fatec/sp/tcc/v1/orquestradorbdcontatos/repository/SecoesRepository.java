package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.SecoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecoesRepository extends JpaRepository<SecoesModel, Long> {
}
