package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;

public class Guerrier extends Personnage {

    /**
     * force du guerrier
     */
    private int force;

    public Guerrier() {
        super();
        this.setNom("un guerrier");
        this.force = 0;
    }

    public Guerrier(String nom, int ptVie, int ptMana, int ptPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos, int force) {
        super(nom, ptVie, ptMana, ptPar, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
        this.force = force;
    }

    /**
     * constructeur par recopie
     *
     * @param g guerrier à copier
     */
    public Guerrier(Guerrier g) {
        super(g.getNom(), g.getPtVie(), g.getPtMana(), g.getPtPar(), g.getPourcentageAtt(), g.getPourcentagePar(), g.getPourcentageMag(), g.getPourcentageResistMag(), g.getDegAtt(), g.getDegMag(), g.getDistAttMax(), g.getPos());
        this.force = g.getForce();
    }

    public void affiche() {
        System.out.printf("Guerrier{%s, nbFleches=%s}\n", this.toString(), force);
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void combatre(Personnage defenseur) {
        double distCombatants = this.getPos().distance(defenseur.getPos());
        if (distCombatants <= 1) {
            super.combatCorpsACorps(defenseur);
        } else {
            System.out.println("⛔ Trop loin pour attaquer");
        }
    }
}
