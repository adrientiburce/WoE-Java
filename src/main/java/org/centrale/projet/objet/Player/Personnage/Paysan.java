package org.centrale.projet.objet.Player.Personnage;

import org.centrale.projet.objet.Grille.Point2D;

public class Paysan extends Personnage {

    public Paysan() {
        super();
        this.setNom("un paysan");
    }

    public Paysan(Personnage perso) {
        super(perso);
    }

    public Paysan(String nom, int ptVie, int ptMana, int prPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos) {
        super(nom, ptVie, ptMana, prPar, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
    }

    public void affiche() {
        System.out.printf("Paysan{%s}\n", this.toString());
    }
}
