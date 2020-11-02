package org.centrale.projet.objet;


import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Personnage;
import org.centrale.projet.objet.Save.LoadGame;
import org.centrale.projet.objet.Save.Save;

import java.util.Random;

public class TestSeance7 {

    public static int NOMBRE_TOUR = 3;

    public static void main(String[] args) throws Exception {
        Joueur joueur = new Joueur();
        Personnage persoSelected = new Archer("Robin Hood", new Random());
        joueur.perso = persoSelected;

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(10);
        monde.creerMondeAlea(20);

//        System.out.println(NewWorld.map);
        Save.saveGame(monde, joueur.perso, "game.txt");

//        LoadGame.load("game.txt");

    }
}
