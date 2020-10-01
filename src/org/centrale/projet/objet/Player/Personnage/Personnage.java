package org.centrale.projet.objet.Player.Personnage;


import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Tools.Mana;
import org.centrale.projet.objet.Tools.Potion;
import org.centrale.projet.objet.Tools.Soin;
import org.centrale.projet.objet.World;

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
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = Integer.min(ptPar, 100);
    }

    /**
     * affiche les attributs du personnage
     */
    public void affiche() {
        System.out.printf("Personnage{%s}\n", this.toString());
    }


    /**
     * action de déplacement aléatoire (de 1 unité maximum selon X et Y)
     */
    public boolean deplace() {
        Point2D newPos = new Point2D();
        newPos.getNextPosition();
        if (this.verifDeplacementMin3(this, newPos)) {
            this.setPos(newPos);
            return true;
        }
        return false;
    }

    /**
     * action de déplacement avec la nouvelle position
     *
     * @param newPos
     */
    public void deplace(Point2D newPos) {
        if (this.getPos().distance(newPos) > Math.sqrt(2)) {
            System.out.println("⛔ déplacement non autorisé");
        } else if (this.verifDeplacementMin3(this, newPos)) {
            this.setPos(newPos);
        }
    }

    /**
     * vérifie si la nouvelle position sera éloigné de 3 des autres perso
     * @param c
     * @param newPos nouvelle position
     * @return si le déplacement a été effectué
     */
    private boolean verifDeplacementMin3(Creature c, Point2D newPos) {
        int x = newPos.getX();
        int y = newPos.getY();
        int xC = ((Personnage) c).getPos().getX();
        int yC = ((Personnage) c).getPos().getY();

        //tous les points compris dans une grille de taille 5*5 autour de newPos
        // sont a une distance inférieur a 3
        for (int xToCheck = x - 2; xToCheck < x + 3; xToCheck++) {
            for (int yToCheck = y - 2; yToCheck < y + 3; yToCheck++) {
                // l'ancienne position
                if (xToCheck == xC && yToCheck == yC) {
                    continue;
                } else {
                    if (World.mapPositions.containsKey(new Point2D(xToCheck, yToCheck))) {
                        return false;
                    }
                }
            }
        }
        World.mapPositions.remove(this.getPos());
        World.mapPositions.put(newPos, c.hashCode());
        return true;
    }

    /**
     * verifie que la nouvelle positon est valable
     * @param c Creature a déplacer
     * @param newPos nouvelle position
     * @return si le déplacement a été effectué
     */
    private boolean verifDeplacement(Creature c, Point2D newPos) {
        if (!World.mapPositions.containsKey(newPos)) {
            World.mapPositions.remove(this.getPos());
            World.mapPositions.put(newPos, c.hashCode());
            return true;
        } else {
            return false;
        }
    }

    /**
     * deplace un personnage sur un case de potion
     * @param newPos nouvelle positon
     * @param p Potion a consomé
     */
    public void deplaceEtConsome(Point2D newPos, Potion p) {
        if (this.getPos().distance(newPos) > Math.sqrt(2)) {
            System.out.println("⛔ déplacement non autorisé");
        } else if (newPos.equals(p.getPos())) {
            System.out.println("👌 potion consomée");
            World.mapPositions.remove(this.getPos());
            World.mapPositions.put(newPos, this.hashCode());
            this.boire(p);
            this.setPos(newPos);
            p = null;
        }
    }

    /**
     * action de boire une potion pour récupérer des points de vie ou mana
     *
     * @param p potion
     */
    private void boire(Potion p) {
        if (p.getClass() == Soin.class) {
            this.setPtVie(this.getPtVie() + ((Soin) p).getPtVieGagne());
        } else if (p.getClass() == Mana.class) {
            this.setPtMana(this.getPtMana() + ((Mana) p).getPtManaGagne());
        }
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
