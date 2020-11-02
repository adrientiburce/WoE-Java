package org.centrale.projet.objet;


import org.centrale.projet.objet.Grille.Point2D;

import java.util.Random;

public class TestSeance6 {

    public static int NOMBRE_TOUR = 10;

    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Random random = new Random();

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(10);
        monde.creerMondeAlea(50);

        joueur.perso = joueur.choosePerso();


        // shortcut to debug
        joueur.perso.putOnMap(new Point2D(3, 3));

        // Tours de jeux
//        for (int i = 0; i < NOMBRE_TOUR; i++) {
//
//        }

        boolean res = true;
        while (res) {
            res = joueur.askNextAction();
        }
    }
}
