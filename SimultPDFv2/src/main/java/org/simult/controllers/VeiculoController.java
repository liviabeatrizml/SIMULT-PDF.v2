package org.simult.controllers;

import org.simult.models.entity.Veiculo;

import java.util.Scanner;
import java.util.regex.Pattern;

import static org.simult.models.dao.VeiculoDAO.*;

public class VeiculoController {
    private static final Scanner input = new Scanner(System.in);

    public static boolean cadastrarVeiculo(){
        int opcao = 0;

        String proprietario = "";
        String placa = "";
        String renavam = "";
        String cidadeRegistro = "";
        String estadoRegistro = "";
        String chassi = "";
        String especie = "";
        String marca = "";
        String modelo = "";
        String cor = "";

        System.out.println("\nInsira as informações para realizar o cadastro de um veículo:\n");

        // Entrada do atributo proprietario do veículo
        do {
            System.out.println("\t- Informe o nome do proprietário do veículo: \n");
            proprietario = input.nextLine().toUpperCase();

            if(proprietario.isEmpty()) {
                System.out.println("\n\t\t É necessário informar o nome do proprietário do veículo!\n");
            }
        } while (proprietario.isEmpty());

        // Entrada do atributo placa do veículo
        do {
            System.out.println("\t- Escreva a placa do veículo: \n");
            placa = input.nextLine().toUpperCase();

            Pattern letras = Pattern.compile("^[A-Z]+$");
            Pattern nums = Pattern.compile("^[0-9]+$");

            if(placa.length() == 7){
                 if(!letras.matcher(placa.substring(0, 3)).find() && !nums.matcher(("" + placa.charAt(3))).find() && !letras.matcher(("" + placa.charAt(4))).find() && !nums.matcher(placa.substring(5, 7)).find()){
                    System.out.println("\n\t\t Formato da placa do veículo incorreta!\n");
                    placa = "";
                 }
            } else {
                System.out.println("\n\t\t A placa do veículo deve ser formada por 7 dígitos!\n");
            }

        } while (placa.length() != 7);

        // Entrada do atributo renavam do veículo
        do {
            System.out.println("\t- Informe o renavam do veículo: \n");
            renavam = input.nextLine();

            Pattern letras = Pattern.compile("^[A-Z]+$");

            if(renavam.length() == 9 || renavam.length() == 11) {
                if (letras.matcher(renavam).find()){
                    System.out.println("\n\t\t O renavam deve conter apenas números!\n");
                    renavam = "";
                }
            } else {
                System.out.println("\n\t\t É necessário informar o renavam válido (com 9 ou 11 algarismos)!\n");
            }

        } while (renavam.length() != 9 && renavam.length() != 11);

        // Entrada do atributo chassi do veículo
        do {
            System.out.println("\t- Informe o chassi do veículo (17 dígitos alfanuméricos): \n");
            chassi = input.nextLine();

            if(chassi.length() != 17) {
                System.out.println("\n\t\t É necessário informar o chassi válido para o veículo!\n");
            }
        } while (chassi.length() != 17);

        // Entrada do atributo estadoRegistro do veículo
        do {
            System.out.println("\t- Informe o estado de registro do veículo: \n");
            estadoRegistro = input.nextLine();

            if(estadoRegistro.isEmpty()) {
                System.out.println("\n\t\t É necessário informar a estado de registro do veículo!\n");
            }
        } while (estadoRegistro.isEmpty());

        // Entrada do atributo cidaderregistro do veículo
        do {
            System.out.println("\t- Informe o cidade de registro do veículo: \n");
            cidadeRegistro = input.nextLine();

            if(cidadeRegistro.isEmpty()) {
                System.out.println("\n\t\t É necessário informar o cidade de registro do veículo!\n");
            }
        } while (cidadeRegistro.isEmpty());

        // Entrada do atributo marca do veículo
        do {
            System.out.println("\t- Informe a marca do veículo: \n");
            marca = input.nextLine();

            if(marca.isEmpty()) {
                System.out.println("\n\t\t É necessário informar a marca para o veículo!\n");
            }
        } while (marca.isEmpty());

        // Entrada do atributo modelo do veículo
        do {
            System.out.println("\t- Informe o modelo do veículo: \n");
            modelo = input.nextLine();

            if(modelo.isEmpty()) {
                System.out.println("\n\t\t É necessário informar o modelo para o veículo!\n");
            }
        } while (modelo.isEmpty());

        // Entrada do atributo cor do veículo
        do {
            System.out.println("\t- Informe a cor do veículo: \n");
            cor = input.nextLine();

            if(cor.isEmpty()) {
                System.out.println("\n\t\t É necessário informar a cor para o veículo!\n");
            }
        } while (cor.isEmpty());

        // Entrada do atributo especie do veículo
        do {
            System.out.println("\t- Informe a especie do veículo: \n");
            System.out.println("\t1 - PASSAGEIRO\n\t2 - CARGA\n\t3 - MISTO\n\t4 - COMPETIÇÃO\n\t5 - TRAÇÃO\n\t6 - ESPECIAL\n\t7 - COLEÇÃO\n");
            System.out.println("\n\t Opção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());

                switch (opcao){
                    case 1:
                        especie = "Passageiro";
                        break;
                    case 2:
                        especie = "Carga";
                        break;
                    case 3:
                        especie = "Misto";
                        break;
                    case 4:
                        especie = "Competição";
                        break;
                    case 5:
                        especie = "Tração";
                        break;
                    case 6:
                        especie = "Especial";
                        break;
                    case 7:
                        especie = "Coleção";
                        break;
                    default:
                        System.out.println("\n\t\t Opção inválida!\n");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("\n\t\t O campo opção aceita somente números!\n");
            }
        } while (especie.isEmpty());

        Veiculo veiculo = new Veiculo(placa, renavam, chassi, proprietario, estadoRegistro, cidadeRegistro, cor, marca, modelo, especie);

        return insereVeiculo(veiculo);
    }

    public static boolean excluirVeiculo(){
        String placa = "";
        String renavam = "";

        System.out.println("\nInsira as informações do veículo para realizar a exclusão:\n");

        // Entrada do valor da placa do veículo
        do {
            System.out.println("\t- Escreva a placa do veículo: \n");
            placa = input.nextLine().toUpperCase();

            Pattern letras = Pattern.compile("^[A-Z]+$");
            Pattern nums = Pattern.compile("^[0-9]+$");

            if(placa.length() == 7){
                if(!letras.matcher(placa.substring(0, 3)).find() && !nums.matcher(("" + placa.charAt(3))).find() && !letras.matcher(("" + placa.charAt(4))).find() && !nums.matcher(placa.substring(5, 7)).find()){
                    System.out.println("\n\t\t Formato da placa do veículo incorreta!\n");
                    placa = "";
                }
            } else {
                System.out.println("\n\t\t A placa do veículo deve ser formada por 7 dígitos!\n");
            }

        } while (placa.length() != 7);

        // Entrada do valor do renavam do veículo
        do {
            System.out.println("\t- Informe o renavam do veículo: \n");
            renavam = input.nextLine();

            Pattern letras = Pattern.compile("^[A-Z]+$");

            if(renavam.length() == 9 || renavam.length() == 11) {
                if (letras.matcher(renavam).find()){
                    System.out.println("\n\t\t O renavam deve conter apenas números!\n");
                    renavam = "";
                }
            } else {
                System.out.println("\n\t\t É necessário informar o renavam válido (com 9 ou 11 algarismos)!\n");
            }

        } while (renavam.length() != 9 && renavam.length() != 11);

        return removeVeiculo(placa, renavam);
    }

    public static Veiculo buscarVeiculo(){
        String placa = "";
        String renavam = "";

        System.out.println("\nInsira as informações do veículo para realizar a busca:\n");

        // Entrada do valor da placa do veículo
        do {
            System.out.println("\t- Escreva a placa do veículo: \n");
            placa = input.nextLine().toUpperCase();

            Pattern letras = Pattern.compile("^[A-Z]+$");
            Pattern nums = Pattern.compile("^[0-9]+$");

            if(placa.length() == 7){
                if(!letras.matcher(placa.substring(0, 3)).find() && !nums.matcher(("" + placa.charAt(3))).find() && !letras.matcher(("" + placa.charAt(4))).find() && !nums.matcher(placa.substring(5, 7)).find()){
                    System.out.println("\n\t\t Formato da placa do veículo incorreta!\n");
                    placa = "";
                }
            } else {
                System.out.println("\n\t\t A placa do veículo deve ser formada por 7 dígitos!\n");
            }

        } while (placa.length() != 7);

        // Entrada do valor do renavam do veículo
        do {
            System.out.println("\t- Informe o renavam do veículo: \n");
            renavam = input.nextLine();

            Pattern letras = Pattern.compile("^[A-Z]+$");

            if(renavam.length() == 9 || renavam.length() == 11) {
                if (letras.matcher(renavam).find()){
                    System.out.println("\n\t\t O renavam deve conter apenas números!\n");
                    renavam = "";
                }
            } else {
                System.out.println("\n\t\t É necessário informar o renavam válido (com 9 ou 11 algarismos)!\n");
            }

        } while (renavam.length() != 9 && renavam.length() != 11);

        return buscaVeiculo(placa, renavam);
    }

    public static void verDadosVeiculo(){
        Veiculo veiculo = buscarVeiculo();
        System.out.println(veiculo);
    }

}
