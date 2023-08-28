package org.simult.models.entity;

import java.math.BigInteger;

public class Usuario extends Ator{
    private String placa;
    private int renavam;

    public Usuario(String placa, int renavam) {
        this.placa = placa;
        this.renavam = renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }
}
