package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<ContatosModel, Long> {
}
