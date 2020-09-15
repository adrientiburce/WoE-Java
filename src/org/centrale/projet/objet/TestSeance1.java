package org.centrale.projet.objet;

public class TestSeance1 {

    public static void main(String[] args) {

        World monMonde = new World();
        monMonde.creerMondeAlea();

        monMonde.robin.affiche(); // archer
        monMonde.peon.affiche(); // paysan
        monMonde.bugs.affiche(); // monstre

        // augmenter l'attaque
        monMonde.robin.setDegAtt(30);
        monMonde.robin.affiche();

    }
}
