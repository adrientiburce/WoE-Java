package org.centrale.projet.objet.Objects.Nourriture;

import java.util.Random;

/**
 * Malus sur les les dégâts d'attaque: degAtt
 */
public class CigueToxique extends Nourriture {

    private int degAttMalus;

    public CigueToxique(String nom, Random random) {
        super(nom, random.nextInt(2) + 1);
        this.degAttMalus = random.nextInt(5) + 2;
    }

    public CigueToxique(String nom, int dureeEffet, int degAttMalus) {
        super(nom, dureeEffet);
        this.degAttMalus = degAttMalus;
    }

    public int getDegAttMalus() {
        return degAttMalus;
    }

    public void setDegAttMalus(int degAttMalus) {
        this.degAttMalus = degAttMalus;
    }

    public String saveObject() {
        return String.format("CigueToxique %s\n", this.getPos() + " " + degAttMalus);
    }
}
