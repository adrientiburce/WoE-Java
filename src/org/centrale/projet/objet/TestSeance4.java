package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Personnage.Personnage;

public class TestSeance4 {

    public static void main(String[] args) {
        World monde = new World(100);
        monde.creerMondeAlea(100);
        System.out.println("Monde 1: " + monde);

        // calcul barycentre :
        long debut = System.currentTimeMillis();
        long debutN = System.nanoTime();
        System.out.println(monde.caculBarycentrePersos(monde));
        long fin = System.currentTimeMillis();
        long finN = System.nanoTime();
        System.out.printf("Temps d'exécution %d ms \n", fin - debut);
        System.out.printf("Temps d'exécution %d nanos", (finN - debutN)/1000);
    }



}


