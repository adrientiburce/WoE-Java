package org.centrale.projet.objet;


import org.centrale.projet.objet.GameBackup.Loader;
import org.centrale.projet.objet.GameBackup.Save;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.util.Random;

public class Play {


    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Loader.load("game.txt", joueur);

        System.out.println(NewWorld.map);

        new NewWorld(2);
        System.out.println(NewWorld.map);
    }
}
