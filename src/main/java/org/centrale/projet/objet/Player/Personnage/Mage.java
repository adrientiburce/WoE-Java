package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;

import java.util.Random;

public class Mage extends Personnage {

    public Mage() {
        super();
        this.setNom("un mage");
    }

    public Mage(String nom, int ptVie, int ptMana, int ptPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos, int force) {
        super(nom, ptVie, ptMana, ptPar, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
    }

    /**
     * constructeur par recopie
     *
     * @param m guerrier à copier
     */
    public Mage(Mage m) {
        super(m.getNom(), m.getPtVie(), m.getPtMana(), m.getPtPar(), m.getPourcentageAtt(), m.getPourcentagePar(), m.getPourcentageMag(), m.getPourcentageResistMag(), m.getDegAtt(), m.getDegMag(), m.getDistAttMax(), m.getPos());
    }

    public void affiche() {
        System.out.printf("Mage{%s}\n", this.toString());
    }

    public void combatre(Personnage defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        // contact
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur);
        } else if (distCombatants <= this.getDistAttMax()) {
            System.out.printf("🎩 Combat magique: %s attaque %s 🎩 \n", this.getNom(), defenseur.getNom());
            this.combatMagique(defenseur);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }

    private void combatMagique(Personnage defenseur) {
        Random randomGenerator = new Random();
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageAtt()) {
            int newPtvie;
            String res = "";
            // parade réussie
            if (randomGenerator.nextInt(101) <= defenseur.getPourcentageResistMag()) {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegMag() + defenseur.getPtPar(), 0);
                res = "🛡️ Parade";
            } // aucune parade
            else {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegMag(), 0);
            }
            System.out.printf("%s 👌 perte de vie engendré: %d \n", res, defenseur.getPtVie() - newPtvie);
            defenseur.setPtVie(newPtvie);
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
        this.setPtMana(Integer.max(this.getPtMana() - 1, 0));
    }

}
