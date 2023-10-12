package org.simult.connection.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conexcao;
    private static Conexao instance;

    //Construtor privado, referente ao padrão criacional Singleton
    private Conexao() {
        try {
            //Class.forName("org.postgresql.Driver");
            this.conexcao = DriverManager.getConnection("jdbc:postgresql://silly.db.elephantsql.com:5432/hggqunio", "hggqunio", "nSN9A8DmvmDM-WIfuDhiAbyWOJzBxpzg");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    //Metodo por onde é possivel obter uma instancia classe ou criar uma caso não tenha sido criada
    public static synchronized Conexao getInstance(){
        if(instance == null){
            instance = new Conexao();
        }

        return instance;
    }

    //Metodo get que retorna a conexao
    public Connection getConexao(){
        return this.conexcao;
    }

    //Metodo responsável por encerrar a conexão com o banco de dados
    public boolean closeConnection(){
        try {
            if (conexcao != null) {
                conexcao.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("\nFalha ao encerrar conexão: " + e.getMessage());
        }

        return false;
    }

}
