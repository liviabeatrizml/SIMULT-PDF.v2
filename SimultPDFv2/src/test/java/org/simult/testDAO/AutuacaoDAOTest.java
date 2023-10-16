package org.simult.testDAO;

import junit.framework.Assert;
import org.junit.Test;
import org.simult.models.dao.AutuacaoTransitoDAO;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.AutuacaoTransito;
import org.simult.models.entity.Multa;
import org.simult.models.entity.Veiculo;

import static junit.framework.TestCase.*;
import static org.simult.models.dao.AutuacaoTransitoDAO.*;

public class AutuacaoDAOTest {

    @Test
    public void testInsertAutuacao(){
        Veiculo veiculo = new Veiculo("BGF3L99", "58496448211", "BVD21RED56W128GF6", "Francisco ALmeida de Souza", "Acre", "Rio Branco", "Amarela", "Volvo", "xc30", "Passageiro");
        Multa multa = new Multa("523-11", "ATIRAR DO VEICULO OBJETOS OU SUBSTANCIAS", "Média", 4, 130.16);
        Administrador autor = new Administrador(1, "Alysson Milanez", "admin@gmail.com", "admin", "$2a$10$dxZ2u1PRt3mUkTtRZfYDLu5sts8HP8ubKTW9SGKiMRDG1XiI8I2qy");
        AutuacaoTransito autuacao = new AutuacaoTransito(autor, veiculo, multa, "Ceare", "Fortaleza");

        assertTrue(insereAutuacao(autuacao));
    }

    @Test
    public void testSearchAutuacao(){
        int id = 7;
        AutuacaoTransito autuacao = buscaAutuacao(id);
        assertNotNull(autuacao);

        id = 0;
        autuacao = buscaAutuacao(id);
        assertNull(autuacao);
    }

    @Test
    public void testSearchIdAutuacao(){
        String dataHora = "10/10/2023 - 14:16:28 BRT";
        int idAdministrador = 2;

        int valorTestado = buscaIdAutuacao(idAdministrador, dataHora);
        int valorEsperado = 5;

        assertEquals(valorEsperado, valorTestado);
    }

    @Test
    public void testRemoveAutuacao(){
        int idAutuacao = 9;
        assertTrue(removeAutuacao(idAutuacao));
    }

}
