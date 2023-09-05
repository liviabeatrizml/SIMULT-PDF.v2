package org.simult;

import org.simult.models.entity.Administrador;

import java.util.Scanner;

import static org.simult.controllers.AdministradorController.*;
import static org.simult.models.dao.AdministradorDAO.buscaAdministrador;

public class App  {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        Administrador adm = null;


        int opcao = 0;

        System.out.println("\n\t\t\t **** SIMULT-PDF  V.2 **** \n\n");

        adm = logar();

        do {
            if (adm != null) {
                System.out.println("\n\t- Que operação deseja realizar:");
                System.out.print("\t\t1. Cadastrar novo administrador\n\t\t2. Buscar veículo\n\t\t3. Buscar multa\n\t\t4. Vincular multa a um veículo\n\t\t5. Desvincular multa de um veículo\n\t\t6. Gerar relatório de multas\n\t\t7. Gerar relatório de ações gerais\n\t\t8. Sair\n\t\t9. Fechar sistema\n\tOpcao: ");
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
                            vincularMulta(adm);
                            break;
                        case 5:
                            desvincularMulta(adm);
                            break;
                        case 6:
                            //gerarRelatorio(adm);
                            break;
                        case 7:
                            //gerarRelatorio(adm);
                            break;
                        case 8:
                            adm = null;
                            break;
                        case 9:
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
        } while (opcao != 9);
    }
}
