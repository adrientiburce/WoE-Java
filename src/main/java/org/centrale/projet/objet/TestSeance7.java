package org.centrale.projet.objet;


import org.centrale.projet.objet.GameBackup.Loader;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Personnage;
import org.centrale.projet.objet.GameBackup.Save;

import java.util.Random;

public class TestSeance7 {

    public static int NOMBRE_TOUR = 3;

    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Personnage persoSelected = new Archer("RobinHood", new Random());
        joueur.perso = persoSelected;

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(10);
        joueur.perso.putOnMap(new Point2D(3, 3));
        monde.creerMondeAlea(20);

//        System.out.println(NewWorld.map);
        Save.saveGame(joueur, "game.txt");

        Loader.load("game.txt", joueur);

    }
}
