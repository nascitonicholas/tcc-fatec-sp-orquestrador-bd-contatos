package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper.DivisoesMapper;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.DivisoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DivisoesFacade {

    @Autowired
    private DivisoesRepository divisoesRepository;

    private DivisoesMapper divisoesMapper;

    public List<DivisoesResponse> getDivisoes() {
        List<DivisoesModel> listaDivisoes = divisoesRepository.findAll();

        return divisoesMapper.mapListaDivisaoModelToDivisaoResponse(listaDivisoes);
    }
}
