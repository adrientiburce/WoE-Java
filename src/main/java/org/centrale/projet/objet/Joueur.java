package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.util.Random;
import java.util.Scanner;

/**
 * classe responsable de la sélection d'un personnage par le joueur
 */
public class Joueur {

    public Personnage getPerso() {
        return perso;
    }

    /**
     * personnage choisit par le joueur
     */
    public Personnage perso;

    public Joueur() {
    }

    private void deplaceAvecChoix(String deplaceChoice) {
        deplaceChoice = deplaceChoice.toUpperCase();
        Point2D oldPos = this.perso.getPos();
        switch (deplaceChoice) {
            // avance
            case "Z": {
                Point2D newPos = new Point2D(oldPos.getX(), oldPos.getY() + 1);
                this.perso.deplace(newPos);
                break;
            }
            // recule
            case "S": {
                this.perso.deplace(new Point2D(oldPos.getX(), oldPos.getY() - 1));
                break;
            }
            // vers la droite
            case "D": {
                this.perso.deplace(new Point2D(oldPos.getX() + 1, oldPos.getY()));
                break;
            }
            // vers la gauche
            case "Q": {
                this.perso.deplace(new Point2D(oldPos.getX() - 1, oldPos.getY()));
                break;
            }
            default: {
                System.out.println("Déplacement non compris");
            }
        }
    }

    public void askNextAction(World monde) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Veux tu te déplacer (D) ou combattre (C) ?");
        String choix = myObj.nextLine();
        if (choix.equals("D")) {
            System.out.println("Choisis ton déplacement avec les touches Z, Q, S, D :");
            deplaceAvecChoix(myObj.nextLine());
            System.out.println("Nouvelle position " + this.perso.getPos());
        } else if (choix.equals("C")) {
            this.perso.combattre(monde.creatures.get(2));
        } else {
            this.askNextAction(monde);
        }
    }



    /**
     * permet à l'utilisateur de choisir un personnage
     */
    public Creature choosePerso() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choisit ton personnage : Archer, Guerrier ou Mage");
        Random random = new Random();

        String userPerso = myObj.nextLine();
        userPerso = userPerso.toLowerCase();

        switch (userPerso) {
            case "archer": {
                System.out.println("Nom du mage ?");
                String name = myObj.nextLine();
                this.perso = new Archer(name, 100, random.nextInt(50) + 50, random.nextInt(30), random.nextInt(80) + 20, random.nextInt(80) + 20, random.nextInt(50) + 50, random.nextInt(50) + 50,
                        random.nextInt(50) + 10, random.nextInt(50) + 50, random.nextInt(15) + 2, new Point2D(21, 23), random.nextInt(15) + 5);
                break;
            }
            case "guerrier": {
                System.out.println("Nom du guerrier ?");
                String name = myObj.nextLine();
                this.perso = new Guerrier(name, 100, random.nextInt(40), random.nextInt(30), random.nextInt(80) + 20, random.nextInt(80) + 20, random.nextInt(20) + 10, random.nextInt(30) + 10,
                        random.nextInt(50) + 50, random.nextInt(20) + 10, 1, new Point2D(21, 23));
                break;
            }
            case "mage": {
                System.out.println("Nom du mage ?");
                String name = myObj.nextLine();
                this.perso = new Mage(name, 100, random.nextInt(50) + 50, random.nextInt(30), random.nextInt(80) + 20, random.nextInt(80) + 20, random.nextInt(50) + 50, random.nextInt(50) + 50,
                        random.nextInt(50) + 10, random.nextInt(50) + 50, random.nextInt(8) + 2, new Point2D(21, 23));
                break;
            }
            default: {
                System.out.println("Personnage non reconnu");
                this.choosePerso();
            }
        }

        return this.perso;
    }
}


