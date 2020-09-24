package org.centrale.projet.objet;

public class TestSeance1 {

    public static void main(String[] args) {

        World monMonde = new World();
//        monMonde.creerMondeAlea();


        System.out.println(" ----- CREATION DU MONDE ------ ");

        monMonde.robin.affiche(); // archer
        monMonde.peon.affiche(); // paysan
        monMonde.bugs.affiche(); // monstre

        monMonde.robin.deplace();
        monMonde.peon.deplace();
        monMonde.bugs.deplace();

        System.out.println(" ----- APRES DEPLACEMENT ------ ");
        monMonde.robin.affiche(); // archer
        monMonde.peon.affiche(); // paysan
        monMonde.bugs.affiche(); // monstre
    }
}
