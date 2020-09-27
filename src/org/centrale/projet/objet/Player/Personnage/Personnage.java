package org.centrale.projet.objet.Player.Personnage;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Tools.Mana;
import org.centrale.projet.objet.Tools.Soin;

import java.util.Map;
import java.util.Random;

public class Personnage extends Creature {

    private String nom;

    /**
     * point de vie
     */
    private int ptVie;

    /**
     * point de mana, donc la réserve d'énergie magique
     */
    private int ptMana;

    /**
     * diminution des dégâts subits en cas de parade réussie
     */
    private int ptPar;

    /**
     * pourcentage d'attaque, pour donner des dégats
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
     * dégâts magiques
     */
    private int degMag;

    /**
     * distance d'attaque maximum
     */
    private int distAttMax;

    /**
     * position du personnage
     */
    private Point2D pos;

    public Personnage() {
        // generate random point
        this.nom = "un personnage";
        this.pos = new Point2D();

    }

    /**
     * constructeur par copie
     *
     * @param perso personnage à copier
     */
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

    public Personnage(String nom, int ptVie, int ptMana, int ptPar, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.ptMana = ptMana;
        this.ptPar = ptPar;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degAtt = degAtt;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        this.pos = pos;
    }

    public void combatCorpsACorps(Personnage defenseur) {
        Random randomGenerator = new Random();
        System.out.printf("⚔️ Combat au corps à corps:  %s attaque %s ⚔️ \n", this.getNom(), defenseur.getNom());
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageAtt()) {
            int newPtvie;
            String res = "";
            // parade réussie
            if (randomGenerator.nextInt(101) <= defenseur.getPourcentagePar()) {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegAtt() + defenseur.getPtPar(), 0);
                res = "🛡️ Parade,";
            } // aucune parade
            else {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegAtt(), 0);
            }
            System.out.printf("%s 👌 Perte de vie engendré: %d\n", res, defenseur.getPtVie() - newPtvie);
            defenseur.setPtVie(newPtvie);
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
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
        this.pourcentageMag = Integer.min(pourcentagePar, 100);
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = Integer.min(pourcentageMag, 100);
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = Integer.min(pourcentageResistMag, 100);
        ;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = Integer.min(ptPar, 100);
        ;
        ;
    }


    public void boireMana(Mana m) {
        this.ptMana += m.getPtManaGagne();
    }

    public void boireSoin(Soin s) {
        this.ptVie += s.getPtVieGagne();
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

    public void deplace(Map<Integer, Point2D> mapPositions) {
        this.deplace();
        // mis a jour de la positon dans mapPositions
        mapPositions.put(this.hashCode(), this.getPos());
    }

    @Override
    public String toString() {
        return
                "pos=" + pos +
                        ", nom='" + nom + '\'' +
                        ", ptVie=" + ptVie +
                        ", ptMana=" + ptMana +
                        ", ptPar=" + ptPar +
                        ", pourcentageAtt=" + pourcentageAtt +
                        ", pourcentagePar=" + pourcentagePar +
                        ", pourcentageMag=" + pourcentageMag +
                        ", pourcentageResistMag=" + pourcentageResistMag +
                        ", degAtt=" + degAtt +
                        ", degMag=" + degMag +
                        ", distAttMax=" + distAttMax;
    }
}
