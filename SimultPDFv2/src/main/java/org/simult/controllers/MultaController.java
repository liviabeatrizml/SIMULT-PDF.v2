package org.simult.controllers;

import org.simult.models.entity.Multa;
import org.simult.models.entity.Veiculo;

import java.util.Calendar;
import java.util.Scanner;

public class MultaController {
    private static Scanner input = new Scanner(System.in);

    public static Multa criarMulta(){
        int id = 0;
        int opcao = 0;
        double valor = 0.0;

        String descricao = "";
        String estado = "";
        String municipio = "";
        String classificacao = "";
        Calendar dataHora = null;
        Veiculo veiculo = null;

        System.out.println("\nInsira as informações para realizar o cadastro de Multa:\n");

        // Entrada do atributo veiculo da multa
        do {
            System.out.println("\t- Informe a placa e o renavam do veículo: \n");

        } while (veiculo != null);

        // Entrada do atributo descrição da multa
        do {
            System.out.println("\t- Informe a descrição da multa ocorreu a multa (Max. 100 caracteres):: \n");
            descricao = input.nextLine();

            if(descricao.isEmpty()) {
                System.out.println("\t\t\n Descrição não pode ser vazia...\n");
            } else if(descricao.length() > 100){
                System.out.println("\t\t\n Descrição não pode ter mais de 100 caracteres...\n");
            }
        } while (descricao.isEmpty() || descricao.length() > 100);

        // Entrada do atributo classificação e valor da multa
        do {
            System.out.println("\t- Informe a classificação da multa: \n");
            System.out.println("\t1 - LEVE\n\t2 - MÉDIA\n\t3 - GRAVE\n\t4 - GRAVÍSSIMA\n");
            System.out.println("\n\t Opção: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    classificacao = "Leve";
                    valor = 88.38;                  // Valor do dia 25/08/2023 as 20hrs
                    break;
                case 2:
                    classificacao = "Média";
                    valor = 130.16;                  // Valor do dia 25/08/2023 as 20hrs
                    break;
                case 3:
                    classificacao = "Grave";
                    valor = 195.23;                  // Valor do dia 25/08/2023 as 20hrs
                    break;
                case 4:
                    classificacao = "Gravíssima";
                    valor = 293.47;                  // Valor do dia 25/08/2023 as 20hrs
                    break;
                default:
                    System.out.println("\t\t\n Opção inválida!\n");
                    break;
            }

        } while (classificacao.isEmpty());

        // Entrada do atributo estado da multa
        do {
            System.out.println("\t- Informe o estado em que ocorreu a multa: \n");
            estado = input.nextLine();

            if(estado.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o estado em que ocorreu a multa!\n");
            }
        } while (estado.isEmpty());

        // Entrada do atributo municipio da multa
        do {
            System.out.println("\t- Informe o municipio em que ocorreu a multa: \n");
            municipio = input.nextLine();

            if(municipio.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o municipio em que ocorreu a multa!\n");
            }
        } while (municipio.isEmpty());

        Multa multa = new Multa(veiculo, descricao, estado, municipio, classificacao, valor, Calendar.getInstance());

        return multa;
    }

    public boolean excluirMulta(){
        return false;
    }

    public Multa buscarMulta(){
        return null;
    }

}
