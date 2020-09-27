package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Tools.Potion;
import org.centrale.projet.objet.Tools.Soin;

public class TestSeance1 {

    public static void main(String[] args) {

        World monMonde = new World();
        System.out.println(World.mapPositions);
//        monMonde.creerMondeAlea();

        System.out.println(" ----- CREATION DU MONDE ------ ");

        monMonde.robin.affiche(); // archer
//        monMonde.guillaumeT.affiche(); // archer

        monMonde.mage.deplace();

        System.out.println(World.mapPositions);
//        System.out.println("--- deplace robin --- ");
//        monMonde.robin.deplace(new Point2D(20, 23));


//        monMonde.robin.deplaceEtConsome(new Point2D(20, 24), monMonde.potionVie);
//        monMonde.robin.affiche();
//        monMonde.robin.deplace();
//        monMonde.robin.affiche();

//        monMonde.robin.affiche(); // archer
//        monMonde.guillaumeT.affiche(); // archer


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
