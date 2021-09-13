package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.AtualizaDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.CriacaoDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.DeleteDivisoesRequest;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.DivisoesResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensErrosEnum;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper.DivisoesMapper;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.DivisoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;

@Component
public class DivisoesFacade {

    @Autowired
    private DivisoesRepository divisoesRepository;

    private DivisoesMapper divisoesMapper = Mappers.getMapper(DivisoesMapper.class);

    public List<DivisoesResponse> getDivisoes() {
        List<DivisoesModel> listaDivisoes = divisoesRepository.findAll();

        return divisoesMapper.mapListaDivisaoModelToDivisaoResponse(listaDivisoes);
    }

    public DivisoesResponse getDivisoesById(Long id) {
        try {
            DivisoesModel divisao = divisoesRepository.findById(id).get();

            return divisoesMapper.mapDivisaoModelToDivisaoResponse(divisao);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MensagensErrosEnum.MESSAGE_ERROR_FIND.getMessage() + e.toString());
        }
    }

    public void postDivisoes(CriacaoDivisoesRequest divisaoRequest) {
        try {
            divisaoRequest.getDivisao().stream().forEach(divisao -> {
                if(divisao.getNomeDivisao().isBlank()) {
                    DivisoesModel divisaoModel = divisoesMapper.mapDivisaoEntradaToDivisaoModel(divisao);
                    divisoesRepository.save(divisaoModel);
                }
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_CREATE.getMessage() + e.toString());
        }
    }

    public void deleteDivisoes(DeleteDivisoesRequest divisaoRequest) {
        try {
            divisaoRequest.getDivisao().stream().forEach(item -> {
                Optional<DivisoesModel> divisao = divisoesRepository.findById(item.getId());
                if(divisao.isPresent()) {
                    divisoesRepository.deleteById(item.getId());
                }
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_DELETE.getMessage() + e.toString());
        }
    }

    public void putDivisoes(AtualizaDivisoesRequest divisaoRequest) {
        try {
            divisaoRequest.getDivisao().stream().forEach(divisaoAtualizada -> {
                Optional<DivisoesModel> divisao = divisoesRepository.findById(divisaoAtualizada.getId());
                if(divisao.isPresent()) {
                    divisao.get().setNomeDivisao(divisaoAtualizada.getNomeDivisao());
                    divisoesRepository.save(divisao.get());
                }
            });
        } catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_UPDATE.getMessage() + e.toString());
        }
    }
}
