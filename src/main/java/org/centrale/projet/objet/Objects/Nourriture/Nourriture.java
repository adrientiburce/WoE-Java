package org.centrale.projet.objet.Objects.Nourriture;

import org.centrale.projet.objet.Objects.Objet;

public class Nourriture extends Objet {

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

    /**
     * nombre de tours ou le bonus/malus prend effet
     */
    private int dureeEffet;


    @Override
    public String toString() {
        return "Nourriture{" +
                "dureeEffet=" + dureeEffet +
                ", pos=" + pos +
                "}";
    }
}
