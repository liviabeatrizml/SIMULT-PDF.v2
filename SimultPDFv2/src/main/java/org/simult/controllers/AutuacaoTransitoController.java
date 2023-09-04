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

        do {
            System.out.println("\t- Renavam:");
            renavam = input.nextLine();

        } while (renavam.length() != 7);

        Veiculo veiculo = buscaVeiculo(placa, renavam);
        System.out.println(veiculo);

        System.out.println("\nAgora informe as multas a ser inserida no veículo multado:");
        do {
            System.out.println("\t- Informe a classificação da multa: \n");
            System.out.println("\t1 - LEVE\n\t2 - MÉDIA\n\t3 - GRAVE\n\t4 - GRAVÍSSIMA\n");
            System.out.println("\n\t Opção: ");

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
                System.out.println("\n\t- Informe o código da multa (apenas números): \n");
                id = Integer.parseInt(input.nextLine());

                codigo = "" + id;
                aux1 = codigo.substring(0, 3);
                aux2 = codigo.substring(3, 5);

                codigo = aux1 + "-" + aux2;

                if (buscaMulta(codigo) == null) {
                    System.out.println("\n\t\t Não existe nenhuma multa com esse código!\n");
                    codigo = "";
                }
            } catch (NumberFormatException e) {
                System.out.println("\n\t\t O campo código aceita somente números!\n");
            }
        } while (!codigo.isEmpty());

        Multa multa = buscaMulta(codigo);

        // Entrada do atributo estado da autuacao
        do {
            System.out.println("\t- Informe o estadodo da autuacao: \n");
            estado = input.nextLine();

            if (estado.isEmpty()) {
                System.out.println("\n\t\t É necessário informar a estado da autuacao!\n");
            }
        } while (estado.isEmpty());

        // Entrada do atributo municipio da autuacao
        do {
            System.out.println("\t- Informe o municipio da autuacao: \n");
            municipio = input.nextLine();

            if (municipio.isEmpty()) {
                System.out.println("\n\t\t É necessário informar o municipio da autuacao!\n");
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
            System.out.println("\t- Escreva o ID da autuacão: \n");
            try {
                id = Integer.parseInt(input.nextLine());

                if(buscaAutuacao(id) != null){
                    valid = false;
                } else {
                    System.out.println("\n\t\t Autuação de trânsito com ID " + id + " não existe!");
                }
            } catch (NumberFormatException e){
                System.out.println("\n\t\t O campo opção aceita somente números!\n");
            }

        } while (valid);

        return removeAutuacao(id);
    }

}
