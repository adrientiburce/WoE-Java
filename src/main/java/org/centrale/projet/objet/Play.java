package org.centrale.projet.objet;


import org.centrale.projet.objet.GameBackup.Loader;
import org.centrale.projet.objet.Grille.Point2D;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Play {

    private static Joueur joueur;


    public static void main(String[] args) {
        joueur = new Joueur();
        System.out.println("===============================================================");
        System.out.println("|                  Bienvenue sur WOE - ECN !                   |");
        for (int i = 0; i < 3; i++) {
            System.out.println("|                                                              |");
        }
        System.out.println("|               Réalisé par Adrien.T & Léa.R                   |");
        System.out.println("===============================================================");

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Veux-tu charger la dernière partie (C) ou en démarrer une nouvelle (N) ?");
        String choice = scan.nextLine();

        switch (choice) {
            case "C": {
                System.out.println("Nom de votre sauvegarde");
                String backup = scan.nextLine();
                try {
                    Loader.load(backup + ".txt", joueur);
                } catch (FileNotFoundException e) {
                    System.out.println("Fichier non trouvé");
                    return;
                } catch (Exception e) {
                    System.out.println("Echec du chargement du fichier");
                    return;
                }
                break;
            }
            case "N": {
                newGame();
                break;
            }
            default:
                newGame();
                break;
        }
        play();
    }

    private static void play() {
        joueur.showPersoInfos();
        joueur.showElementAround();

        int res = 1;
        while (res == 1) {

            res = joueur.askNextAction();
            // si une action a été effectué
            if (res == 1) {
                joueur.showPersoInfos();
                joueur.showElementAround();
                joueur.attaqueDesLoups();
            } // si aucune action
            else if (res == -1) {
                res = 1;
            }
            if (!joueur.isAlive()) {
                System.out.println("😵 La partie est finie vous ête mort !");
                res = 0;
            }

        }
    }


    public static void newGame() {
        NewWorld monde = new NewWorld(10);
        monde.creerMondeAlea(50);
        joueur.perso = joueur.choosePerso();
        try {
            joueur.perso.putOnMap(new Point2D(3, 3));
        } // creerMondeAlea garde cette positon libre
        catch (Exception e) {
            System.out.println("Position [3;3] déjà prise");
        }
    }


}
