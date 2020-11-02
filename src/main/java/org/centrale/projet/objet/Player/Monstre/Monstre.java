package org.centrale.projet.objet.Player.Monstre;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;

public abstract class Monstre extends Creature {

    public Monstre() {
        this.nom = "un Monstre";
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.pos = new Point2D();
    }

    /**
     * Constructeur par attributs
     *
     * @param nom            nom
     * @param ptVie          point de vie
     * @param pourcentageAtt pourcentage d'attaque
     * @param pourcentagePar pourcentage de défense
     * @param degAtt         degré d'attaque
     * @param pos            position du personnage
     */
    public Monstre(String nom, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = pos;
    }

    /**
     * constructeur par copie
     *
     * @param m montre à copier
     */
    public Monstre(Monstre m) {
        this.ptVie = m.ptVie;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.degAtt = m.degAtt;
        this.pos = m.pos;
    }

    public void affiche() {
        System.out.printf("Monstre{%s}\n", this.toString());
    }

    @Override
    public String toString() {
        return
                "pos=" + pos +
                        ", nom=" + nom +
                        ", ptVie=" + ptVie +
                        ", pourcentageAtt=" + pourcentageAtt +
                        ", pourcentagePar=" + pourcentagePar +
                        ", degAtt=" + degAtt;
    }

    public String toSave() {
        return nom + " " + ptVie + " " + pourcentageAtt + " " + pourcentagePar + " " + degAtt + " " + pos;
    }
}
