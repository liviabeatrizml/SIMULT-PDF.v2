package org.simult;


import java.sql.*;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Relatorio;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.simult.controllers.AdministradorController.logar;

/**
 * Hello world!
 *
 */
public class App  {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);

        String login = "";
        String senha = "";

        int tentativas = 0;
        int opcao = 0;
        boolean acesso = false;

        System.out.println("\n\t\t\t **** SIMULT-PDF  V.2 **** \n\n");

        do {
            // Entrada do valor do login do administrador
            System.out.println("\t- Login: \n");
            login = input.nextLine();

            // Entrada do valor da senha do administrador
            System.out.println("\t- Senha: \n");
            senha = input.nextLine();

            senha = BCrypt.hashpw(senha, BCrypt.gensalt());

            if (!logar(login, senha)){
                System.out.println("\n\t\t Credenciais incorretas! \n\n");
                tentativas++;
            } else {
                System.out.println("\n\t\t Logando no sistema! \n\n");
                acesso = true;
            }

        } while (tentativas < 3 && !acesso);

        if(tentativas == 3){
            System.out.println("\n\t\t Acesso bloqueado!!!\n\n");
        } else {
            try {

            } catch (){

            }

            switch ()
        }
    }
}
