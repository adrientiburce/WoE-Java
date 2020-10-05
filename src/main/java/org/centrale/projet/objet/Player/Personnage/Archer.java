package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;

import java.util.Random;

public class Archer extends Personnage {

    /**
     * nombre de flèches que possède l'archer
     */
    private int nbFleches;

    public Archer() {
        super();
        this.setNom("un archer");
        this.nbFleches = 0;
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

    public void combattre(Personnage defenseur) {
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

    private void combatADistance(Personnage defenseur) {
        Random randomGenerator = new Random();
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageAtt()) {
            int newPtvie = Integer.max(defenseur.getPtVie() - this.getDegAtt(), 0);
            defenseur.setPtVie(newPtvie);
            System.out.println("\uD83D\uDC4C perte de vie de : " + this.getDegAtt());
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
        this.setNbFleches(Integer.max(this.getNbFleches() - 1, 0));
    }

    public void affiche() {
        System.out.printf("Archer{%s, nbFleches=%s}\n", this.toString(), nbFleches);
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
}
