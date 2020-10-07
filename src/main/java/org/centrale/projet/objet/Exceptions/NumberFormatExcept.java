/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet.Exceptions;


import java.util.Scanner;

/**
 * @author learoussel
 */
public class NumberFormatExcept {

    public NumberFormatExcept() {
    }

    public int preventWrongInput() {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        Boolean check = true;
        System.out.println("Choisissez un entier entre 1 et 10 ");
        while (check)
            try {
                String s = sc.next();
                x = Integer.parseInt(s);
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez rentrer un entier");
            }
        return x;
    }

    public int askForNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez un entier entre 1 et 10 ");
        String s = sc.next();
        return Integer.parseInt(s);
    }

}
