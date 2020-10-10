package org.centrale.projet.objet.Objects;

import org.centrale.projet.objet.Grille.Point2D;

/**
 * classe générique comprenant des objets modifiants les point de vie et magiques
 */
public class Potion extends Objet {

    /**
     * nom de la potion
     */
    private String nom;


    public Potion(String nom) {
        super(nom, new Point2D());
    }

    public Potion() {
        super();
    }
}
