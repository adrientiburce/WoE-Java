package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Combattant;
import org.centrale.projet.objet.Player.Creature;

import java.util.Random;

public class Mage extends Personnage implements Combattant {

    public Mage() {
        super();
        this.setNom("un mage");
    }

    public Mage(String nom, Random random) {
        super(nom, random.nextInt(50) + 50, random.nextInt(50) + 50, random.nextInt(30)+ 10, random.nextInt(70) + 30, random.nextInt(80) + 20, random.nextInt(50) + 50, random.nextInt(50) + 50,
                random.nextInt(50) + 10, random.nextInt(50) + 50, random.nextInt(8) + 2, new Point2D());
    }

    public Mage(String nom, int ptVie, int ptMana, int ptPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos) {
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
        System.out.printf("🎩 Mage{%s}\n", this.toString());
    }

    public String saveObject() {
        return String.format("Mage %s\n", this.toSave());
    }

    public void afficheMap() {
        System.out.print("🎩Mage");
    }

    /**
     * combat avec combat magique et corps à corps
     *
     * @param defenseur
     */
    @Override
    public void combattre(Creature defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        // contact
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur, getPointsBonus(), getPointsMalus());
        } else if (distCombatants <= this.getDistAttMax() && defenseur instanceof Personnage) {
            System.out.printf("🎩 Combat magique: %s attaque %s 🎩 \n", this.getNom(), defenseur.getNom());
            this.combatMagique((Personnage) defenseur);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }

    private void combatMagique(Personnage defenseur) {
        if (this.getPtMana() <= 0) {
            System.out.println("⛔ réserve magique vide");
            return;
        }
        Random randomGenerator = new Random();
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageMag()) {
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
            // vérifier si parade trop forte
            if (newPtvie < defenseur.getPtVie()) {
                System.out.printf("%s 👌 Perte de vie engendrée: %d\n", res, defenseur.getPtVie() - newPtvie);
                defenseur.setPtVie(newPtvie);
            }
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
        this.setPtMana(this.getPtMana() - 1);
    }

}
