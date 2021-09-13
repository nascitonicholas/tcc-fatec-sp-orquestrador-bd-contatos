package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums;

import lombok.Getter;

public enum MensagensErrosEnum {

    MESSAGE_ERROR_CREATE("Não foi possível salvar o recurso - Erro : "),
    MESSAGE_ERROR_DELETE("Não foi possível deletar o recurso - Erro : "),
    MESSAGE_ERROR_UPDATE("Não foi possível atualizar o recurso - Erro : "),
    MESSAGE_ERROR_FIND("Não foi possível encontrar o recurso - Erro : ");

    @Getter
    private String message;

    MensagensErrosEnum(final String message) { this.message = message;}
}
