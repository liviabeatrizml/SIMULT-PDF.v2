package org.simult.models.entity;

import java.util.Calendar;

public class Multa {
    private int codigo;
    private String descricao;
    private Veiculo veiculo;
    private String estado;
    private String municio;
    private String classificacao;
    private double valor;
    private Calendar dataHora;
    private Calendar vencimento;

    public Multa(Veiculo veiculo, String descricao, String estado, String municio, String classificacao, double valor, Calendar dataHora) {
        this.codigo = 0;
        this.veiculo = veiculo;
        this.descricao = descricao;
        this.estado = estado;
        this.municio = municio;
        this.classificacao = classificacao;
        this.valor = valor;
        this.dataHora = dataHora;
        this.vencimento = dataHora;
        this.vencimento.add(Calendar.MONTH,5);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicio() {
        return municio;
    }

    public void setMunicio(String municio) {
        this.municio = municio;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

}
