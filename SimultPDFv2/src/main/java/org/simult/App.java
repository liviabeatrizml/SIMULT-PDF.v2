package org.simult;

import org.simult.models.entity.Administrador;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.simult.controllers.AdministradorController.*;

public class App  {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        Administrador adm = null;

        int opcao = 0;

        System.out.println("\n\t\t\t **** SIMULT-PDF  V.2 **** \n");

        adm = logar();

        do {
            if (adm != null) {
                System.out.println("\n\t- Que operação deseja realizar:");
                System.out.print("\t\t1. Cadastrar novo administrador\n\t\t2. Buscar veículo\n\t\t3. Buscar multa\n\t\t4. Vincular multa a um veículo\n\t\t5. Desvincular multa de um veículo\n\t\t6. Gerar relatório de autuações\n\t\t7. Sair\n\t\t8. Fechar sistema\n\tOpcao: ");
                try {
                    opcao = Integer.parseInt(input.nextLine());

                    switch (opcao) {
                        case 1:
                            if (cadastrarAdministrador(adm)) {
                                System.out.println("\n\t\t Cadastramento concluído com sucesso!");
                            } else if (!cadastrarAdministrador(adm)) {
                                System.out.println("\n\t\t Falha no cadastramento!");
                            }
                            break;
                        case 2:
                            consultarVeiculo();
                            break;
                        case 3:
                            consultarMulta();
                            break;
                        case 4:
                            if (vincularMulta(adm)){
                                System.out.println("\n\t\t Autuação vinculada com sucesso!");
                            } else {
                                System.out.println("\n\t\t Falha no vinculação da autuação!");
                            }
                            break;
                        case 5:
                            if (desvincularMulta(adm)){
                                System.out.println("\n\t\t Autuação desvinculada com sucesso!");
                            } else {
                                System.out.println("\n\t\t Falha no desvinculação da autuação!");
                            }
                            break;
                        case 6:
                            if (!gerarRelatorio(adm)){
                                System.out.println("\n\t\t Falha na geração do relatório!");
                            }
                            break;
                        case 7:
                            adm = null;
                            break;
                        case 8:
                            System.out.println("\n\t\t Encerrando sistema!!!\n");
                            break;
                        default:
                            System.out.println("\n\t\t Opção inválida!!!");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\t\t O campo opção aceita somente números!\n");
                }
            } else {
                System.out.println("\n\t\t Para acessar o sistema é necessário está logado!\n");
                adm = logar();
            }
        } while (opcao != 8);
        /**/
    }
}
