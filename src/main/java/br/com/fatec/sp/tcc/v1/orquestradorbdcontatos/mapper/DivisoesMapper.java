package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(imports = {Utils.class})
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

    @Mappings({
            @Mapping(target = "dataCriacao", expression = "java(Utils.buscaDataAtual())"),
            @Mapping(target = "dataUltimaAlteracao", expression = "java(Utils.buscaDataAtual())"),
    })
    DivisoesModel mapDivisaoEntradaToDivisaoModel(DivisoesRequest.DivisaoRequest divisao);
}
