package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;

public class TestSeance1 {

    public static void main(String[] args) {

        World monMonde = new World();
//        monMonde.creerMondeAlea();


        System.out.println(" ----- CREATION DU MONDE ------ ");

        monMonde.robin.affiche(); // archer
        monMonde.guillaumeT.affiche(); // archer

        System.out.println("--- deplace robin --- ");
        monMonde.robin.deplace();
        monMonde.robin.affiche(); // archer
        monMonde.guillaumeT.affiche(); // archer



//        monMonde.robin.deplace();
//        monMonde.peon.deplace();
//        monMonde.bugs.deplace();
//
//        System.out.println(" ----- APRES DEPLACEMENT ------ ");
//        monMonde.robin.affiche(); // archer
//        monMonde.peon.affiche(); // paysan
//        monMonde.bugs.affiche(); // monstre
    }
}
