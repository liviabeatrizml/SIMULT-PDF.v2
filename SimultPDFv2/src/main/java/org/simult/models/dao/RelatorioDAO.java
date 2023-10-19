package org.simult.models.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.AutuacaoTransito;
import org.simult.models.entity.Relatorio;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Objects;

public class RelatorioDAO {
    public static boolean insereRelatorio(@NotNull Relatorio relatorio){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("INSERT INTO relatorio (tbAdministrador_Id, tbRelatorio_DataHora) VALUES (?, ?);");

            sql.setInt(1, relatorio.getAutor().getId());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss z");
            LocalDateTime localTimeDH = LocalDateTime.from(formatter.parse(relatorio.getDataHora()));
            Timestamp timeDH = Timestamp.valueOf(localTimeDH);

            sql.setTimestamp(2, timeDH);

            sql.executeUpdate();
            sql.close();

            int idRelatorio = buscaIdRelatorio(relatorio.getAutor().getId(), relatorio.getDataHora());

            for (AutuacaoTransito autuacao: relatorio.getAutuacoesTransito()) {
                RelatorioAutuacaoDAO.insereRelatorioDeAutuacao(idRelatorio, autuacao.getId());
            };

            return true;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return false;
        }
    }

    public static int buscaIdRelatorio(int idAdministrador, String dataHora){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM relatorio WHERE tbAdministrador_Id = ? AND tbRelatorio_DataHora = ?;");
            sql.setInt(1, idAdministrador);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss z");
            LocalDateTime localTimeDH = LocalDateTime.from(formatter.parse(dataHora));
            Timestamp timeDH = Timestamp.valueOf(localTimeDH);

            sql.setTimestamp(2, timeDH);

            int idRelatorio = 0;

            ResultSet rs = null;

            rs = sql.executeQuery();

            while (rs.next()){
                idRelatorio = rs.getInt("tbRelatorio_Id");
            }

            rs.close();
            sql.close();

            return idRelatorio;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return 0;
        }
    }

/*  Proximas atualizações
    @Nullable
    public static Relatorio buscaRelatorio(int idRelatorio){
        Conexao conexao = Conexao.getInstance();
        Connection con = conexao.getConexao();

        try {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM relatorio WHERE tbRelatorio_Id = ?;");
            sql.setInt(1, idRelatorio);

            ResultSet rs = null;

            Administrador autor = null;
            LinkedList<AutuacaoTransito> acoes = new LinkedList<>();

            int idAutor = 0;
            idRelatorio = 0;

            rs = sql.executeQuery();

            while (rs.next()){
                idRelatorio = rs.getInt("tbRelatorio_Id");
                idAutor = rs.getInt("tbAdministrador_Id");
            }

            autor = AdministradorDAO.buscaAdministrador(idAutor);

            for (int idAutuacoes: Objects.requireNonNull(RelatorioAutuacaoDAO.buscaAutuacoesRelatorio(idRelatorio))) {
                acoes.add(AutuacaoTransitoDAO.buscaAutuacao(idAutuacoes));
            }

            rs.close();
            sql.close();

            if(idRelatorio != 0){
                return new Relatorio(idRelatorio, autor, acoes);
            }

            return null;
        } catch (SQLException e){
            String mensagemDeErro = "Ocorreu um erro durante a execução do SQL: " + e.getMessage();
            System.err.println(mensagemDeErro);

            return null;
        }
    }
*/

}
