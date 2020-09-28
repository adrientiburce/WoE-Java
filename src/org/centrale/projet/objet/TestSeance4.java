package org.centrale.projet.objet;

import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Personnage.Personnage;

public class TestSeance4 {

    public static void main(String[] args) {


        World world = new World();
        world.creerMondeAlea();
        System.out.println("Monde 1: " + world);
//        System.out.println(World.mapPositions);

        System.out.println(((Personnage) world.creatures.get(0)));
        System.out.println(((Personnage) world.creatures.get(1)));
        System.out.println(((Personnage) world.creatures.get(20)));
        System.out.println(((Personnage) world.creatures.get(3)));
        System.out.println(((Personnage) world.creatures.get(40)));
        System.out.println(((Personnage) world.creatures.get(5)));


    }
}
