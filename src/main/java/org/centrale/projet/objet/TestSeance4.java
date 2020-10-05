package org.centrale.projet.objet;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;

public class TestSeance4 {

    public static void main(String[] args) {
        World monde = new World(200);
        testCombatGuerrier(monde);
        System.out.println();

        testCombatMage(monde);
        System.out.println();

        testCombatLoup(monde);
    }

    public static void testArrayVSList() {
        World monde = new World(200);
        monde.creerMondeAlea(1000);
        System.out.println("Monde 1: " + monde);

        // calcul barycentre :
        long debut = System.currentTimeMillis();
        long debutN = System.nanoTime();
        System.out.println(World.calculBarycentrePersos(monde));
        long fin = System.currentTimeMillis();
        long finN = System.nanoTime();
        System.out.printf("Temps d'exécution %d ms \n", fin - debut);
        System.out.printf("Temps d'exécution %d nanos", (finN - debutN) / 1000);
    }

    public static void testCombatGuerrier(World monde) {
        monde.creatures.add(new Guerrier("Hulk", 70, 50, 12, 85, 32, 20, 90,
                65, 90, 20, new Point2D(21, 23), 8));
        monde.creatures.add(new Archer("Robin Hoods", 100, 50, 10, 80, 50, 20, 80,
                30, 90, 15, new Point2D(20, 23), 10));

        Guerrier g = ((Guerrier) monde.creatures.get(0));
        Archer archer = (Archer) monde.creatures.get(1);
        archer.affiche();
        g.combattre(archer);
        archer.affiche();
    }

    public static void testCombatMage(World monde) {
        monde.creatures.add(new Mage("Dumbledore", 90, 50, 10, 85, 88, 20, 80,
                18, 40, 15, new Point2D(18, 19), 10));
        Mage m = (Mage) monde.creatures.get(2);
        Archer archer = (Archer) monde.creatures.get(1);
        m.combattre(archer);
        archer.affiche();
    }

    public static void testCombatLoup(World monde) {
        monde.creatures.add(new Loup( "Loup Garou", 70, 70, 12, 33, new Point2D(22, 23)));

        Guerrier g = ((Guerrier) monde.creatures.get(0));
        Loup p = ((Loup) monde.creatures.get(3));
        g.affiche();
        p.combattre(g);
        g.affiche();
    }

    public static void testPotion() {
        World monde = new World(200);
//        this.potionVie = new Soin("vie++", "rouge", new Point2D(20, 24), 3);
//        this.potionPanoramix = new Mana(8);
    }
}
