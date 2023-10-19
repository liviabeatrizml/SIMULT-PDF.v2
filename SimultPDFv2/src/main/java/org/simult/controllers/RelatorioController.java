package org.simult.controllers;

import org.jetbrains.annotations.NotNull;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.Relatorio;

import static org.simult.models.dao.RelatorioDAO.insereRelatorio;

public class RelatorioController {

    public static boolean criarRelatorio(@NotNull Administrador autor){
        Relatorio relatorio = new Relatorio(autor);

        if (insereRelatorio(relatorio)){
            System.out.println("\n\t\tRelatorio -> " + relatorio);
            return true;
        } else {
            return false;
        }
    }
}
