package org.centrale.projet.objet.Player;


import org.centrale.projet.objet.Grille.Point2D;

public class Lapin extends Monstre {

    public Lapin() {
    }

    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
    }

    public Lapin(Lapin l) {
        super(l.getPtVie(), l.getPourcentageAtt(), l.getPourcentagePar(), l.getDegAtt(), l.getPos());
    }

    @Override
    public String toString() {
        return "Lapin{} " + super.toString();
    }

    public void affiche() {
        System.out.println(this);
    }
}
