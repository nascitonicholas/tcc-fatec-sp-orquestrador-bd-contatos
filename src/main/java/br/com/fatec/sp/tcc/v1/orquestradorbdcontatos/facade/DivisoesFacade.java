package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper.DivisoesMapper;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.DivisoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class DivisoesFacade {

    @Autowired
    private DivisoesRepository divisoesRepository;

    private DivisoesMapper divisoesMapper;

    public List<DivisoesResponse> getDivisoes() {
        List<DivisoesModel> listaDivisoes = divisoesRepository.findAll();

        return divisoesMapper.mapListaDivisaoModelToDivisaoResponse(listaDivisoes);
    }

    public DivisoesResponse getDivisoesById(Long id) {
        try {
            DivisoesModel divisao = divisoesRepository.findById(id).get();

            return divisoesMapper.mapDivisaoModelToDivisaoResponse(divisao);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados não encontrados - Erro : " + e.toString());
        }

    }
}
