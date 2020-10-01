package org.centrale.projet.objet.Grille;

public class TestPoint2D {

    public static void main(String[] args) {

        // test constructeur
        System.out.println("Constructeurs");

        Point2D origine = new Point2D();
        Point2D pointA = new Point2D(3, 14);
        Point2D pointB = new Point2D(pointA);
        origine.affiche();
        pointA.affiche();
        pointB.affiche();


        System.out.println("\n==============");
        // test autres méthodes
        pointA.translater(-2, 6);
        pointA.affiche(); // (1, 20)
        pointA.translater(-13, 90); // (1, 20)
        pointA.affiche(); // hors grille donc (0, 100)

        origine.setPosition(-10, 10);
        origine.affiche();

        System.out.println(origine.distance(pointA));


    }


}
