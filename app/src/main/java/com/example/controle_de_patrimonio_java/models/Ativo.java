package com.example.controle_de_patrimonio_java.models;

/**
 * @author Matheus Martinelli
 * Created on *27-11-2022
 * martinelli.matheus2@gmail.com
 */
public class Ativo {
    private long id;
    private String descricao;
    private Double valor;

    public Ativo() {
    }

    public Ativo(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Ativo(long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
