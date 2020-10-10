package org.centrale.projet.objet.Objects;

/**
 * potion pour récupérer des points magiques
 */
public class Mana extends Potion {

    /**
     * nombre de point de mana que la potion permet de récupérer
     */
    private final int ptManaGagne;

    public Mana(int ptVieMana) {
        super();
        this.ptManaGagne = ptVieMana;
    }

    public int getPtManaGagne() {
        return ptManaGagne;
    }
}
