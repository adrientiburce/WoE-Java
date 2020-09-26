package org.centrale.projet.objet.Tools;

import org.centrale.projet.objet.Grille.Point2D;

public class Objet {

    private String nom;

    /**
     * position de l'objet sur la grille
     */
    private Point2D pos;

    public Objet() {
        this.pos = new Point2D();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
