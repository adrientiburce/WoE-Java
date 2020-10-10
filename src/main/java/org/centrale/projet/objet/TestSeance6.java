package org.centrale.projet.objet;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.util.Random;

public class TestSeance6 {

    public static int NOMBRE_TOUR = 3;

    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Random random = new Random();

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(10);
        monde.creerMondeAlea(60);

        // shortcut to debug
        Personnage persoSelected = new Archer("Robin Hood", random);
        joueur.perso = persoSelected;
        // shortcut to debug
        joueur.perso.putOnMap(new Point2D(3, 3));


        // Tours de jeux
        for (int i = 0; i < NOMBRE_TOUR; i++) {
            joueur.askNextAction();
        }


    }
}
