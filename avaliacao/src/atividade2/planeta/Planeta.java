package atividade2.planeta;

import atividade2.interfaces.IDetalhes;

public class Planeta implements IDetalhes, IPlaneta {
    private String nome;
    private Double periculosidade;

    public Planeta(String nome, Double periculosidade) {
        this.nome = nome;
        this.periculosidade = periculosidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(Double periculosidade) {
        this.periculosidade = periculosidade;
    }

    @Override
    public String detalhes() {
        return "Planeta: " + getNome() + ", Periculosidade: " + getPericulosidade();
    }
}
