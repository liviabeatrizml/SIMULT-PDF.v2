package org.simult.controllers;

import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.simult.models.entity.Administrador;
import org.simult.models.entity.Veiculo;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.simult.controllers.AutuacaoTransitoController.cadastrarAutuacao;
import static org.simult.controllers.AutuacaoTransitoController.removerAutuacao;
import static org.simult.controllers.VeiculoController.verDadosVeiculo;
import static org.simult.models.dao.AdministradorDAO.buscaAdministrador;
import static org.simult.models.dao.AdministradorDAO.insereAdministrador;

public class AdministradorController{
    private static final Scanner input = new Scanner(System.in);

    public static boolean logar(String login, String senha){
        String senhaCodificada = Objects.requireNonNull(buscaAdministrador(login)).getSenha();

        return BCrypt.checkpw(senha, senhaCodificada);
    }

    public static boolean cadastrarAdministrador(@NotNull Administrador administrador){
        if(administrador.getId() == 0){
            String nome = "";
            String email = "";
            String login = "";
            String senha = "";

            // Entrada do atributo nome do administrador
            do {
                System.out.println("\t- Informe o nome do administrador: \n");
                nome = input.nextLine();

                if(nome.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar o nome do administrador!\n");
                }
            } while (nome.isEmpty());

            // Entrada do atributo email do administrador
            do {
                System.out.println("\t- Informe um email para a conta: \n");
                email = input.nextLine();

                if(email.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar um email para a conta!\n");
                }
            } while (email.isEmpty());

            // Entrada do atributo login do administrador
            do {
                System.out.println("\t- Informe um login para a conta: \n");
                login = input.nextLine();

                if(login.isEmpty()) {
                    System.out.println("\n\t\t É necessário informar um login para a conta!\n");
                }
            } while (login.isEmpty());

            // Entrada do atributo senha do administrador
            do {
                System.out.println("\t- Informe uma senha para a conta: \n");
                senha = input.nextLine();

                if(senha.length() < 8) {
                    System.out.println("\n\t\t É necessário informar uma senha para a conta!\n");
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
        return removerAutuacao();
    }

    public static void consultarVeiculo(){
        verDadosVeiculo();
    }

    public static boolean gerarRelatorio(Administrador administrador){
        return false;
    }

}
