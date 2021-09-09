package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper
public interface DivisoesMapper {

    @Named("mapListaDivisaoModelToDivisaoResponse")
    default List<DivisoesResponse> mapListaDivisaoModelToDivisaoResponse (List<DivisoesModel> listaDivisoes) {

        List<DivisoesResponse> divisoesResponses = new ArrayList<>();

        listaDivisoes.stream().forEach(divisao -> {
            if(Objects.nonNull(divisao)) divisoesResponses.add(mapDivisaoModelToDivisaoResponse(divisao));
        });

        return  divisoesResponses;
    }

    DivisoesResponse mapDivisaoModelToDivisaoResponse(DivisoesModel divisoesModel);

}
