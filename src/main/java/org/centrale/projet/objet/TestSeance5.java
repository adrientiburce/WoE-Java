package org.centrale.projet.objet;


import org.centrale.projet.objet.Player.Creature;

import java.util.Random;

public class TestSeance5 {

    public static int NOMBRE_TOUR = 3;

    public static void main(String[] args) {

        Joueur j = new Joueur();
        Random random = new Random();

        // shortcut to debug
//        Personnage persoSelected = new Archer("Dumb", 100, random.nextInt(50) + 50, random.nextInt(30), random.nextInt(80) + 20, random.nextInt(80) + 20, random.nextInt(50) + 50, random.nextInt(50) + 50,
//                random.nextInt(50) + 10, random.nextInt(50) + 50, random.nextInt(15) + 80, new Point2D(), random.nextInt(15) + 5);
//        j.perso = persoSelected;
        // shortcut to debug

        Creature persoSelected = j.choosePerso();

        // creation du monde avec 60 creatures
        World monde = new World(100);
        monde.creerMondeAlea(20);
        //ajout du perso du joueur
        monde.addToWorld(persoSelected);
        System.out.println(persoSelected.getPos());

        // DEBUG
        System.out.println(monde);


        // Tours de jeux
        int i = 0;
        while (i < NOMBRE_TOUR) {
            j.askNextAction(monde);
            i++;
        }
    }
}
