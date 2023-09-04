package org.simult.models.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.AutuacaoTransito;
import org.simult.models.entity.Multa;
import org.simult.models.entity.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.simult.models.dao.AdministradorDAO.buscaAdministrador;
import static org.simult.models.dao.MultaDAO.buscaMulta;
import static org.simult.models.dao.VeiculoDAO.buscaVeiculo;

public class AutuacaoTransitoDAO {
    public static boolean insereAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO autuaca_transito (tbAdministrador_Id, tbVeiculo_Placa, tbVeiculo_Renavam, tbMulta_Codigo, tbAutuacaoTransito_Estado, tbAutuacaoTransito_Municipio, tbAutuacaoTransito_DataHora, tbAutuacaoTransito_Vencimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

            sql.setInt(1, autuacao.getAutor().getId());
            sql.setString(2, autuacao.getVeiculo().getPlaca());
            sql.setString(3, autuacao.getVeiculo().getRenavam());
            sql.setString(4, autuacao.getMulta().getCodigo());
            sql.setString(4, autuacao.getEstado());
            sql.setString(4, autuacao.getMunicipio());
            sql.setString(4, autuacao.getDataHora());
            sql.setString(4, autuacao.getVencimento());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaAutorAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbAdministrador_Id = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setInt(1, autuacao.getAutor().getId());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaVeiculoAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbVeiculo_Placa = ?, tbVeiculo_Renavam = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getVeiculo().getPlaca());
            sql.setString(2, autuacao.getVeiculo().getRenavam());
            sql.setInt(3, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaMultaAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbMulta_Codigo = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getMulta().getCodigo());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaEstadoAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbAutuacaoVeiculo_Estado = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getEstado());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaMunicipioAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbAutuacaoVeiculo_Municipio = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getMunicipio());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaDataHoraAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbAutuacaoVeiculo_DataHora = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getDataHora());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static boolean editaVencimentoAutuacao(@NotNull AutuacaoTransito autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("UPDATE autuacao_veiculo SET tbAutuacaoVeiculo_Vencimento = ? WHERE tbAtuacaoVeiculo_Id = ?;");
            sql.setString(1, autuacao.getVencimento());
            sql.setInt(2, autuacao.getId());

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    @Nullable
    public static AutuacaoTransito buscaAutuacao(int id){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM autuacao_transito WHERE tbAutuacaoTransito_Id = ?;");
            sql.setInt(1, id);

            ResultSet rs = null;

            String placaVeiculo = "";
            String renavamVeiculo = "";
            String codigoMulta = "";
            String estado = "";
            String municipio = "";
            String dataHora = "";
            String vencimento = "";

            int autorId = 0;

            rs = sql.executeQuery();

            while (rs.next()){
                id = rs.getInt("tbAutuacaoTransito_Id");
                autorId = rs.getInt("tbAdministrador_Id");
                placaVeiculo = rs.getString("tbVeiculo_Placa");
                renavamVeiculo = rs.getString("tbVeiculo_Renavam");
                codigoMulta = rs.getString("tbMulta_Codigo");
                estado = rs.getString("tbAutuacaoTransito_Estado");
                municipio = rs.getString("tbAutuacaoTransito_Municipio");
                dataHora = rs.getString("tbAutuacaoTransito_DataHora");
                vencimento = rs.getString("tbAutuacaoTransito_Vencimento");
            }

            rs.close();
            sql.close();

            Administrador autor = buscaAdministrador(autorId);
            Veiculo veiculo = buscaVeiculo(placaVeiculo, renavamVeiculo);
            Multa multa = buscaMulta(codigoMulta);

            if(autor != null){
                return new AutuacaoTransito(id, autor, veiculo, multa, estado, municipio, dataHora, vencimento);
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }

    public static boolean removeAutuacao(int id){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("DELETE FROM autuacao_transito WHERE tbAutuacaoTransito_Id = ?;");
            sql.setInt(1, id);

            sql.executeUpdate();
            sql.close();

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

}
