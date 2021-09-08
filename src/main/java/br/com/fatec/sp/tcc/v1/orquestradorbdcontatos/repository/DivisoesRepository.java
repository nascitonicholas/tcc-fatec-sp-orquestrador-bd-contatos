package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DivisoesRepository extends JpaRepository<DivisoesModel, Long> {

}
