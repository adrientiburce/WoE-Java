package org.centrale.projet.objet.Player;

import org.centrale.projet.objet.Grille.Point2D;

public interface Deplacable {

    /**
     * déplacement aléatoire de 1 unité
     * @return si le déplacement a été effectué
     */
    public boolean deplace();

    /**
     *  déplacement vers une autre case
     * @param newPos nouvelle position
     * @return si le déplacement a été effectué
     */
    public boolean deplace(Point2D newPos);

}
