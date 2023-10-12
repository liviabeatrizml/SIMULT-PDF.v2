package org.simult.controllers;

import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.simult.models.entity.Administrador;

import java.util.Objects;
import java.util.Scanner;

import static org.simult.controllers.AutuacaoTransitoController.cadastrarAutuacao;
import static org.simult.controllers.AutuacaoTransitoController.removerAutuacao;
import static org.simult.controllers.MultaController.verDadosMulta;
import static org.simult.controllers.RelatorioController.criarRelatorio;
import static org.simult.controllers.VeiculoController.verDadosVeiculo;
import static org.simult.models.dao.AdministradorDAO.buscaAdministrador;
import static org.simult.models.dao.AdministradorDAO.insereAdministrador;

public class AdministradorController{
    private static final Scanner input = new Scanner(System.in);

    public static Administrador logar(){
        String login = "";
        String senha = "";

        int tentativas = 0;
        boolean acesso = false;

        do {
            // Entrada do valor do login do administrador
            System.out.print("\t- Login: ");
            login = input.nextLine();

            // Entrada do valor da senha do administrador
            System.out.print("\t- Senha: ");
            senha = input.nextLine();

            String senhaCodificada = Objects.requireNonNull(buscaAdministrador(login)).getSenha();

            if(!senhaCodificada.isEmpty() && BCrypt.checkpw(senha, senhaCodificada)){
                System.out.println("\n\t\t Logando no sistema!");
                return buscaAdministrador(login);
            } else {
                System.out.println("\n\t\t Credenciais incorretas! \n");
                tentativas++;
            }
        } while (tentativas < 3 && !acesso);

        System.out.println("\n\t\t Máximo de tentativas atingido.\n\t\t\t  Acesso bloqueado!!!\n\n");
        System.exit(0);
        return null;
    }

    public static boolean cadastrarAdministrador(@NotNull Administrador administrador){
        if(administrador.getId() == 1){
            String nome = "";
            String email = "";
            String login = "";
            String senha = "";

            // Entrada do atributo nome do administrador
            do {
                System.out.print("\n\t- Informe o nome do administrador: ");
                nome = input.nextLine();

                if(nome.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar o nome do administrador!\n");
                }
            } while (nome.isEmpty());

            // Entrada do atributo email do administrador
            do {
                System.out.print("\t- Informe um email para a conta: ");
                email = input.nextLine();

                if(email.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar um email para a conta!\n");
                }
            } while (email.isEmpty());

            // Entrada do atributo login do administrador
            do {
                System.out.print("\t- Informe um login para a conta: ");
                login = input.nextLine();

                if(login.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar um login para a conta!\n");
                }
            } while (login.isEmpty());

            // Entrada do atributo senha do administrador
            do {
                System.out.print("\t- Informe uma senha para a conta: ");
                senha = input.nextLine();

                if(senha.length() < 8) {
                    System.out.println("\n\t\t A senha deve conter no mínimo 8 dígitos!\n");
                }
            } while (senha.length() < 8);

            senha = BCrypt.hashpw(senha, BCrypt.gensalt());

            Administrador adm = new Administrador(nome, email, login, senha);

            return insereAdministrador(adm);
        } else {
            System.out.println("\n\t\t Você não possui permissão para isso!\n");
            return false;
        }
    }

    public static boolean vincularMulta(Administrador administrador){
        return cadastrarAutuacao(administrador);
    }

    public static boolean desvincularMulta(Administrador administrador){
        return removerAutuacao(administrador);
    }

    public static void consultarVeiculo(){
        verDadosVeiculo();
    }

    public static void consultarMulta(){
        verDadosMulta();
    }

    public static boolean gerarRelatorio(Administrador administrador){
        return criarRelatorio(administrador);
    }

}
