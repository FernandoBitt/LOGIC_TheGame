package com.example.logic_thegamev2;

public class Jogador {

    String apelido;
    static int progresso;

    public String getApelido() {
        return apelido;
    }

    public static int getProgresso() {
        return progresso;
    }

    public static void setProgresso(int progresso) {
        Jogador.progresso = progresso;
    }

}
