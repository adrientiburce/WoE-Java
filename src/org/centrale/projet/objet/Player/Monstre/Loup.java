package org.centrale.projet.objet.Player.Monstre;


import org.centrale.projet.objet.Grille.Point2D;

public class Loup extends Monstre {

    public Loup() {
        super();
    }

    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
    }

    public Loup(Lapin l) {
        super(l.getPtVie(), l.getPourcentageAtt(), l.getPourcentagePar(), l.getDegAtt(), l.getPos());
    }

    public void affiche() {
        System.out.printf("Lapin{%s}\n", this.toString());
    }
}
