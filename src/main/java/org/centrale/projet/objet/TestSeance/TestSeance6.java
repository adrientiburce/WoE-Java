package org.centrale.projet.objet.TestSeance;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Joueur;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Player.Personnage.Archer;

import java.util.Random;

public class TestSeance6 {

    public static int NOMBRE_TOUR = 10;

    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Random random = new Random();

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(10);
        monde.creerMondeAlea(50);

        joueur.perso = new Archer("Dumbledore", random);
//        joueur.perso = joueur.choosePerso();
        joueur.perso.putOnMap(new Point2D(3, 3));


        int res = 1;
        while (res == 1) {
            res = joueur.askNextAction();
        }
    }
}
