package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Combattant;
import org.centrale.projet.objet.Player.Creature;

public class Guerrier extends Personnage implements Combattant {

    public Guerrier() {
        super();
        this.setNom("un guerrier");
    }

    public Guerrier(String nom, int ptVie, int ptMana, int ptPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos) {
        super(nom, ptVie, ptMana, ptPar, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
    }

    /**
     * constructeur par recopie
     *
     * @param g guerrier à copier
     */
    public Guerrier(Guerrier g) {
        super(g.getNom(), g.getPtVie(), g.getPtMana(), g.getPtPar(), g.getPourcentageAtt(), g.getPourcentagePar(), g.getPourcentageMag(), g.getPourcentageResistMag(), g.getDegAtt(), g.getDegMag(), g.getDistAttMax(), g.getPos());
    }

    public void affiche() {
        System.out.printf("Guerrier{%s}\n", this.toString());
    }


    /**
     * Guerrier ne peut attaquer qu'au corps à corps
     *
     * @param defenseur Creature attaquée
     */
    @Override
    public void combattre(Creature defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }
}
