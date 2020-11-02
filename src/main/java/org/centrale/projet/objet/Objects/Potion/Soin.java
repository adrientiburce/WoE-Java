package org.centrale.projet.objet.Objects.Potion;

import java.util.Random;

/**
 * potion de soin pour récupérer des points de vie
 */
public class Soin extends Potion {

    /**
     * nombre de point de vie que la potion permet de récupérer
     */
    private final int ptVieGagne;

    public Soin(String nom, Random random) {
        super(nom);
        this.ptVieGagne = random.nextInt(10) + 3;
    }

    public Soin(String nom, int ptVieGagne) {
        super(nom);
        this.ptVieGagne = ptVieGagne;
    }

    public int getPtVieGagne() {
        return ptVieGagne;
    }

    public String saveObject() {
       return String.format("Soin %s\n", this.getPos() + " " + ptVieGagne);
    }

    public void afficheMap() {
        System.out.print("🍵 Vie");
    }
}
