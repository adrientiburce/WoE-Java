package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;

public class TestSeance2 {

    public static void main(String[] args) {

        World monMonde = new World();
//        monMonde.creerMondeAlea();
        System.out.println(" ----- CREATION DU MONDE ------ ");
        monMonde.robin.affiche();
        monMonde.guillaumeT.affiche();
        monMonde.hulk.affiche();
        monMonde.mage.affiche();
        System.out.println("\n");

        // corps a corps de hulk
        monMonde.robin.affiche();
        monMonde.hulk.combattre(monMonde.robin);
        monMonde.robin.affiche();
        System.out.println("\n");

        // combat distance de robin
        monMonde.robin.combattre(monMonde.guillaumeT);
        monMonde.robin.affiche();
        monMonde.guillaumeT.affiche();
        System.out.println("\n");

        // combat magique
        monMonde.mage.combatre(monMonde.hulk);
        monMonde.mage.affiche();
        monMonde.hulk.affiche();

        System.out.println("\n ----- Potion ------ ");
        monMonde.robin.affiche();
        monMonde.robin.deplaceEtConsome(new Point2D(20, 24), monMonde.potionVie);
        monMonde.robin.affiche();

    }
}
