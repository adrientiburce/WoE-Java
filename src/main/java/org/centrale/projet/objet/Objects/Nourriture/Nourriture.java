package org.centrale.projet.objet.Objects.Nourriture;

import org.centrale.projet.objet.Objects.Objet;

/**
 * Objet temporaires permettant au perso de gagner des bonus/malus
 * pendant un nombre de tour défini
 */
public class Nourriture extends Objet {

    /**
     * nombre de tours ou le bonus/malus prend effet
     */
    private int dureeEffet;

    public int getDureeEffet() {
        return dureeEffet;
    }

    public Nourriture(String nom, int dureeEffet) {
        super(nom);
        this.dureeEffet = dureeEffet;
    }

    public void setDureeEffet(int dureeEffet) {
        this.dureeEffet = dureeEffet;
    }


    @Override
    public String toString() {
        return "Nourriture{" +
                "dureeEffet=" + dureeEffet +
                ", pos=" + pos +
                "}";
    }
}
