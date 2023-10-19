package org.simult.testDAO;

import org.junit.Test;
import org.simult.models.entity.Veiculo;

import static junit.framework.TestCase.*;
import static org.simult.models.dao.VeiculoDAO.buscaVeiculo;

public class VeiculoDAOTest {

    @Test
    public void testBuscaVeiculo(){
        String placaCorrect = "INU0D54";
        String renavamCorrect = "90587358493";
        Veiculo veiculo1 = buscaVeiculo(placaCorrect, renavamCorrect);
        assertNotNull(veiculo1);

        placaCorrect = "LGL1P23";
        renavamCorrect = "25652248856";
        veiculo1 = buscaVeiculo(placaCorrect, renavamCorrect);
        assertNotNull(veiculo1);

        String placaIncorrect = "HHJ0C85";
        String renavamIncorrect = "15635651332";
        Veiculo veiculo2 = buscaVeiculo(placaIncorrect, renavamIncorrect);
        assertNull(veiculo2);

        placaIncorrect = "C2PJ0C78";
        renavamIncorrect = "915635651332";
        veiculo2 = buscaVeiculo(placaIncorrect, renavamIncorrect);
        assertNull(veiculo2);

        placaIncorrect = "HJ0C85";
        renavamIncorrect = "9156356513";
        veiculo2 = buscaVeiculo(placaIncorrect, renavamIncorrect);
        assertNull(veiculo2);
    }
}

