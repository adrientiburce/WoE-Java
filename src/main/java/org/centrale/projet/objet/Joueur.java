package org.centrale.projet.objet;

import org.centrale.projet.objet.GameBackup.Save;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Nourriture.Nourriture;
import org.centrale.projet.objet.Objects.Potion.Potion;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Loup;
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

    /**
     * personnage choisit par le joueur
     */
    public Personnage perso;

    /**
     * nom de la classe du personnage
     * utile pour la sauvegarde de la partie
     */
    private String className;

    public Personnage getPerso() {
        return perso;
    }


    public void setClassName(String className) {
        this.className = className;
    }

    public Joueur() {
    }

    private int deplaceAvecChoix(String deplaceChoice) {
        deplaceChoice = deplaceChoice.toUpperCase();
        Point2D oldPos = this.perso.getPos();
        boolean effected;
        switch (deplaceChoice) {
            // avance
            case "Z": {
                effected = this.perso.move(new Point2D(oldPos.getX(), oldPos.getY() + 1));
                break;
            }
            // recule
            case "S": {
                effected = this.perso.move(new Point2D(oldPos.getX(), oldPos.getY() - 1));
                break;
            }
            // vers la droite
            case "D": {
                effected = this.perso.move(new Point2D(oldPos.getX() + 1, oldPos.getY()));
                break;
            }
            // vers la gauche
            case "Q": {
                effected = this.perso.move(new Point2D(oldPos.getX() - 1, oldPos.getY()));
                break;
            }
            default: {
                System.out.println("Déplacement non compris");
                return -1;
            }
        }
        if (effected) {
            System.out.println("Ta nouvelle position " + perso.getPos());
            return 1;
        }
        return -1;
    }

    /**
     * Récupère la position de l'attaqué et le combat
     * @param choixCombat
     * @return
     */
    private int combatAvecChoix(String choixCombat) {
        String[] posArray = choixCombat.split("\\s+");
        Point2D newPos = new Point2D(Integer.parseInt((posArray[0])), Integer.parseInt((posArray[1])));

        if (NewWorld.map.get(newPos) == null) {
            System.out.println("⛔ Case vide");
        } else if (NewWorld.map.get(newPos) instanceof Creature) {
            perso.combattre((Creature) NewWorld.map.get(newPos));
            return 1;
        } else {
            System.out.println("⛔ Case avec une potion");
        }
        return -1;
    }

    /**
     * Récupère la position de l'utilisateur et réalise l'action
     * @param choix
     * @return
     * @throws NumberFormatException
     */
    private int ramasseObjet(String choix) throws NumberFormatException {
        String[] posArray = choix.split("\\s+");
        Point2D newPos = new Point2D(Integer.parseInt((posArray[0])), Integer.parseInt((posArray[1])));

        if (NewWorld.map.get(newPos) == null) {
            System.out.println("⛔ Case vide");
            return -1;
        } else if (NewWorld.map.get(newPos) instanceof Potion) {
            perso.deplaceEtBoirePotion((Potion) NewWorld.map.get(newPos));
        } else if (NewWorld.map.get(newPos) instanceof Nourriture) {
            perso.ramasseNourriture((Nourriture) NewWorld.map.get(newPos));
        } else {
            System.out.println("⛔ Case avec une Creature");
            return -1;
        }
        return 2;
    }

    /**
     *
     * @return -1: tour de jeu non effectué (non compris) / 0: arrêt du jeu par l'utilisateur
     *  1: se déplacer ou combattre /  2: ramasser un objet
     */
    public int askNextAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veux tu te déplacer (D), combattre (C) ou ramasser un objet (R) ou quitter(Q) ?");
        String choix = scanner.nextLine();
        switch (choix) {
            case "D":
                System.out.println("Ta position actuelle: " + perso.getPos());
                System.out.println("Choisis ton déplacement avec les touches Z (monte), Q (gauche), S (descend), D (droite) :");
                return deplaceAvecChoix(scanner.nextLine());
            case "C":
                System.out.println("Position du perso que tu attaques sous la forme: 'X Y'");
                try {
                    return combatAvecChoix(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Position non valable");
                    return -1;
                }
            case "R":
                System.out.println("Position de l'objet: 'X Y'");
                try {
                    return ramasseObjet(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Position non valable");
                    return -1;
                }
            case "Q":
                System.out.println("Veux-tu sauvegarder la partie (S) ou quitter définitivement (Q) ?");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "S": {
                        System.out.println("Nom de la sauvegarde");
                        String backupName = scanner.nextLine();
                        Save.saveGame(this, backupName + ".txt");
                        break;
                    }
                    case "Q": {
                        return 0;
                    }
                }
                return 0;
            default:
                this.askNextAction();
                return 1;
        }
    }

    /**
     * Montre la nouvelle Map au joueur après chaque tour
     */
    public void showElementAround() {
        System.out.println("======= Ton entourage =======");
        int x = perso.getPos().getX();
        int y = perso.getPos().getY();
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                Point2D pt = new Point2D(i, j);
                if (!pt.equals(perso.getPos())) {
                    System.out.println("position " + pt.toString() + " -> " + (NewWorld.map.get(pt) != null ? NewWorld.map.get(pt) : "Case vide"));
                } else {
                    System.out.println("position: " + pt.toString() + " -> " + " << ----- 🙋 Ton Perso ---- >>");
                }
            }
        }
        System.out.println("======= La Map =======");
        NewWorld.showMap(this);
    }

    /**
     * Montre les infos de son perso au joueur
     */
    public void showPersoInfos() {
        System.out.print("======= 🙋 Ton Perso ");this.perso.afficheMap();
        System.out.println(" =======");
        System.out.println(perso);
        perso.showNourritureBag();
    }

    public void afficheMap() {
        if (perso.getNom().length() <= 4) {
            System.out.print("🙋" + perso.getNom());
        } else {
            System.out.print("🙋" + perso.getNom().substring(0, 4));
        }
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
                this.perso = new Archer(name, random);
                this.className = Archer.class.getSimpleName();
                break;
            }
            case "guerrier": {
                System.out.println("Nom du guerrier ?");
                String name = myObj.nextLine();
                this.perso = new Guerrier(name, random);
                this.className = Guerrier.class.getSimpleName();
                break;
            }
            case "mage": {
                System.out.println("Nom du mage ?");
                String name = myObj.nextLine();
                this.perso = new Mage(name, random);;
                this.className = Mage.class.getSimpleName();
                break;
            }
            default: {
                System.out.println("Personnage non reconnu");
                this.choosePerso();
            }
        }
        return this.perso;
    }

    /**
     * attaque automatiques des Loups sur le joueur si distance assez proche
     */
    public void attaqueDesLoups() {
        int x = perso.getPos().getX();
        int y = perso.getPos().getY();
        // positions environnantes
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                // pas les diagonales
                if (i == x || j == y) {
                    Point2D pt = new Point2D(i, j);
                    if (NewWorld.map.get(pt) instanceof Loup) {
                        Loup loup = (Loup) NewWorld.map.get(pt);
                        loup.combattre(this.perso);
                        return;
                    }
                }
            }
        }
    }

    /**
     * vérifie si la partie doit continuer
     * @return
     */
    public boolean isAlive() {
        return this.perso.getPtVie() >= 1;
    }

    public String saveObject() {
        return String.format("Joueur %s %s\n", this.className, this.perso.toSave());
    }
}


