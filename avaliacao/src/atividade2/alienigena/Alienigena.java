package atividade2.alienigena;

import atividade2.especie.Especie;
import atividade2.interfaces.IDetalhes;

import java.time.LocalDateTime;
import java.util.Random;

public class Alienigena implements IDetalhes, IAlienigena {
    private static Integer id;
    private String nome;
    private Especie especie;
    private Double periculosidade;
    private LocalDateTime dataHoraEntrada;
    private Boolean emQuarentena;

    public Alienigena(String nome, Especie especie, Double periculosidade) {
        this.id = new Random().nextInt();
        this.nome = nome;
        this.especie = especie;
        this.periculosidade = periculosidade;
        this.dataHoraEntrada = LocalDateTime.now();
        this.emQuarentena = false;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Alienigena.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Double getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(Double periculosidade) {
        this.periculosidade = periculosidade;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Boolean getEmQuarentena() {
        return emQuarentena;
    }

    public void setEmQuarentena(Boolean emQuarentena) {
        this.emQuarentena = emQuarentena;
    }

    @Override
    public String detalhes() {
        return "Alienigena: ID: " + getId() + ", Nome: " + getNome() + ", Espécie: " + especie.getNome() + ", Periculosidade: " + getPericulosidade() + ", Data/Hora Entrada: " + getDataHoraEntrada();
    }
}
