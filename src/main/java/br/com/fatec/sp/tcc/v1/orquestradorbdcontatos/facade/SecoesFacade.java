package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.AtualizaSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DeleteSecoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.SecoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensErrosEnum;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper.SecoesMapper;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.SecoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.SecoesRepository;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;

@Component
public class SecoesFacade {

    @Autowired
    private SecoesRepository secoesRepository;

    private SecoesMapper mapper = Mappers.getMapper(SecoesMapper.class);

    public List<SecoesResponse> get() {
        List<SecoesModel> listaSecoes = secoesRepository.findAll();
        return mapper.mapListaSecoesModelToListaSecoesResponse(listaSecoes);
    }

    public SecoesResponse getById(Long id) {
        try {
            SecoesModel secao = secoesRepository.findById(id).get();
            return mapper.mapSecoesModelToSecoesResponse(secao);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MensagensErrosEnum.MESSAGE_ERROR_FIND.getMessage() + e.toString());
        }
    }

    public void put(AtualizaSecoesRequest atualizaSecoesRequest) {
        try {
            atualizaSecoesRequest.getRequest().stream().forEach(item -> {
                Optional<SecoesModel> secao = secoesRepository.findById(item.getId());
                if(secao.isPresent()) {
                    secao.get().setNomeSecao(item.getNomeSecao());
                    secao.get().setDataUltimaAlteracao(Utils.buscaDataAtual());
                    secoesRepository.save(secao.get());
                }
            });
        } catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_UPDATE.getMessage() + e.toString());
        }
    }

    public void post(CriacaoSecoesRequest secoesRequest) {
        try {
            secoesRequest.getRequest().forEach(item -> {
                SecoesModel secao = mapper.mapNomeToSecoesModel(item.getNomeSecao());
                secoesRepository.save(secao);
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_CREATE.getMessage() + e.toString());
        }
    }

    public void delete(DeleteSecoesRequest secoesRequest) {
        try {
            secoesRequest.getRequest().forEach(item -> {
                Optional<SecoesModel> secao = secoesRepository.findById(item.getId());
                if(secao.isPresent()) {
                    secoesRepository.deleteById(item.getId());
                }
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_DELETE.getMessage() + e.toString());
        }
    }

}
