package org.simult.connection.entity;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class Relatorio {
    private int id;
    private Administrador autor;
    private LinkedList<AutuacaoTransito> autuacoesTransito;
    private String dataHora;

    public Relatorio(@NotNull Administrador autor) {
        this.autor = autor;
        this.autuacoesTransito = autor.getAcoes();

        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss z");
        Calendar data = Calendar.getInstance();
        this.dataHora = mascara.format(data.getTime());
    }

    public Relatorio(int id, Administrador autor, LinkedList<AutuacaoTransito> autuacoes) {
        this.id = id;
        this.autor = autor;
        this.autuacoesTransito = autuacoes;

        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss z");
        Calendar data = Calendar.getInstance();
        this.dataHora = mascara.format(data.getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administrador getAutor() {
        return autor;
    }

    public void setAutor(Administrador autor) {
        this.autor = autor;
    }

    public LinkedList<AutuacaoTransito> getAutuacoesTransito() {
        return autuacoesTransito;
    }

    public void setAutuacoesTransito(LinkedList<AutuacaoTransito> autuacoesTransito) {
        this.autuacoesTransito = autuacoesTransito;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        String autuacoes = "";

        for (AutuacaoTransito acoes: autuacoesTransito) {
            autuacoes += "\n\t\t\t Veículo: " +
                           "\n\t\t\t\t Proprietário: " + acoes.getVeiculo().getProprietario() +
                           "\n\t\t\t\t Placa: " + acoes.getVeiculo().getPlaca() +
                           "\t\t Renavam: " + acoes.getVeiculo().getRenavam() +
                           "\n\t\t\t Multa: " +
                           "\n\t\t\t\t Código: " + acoes.getMulta().getCodigo() +
                           "\n\t\t\t\t Descrição: " + acoes.getMulta().getDescricao() + "\n";
        }

        return "\n\t\tIdentificador: " + id +
                "\n\t\tAutor: " + autor.getNome() +
                "\n\t\tAutuacões: " + autuacoes +
                "\n\t\tHorário: " + dataHora;
    }
}
