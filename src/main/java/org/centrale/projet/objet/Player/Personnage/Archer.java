package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Combattant;
import org.centrale.projet.objet.Player.Creature;

import java.util.Random;

public class Archer extends Personnage implements Combattant {


    /**
     * nombre de flèches que possède l'archer
     */
    private int nbFleches;

    public Archer() {
        super();
        this.setNom("un archer");
        this.nbFleches = 0;
    }

    public Archer(String nom, Random random) {
        super(nom, random.nextInt(50) + 50, random.nextInt(50) + 50, random.nextInt(30), random.nextInt(20) + 80, random.nextInt(80) + 20, random.nextInt(50) + 50, random.nextInt(50) + 50,
                random.nextInt(50) + 10, random.nextInt(50) + 50, random.nextInt(15) + 2, new Point2D());
        this.setNbFleches(random.nextInt(15) + 5);
    }

    public Archer(String nom, int ptVie, int ptMana, int ptPar, int pAtt, int pPar, int pMag, int pResistMag, int degAtt, int degMag, int distAttMax, Point2D pos, int nbFleches) {
        super(nom, ptVie, ptMana, ptPar, pAtt, pPar, pMag, pResistMag, degAtt, degMag, distAttMax, pos);
        this.nbFleches = nbFleches;
    }

    /**
     * constructeur par recopie
     *
     * @param a archer à copier
     */
    public Archer(Archer a) {
        super(a.getNom(), a.getPtVie(), a.getPtMana(), a.getPtPar(), a.getPourcentageAtt(), a.getPourcentagePar(), a.getPourcentageMag(), a.getPourcentageResistMag(), a.getDegAtt(), a.getDegMag(), a.getDistAttMax(), a.getPos());
        this.nbFleches = a.nbFleches;
    }

    @Override
    public void combattre(Creature defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        // contact
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur);
        } else if (distCombatants <= this.getDistAttMax()) {
            System.out.printf("\uD83C\uDFF9 Combat à distance: %s attaque %s \uD83C\uDFF9 \n", this.getNom(), defenseur.getNom());
            this.combatADistance(defenseur);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }

    private void combatADistance(Creature defenseur) {
        if (this.getNbFleches() <= 0) {
            System.out.println("⛔ plus de flèches");
            return;
        }

        Random randomGenerator = new Random();
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageAtt()) {
            int bonus = getPointsBonus();
            int malus = getPointsMalus();
            int newPtvie = defenseur.getPtVie() - this.getDegAtt() - bonus + malus;
            defenseur.setPtVie(newPtvie);
            System.out.println("👌 perte de vie de : " + (this.getDegAtt() + bonus - malus));
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
        this.setNbFleches(this.getNbFleches() - 1);
    }

    public void affiche() {
        System.out.printf("Archer{%s, nbFleches=%s}\n", this.toString(), nbFleches);
    }

    public String saveObject() {
        return String.format("Archer %s\n", this.toSave());
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
}
