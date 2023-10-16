package org.simult.testDAO;

import org.junit.Test;
import org.simult.models.entity.Administrador;

import static junit.framework.TestCase.*;
import static org.simult.models.dao.AdministradorDAO.buscaAdministrador;
import static org.simult.models.dao.AdministradorDAO.insereAdministrador;

public class AdministradorDAOTest {

    @Test
    public void testInsertAdministrador(){
        Administrador autor = new Administrador("Luan Pereira Augusto", "LudjsfksanPA@gmail.com", "luanlpdsdppa.123", "LuanPA123");
        boolean situacao = insereAdministrador(autor);
        assertTrue(situacao);

        // Campo nome com 79 caracteres
        autor = new Administrador("Livia Geisas Pereira Jacinta Antonio Silva Me Professor Maia Lima Souza Morais", "LuanPA@fgdfhsd.com", "lufdshuanpa.123", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertTrue(situacao);

        // Campo nome com 80 caracteres
        autor = new Administrador("Leonardo Auguto Pereira Jacinta Antonio Silva Me Millanez Maia da Lima Souza Sa", "gdfgdfgdf@gmail.com", "luanpa.15646423", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertTrue(situacao);

        // Campo login com 29 caracteres
        autor = new Administrador("Marcos Antonio Silva Mel Millanez", "fsdfbsj", "marcos.antonio.millanez.2023", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertTrue(situacao);

        // Campo login com 30 caracteres
        autor = new Administrador("Antonio Silva Mel Millanez", "sdfsdg", "marcos.dantonio.millanez.2023", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertTrue(situacao);

        // Campo nome com 81 caracteres
        autor = new Administrador("Rodrigo Augusto Pereira Marcos Antonio Silva Mel Millanez Maia da Lima Souza Sas", "LuagdfgdnPA@gmfdgdfgail.com", "luan426pa.123", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertFalse(situacao);

        // Campo login com 31 caracteres
        autor = new Administrador("Silva Mel Millanez", "klgkdigodfng", "marcos.antonio.milanez.da.2023", "LuanPA123");
        situacao = insereAdministrador(autor);
        assertFalse(situacao);
    }

    @Test
    public void testSearchAdministradorLogin(){
        String login = "geisa.pereiro";
        Administrador adm = buscaAdministrador(login);
        assertNotNull(adm);

        login = "naoExiste123";
        adm = buscaAdministrador(login);
        assertNull(adm);
    }

    @Test
    public void testSearchAdministradorId(){
        int id = 2;
        Administrador adm = buscaAdministrador(id);
        assertNotNull(adm);

        id = 231;
        adm = buscaAdministrador(id);
        assertNull(adm);
    }
}
