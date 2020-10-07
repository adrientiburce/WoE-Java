/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet.Exceptions;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author learoussel
 */
public class Test {

    /**
     * decommenter la methode pour générer l'exception désirée
     *
     * @param args
     */
    public static void main(String[] args) {

        getNullPointerException();

//        getArrayIndexOutOfBounds();

//        getArithmeticException();

//        getClassCastException();

//        getNumberFormatException();
//        preventNumberFormatException();

//        getStackOverFlowException();

//        getConcurrentModificationException();
    }

    private static void getStackOverFlowException() {
        System.out.println("Tentons d'avoir une exception de type StackOverFlowException");
        SofException.appel();
    }

    private static void getConcurrentModificationException() {
        System.out.println("Tentons d'avoir une exception de type ConcurrentModificationException");
        ArrayList<String> arr = new ArrayList<>();

        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add("Four");
        System.out.println("Print ArrayList: ");
        Iterator<String> iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
            arr.add("Five");
        }
    }

    private static void getNumberFormatException() {
        System.out.println("Tentons d'avoir une exception de type NumberFormatException");
        NumberFormatExcept scan = new NumberFormatExcept();
        scan.askForNumber();
    }

    /**
     * ne génère pas d'exception grace au bloc try/catch
     */
    private static void preventNumberFormatException() {
        System.out.println("Evitons d'avoir une exception de type NumberFormatException");
        NumberFormatExcept scan = new NumberFormatExcept();
        int n = scan.preventWrongInput();
        System.out.printf("Tu as rentré %d", n);
    }

    /**
     * générer une exception si du texte est rentré
     */
    private static void getClassCastException() {
        System.out.println("Tentons d'avoir une exception de type ClassCastException");
        Object x = 1;
        System.out.println((String) x);
    }

    private static void getArithmeticException() {
        System.out.println("Tentons d'avoir une exception de type ArithmeticException");
        System.out.println(1 / 0);
    }

    private static void getArrayIndexOutOfBounds() {
        System.out.println("Tentons d'avoir une exception de type ArrayIndexOutOfBounds");
        int[] tab = new int[18];
        System.out.println(tab[18]);
    }

    private static void getNullPointerException() {
        System.out.println("Tentons d'avoir une exception de type NullPointerException :");
        Test t = initTest();
        // utiliser une methode sur null
        t.foo("Hi");
    }

    public static Test initTest() {
        return null;
    }


    public void foo(String s) {
        System.out.println(s.toLowerCase());
    }

}
