package org.centrale.projet.objet.Player;


import org.centrale.projet.objet.Grille.Point2D;

public class Lapin extends Monstre {

    public Lapin() {
        super();
    }

    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
    }

    public Lapin(Lapin l) {
        super(l.getPtVie(), l.getPourcentageAtt(), l.getPourcentagePar(), l.getDegAtt(), l.getPos());
    }

    public void affiche() {
        System.out.printf("Lapin{%s}\n", this.toString());
    }
}
