package org.centrale.projet.objet.Tools;

import org.centrale.projet.objet.Grille.Point2D;

/**
 * potion magique pour récupérer des points de vie
 */
public class Soin extends Potion {

    /**
     * nombre de point de vie que la potion permet de récuperer
     */
    private int ptVieGagne;

    public Soin(int ptVieGagne) {
        super();
        this.ptVieGagne = ptVieGagne;
    }

    public Soin(String nom, String color, Point2D pos, int ptVieGagne) {
        super(nom, color, pos);
        this.ptVieGagne = ptVieGagne;
    }

    public int getPtVieGagne() {
        return ptVieGagne;
    }
}
