package org.centrale.projet.objet.Player.Personnage;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Nourriture.CigueToxique;
import org.centrale.projet.objet.Objects.Nourriture.Nourriture;
import org.centrale.projet.objet.Objects.Nourriture.Vitamine;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Potion;
import org.centrale.projet.objet.Objects.Potion.Soin;
import org.centrale.projet.objet.Player.Creature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    /**
     * nourriture dans la besace du personnage
     * permet d'appliquer des bonus/malus temporaires
     */
    private List<Nourriture> nourritures;

    public Personnage() {
        this.nom = "un personnage";
        this.setPos(new Point2D());
        this.nourritures = new ArrayList<>();
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
        this.nourritures = new ArrayList<>();
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
        this.nourritures = new ArrayList<>();
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

    public List<Nourriture> getNourritures() {
        return nourritures;
    }

    public void setNourritures(List<Nourriture> nourritures) {
        this.nourritures = nourritures;
    }

    protected int getPointsMalus() {
        Iterator<Nourriture> iter = this.getNourritures().iterator();
        List<Nourriture> nourritureEmpty = new ArrayList<>();
        int resMalus = 0;
        while (iter.hasNext()) {
            Nourriture n = iter.next();
            if (n instanceof CigueToxique) {
                resMalus += ((CigueToxique) n).getDegAttMalus();
                n.setDureeEffet(n.getDureeEffet() - 1);
                nourritureEmpty.add(n);
            }
        }
        nourritures.removeAll(nourritureEmpty);
        return resMalus;
    }

    protected int getPointsBonus() {
        Iterator<Nourriture> iter = this.getNourritures().iterator();
        List<Nourriture> nourritureEmpty = new ArrayList<>();
        int resBonus = 0;
        while (iter.hasNext()) {
            Nourriture n = iter.next();
            if (n instanceof Vitamine) {
                resBonus += ((Vitamine) n).getDegAttBonus();
                n.setDureeEffet(n.getDureeEffet() - 1);
            }
        }
        nourritures.removeAll(nourritureEmpty);
        return resBonus;
    }

    /**
     * ajoute la nourriture dans la besace d'un personnage et met a jour la map
     *
     * @param n Nourriture à ramasser
     */
    public void ramasseNourriture(Nourriture n) {
        if (this.getPos().distance(n.getPos()) > Math.sqrt(2)) {
            System.out.println("⛔ nourriture trop éloigné");
        } else if (NewWorld.map.get(n.getPos()) instanceof Nourriture) {
            NewWorld.map.remove(this.pos);
            this.setPos(n.getPos());
            NewWorld.map.put(this.pos, this);
            this.nourritures.add(n);
            System.out.println("👌 Nourriture ajoutée");
        }
    }

    /**
     * se déplace sur une case avec une potion et la boit et met a jour la map
     *
     * @param p la potion
     */
    public void deplaceEtBoirePotion(Potion p) {
        if (pos.distance(p.getPos()) > Math.sqrt(2)) {
            System.out.println("⛔ Potion trop éloigné");
        } else if (NewWorld.map.get(p.getPos()) instanceof Potion) {
            NewWorld.map.remove(this.pos);
            this.setPos(p.getPos());
            NewWorld.map.put(this.pos, this);
            boirePotion(p);
        }
    }

    /**
     * action de boire une potion pour récupérer des points de vie ou mana
     *
     * @param p potion
     */
    protected void boirePotion(Potion p) {
        if (p instanceof Soin) {
            this.setPtVie(this.getPtVie() + ((Soin) p).getPtVieGagne());
            System.out.printf("👌 Potion consomée: + %s point Vie \n", ((Soin) p).getPtVieGagne());
        } else if (p instanceof Mana) {
            this.setPtMana(this.getPtMana() + ((Mana) p).getPtManaGagne());
            System.out.printf("👌 Potion consomée: + %s point Mana \n", ((Mana) p).getPtManaGagne());
        }
    }

    /**
     * affiche les attributs du personnage
     */
    public void affiche() {
        System.out.printf("Personnage{%s}\n", this.toString());
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
                        ", distAttMax=" + distAttMax +
                        ", nourritures=" + nourritures;
    }

    public String toSave() {
        return nom + " " + ptVie + " " + ptMana + " " + ptPar + " " + pourcentageAtt + " " + pourcentagePar + " " +
                pourcentageMag + " " + pourcentageResistMag + " " + degAtt + " " + degMag + " " + distAttMax + " " + pos;
    }
}
