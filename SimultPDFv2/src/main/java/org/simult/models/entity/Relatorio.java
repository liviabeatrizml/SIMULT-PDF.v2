package org.simult.models.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Relatorio {
    private int id;
    private Ator autor;
    private Veiculo veiculo;
    private ArrayList<Multa> listaDeMultas;
    private String dataHora;

    public Relatorio(Veiculo veiculo, Ator autor) {
        this.id = 0;
        this.autor = autor;
        this.veiculo = veiculo;

        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss z");
        Calendar data = Calendar.getInstance();
        this.dataHora = mascara.format(data.getTime());
    }

    public Relatorio(Ator autor, ArrayList<Multa> multas) {
        this.id = 0;
        this.autor = autor;
        this.listaDeMultas = multas;

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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Ator getAutor() {
        return autor;
    }

    public void setAutor(Ator autor) {
        this.autor = autor;
    }

}
