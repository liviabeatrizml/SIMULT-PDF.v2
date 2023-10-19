package org.simult.models.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AdministradorDAO {
    public static boolean insereAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO administrador (tbAdministrador_Nome, tbAdministrador_Email, tbAdministrador_Login, tbAdministrador_Senha) VALUES (?, ?, ?, ?);");

            sql.setString(1, autor.getNome());
            sql.setString(2, autor.getEmail());
            sql.setString(3, autor.getLogin());
            sql.setString(4, autor.getSenha());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

/*  Proximas atualizações

    public static boolean editaNomeAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE administrador SET tbAdiministrador_Nome = ? WHERE tbAdministrador_Login = ?;");
            sql.setString(1, autor.getNome());
            sql.setString(2, autor.getLogin());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaEmailAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE administrador SET tbAdiministrador_Email = ? WHERE tbAdministrador_Login = ?;");

            sql.setString(1, autor.getEmail());
            sql.setString(2, autor.getLogin());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaLoginAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE administrador SET tbAdiministrador_Email = ? WHERE tbAdministrador_Email = ?;");

            sql.setString(1, autor.getEmail());
            sql.setString(2, autor.getEmail());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaSenhaAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE administrador SET tbAdiministrador_Senha = ? WHERE tbAdministrador_Login = ?;");

            sql.setString(1, autor.getSenha());
            sql.setString(2, autor.getLogin());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean removeAdministrador(@NotNull Administrador autor){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("DELETE FROM administrador WHERE tbAdministrador_Login = ?;");

            sql.setString(1, autor.getLogin());

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
    public static Administrador buscaAdministrador(int id){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM administrador WHERE tbAdministrador_Id = ?;");
            sql.setInt(1, id);

            ResultSet rs = null;
            String nome = "";
            String login = "";
            String email = "";
            String senha = "";

            rs = sql.executeQuery();

            while (rs.next()){
                nome = rs.getString("tbAdministrador_Nome");
                email = rs.getString("tbAdministrador_Email");
                login = rs.getString("tbAdministrador_Login");
                senha = rs.getString("tbAdministrador_Senha");
            }

            rs.close();
            sql.close();

            if(!login.isEmpty()){
                return new Administrador(id, nome, email, login, senha);
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

    @Nullable
    public static Administrador buscaAdministrador(String login){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM administrador WHERE tbAdministrador_Login = ?;");
            sql.setString(1, login);

            ResultSet rs = null;

            int id = 0;

            login = "";
            String nome = "";
            String email = "";
            String senha = "";

            rs = sql.executeQuery();

            while (rs.next()){
                id = rs.getInt("tbAdministrador_Id");
                login = rs.getString("tbAdministrador_Login");
                nome = rs.getString("tbAdministrador_Nome");
                email = rs.getString("tbAdministrador_Email");
                senha = rs.getString("tbAdministrador_Senha");
            }

            sql.close();

            if(!login.isEmpty()){
                return new Administrador(id, nome, email, login, senha);
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução da consulta SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

}
