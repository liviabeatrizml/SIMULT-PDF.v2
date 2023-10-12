package org.simult.connection.entity;

public class Multa {
    private String codigo;
    private String descricao;
    private String classificacao;
    private int pontos;
    private double valor;

    public Multa(String codigo, String descricao, String classificacao, int pontos, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.pontos = pontos;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\n\t\tCódigo: " + codigo +
                "\n\t\tDescrição: " + descricao +
                "\n\t\tClassificacao: " + classificacao +
                "\t\tPontos: " + pontos +
                "\t\tValor: " + valor;
    }
}
