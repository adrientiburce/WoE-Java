package org.centrale.projet.objet.Objects.Potion;

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

    public Mana(String nom, int ptManaGagne) {
        super(nom);
        this.ptManaGagne = ptManaGagne;
    }

    public int getPtManaGagne() {
        return ptManaGagne;
    }

    public String saveObject() {
        return String.format("Mana %s\n", this.getPos() + " " + ptManaGagne);
    }
    public void afficheMap() {
        System.out.print("🍷Mana");
    }
}
