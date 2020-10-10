package org.centrale.projet.objet.Objects;

import java.util.Random;

/**
 * potion pour récupérer des points magiques
 */
public class Mana extends Potion {

    /**
     * nombre de point de mana que la potion permet de récupérer
     */
    private final int ptManaGagne;

    public Mana(String nom, Random random) {
        super(nom);
        this.ptManaGagne = random.nextInt(10) + 3;
    }

    public int getPtManaGagne() {
        return ptManaGagne;
    }
}
