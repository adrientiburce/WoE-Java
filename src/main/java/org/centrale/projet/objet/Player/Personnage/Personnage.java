package org.centrale.projet.objet.Player.Personnage;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Mana;
import org.centrale.projet.objet.Objects.Potion;
import org.centrale.projet.objet.Objects.Soin;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Monstre;
import org.centrale.projet.objet.World;

import java.util.Random;

public abstract class Personnage extends Creature {

    /**
     * point de mana, donc la réserve d'énergie magique
     */
    private int ptMana;

    /**
     * pourcentage magique, pour les attaques magiques
     */
    private int pourcentageMag;

    /**
     * pourcentage de résistance à la magie
     */
    private int pourcentageResistMag;

    /**
     * dégâts magiques
     */
    private int degMag;

    /**
     * distance d'attaque maximum
     */
    private int distAttMax;

    public Personnage() {
        // generate random point
        this.nom = "un personnage";
        this.setPos(new Point2D());
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
        this.setPos(perso.getPos());
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
        this.setPos(pos);
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
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
    }

    /**
     * affiche les attributs du personnage
     */
    public void affiche() {
        System.out.printf("Personnage{%s}\n", this.toString());
    }


    /**
     * se déplace sur une case avec une potion et la boit
     * @param p la potion
     */
    public void deplaceEtBoirePotion(Potion p) {
        if (p.getPos().distance(p.getPos()) > Math.sqrt(2)) {
            System.out.println("⛔ Potion trop éloigné");
        } else if (NewWorld.map.get(p.getPos()) instanceof Potion) {
            this.setPos(p.getPos());
            NewWorld.map.remove(this.pos);
            NewWorld.map.put(this.pos, this);
            boirePotion(p);
        }
    }

    /**
     * action de boire une potion pour récupérer des points de vie ou mana
     *
     * @param p potion
     */
    private void boirePotion(Potion p) {
        if (p instanceof Soin) {
            this.setPtVie(this.getPtVie() + ((Soin) p).getPtVieGagne());
            System.out.printf("👌 Potion consomée: + %s point Vie \n", ((Soin) p).getPtVieGagne());
        } else if (p instanceof Mana) {
            this.setPtMana(this.getPtMana() + ((Mana) p).getPtManaGagne());
            System.out.printf("👌 Potion consomée: + %s point Mana \n", ((Mana) p).getPtManaGagne());
        }
    }

    @Override
    public String toString() {
        return
                "pos=" + this.getPos() +
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
