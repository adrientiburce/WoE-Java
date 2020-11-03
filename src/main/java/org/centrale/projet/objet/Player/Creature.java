package org.centrale.projet.objet.Player;

import org.centrale.projet.objet.ElementDeJeu;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.World;

import java.util.Random;

public abstract class Creature extends ElementDeJeu implements Deplacable {

    protected String nom;

    /**
     * point de vie
     */
    protected int ptVie;

    /**
     * diminution des dégâts subits en cas de parade réussie
     */
    protected int ptPar;

    /**
     * pourcentage d'attaque
     */
    protected int pourcentageAtt;

    /**
     * pourcentage de parade, pour diminuer les dégâts subits
     */
    protected int pourcentagePar;

    /**
     * dégâts d'attaque
     */
    protected int degAtt;
    private String nameDefenseur;

    /**
     * méthode de combat au corps à corps
     * utilisé par tous les combattants
     *
     * @param defenseur Créature attaquée
     */
    protected void combatCorpsACorps(Creature defenseur, int bonus, int malus) {
        Random randomGenerator = new Random();
        String nameDefenseur = "";
        System.out.printf("⚔️ Combat au corps à corps:  %s attaque %s ⚔️ \n", this.getNom(), defenseur.getNom());
        // attaque réussie
        if (randomGenerator.nextInt(101) <= this.getPourcentageAtt()) {
            int newPtvie = defenseur.getPtVie() - this.getDegAtt() - bonus + malus;
            String res = "";
            // parade réussie
            if (randomGenerator.nextInt(101) <= defenseur.getPourcentagePar()) {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegAtt() + defenseur.getPtPar(), 0);
                res = "🛡️ Parade,";
            } // aucune parade
            else {
                newPtvie = Integer.max(defenseur.getPtVie() - this.getDegAtt(), 0);
            }
            System.out.printf("%s 👌 Perte de vie engendrée: %d\n", res, defenseur.getPtVie() - newPtvie);
            defenseur.setPtVie(newPtvie);
        } else {
            System.out.println("⛔ échec de l'attaque");
        }
    }

    /**
     * action de déplacement aléatoire (de 1 unité maximum selon X et Y)
     */
    public boolean deplace() {
        Point2D newPos = new Point2D(this.pos);
        newPos.getNextPosition();
        if (this.verifDeplacement(this, newPos)) {
            this.setPos(newPos);
            return true;
        }
        return false;
    }

    /**
     * action de déplacement vers la nouvelle position
     * met a jour la map
     *
     * @param newPos nouvelle position
     */
    public boolean move(Point2D newPos) {
        if (this.getPos().distance(newPos) > Math.sqrt(2)) {
            System.out.println("⛔ déplacement non autorisé");
        } else if (NewWorld.map.get(newPos) == null) {
            return deplaceDansGrille(this.pos, newPos);
        } else {
            System.out.println("⛔ case occupée");
        }
        return false;
    }

    public boolean deplaceDansGrille(Point2D oldPos, Point2D newPos) {
        if (newPos.isPositionValable()) {
            NewWorld.map.remove(oldPos);
            this.setPos(newPos);
            NewWorld.map.put(newPos, this);
            return true;
        } else {
            System.out.println("⛔ déplacement hors grille");
        }
        return false;
    }

    /**
     * action de déplacement avec la nouvelle position
     *
     * @param newPos nouvelle position
     */
    public boolean deplace(Point2D newPos) {
        if (this.getPos().distance(newPos) > Math.sqrt(2)) {
            System.out.println("⛔ déplacement non autorisé");
        } else if (this.verifDeplacement(this, newPos)) {
            this.setPos(newPos);
            return true;
        }
        return false;
    }

    private boolean verifDeplacement(Creature c, Point2D newPos) {
        if (!World.mapPositions.containsKey(newPos)) {
            World.mapPositions.remove(this.getPos());
            World.mapPositions.put(newPos, c.hashCode());
            return true;
        } else {
            return false;
        }
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = Integer.min(ptPar, 100);
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

    public void setPtVie(int ptVie) {
        this.ptVie = Integer.max(0, ptVie);
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void combattre(Creature defenseur) {

    }
}
