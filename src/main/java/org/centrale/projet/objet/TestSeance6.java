package org.centrale.projet.objet;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Personnage.Archer;

import java.util.Random;

public class TestSeance6 {

    public static void main(String[] args) {

        // creation du monde avec 60 creatures
        NewWorld monde = new NewWorld(20);
        monde.creerMondeAlea(50);


        Archer a = new Archer("Dumbledore", new Random());
        Point2D pt33 = new Point2D(3, 3);
        a.putOnMap(pt33);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Point2D key = new Point2D(i, j);
                System.out.println(key.toString() + NewWorld.map.get(key));
            }
        }
    }
}
