package org.centrale.projet.objet.Player;

import org.centrale.projet.objet.Grille.Point2D;

public interface Deplacable {

    /**
     * action de déplacement vers la nouvelle position
     * met a jour la map
     *
     * @param newPos nouvelle position
     */
    public boolean move(Point2D newPos);

}
