package org.simult.controllers;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.simult.models.entity.Multa;

import java.util.ArrayList;
import java.util.Scanner;

import static org.simult.models.dao.MultaDAO.*;

public class MultaController {
    private static final Scanner input = new Scanner(System.in);

    public static boolean criarMulta(){
        int id = 0;
        int opcao = 0;
        int pontos = 0;
        double valor = 0.0;

        String codigo = "";
        String descricao = "";
        String classificacao = "";

        System.out.println("\nInsira as informações para realizar o cadastro de Multa:\n");

        // Entrada do atributo codigo da multa
        do {
            String aux1 = "";
            String aux2 = "";

            try {
                System.out.println("\t- Informe o código da multa (apenas números): \n");
                id = Integer.parseInt(input.nextLine());

                codigo = "" + id;
                aux1 = codigo.substring(0,3);
                aux2 = codigo.substring(3, 5);

                codigo = aux1 + "-" + aux2;
            } catch (NumberFormatException e){
                System.out.println("\n\t\t O campo código aceita somente números!\n");
            }

        } while (!codigo.isEmpty());

        // Entrada do atributo descrição da multa
        do {
            System.out.println("\t- Informe a descrição da multa ocorreu a multa (Max. 100 caracteres):: \n");
            descricao = input.nextLine();

            if(descricao.isEmpty()) {
                System.out.println("\n\t\t Descrição não pode ser vazia...\n");
            } else if(descricao.length() > 100){
                System.out.println("\n\t\t Descrição não pode ter mais de 100 caracteres...\n");
            }
        } while (descricao.isEmpty() || descricao.length() > 100);

        // Entrada do atributo classificação, pontos e valor da multa
        do {
            System.out.println("\t- Informe a classificação da multa: \n");
            System.out.print("\t\t1. Leve\n\t\t2. Média\n\t\t3. Grave\n\t\t4. Gravíssima\n\t\tOpção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());

                switch (opcao){
                    case 1:
                        classificacao = "Leve";
                        pontos = 3;
                        valor = 88.38;                  // Valor do dia 25/08/2023 as 20hrs
                        break;
                    case 2:
                        classificacao = "Média";
                        pontos = 4;
                        valor = 130.16;                  // Valor do dia 25/08/2023 as 20hrs
                        break;
                    case 3:
                        classificacao = "Grave";
                        pontos = 5;
                        valor = 195.23;                  // Valor do dia 25/08/2023 as 20hrs
                        break;
                    case 4:
                        classificacao = "Gravíssima";
                        pontos = 7;
                        valor = 293.47;                  // Valor do dia 25/08/2023 as 20hrs
                        break;
                    default:
                        System.out.println("\n\t\t Opção inválida!\n");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("\n\t\t O campo opção aceita somente números!\n");
            }

        } while (classificacao.isEmpty());

        Multa multa = new Multa(codigo, descricao, classificacao, pontos, valor);

        return insereMulta(multa);
    }

    public static boolean excluirMulta() {
        int id = 0;
        String codigo = "";

        System.out.println("\nInsira as informações da multa para realizar a exclusão:\n");

        // Entrada do valor do codigo da multa
        do {
            String aux1 = "";
            String aux2 = "";

            try {
                System.out.println("\t- Informe o código da multa (apenas números): \n");
                id = Integer.parseInt(input.nextLine());

                codigo = "" + id;
                aux1 = codigo.substring(0, 3);
                aux2 = codigo.substring(3, 5);

                codigo = aux1 + "-" + aux2;
            } catch (NumberFormatException e) {
                System.out.println("\n\t\t O campo código aceita somente números!\n");
            }

        } while (!codigo.isEmpty());

        return removeMulta(codigo);
    }

    public static Multa buscarMulta(){
        int id = 0;
        String codigo = "";

        System.out.println("\nInsira as informações da multa para realizar a busca:\n");

        // Entrada do valor do codigo da multa
        do {
            String aux1 = "";
            String aux2 = "";

            try {
                System.out.print("\t- Informe o código da multa (apenas números): ");
                id = Integer.parseInt(input.nextLine());

                codigo = "" + id;
                aux1 = codigo.substring(0, 3);
                aux2 = codigo.substring(3, 5);

                codigo = aux1 + "-" + aux2;
            } catch (NumberFormatException e) {
                System.out.println("\n\t\t O campo código aceita somente números!\n");
            }

        } while (!codigo.isEmpty());

        return buscaMulta(codigo);
    }

    public static void verDadosMulta(){
        Multa multa = buscarMulta();

        if (multa != null){
            System.out.println(multa);
        } else {
            System.out.println("\n\t\t Nenhuma multa cadastrada com essas informações!\n");
        }
    }

    public static void listaMultas(){
        ArrayList<Multa> multas = new ArrayList<>();
        multas = buscaMultaGeral();

        System.out.println("Multas cadastradas: \n");
        if (multas != null){
            for (Multa multa : multas) {
                System.out.println(multa);
            }
        } else {
            System.out.println("\n\t\t Nenhuma multa cadastrada no sistema!\n");
        }
    }

    public static void listaMultas(String classificacao){
        ArrayList<Multa> multas = new ArrayList<>();
        multas = buscaMultaClassificacao(classificacao);

        System.out.println("Multas " + classificacao + ": \n");
        if (multas != null){
            for (Multa multa : multas) {
                System.out.println(multa);
            }
        } else {
            System.out.println("\n\t\t Nenhuma multa cadastrada com essa classificação!\n");
        }
    }
}
