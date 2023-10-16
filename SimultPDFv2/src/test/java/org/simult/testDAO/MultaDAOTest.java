package org.simult.testDAO;

import org.junit.Test;
import org.simult.models.entity.Multa;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.simult.models.dao.MultaDAO.*;

public class MultaDAOTest {

    @Test
    public void testSearchMulta(){
        String codigoCorrect = "679-30";
        Multa multa1 = buscaMulta(codigoCorrect);
        assertNotNull(multa1);

        codigoCorrect = "747-10";
        multa1 = buscaMulta(codigoCorrect);
        assertNotNull(multa1);

        String codigoIncorrect = "111-30";
        Multa multa2 = buscaMulta(codigoIncorrect);
        assertNull(multa2);

        codigoIncorrect = "356245";
        multa2 = buscaMulta(codigoIncorrect);
        assertNull(multa2);

        codigoIncorrect = "12245";
        multa2 = buscaMulta(codigoIncorrect);
        assertNull(multa2);

        codigoIncorrect = "3652145";
        multa2 = buscaMulta(codigoIncorrect);
        assertNull(multa2);
    }

    @Test
    public void testSearchClassifyMulta(){
        ArrayList<Multa> multasCorrect = new ArrayList<>();

        String classificacaoCorrect = "Leve";
        multasCorrect = buscaMultaClassificacao(classificacaoCorrect);
        assertNotNull(multasCorrect);

        classificacaoCorrect = "Média";
        multasCorrect = buscaMultaClassificacao(classificacaoCorrect);
        assertNotNull(multasCorrect);

        classificacaoCorrect = "Grave";
        multasCorrect = buscaMultaClassificacao(classificacaoCorrect);
        assertNotNull(multasCorrect);

        classificacaoCorrect = "Gravíssima";
        multasCorrect = buscaMultaClassificacao(classificacaoCorrect);
        assertNotNull(multasCorrect);

        String classificacaoIncorrect = "GrAvE";
        ArrayList<Multa> multasIncorrect = buscaMultaClassificacao(classificacaoIncorrect);
        assertNull(multasIncorrect);

        classificacaoIncorrect = "QualquerNome";
        multasIncorrect = buscaMultaClassificacao(classificacaoIncorrect);
        assertNull(multasIncorrect);
    }

    @Test
    public void testSearchAllMulta(){
        ArrayList<Multa> multas = new ArrayList<>();

        multas = buscaMultaGeral();
        assertNotNull(multas);
    }

}
