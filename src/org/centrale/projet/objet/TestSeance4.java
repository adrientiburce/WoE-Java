package org.centrale.projet.objet;

/**
 * classe de Test pour le TP4
 */
public class TestSeance4 {

    public static void main(String[] args) {
        World monde = new World(20);
        monde.creerMondeAlea(10);
        System.out.println("Monde 1: " + monde);

        for (int i = 1; i < 5; i++) {
            System.out.println(monde.creatures.get(i));
        }
        System.out.println(World.mapPositions);


        // calcul barycentre :
//        long debut = System.currentTimeMillis();
//        long debutN = System.nanoTime();
//        System.out.println(monde.caculBarycentrePersos(monde));
//        long fin = System.currentTimeMillis();
//        long finN = System.nanoTime();
//        System.out.printf("Temps d'exécution %d ms \n", fin - debut);
//        System.out.printf("Temps d'exécution %d nanos", (finN - debutN)/1000);
    }

}

