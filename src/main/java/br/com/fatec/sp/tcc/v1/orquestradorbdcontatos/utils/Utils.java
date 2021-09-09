package br.com.fatec.sp.tcc.v1.orquestradorbdcontatos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    private static final String DATA_FORMATO = "yyyy/MM/dd HH:mm:ss";

    public static String buscaDataAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATA_FORMATO));
    }

    public static void main(String[] args) {
        System.out.println(buscaDataAtual());
    }
}

