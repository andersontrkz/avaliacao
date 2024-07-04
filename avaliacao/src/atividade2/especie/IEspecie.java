package atividade2.especie;

import atividade2.planeta.Planeta;

public interface IEspecie {
    String getNome();
    Planeta getPlanetaOrigem();
    Double getPericulosidade();
}
