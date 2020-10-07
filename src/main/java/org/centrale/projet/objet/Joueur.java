package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.util.Random;
import java.util.Scanner;

public class Joueur {

    public Personnage getPerso() {
        return perso;
    }

    /**
     * personnage choisit par le joueur
     */
    private Personnage perso;

    public Joueur() {
    }


    public void choosePerso() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choisit votre personnage : Archer, Guerrier ou Mage");
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
    }
}


