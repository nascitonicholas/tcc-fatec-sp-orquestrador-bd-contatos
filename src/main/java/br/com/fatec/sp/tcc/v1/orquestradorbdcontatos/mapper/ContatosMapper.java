package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoContatosRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.ContatosModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(imports = {Utils.class})
public interface ContatosMapper {

    @Mappings({
            @Mapping(target = "dataCriacao", expression = "java(Utils.buscaDataAtual())"),
            @Mapping(target = "dataUltimaAlteracao", expression = "java(Utils.buscaDataAtual())"),
    })
    ContatosModel mapContatosRequestToContatosModel(CriacaoContatosRequest.Request request);

    ContatosResponse mapContatosModelToContatosResponse(ContatosModel secao);

    @Named("mapListaSecoesModelToListaSecoesResponse")
    default List<ContatosResponse> mapListaContatosModelToListaContatosResponse(List<ContatosModel> listaSecoes) {
        List<ContatosResponse> response = new ArrayList<>();
        listaSecoes.stream().forEach(item -> {
            if(Objects.nonNull(item)) response.add(mapContatosModelToContatosResponse(item));
        });
        return response;
    }

}
