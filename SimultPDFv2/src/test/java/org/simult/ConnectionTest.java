package org.simult;

import org.junit.Test;
import org.simult.models.bd.Conexao;

import java.sql.Connection;

import static junit.framework.TestCase.*;

public class ConnectionTest {

    @Test
    public void testGetInstance(){
        Conexao conexao = Conexao.getInstance();
        Connection connection = conexao.getConexao();
        assertNotNull(connection);
    }

    @Test
    public void testCloseConnection(){
        Conexao conexao = Conexao.getInstance();
        Connection connection = conexao.getConexao();

        assertTrue(conexao.closeConnection());
    }
}
