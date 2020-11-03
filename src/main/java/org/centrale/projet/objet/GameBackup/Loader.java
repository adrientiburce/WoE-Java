package org.centrale.projet.objet.GameBackup;

import org.centrale.projet.objet.ElementDeJeu;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Joueur;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Nourriture.CigueToxique;
import org.centrale.projet.objet.Objects.Nourriture.Vitamine;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Soin;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Loader {

    private static FileReader reader;

    public static void main(String[] args) throws Exception {
        Joueur j = new Joueur();
        load("game.txt", j);
        NewWorld.showMap(j);
    }

    public static void load(String backupName, Joueur joueur) throws Exception {
        // open the file
        Loader.reader = new FileReader(new File(backupName));

        // read the file
        try {
            BufferedReader b = new BufferedReader(Loader.reader);
            String readLine = "";
            int i = 1;
            while ((readLine = b.readLine()) != null) {
                if (i == 1) {
                    createWorld(readLine);
                    b.readLine(); // skip largeur
                } else {
                    if (readLine.startsWith("Joueur")) {
                        String perso = readLine.substring("Joueur".length());
                        loadElemJeu(perso, true, joueur);
                    }
                    loadElemJeu(readLine, false, joueur);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (joueur.perso == null) {
            throw new Exception("Joueur non généré");
        }
    }


    public static void createWorld(String hauteur) {
        StringTokenizer tokenizer = new StringTokenizer(hauteur, " ");
        tokenizer.nextToken();
        int h = Integer.parseInt(tokenizer.nextToken());
        new NewWorld(h);
    }

    public static void loadElemJeu(String str, boolean isJoueur, Joueur joueur) throws Exception {
        List<Integer> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        String className = tokenizer.nextToken();
        Point2D pt = new Point2D();
        String name = "";
        while (tokenizer.hasMoreElements()) {
            String lineStr = tokenizer.nextToken();
            if (lineStr.startsWith("[")) {
                lineStr = lineStr.substring(1, lineStr.length() - 1);
                String[] arrOfCoord = lineStr.split(";");
                pt.setX(Integer.parseInt(arrOfCoord[0]));
                pt.setY(Integer.parseInt(arrOfCoord[1]));
            } else {
                try {
                    int att = Integer.parseInt(lineStr);
                    tokens.add(att);
                } catch (NumberFormatException e) {
                    name = lineStr;
                }
            }
        }
        ElementDeJeu elem = getElemDeJeu(className, tokens, name);
        if (elem != null) {
            elem.putOnMap(pt);
        }
        if (isJoueur && elem instanceof Personnage) {
            joueur.perso = (Personnage) elem;
            joueur.setClassName(className);
        }
    }

    public static ElementDeJeu getElemDeJeu(String className, List<Integer> tokens, String name) {
        switch (className) {
            case "Archer":
                return new Archer(name, tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D(), tokens.get(9));
            case "Mage":
                return new Mage(name, tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D());
            case "Guerrier":
                return new Guerrier(name, tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D());
            case "Loup":
                return new Loup(name, tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), new Point2D());
            case "Soin":
                return new Soin("Soin", tokens.get(0));
            case "Mana":
                return new Mana("Mana", tokens.get(0));
            case "Vitamine":
                return new Vitamine(name, tokens.get(0), tokens.get(1));
            case "CigueToxique":
                return new CigueToxique(name, tokens.get(0), tokens.get(1));
        }
        return null;
    }
}
