package org.centrale.projet.objet;

import org.centrale.projet.objet.GameBackup.Save;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Nourriture.Nourriture;
import org.centrale.projet.objet.Objects.Potion.Potion;
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
                this.perso.move(newPos);
                break;
            }
            // recule
            case "S": {
                this.perso.move(new Point2D(oldPos.getX(), oldPos.getY() - 1));
                break;
            }
            // vers la droite
            case "D": {
                this.perso.move(new Point2D(oldPos.getX() + 1, oldPos.getY()));
                break;
            }
            // vers la gauche
            case "Q": {
                this.perso.move(new Point2D(oldPos.getX() - 1, oldPos.getY()));
                break;
            }
            default: {
                System.out.println("Déplacement non compris");
            }
        }
        System.out.println("Ta nouvelle position " + perso.getPos());
    }

    private void combatAvecChoix(String choixCombat) {
        String[] posArray = choixCombat.split("\\s+");
        Point2D newPos = new Point2D(Integer.parseInt((posArray[0])), Integer.parseInt((posArray[1])));

        if (NewWorld.map.get(newPos) == null) {
            System.out.println("⛔ Case vide");
        } else if (NewWorld.map.get(newPos) instanceof Creature) {
            perso.combattre((Creature) NewWorld.map.get(newPos));
        } else {
            System.out.println("⛔ Case avec une potion");
        }
    }

    private void boirePotion(String choix) {
        String[] posArray = choix.split("\\s+");
        Point2D newPos = new Point2D(Integer.parseInt((posArray[0])), Integer.parseInt((posArray[1])));

        if (NewWorld.map.get(newPos) == null) {
            System.out.println("⛔ Case vide");
        } else if (NewWorld.map.get(newPos) instanceof Potion) {
            perso.deplaceEtBoirePotion((Potion) NewWorld.map.get(newPos));
        }else if (NewWorld.map.get(newPos) instanceof Nourriture) {
            perso.ramasseNourriture((Nourriture) NewWorld.map.get(newPos));
        } else {
            System.out.println("⛔ Case avec une Creature");
        }
    }

    public boolean askNextAction() {
        showInfos();
        showElementAround();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Veux tu te déplacer (D), combattre (C) ou ramasser un objet (R) ou quitter(Q) ?");
        String choix = myObj.nextLine();
        switch (choix) {
            case "D":
                System.out.println("Ta position actuelle: " + perso.getPos());
                System.out.println("Choisis ton déplacement avec les touches Z (monte), Q (gauche), S (descend), D (droite) :");
                deplaceAvecChoix(myObj.nextLine());
                break;
            case "C":
                System.out.println("Position du perso que tu attaques sous la forme: 'X Y'");
                combatAvecChoix(myObj.nextLine());
                break;
            case "R":
                System.out.println("Position de l'objet: 'X Y'");
                boirePotion(myObj.nextLine());
                break;
            case "Q":
                System.out.println("Arret du jeu");
                Save.saveGame(this, "game.txt");
                return false;
            default:
                this.askNextAction();
                return true;
        }
        return true;
    }

    private void showElementAround() {
        System.out.println("======= Ton entourage =======");
        int x = perso.getPos().getX();
        int y = perso.getPos().getY();
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                Point2D pt = new Point2D(i, j);
                if (!pt.equals(perso.getPos())) {
                    System.out.println(pt.toString() + " -> " + (NewWorld.map.get(pt) != null ? NewWorld.map.get(pt) : "Case vide"));
                } else {
                    System.out.println(pt.toString() + " -> " + " << ----- 🙋 Ton Perso ---- >>");
                }
            }
        }
        System.out.println("======= La Map =======");
        NewWorld.showMap(this);
    }

    private void showInfos() {
        System.out.println("======= 🙋 Ton Perso 🙋 =======");
        System.out.println(perso);
    }

    public void afficheMap() {
        System.out.print("🙋" + perso.getNom().substring(0, 4));
    }

    /**
     * permet à l'utilisateur de choisir un personnage
     */
    public Personnage choosePerso() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choisit ton personnage : Archer, Guerrier ou Mage");
        Random random = new Random();

        String userPerso = myObj.nextLine();
        userPerso = userPerso.toLowerCase();

        switch (userPerso) {
            case "archer": {
                System.out.println("Nom de l'archer ?");
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

    public String saveObject() {
        return String.format("Joueur %s\n", this.perso.toSave());
    }
}


