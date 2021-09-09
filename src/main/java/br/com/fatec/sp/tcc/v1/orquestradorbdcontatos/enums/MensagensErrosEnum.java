package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.enums;

import lombok.Getter;

public enum MensagensErrosEnum {

    MESSAGE_ERROR_CREATE("Não foi possível salvar o recurso"),
    MESSAGE_ERROR_DELETE("Não foi possível deletar o recurso"),
    MESSAGE_ERROR_UPDATE("Não foi possível atualizar o recurso"),
    MESSAGE_ERROR_FIND("Não foi possível encontrar o recurso");

    @Getter
    private String message;

    MensagensErrosEnum(final String message) { this.message = message;}
}
