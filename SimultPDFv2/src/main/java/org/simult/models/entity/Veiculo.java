package org.simult.models.entity;

import java.util.ArrayList;

public class Veiculo {
    private String proprietario;
    private String placa;
    private String renavam;
    private String chassi;
    private String estadoRegistro;
    private String municipioRegistro;
    private String cor;
    private String marca;
    private String modelo;
    private String especie;
    private ArrayList<Multa> multas;

    public Veiculo(String placa, String renavam, String chassi, String proprietario, String estadoRegistro, String municipioRegistro, String cor, String marca, String modelo, String especie) {
        this.placa = placa;
        this.renavam = renavam;
        this.chassi = chassi;
        this.proprietario = proprietario;
        this.estadoRegistro = estadoRegistro;
        this.municipioRegistro = municipioRegistro;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.especie = especie;
        this.multas = new ArrayList<>();
    }

    public Veiculo(String placa, String renavam, String chassi, String proprietario, String estadoRegistro, String municipioRegistro, String cor, String marca, String modelo, String especie, ArrayList<Multa> multas) {
        this.placa = placa;
        this.renavam = renavam;
        this.chassi = chassi;
        this.proprietario = proprietario;
        this.estadoRegistro = estadoRegistro;
        this.municipioRegistro = municipioRegistro;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.especie = especie;
        this.multas = multas;
        this.multas = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getMunicipioRegistro() {
        return municipioRegistro;
    }

    public void setMunicipioRegistro(String municipioRegistro) {
        this.municipioRegistro = municipioRegistro;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }
}
