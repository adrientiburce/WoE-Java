package org.centrale.projet.objet.Objects.Nourriture;

import java.util.Random;

/**
 * Ajoute des bonus pour les dégâts d'attaque: degAtt
 */
public class Vitamine extends Nourriture {

    private int degAttBonus;

    public Vitamine(String nom, Random random) {
        super(nom, random.nextInt(2) + 1);
        this.degAttBonus = random.nextInt(5) + 2;
    }

    public Vitamine(String nom, int dureeEffet, int degAttBonus) {
        super(nom, dureeEffet);
        this.degAttBonus = degAttBonus;
    }

    public int getDegAttBonus() {
        return degAttBonus;
    }

    public void setDegAttBonus(int degAttBonus) {
        this.degAttBonus = degAttBonus;
    }

    public String saveObject() {
        return String.format("Vitamine %s\n", this.getPos() + " " + degAttBonus);
    }

    public void afficheMap() {
        System.out.print( "🥝Vita");
    }
}
