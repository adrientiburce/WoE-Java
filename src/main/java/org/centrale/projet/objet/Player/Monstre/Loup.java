package org.centrale.projet.objet.Player.Monstre;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Combattant;
import org.centrale.projet.objet.Player.Creature;

import java.util.Random;

public class Loup extends Monstre implements Combattant {

    public Loup() {
        super();
    }

    /**
     * génère un loup aléatoirement
     * @param nom
     * @param random
     */
    public Loup(String nom, Random random) {
        super(nom, random.nextInt(50) + 50, random.nextInt(40) + 50, random.nextInt(30) + 50, random.nextInt(80) + 20, new Point2D());
    }

    public Loup(String nom, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        super(nom, ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
    }

    public Loup(Loup l) {
        super(l.getNom(), l.getPtVie(), l.getPourcentageAtt(), l.getPourcentagePar(), l.getDegAtt(), l.getPos());
    }

    public void affiche() {
        System.out.printf("Loup{%s}\n", this.toString());
    }

    public void afficheMap() {
        System.out.print( "🐺Loup");
    }


    public String saveObject() {
        return String.format("Loup %s\n", this.toSave());
    }

    @Override
    public void combattre(Creature defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur, 0, 0);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }
}
