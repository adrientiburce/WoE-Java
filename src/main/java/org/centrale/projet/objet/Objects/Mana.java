package org.centrale.projet.objet.Objects;

/**
 * potion magique pour récupérer des points de vie
 */
public class Mana extends Potion {

    /**
     * nombre de point de mana que la potion permet de récuperer
     */
    private int ptManaGagne;

    public Mana(int ptVieMana) {
        super();
        this.ptManaGagne = ptVieMana;
    }


    public int getPtManaGagne() {
        return ptManaGagne;
    }
}
