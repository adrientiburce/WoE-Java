package org.centrale.projet.objet;


public class Personnage {

    private String nom;
    private int ptVie;
    private int ptMana;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int pourcentageMag;
    private int pourcentageResistMag;
    private int degAtt;
    private int degMag;
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

    public void affiche() {
        System.out.println(this);
    }

    public void deplace() {
        this.pos = new Point2D();
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", ptVie=" + ptVie +
                ", ptMana=" + ptMana +
                ", pourcentageAtt=" + pourcentageAtt +
                ", pourcentagePar=" + pourcentagePar +
                ", pourcentageMag=" + pourcentageMag +
                ", pourcentageResistMag=" + pourcentageResistMag +
                ", degAtt=" + degAtt +
                ", degMag=" + degMag +
                ", distAttMax=" + distAttMax +
                ", pos=" + pos +
                '}';
    }
}
