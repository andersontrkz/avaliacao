package atividade2.especie;

import atividade2.interfaces.IDetalhes;
import atividade2.planeta.Planeta;

public class Especie implements IDetalhes, IEspecie {
    private String nome;
    private Planeta planetaOrigem;
    private Double periculosidade;

    public Especie(String nome, Planeta planetaOrigem, Double periculosidade) {
        this.nome = nome;
        this.planetaOrigem = planetaOrigem;
        this.periculosidade = periculosidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Planeta getPlanetaOrigem() {
        return planetaOrigem;
    }

    public void setPlanetaOrigem(Planeta planetaOrigem) {
        this.planetaOrigem = planetaOrigem;
    }

    public Double getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(Double periculosidade) {
        this.periculosidade = periculosidade;
    }

    @Override
    public String detalhes() {
        return "Espécie: " + getNome() + ", Planeta de Origem: " + getPlanetaOrigem().getNome() + ", Periculosidade: " + getPericulosidade();
    }
}
