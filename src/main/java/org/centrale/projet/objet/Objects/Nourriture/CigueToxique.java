package org.centrale.projet.objet.Objects.Nourriture;

import java.util.Random;

/**
 * Malus sur les les dégâts d'attaque: degAtt
 */
public class CigueToxique extends Nourriture {

    private final int degAttMalus;

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

    @Override
    public String saveObject() {
        return String.format("CigueToxique %s\n", this.getNom() + " " + this.getDureeEffet() + " " + degAttMalus + " " + this.pos);
    }

    @Override
    public void afficheMap() {
        System.out.print("🤢Toxi");
    }

    @Override
    public String toString() {
        return "CigueToxique{" +
                "dureeEffet=" + this.getDureeEffet() +
                "; degAttMalus=" + degAttMalus +
                "}";
    }
}
