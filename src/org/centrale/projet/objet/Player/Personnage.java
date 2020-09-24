package org.centrale.projet.objet.Player;


import org.centrale.projet.objet.Grille.Point2D;

public class Personnage {

    private String nom;

    /**
     * point de vie
     */
    private int ptVie;

    /**
     *  point de mana, donc la réserve d'énergie magique
     */
    private int ptMana;

    /**
     * diminution des dégâts subits en cas de parade réussie
     */
    private int ptPar;

    /**
     * pourcentage d'attque, pour donner des dégats
     */
    private int pourcentageAtt;

    /**
     * pourcentage de parade, pour diminuer les dégâts subits
     */
    private int pourcentagePar;

    /**
     * pourcentage magique, pour les attaques magiques
     */
    private int pourcentageMag;

    /**
     * pourcentage de résistance à la magie
     */
    private int pourcentageResistMag;

    /**
     * dégâts d'attaque
     */
    private int degAtt;

    /**
     *  dégâts magiques
     */
    private int degMag;

    /**
     * distance d'attaque maximum
     */
    private int distAttMax;

    private Point2D pos;

    public Personnage() {
        // generate random point
        this.nom = "un personnage";
        this.pos = new Point2D();
    }

    public Personnage(Personnage perso) {
        this.nom = perso.nom;
        this.ptVie = perso.ptVie;
        this.ptMana = perso.ptMana;
        this.pourcentageAtt = perso.pourcentageAtt;
        this.pourcentagePar = perso.pourcentagePar;
        this.pourcentageMag = perso.pourcentageMag;
        this.pourcentageResistMag = perso.pourcentageResistMag;
        this.degAtt = perso.degAtt;
        this.degMag = perso.degMag;
        this.distAttMax = perso.distAttMax;
        this.pos = perso.pos;
    }

    public Personnage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.ptMana = ptMana;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degAtt = degAtt;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        this.pos = pos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * affiche les attributs du personnage
     */
    public void affiche() {
        System.out.printf("Personnage{%s}\n", this.toString());
    }

    /**
     * deplace un personnage avec un deplacement d'une unité maximum
     * selon X et Y
     */
    public void deplace() {
        Point2D newPos = new Point2D(this.pos);
        newPos.getNextPosition();
        this.pos = newPos;
    }

    @Override
    public String toString() {
        return
                "pos=" + pos +
                ", nom='" + nom + '\'' +
                ", ptVie=" + ptVie +
                ", ptMana=" + ptMana +
                ", pourcentageAtt=" + pourcentageAtt +
                ", pourcentagePar=" + pourcentagePar +
                ", pourcentageMag=" + pourcentageMag +
                ", pourcentageResistMag=" + pourcentageResistMag +
                ", degAtt=" + degAtt +
                ", degMag=" + degMag +
                ", distAttMax=" + distAttMax;
    }
}
