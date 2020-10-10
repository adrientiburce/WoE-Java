package org.centrale.projet.objet.Objects;

/**
 * potion de soin pour récupérer des points de vie
 */
public class Soin extends Potion {

    /**
     * nombre de point de vie que la potion permet de récupérer
     */
    private final int ptVieGagne;

    public Soin(int ptVieGagne) {
        super();
        this.ptVieGagne = ptVieGagne;
    }

    public Soin(String nom, int ptVieGagne) {
        super(nom);
        this.ptVieGagne = ptVieGagne;
    }

    public int getPtVieGagne() {
        return ptVieGagne;
    }
}
