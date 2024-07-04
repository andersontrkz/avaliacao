package atividade1;

import static atividade1.utils.Verificadores.verificarFinalString;

public class Main {
    public static void main(String[] args) {
        System.out.println("Atividade 1");
        verificarFinalString("programação", "ão");
        verificarFinalString("olá", "mundo");
        verificarFinalString("", "abc");
    }
}
