package org.centrale.projet.objet.Objects;

import org.centrale.projet.objet.ElementDeJeu;
import org.centrale.projet.objet.Grille.Point2D;

public class Objet extends ElementDeJeu {

    private String nom;

    public Objet(String nom, Point2D pos) {
        this.nom = nom;
        this.pos = pos;
    }

    public Objet() {
        this.pos = new Point2D();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Potion{" +
                "nom='" + nom + '\'' +
                ", pos=" + pos +
                "}";
    }
}
