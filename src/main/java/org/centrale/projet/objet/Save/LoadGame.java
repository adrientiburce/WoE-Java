package org.centrale.projet.objet.Save;

import org.centrale.projet.objet.ElementDeJeu;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Soin;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class LoadGame {

    public static void main(String[] args) throws Exception {
        load("game.txt");
    }

    public static void load(String backupName) throws Exception {

        try {
            File f = new File(backupName);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            int i = 1;
            while ((readLine = b.readLine()) != null) {
                if (i == 1) {
                    NewWorld monde = createWorld(readLine);
                    b.readLine(); // skip largeur
                } else {
                    loadElemJeu(readLine);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(NewWorld.map);

    }

    public static NewWorld createWorld(String hauteur) {
        StringTokenizer tokenizer = new StringTokenizer(hauteur, " ");
        tokenizer.nextToken();
        int h = Integer.parseInt(tokenizer.nextToken());
        return new NewWorld(h);
    }

    public static void loadElemJeu(String str) throws Exception {
        List<Integer> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        String elementDeJeu = tokenizer.nextToken();

        Point2D pt = new Point2D();
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
                }
            }
        }
        ElementDeJeu elem = getElemDeJeu(elementDeJeu, tokens);
        elem.putOnMap(pt);
    }

    public static ElementDeJeu getElemDeJeu(String elementDeJeu, List<Integer> tokens) {
        Random random = new Random();
        switch (elementDeJeu) {
            case "Archer":
                return new Archer("archerGénéré", tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D(), tokens.get(9));
            case "Mage":
                return new Mage("mageGénéré", tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D());
            case "Guerrier":
                return new Guerrier("guerrierGénéré", tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), tokens.get(4), tokens.get(5), tokens.get(6),
                        tokens.get(7), tokens.get(8), tokens.get(9), new Point2D());
            case "Loup":
                return new Loup("loupGénéré", tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3), new Point2D());
            case "Soin":
                return new Soin("Soin",  tokens.get(0));
            case "Mana":
                return new Mana("Mana",  tokens.get(0));
        }
        return new Mage("mageGénéré", random);
    }
}
