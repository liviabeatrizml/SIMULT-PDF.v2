package org.simult.testDAO;

import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.simult.models.dao.RelatorioAutuacaoDAO.buscaAutuacoesRelatorio;
import static org.simult.models.dao.RelatorioAutuacaoDAO.insereRelatorioDeAutuacao;

public class RelatorioAutuaocaoDAOTest {

    @Test
    public void testInsertRelatorioAutuacao(){
        int idRelatorio = 8;
        int idAutuacao = 11;
        assertTrue(insereRelatorioDeAutuacao(idRelatorio, idAutuacao));

        idAutuacao = 26;
        assertFalse(insereRelatorioDeAutuacao(idRelatorio, idAutuacao));

        idRelatorio = 17;
        idAutuacao = 8;
        assertFalse(insereRelatorioDeAutuacao(idRelatorio, idAutuacao));
    }

    @Test
    public void testSearchRelatorioAutuacoes(){
        int idRelatorio = 8;

        LinkedList<Integer> lista = buscaAutuacoesRelatorio(idRelatorio);
        LinkedList<Integer> listaEsperada = new LinkedList<>();
        listaEsperada.add(17);
        listaEsperada.add(8);
        listaEsperada.add(10);
        listaEsperada.add(11);


        assertEquals(lista, listaEsperada);
    }

}
