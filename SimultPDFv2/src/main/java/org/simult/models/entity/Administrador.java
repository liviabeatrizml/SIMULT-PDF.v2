package org.simult.connection.entity;

import java.util.LinkedList;

public class Administrador{
    private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private LinkedList<AutuacaoTransito> acoes = new LinkedList<>();

    public Administrador(int id, String nome, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Administrador(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<AutuacaoTransito> getAcoes() {
        return acoes;
    }

    public void setAcoes(AutuacaoTransito acao) {
        this.acoes.add(acao);
    }


}
