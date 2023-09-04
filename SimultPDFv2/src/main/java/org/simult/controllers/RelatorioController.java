package org.simult.controllers;

import org.simult.models.entity.Relatorio;
import org.simult.models.entity.Veiculo;

public class RelatorioController {
    public Relatorio criarRelatorio(){
        Veiculo veiculo = null;

        // Entrada do atributo autor da multa
        do {
            System.out.println("\t- Informe o estado em que ocorreu a multa: \n");

            if(veiculo == null) {
                System.out.println("\t\t\n É necessário informar o estado em que ocorreu a multa!\n");
            }
        } while (veiculo == null);

        return null;
    }
}
