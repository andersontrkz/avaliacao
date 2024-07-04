package atividade1.utils;

public class Verificadores {
    public static Boolean verificarFinalString(String palavra1, String palavra2) {
        String[] partesPalavra1 = palavra1.split("");
        String[] partesPalavra2 = palavra2.split("");

        String ultimoCaractere = pegarLetraPorIndex(partesPalavra1, palavra1.length() - 1);
        String penultimoCaractere = pegarLetraPorIndex(partesPalavra1, palavra1.length() - 2);

        String primeiroCaractere = pegarLetraPorIndex(partesPalavra2, 0);
        String segundoCaractere = pegarLetraPorIndex(partesPalavra2, 1);

        Boolean ehIgual = ultimoCaractere.equals(segundoCaractere) && penultimoCaractere.equals(primeiroCaractere);

        if (ehIgual) {
            System.out.println("As entradas são iguais!");
        } else {
            System.out.println("As entradas não são iguais!");
        }

        return ehIgual;
    }

    private static String pegarLetraPorIndex(String[] palavras, Integer index) {
        if (index >= 0 && index < palavras.length) {
            return palavras[index];
        }

        return "";
    }
}
