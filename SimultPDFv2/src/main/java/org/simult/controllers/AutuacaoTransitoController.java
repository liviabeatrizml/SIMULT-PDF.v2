package org.simult.controllers;

import org.simult.models.entity.Administrador;
import org.simult.models.entity.AutuacaoTransito;
import org.simult.models.entity.Multa;
import org.simult.models.entity.Veiculo;

import java.util.Scanner;
import java.util.regex.Pattern;

import static org.simult.controllers.MultaController.listaMultas;
import static org.simult.models.dao.AutuacaoTransitoDAO.*;
import static org.simult.models.dao.MultaDAO.buscaMulta;
import static org.simult.models.dao.VeiculoDAO.buscaVeiculo;

public class AutuacaoTransitoController {
    private static final Scanner input = new Scanner(System.in);

    public static boolean cadastrarAutuacao(Administrador autor){
        int id = 0;
        int opcao = 0;

        String codigo = "";
        String placa = "";
        String renavam = "";
        String classificacao = "";
        String estado = "";
        String municipio = "";

        System.out.println("\nInforme a Placa e o Renavam do veículo multado:");

        do {
            System.out.print("\t- Escreva a PLACA do veículo: ");
            placa = input.nextLine().toUpperCase();

            Pattern letras = Pattern.compile("^[A-Z]+$");
            Pattern nums = Pattern.compile("^[0-9]+$");

            if(placa.length() == 7){
                if(!letras.matcher(placa.substring(0, 3)).find() && !nums.matcher(("" + placa.charAt(3))).find() && !letras.matcher(("" + placa.charAt(4))).find() && !nums.matcher(placa.substring(5, 7)).find()){
                    System.out.println("\n\t\t Formato da PLACA do veículo incorreta!\n");
                    placa = "";
                }
            } else {
                System.out.println("\n\t\t A PLACA do veículo deve ser formada por 7 dígitos!\n");
            }

        } while (placa.length() != 7);

        // Entrada do valor do renavam do veículo
        do {
            System.out.print("\t- Informe o RENAVAM do veículo: ");
            renavam = input.nextLine();

            Pattern letras = Pattern.compile("^[A-Z]+$");

            if(renavam.length() == 9 || renavam.length() == 11) {
                if (letras.matcher(renavam).find()){
                    System.out.println("\n\t\t O RENAVAM deve conter apenas números!\n");
                    renavam = "";
                }
            } else {
                System.out.println("\n\t\t É necessário informar o RENAVAM válido (com 9 ou 11 algarismos)!\n");
            }

        } while (renavam.length() != 9 && renavam.length() != 11);

        Veiculo veiculo = buscaVeiculo(placa, renavam);
        System.out.println(veiculo);

        System.out.println("\nAgora informe as multas a ser inserida no veículo multado:");
        do {
            System.out.println("\t- Informe a classificação da multa: \n");
            System.out.print("\t\t1 - Leve\n\t\t2 - MÉDIA\n\t\t3 - GRAVE\n\t\t4 - GRAVÍSSIMA\n\t Opção: ");

            try {
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        classificacao = "Leve";
                        break;
                    case 2:
                        classificacao = "Média";
                        break;
                    case 3:
                        classificacao = "Grave";
                        break;
                    case 4:
                        classificacao = "Gravíssima";
                        break;
                    default:
                        System.out.println("\n\t\t Opção inválida!\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n\t\t O campo opção aceita somente números!\n");
            }

        } while (classificacao.isEmpty());

        listaMultas(classificacao);

        do {
            String aux1 = "";
            String aux2 = "";

            try {
                System.out.print("\n\t- Informe o código da multa (apenas números): ");
                id = Integer.parseInt(input.nextLine());

                codigo = "" + id;
                aux1 = codigo.substring(0, 3);
                aux2 = codigo.substring(3, 5);

                codigo = aux1 + "-" + aux2;

                if (buscaMulta(codigo) == null) {
                    System.out.println("\n\t\t Não existe nenhuma multa com esse código!");
                    codigo = "";
                }
            } catch (NumberFormatException e) {
                System.out.println("\n\t\t O campo código aceita somente números!");
            }
        } while (!codigo.isEmpty());

        Multa multa = buscaMulta(codigo);

        // Entrada do atributo estado da autuacao
        do {
            System.out.print("\t- Informe o estado da autuação de trânsito: ");
            estado = input.nextLine();

            if (estado.isEmpty()) {
                System.out.println("\n\t\t É necessário informar a estado da autuação!\n");
            }
        } while (estado.isEmpty());

        // Entrada do atributo municipio da autuacao
        do {
            System.out.print("\t- Informe o município da autuação de trânsito: ");
            municipio = input.nextLine();

            if (municipio.isEmpty()) {
                System.out.println("\n\t\t É necessário informar o município da autuação!\n");
            }
        } while (municipio.isEmpty());

        AutuacaoTransito autuacao = new AutuacaoTransito(autor, veiculo, multa, estado, municipio);

        return insereAutuacao(autuacao);
    }

    public static boolean removerAutuacao(){
        int id = 0;
        boolean valid = true;

        System.out.println("\nInforme o Id da autuação de trânsito que deseja excluir:");
        do {
            System.out.print("\t- Escreva o ID da autuacão: ");
            try {
                id = Integer.parseInt(input.nextLine());

                if(buscaAutuacao(id) != null){
                    valid = false;
                } else {
                    System.out.println("\n\t\t Autuação de trânsito com ID " + id + " não existe! \n");
                }
            } catch (NumberFormatException e){
                System.out.println("\n\t\t O campo opção aceita somente números!\n");
            }

        } while (valid);

        return removeAutuacao(id);
    }

}
