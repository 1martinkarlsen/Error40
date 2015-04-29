/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.Authentification;
import Model.users.User;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class testAuthentification {

    public static void main(String[] args) {
        Authentification au = new Authentification();

        Scanner scan = new Scanner(System.in);
        String username = null;
        String password = null;

        while (true) {
            System.out.println("Enter username: ");
            username = scan.next();
            System.out.println("Enter password: ");
            password = scan.next();

            User u = au.validate(username, password);
            if (u != null ) {
                System.out.println("rank: " + u.getRank());
            }

        }

    }

}
