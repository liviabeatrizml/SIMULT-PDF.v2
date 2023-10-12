package org.simult.connection.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simult.connection.bd.Conexao;
import org.simult.connection.entity.Multa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultaDAO {
    public static boolean insereMulta(@NotNull Multa multa){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO multa (tbMulta_Codigo, tbMulta_Descrição, tbMulta_Classificacao, tbMulta_Pontos, tbMulta_Valor) VALUES (?, ?, ?, ?, ?);");

            sql.setString(1, multa.getCodigo());
            sql.setString(2, multa.getDescricao());
            sql.setString(3, multa.getClassificacao());
            sql.setInt(4, multa.getPontos());
            sql.setDouble(5, multa.getValor());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

/*
    public static boolean editaDestricaoMulta(@NotNull Multa multa){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE multa SET tbMulta_Descricao = ? WHERE tbMulta_Codigo = ?;");
            sql.setString(1, multa.getDescricao());
            sql.setString(2, multa.getCodigo());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaClassificacaoMulta(@NotNull Multa multa){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE multa SET tbMulta_Classificacao = ? WHERE tbMulta_Codigo = ?;");
            sql.setString(1, multa.getClassificacao());
            sql.setString(2, multa.getCodigo());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaPontosMulta(@NotNull Multa multa){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE multa SET tbMulta_Pontos = ? WHERE tbMulta_Codigo = ?;");
            sql.setInt(1, multa.getPontos());
            sql.setString(2, multa.getCodigo());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaValorMulta(@NotNull Multa multa){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE multa SET tbMulta_Valor = ? WHERE tbMulta_Codigo = ?;");
            sql.setDouble(1, multa.getValor());
            sql.setString(2, multa.getCodigo());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean removeMulta(String codigo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("DELETE FROM multa WHERE tbMulta_Codigo = ?;");

            sql.setString(1, codigo);

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }
*/

    @Nullable
    public static Multa buscaMulta(String codigo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM multa WHERE tbMulta_Codigo = ?;");
            sql.setString(1, codigo);

            ResultSet rs = null;
            codigo = "";
            String descricao = "";
            String classificacao = "";

            int pontos = 0;
            double valor = 0.0;

            rs = sql.executeQuery();

            while (rs.next()){
                codigo = rs.getString("tbMulta_Codigo");
                descricao = rs.getString("tbMulta_Descrição");
                classificacao = rs.getString("tbMulta_Classificacao");
                pontos = rs.getInt("tbMulta_pontos");
                valor = rs.getDouble("tbMulta_Valor");
            }

            rs.close();
            sql.close();

            if(!codigo.isEmpty()){
                return new Multa(codigo, descricao, classificacao, pontos, valor);
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

    @Nullable
    public static ArrayList<Multa> buscaMultaGeral(){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        ArrayList<Multa> multas = new ArrayList<>();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM multa");

            ResultSet rs = null;
            String codigo = "";
            String descricao = "";
            String classificacao = "";

            int pontos = 0;
            double valor = 0.0;

            rs = sql.executeQuery();

            while (rs.next()){
                codigo = rs.getString("tbMulta_Codigo");
                descricao = rs.getString("tbMulta_Descrição");
                classificacao = rs.getString("tbMulta_Classificacao");
                pontos = rs.getInt("tbMulta_pontos");
                valor = rs.getDouble("tbMulta_Valor");

                if(!codigo.isEmpty()){
                    multas.add(new Multa(codigo, descricao, classificacao, pontos, valor));
                }
            }

            rs.close();
            sql.close();

            if(!multas.isEmpty()){
                return multas;
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

    @Nullable
    public static ArrayList<Multa> buscaMultaClassificacao(String classificacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        ArrayList<Multa> multas = new ArrayList<>();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM multa WHERE tbMulta_Classificacao = ?;");
            sql.setString(1, classificacao);

            ResultSet rs = null;
            String codigo = "";
            String descricao = "";

            int pontos = 0;
            double valor = 0.0;

            rs = sql.executeQuery();

            while (rs.next()){
                codigo = rs.getString("tbMulta_Codigo");
                descricao = rs.getString("tbMulta_Descrição");
                pontos = rs.getInt("tbMulta_pontos");
                valor = rs.getDouble("tbMulta_Valor");

                if(!codigo.isEmpty()){
                    multas.add(new Multa(codigo, descricao, classificacao, pontos, valor));
                }
            }

            rs.close();
            sql.close();

            if(!multas.isEmpty()){
                return multas;
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

}
