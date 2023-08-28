package org.simult.controllers;

import org.simult.models.entity.Multa;
import org.simult.models.entity.Veiculo;

import java.util.Scanner;

public class VeiculoController {
    private static Scanner input = new Scanner(System.in);

    public Veiculo cadastrarVeiculo(){
        int opcao = 0;
        int renavam = 0;

        String proprietario = "";
        String placa = "";
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
            proprietario = input.nextLine();

            if(proprietario.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o nome do proprietário do veículo!\n");
            }
        } while (proprietario.isEmpty());

        // Entrada do atributo placa do veículo

        do {
            System.out.println("\t- Escreva a placa do veículo: \n");
            placa = input.nextLine();

            if(placa.length() == 7){
                 if(!(placa.substring(0, 2).contains("[^a-Z]")) && !(placa.substring(3).contains("[^0-9]")) && !(placa.substring(4).contains("[^a-Z]")) && !(placa.substring(5, 6).contains("[^0-9]"))){       //Character.isDigit(placa.charAt(i));   matches("[0-9]+");
                 } else {
                 System.out.println("\t\t\n Formato da placa do veículo incorreta!\n");
                 }

            } else {
                System.out.println("\t\t\n A placa do veículo deve ser formada por 7 dígitos!\n");
            }

        } while (placa.length() != 7);


        // Entrada do atributo renavam do veículo
        /*
        do {
            System.out.println("\t- Informe o renavam do veículo: \n");
            renavam = input.nextInt();

            if() {
                System.out.println("\t\t\n É necessário informar o renavam do veículo!\n");
            }
        } while ();
         */

        // Entrada do atributo chassi do veículo
        /*
        do {
            System.out.println("\t- Informe o chassi do veículo: \n");
            chassi = input.nextLine();

            if(chassi.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o chassi para o veículo!\n");
            }
        } while (chassi.isEmpty());
        */

        // Entrada do atributo estadoRegistro do veículo
        do {
            System.out.println("\t- Informe o estado de registro do veículo: \n");
            estadoRegistro = input.nextLine();

            if(estadoRegistro.isEmpty()) {
                System.out.println("\t\t\n É necessário informar a estado de registro do veículo!\n");
            }
        } while (estadoRegistro.isEmpty());

        // Entrada do atributo cidaderregistro do veículo
        do {
            System.out.println("\t- Informe o cidade de registro do veículo: \n");
            cidadeRegistro = input.nextLine();

            if(cidadeRegistro.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o cidade de registro do veículo!\n");
            }
        } while (cidadeRegistro.isEmpty());

        // Entrada do atributo marca do veículo
        do {
            System.out.println("\t- Informe a marca do veículo: \n");
            marca = input.nextLine();

            if(marca.isEmpty()) {
                System.out.println("\t\t\n É necessário informar a marca para o veículo!\n");
            }
        } while (marca.isEmpty());

        // Entrada do atributo modelo do veículo
        do {
            System.out.println("\t- Informe o modelo do veículo: \n");
            modelo = input.nextLine();

            if(modelo.isEmpty()) {
                System.out.println("\t\t\n É necessário informar o modelo para o veículo!\n");
            }
        } while (modelo.isEmpty());

        // Entrada do atributo cor do veículo
        do {
            System.out.println("\t- Informe a cor do veículo: \n");
            cor = input.nextLine();

            if(cor.isEmpty()) {
                System.out.println("\t\t\n É necessário informar a cor para o veículo!\n");
            }
        } while (cor.isEmpty());

        // Entrada do atributo especie do veículo
        do {
            System.out.println("\t- Informe a especie do veículo: \n");
            System.out.println("\t1 - PASSAGEIRO\n\t2 - CARGA\n\t3 - MISTO\n\t4 - COMPETIÇÃO\n\t5 - TRAÇÃO\n\t6 - ESPECIAL\n\t7 - COLEÇÃO\n");
            System.out.println("\n\t Opção: ");
            opcao = input.nextInt();

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
                    System.out.println("\t\t\n Opção inválida!\n");
                    break;
            }

        } while (especie.isEmpty());

        Veiculo veiculo = new Veiculo(proprietario, placa, renavam, chassi, estadoRegistro, cidadeRegistro, cor, marca, modelo, especie);

        return veiculo;
    }

    public Veiculo buscarVeiculo(){
        return null;
    }

}
