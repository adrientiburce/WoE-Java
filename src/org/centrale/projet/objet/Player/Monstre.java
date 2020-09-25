package org.centrale.projet.objet.Player;


import org.centrale.projet.objet.Grille.Point2D;

public class Monstre {

    /**
     * point de viee
     */
    private int ptVie;

    /**
     * pourcentage d'attaque
     */
    private int pourcentageAtt;

    /**
     * pourcentage de parade, pour diminuer les dégâts subits
     */
    private int pourcentagePar;

    /**
     * dégâts d'attaque
     */
    private int degAtt;

    /**
     * position du monstre
     */
    private Point2D pos;

    public Monstre() {
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        // generate random point
        this.pos = new Point2D();
    }

    /**
     * Constructeur par attributs
     * @param ptVie point de vie
     * @param pourcentageAtt pourcentage d'attaque
     * @param pourcentagePar pourcentage de défense
     * @param degAtt degré d'attaque
     * @param pos position du personnage
     */
    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = pos;
    }

    /**
     * constructeur par copie
     * @param m montre à copier
     */
    public Monstre(Monstre m) {
        this.ptVie = m.ptVie;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.degAtt = m.degAtt;
        this.pos = m.pos;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void deplace() {
        this.pos.getNextPosition();
    }

    public void affiche() {
        System.out.printf("Monstre{%s}\n", this.toString());
    }

    @Override
    public String toString() {
        return
                "pos=" + pos +
                ", ptVie=" + ptVie +
                ", pourcentageAtt=" + pourcentageAtt +
                ", pourcentagePar=" + pourcentagePar +
                ", degAtt=" + degAtt;
    }
}
