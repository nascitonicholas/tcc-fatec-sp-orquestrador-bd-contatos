package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.SecoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.SecoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(imports = {Utils.class})
public interface SecoesMapper {

    @Mapping(target = "nomeSecao", expression = "java(Utils.upperCase(nome))")
    SecoesModel mapNomeToSecoesModel(String nome);

    SecoesResponse mapSecoesModelToSecoesResponse(SecoesModel secao);

    @Named("mapListaSecoesModelToListaSecoesResponse")
    default List<SecoesResponse> mapListaSecoesModelToListaSecoesResponse(List<SecoesModel> listaSecoes) {
        List<SecoesResponse> response = new ArrayList<>();
        listaSecoes.stream().forEach(item -> {
            if(Objects.nonNull(item)) response.add(mapSecoesModelToSecoesResponse(item));
        });
        return response;
    }

}
