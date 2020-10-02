package org.centrale.projet.objet.Objects;

import org.centrale.projet.objet.Grille.Point2D;

/**
 * classe générique comprenant des objets modifiants les point de vie et magiques
 */
public class Potion extends Objet {

    /**
     * couleur de la potion
     */
    private String color;


    public Potion(String nom, String color, Point2D pos) {
        super(nom, pos);
        this.color = color;
    }

    public Potion() {
        super();
    }
}
