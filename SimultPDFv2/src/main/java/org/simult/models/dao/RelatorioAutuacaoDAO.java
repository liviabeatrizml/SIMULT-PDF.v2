package org.simult.models.dao;

import org.jetbrains.annotations.Nullable;
import org.simult.models.bd.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class RelatorioAutuacaoDAO {
    public static boolean insereRelatorioDeAutuacao(int id_relatorio, int id_autuacao){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO relatorio_autuacao (tbRelatorio_Id, tbAutuacaoTransito_Id) VALUES (?, ?);");

            sql.setInt(1, id_relatorio);
            sql.setInt(2, id_autuacao);

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
    public static LinkedList<Integer> buscaAutuacoesRelatorio(int idRelatorio){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM relatorio_autuacao WHERE tbRelatorio_Id = ?;");
            sql.setInt(1, idRelatorio);

            ResultSet rs = null;

            LinkedList<Integer> autuacoes = new LinkedList<>();

            rs = sql.executeQuery();

            while (rs.next()){
                autuacoes.add(rs.getInt("tbAutuacaoTransito_Id"));
            }

            rs.close();
            sql.close();

            return autuacoes;

        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }
}
