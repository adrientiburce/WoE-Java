package org.centrale.projet.objet.Tools;

/**
 * potion magique pour récupérer des points de vie
 */
public class Soin extends Potion {

    /**
     * nombre de point (de vie ou mana) que la potion permet de récuperer
     */
    private int ptVieGagne;

    public Soin(int ptVieGagne) {
        super();
        this.ptVieGagne = ptVieGagne;
    }

    public int getPtVieGagne() {
        return ptVieGagne;
    }
}
