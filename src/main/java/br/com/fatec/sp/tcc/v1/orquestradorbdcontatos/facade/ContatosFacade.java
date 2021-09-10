package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.facade;

import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.request.*;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums.MensagensErrosEnum;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.mapper.ContatosMapper;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.ContatosModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.DivisoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.model.SecoesModel;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.ContatosRepository;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.DivisoesRepository;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.repository.SecoesRepository;
import br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils.Utils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class ContatosFacade {

    @Autowired
    private ContatosRepository contatosRepository;

    @Autowired
    private DivisoesRepository divisoesRepository;

    @Autowired
    private SecoesRepository secoesRepository;

    private ContatosMapper mapper = Mappers.getMapper(ContatosMapper.class);

    public List<ContatosResponse> get() {
        List<ContatosModel> listaContatos = contatosRepository.findAll();
        return mapper.mapListaContatosModelToListaContatosResponse(listaContatos);
    }

    public ContatosResponse getById(Long id) {
        try {
            ContatosModel contato = contatosRepository.findById(id).get();
            return mapper.mapContatosModelToContatosResponse(contato);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MensagensErrosEnum.MESSAGE_ERROR_FIND.getMessage() + e.toString());
        }
    }

    public void put(AtualizaContatosRequest atualizaContatosRequest) {
        try {
            atualizaContatosRequest.getRequest().stream().forEach(item -> {
                Optional<ContatosModel> contato = contatosRepository.findById(item.getId());
                if(contato.isPresent()) {
                    Optional<DivisoesModel> divisao = divisoesRepository.findById(item.getIdDivisao());
                    Optional<SecoesModel> secao = secoesRepository.findById(item.getIdSecao());
                    if(divisao.isPresent()) contato.get().setDivisoesModel(divisao.get());
                    if(secao.isPresent()) contato.get().setSecoesModel(secao.get());
                    if(!item.getTelefone().isBlank()) contato.get().setTelefone(item.getTelefone());
                    if(!item.getEmail().isBlank()) contato.get().setEmail(item.getEmail());
                    contato.get().setDataUltimaAlteracao(Utils.buscaDataAtual());
                    contatosRepository.save(contato.get());
                }
            });
        } catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_UPDATE.getMessage() + e.toString());
        }
    }

    public void post(CriacaoContatosRequest contatosRequest) {
        try {
            contatosRequest.getRequest().forEach(item -> {
                ContatosModel contato = mapper.mapContatosRequestToContatosModel(item);
                contatosRepository.save(contato);
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_CREATE.getMessage() + e.toString());
        }
    }

    public void delete(DeleteContatosRequest contatosRequest) {
        try {
            contatosRequest.getRequest().forEach(item -> {
                Optional<ContatosModel> contato = contatosRepository.findById(item.getId());
                if(contato.isPresent()) {
                    contatosRepository.deleteById(item.getId());
                }
            });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MensagensErrosEnum.MESSAGE_ERROR_DELETE.getMessage() + e.toString());
        }
    }

}
