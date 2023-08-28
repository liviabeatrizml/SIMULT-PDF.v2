package org.simult;

import java.sql.*;
import org.simult.models.bd.Conexao;
import org.simult.models.entity.Relatorio;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App  {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        /*
        Connection conex = Conexao.getInstance().getConexao();

        if(conex != null){
            System.out.println("yesss\n");
        } else {
            System.out.println("noooo\n");
        }
         */

        String placa = "";

        System.out.println("\t- Escreva a placa do veículo: \n\t");
        placa = input.nextLine();

        System.out.println(placa.substring(0, 3).matches("[a-z][A-Z]*"));

/*
        if(!(placa.substring(0, 3).contains("^[a-Z]")) && !(placa.substring(3).contains("[^0-9]")) && !(placa.substring(4).contains("[^a-Z]")) && !(placa.substring(5, 7).matches("^[0-9]+$"))){       //Character.isDigit(placa.charAt(i));   matches("[0-9]+");
            System.out.println("\t\t\n Formato da placa do veículo correto!\n");
        } else {
            System.out.println("\t\t\n Formato da placa do veículo incorreta!\n");
        }

 */

    }
}
