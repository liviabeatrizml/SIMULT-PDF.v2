package org.simult.connection.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutuacaoTransito {
    private int id;
    private Administrador autor;
    private Veiculo veiculo;
    private Multa multa;
    private String estado;
    private String municipio;
    private String dataHora;
    private String vencimento;

    public AutuacaoTransito(int id, Administrador autor, Veiculo veiculo, Multa multa, String estado, String municipio) {
        this.id = id;
        this.autor = autor;
        this.veiculo = veiculo;
        this.multa = multa;
        this.estado = estado;
        this.municipio = municipio;

        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss z");
        Calendar data = Calendar.getInstance();
        this.dataHora = mascara.format(data.getTime());

        data.add(Calendar.MONTH,5);
        this.vencimento = mascara.format(data.getTime());
    }

    public AutuacaoTransito(int id, Administrador autor, Veiculo veiculo, Multa multa, String estado, String municipio, String dataHora, String vencimento) {
        this.id = id;
        this.autor = autor;
        this.veiculo = veiculo;
        this.multa = multa;
        this.estado = estado;
        this.municipio = municipio;
        this.dataHora = dataHora;
        this.vencimento = vencimento;
    }

    public AutuacaoTransito(Administrador autor, Veiculo veiculo, Multa multa, String estado, String municipio) {
        this.id = 0;
        this.autor = autor;
        this.veiculo = veiculo;
        this.multa = multa;
        this.estado = estado;
        this.municipio = municipio;

        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss z");
        Calendar data = Calendar.getInstance();
        this.dataHora = mascara.format(data.getTime());

        data.add(Calendar.MONTH,5);
        this.vencimento = mascara.format(data.getTime());
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return "\n\t\tIdentificador: " + id +
                "\n\t\tAutor: " + autor.getNome() +
                "\n\t\tVeiculo: " + veiculo.getProprietario() +
                "\n\t\t\tPlaca: " + veiculo.getPlaca() + " \t-\tRenavam: " + veiculo.getRenavam() +
                "\n\t\tMulta: " + multa.getCodigo() +
                "\n\t\t\tDescrição da multa: " + multa.getDescricao() +
                "\n\t\tEstado: " + estado  + "\tMunicipio: " + municipio +
                "\n\t\tData: " + dataHora + "\tVencimento: " + vencimento;
    }
}
