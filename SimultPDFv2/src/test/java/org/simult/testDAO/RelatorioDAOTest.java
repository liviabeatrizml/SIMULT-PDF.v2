package org.simult.testDAO;

import org.junit.Test;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.Relatorio;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import static org.simult.models.dao.RelatorioDAO.buscaIdRelatorio;
import static org.simult.models.dao.RelatorioDAO.insereRelatorio;

public class RelatorioDAOTest {

    @Test
    public void testInsereRelatorio(){
        Administrador autor = new Administrador(1, "Alysson Milanez", "admin@gmail.com", "admin", "$2a$10$dxZ2u1PRt3mUkTtRZfYDLu5sts8HP8ubKTW9SGKiMRDG1XiI8I2qy");
        Relatorio relatorio = new Relatorio(autor);
        assertTrue(insereRelatorio(relatorio));
    }

    @Test
    public void testBuscaIdRelatorio(){
        String dataHora = "10/10/2023 - 14:16:28 BRT";
        int idAdministrador = 2;

        int valorTestado = buscaIdRelatorio(idAdministrador, dataHora);
        int valorEsperado = 5;

        assertEquals(valorEsperado, valorTestado);
    }

}
