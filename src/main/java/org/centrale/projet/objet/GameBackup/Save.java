package org.centrale.projet.objet.GameBackup;

import org.centrale.projet.objet.ElementDeJeu;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Joueur;
import org.centrale.projet.objet.NewWorld;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    /**
     * sauvegarde un jeu avec tous les objets sur la Map et le Joueur
     */
    public static void saveGame(Joueur joueur, String backupName) {
        try (FileWriter writer = new FileWriter(backupName); // saved at project's root
             BufferedWriter bw = new BufferedWriter(writer)) {
            // sauvegarde de la grille
            saveGrilleInfo(bw, NewWorld.TAILLE_GRILLE);

            // sauvegarde de la map et des éléments de jeu
            for (int i = 0; i < NewWorld.TAILLE_GRILLE; i++) {
                for (int j = 0; j < NewWorld.TAILLE_GRILLE; j++) {
                    if (NewWorld.map.get(new Point2D(i, j)) != null) {
                        Point2D pt = new Point2D(i, j);
                        if (!pt.equals(joueur.perso.getPos())) {
                            saveElemDeJeuInLine(bw, NewWorld.map.get(pt));
                        } else {
                            // sauvegarde du joueur
                            bw.write(joueur.saveObject());
                        }
                    }
                }
            }

            System.out.println("Sauvegarde effectuée 👌");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * sauvegarde la grille
     * @param bw
     * @param tailleGrille
     */
    private static void saveGrilleInfo(BufferedWriter bw, int tailleGrille) {
        try {
            bw.write(String.format("Largeur %s\n", tailleGrille));
            bw.write(String.format("Hauteur %s\n", tailleGrille));
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * sauvegarde chaque ElementDeJeu présent sur la Map
     * @param bw
     * @param elem
     */
    public static void saveElemDeJeuInLine(BufferedWriter bw, ElementDeJeu elem) {
        try {
            bw.write(elem.saveObject()); // newLine in saveObject
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
