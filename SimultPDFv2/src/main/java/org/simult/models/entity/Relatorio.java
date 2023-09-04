package org.simult.models.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Relatorio {
    private int id;
    private Administrador autor;
    private ArrayList<AutuacaoTransito> autuacoesTransito;
    private String dataHora;

    public Relatorio(Administrador autor, ArrayList<AutuacaoTransito> autuacoes) {
        this.id = 0;
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

    public ArrayList<AutuacaoTransito> getAutuacoesTransito() {
        return autuacoesTransito;
    }

    public void setAutuacoesTransito(ArrayList<AutuacaoTransito> autuacoesTransito) {
        this.autuacoesTransito = autuacoesTransito;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }



}
