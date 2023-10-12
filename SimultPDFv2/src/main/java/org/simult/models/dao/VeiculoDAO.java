package org.simult.models.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO {
    public static boolean insereVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO veiculo (tbVeiculo_Placa, tbVeiculo_Renavam, tbVeiculo_Chassi, tbVeiculo_Proprietario, tbVeiculo_EstadoRegistro, tbVeiculo_MunicipioRegistro, tbVeiculo_Cor, tbVeiculo_Marca, tbVeiculo_Modelo, tbVeiculo_Especie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            sql.setString(1, veiculo.getPlaca());
            sql.setString(2, veiculo.getRenavam());
            sql.setString(3, veiculo.getChassi());
            sql.setString(4, veiculo.getProprietario());
            sql.setString(5, veiculo.getEstadoRegistro());
            sql.setString(6, veiculo.getMunicipioRegistro());
            sql.setString(7, veiculo.getCor());
            sql.setString(8, veiculo.getMarca());
            sql.setString(9, veiculo.getModelo());
            sql.setString(10, veiculo.getEspecie());

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
    public static boolean editaChassiVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Chassi = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getChassi());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaProprietarioVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Proprietario = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getProprietario());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaEstadoRegistroVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_EstadoRegistro = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getEstadoRegistro());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaMunicipioVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_MunicipioRegistro = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getMunicipioRegistro());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaCorVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Cor = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getCor());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaMarcaVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Marca = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getMarca());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaModeloVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Modelo = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getModelo());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaEspecieVeiculo(@NotNull Veiculo veiculo){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE veiculo SET tbVeiculo_Especie = ? WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, veiculo.getEspecie());
            sql.setString(2, veiculo.getPlaca());
            sql.setString(3, veiculo.getRenavam());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean removeVeiculo(String placa, String renavam){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("DELETE FROM veiculo WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");

            sql.setString(1, placa);
            sql.setString(2, renavam);

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
    public static Veiculo buscaVeiculo(String placa, String renavam){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM veiculo WHERE tbVeiculo_Placa = ? AND tbVeiculo_Renavam = ?;");
            sql.setString(1, placa);
            sql.setString(2, renavam);

            ResultSet rs = null;
            placa = "";
            renavam = "";
            String chassi = "";
            String proprietario = "";
            String estadoRegistro = "";
            String municipioRegistro = "";
            String cor = "";
            String marca = "";
            String modelo = "";
            String especie = "";

            rs = sql.executeQuery();

            while (rs.next()){
                placa = rs.getString("tbVeiculo_Placa");
                renavam = rs.getString("tbVeiculo_Renavam");
                chassi = rs.getString("tbVeiculo_Chassi");
                proprietario = rs.getString("tbVeiculo_Proprietario");
                estadoRegistro = rs.getString("tbVeiculo_EstadoRegistro");
                municipioRegistro = rs.getString("tbVeiculo_MunicipioRegistro");
                cor = rs.getString("tbVeiculo_Cor");
                marca = rs.getString("tbVeiculo_Marca");
                modelo = rs.getString("tbVeiculo_Modelo");
                especie = rs.getString("tbVeiculo_Especie");
            }

            if(!placa.isEmpty() && !renavam.isEmpty()){
                return new Veiculo(placa, renavam, chassi, proprietario, estadoRegistro, municipioRegistro, cor, marca, modelo, especie);
            }

            rs.close();
            sql.close();

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

}
