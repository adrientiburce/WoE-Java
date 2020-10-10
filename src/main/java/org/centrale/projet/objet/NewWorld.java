package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Potion;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NewWorld {

    /**
     * Map stockant les positions des joueurs & objets dans notre monde
     * permet de vérifier que chaque joueur/object est sur une position différente avec les positions en clé
     */
    public static Map<Point2D, Creature> map;

    public static int TAILLE_GRILLE;

    /**
     * constructeur par défaut
     */
    public NewWorld() {
        this(10);
        TAILLE_GRILLE = 10;
    }

    public NewWorld(int tailleGrille) {
        TAILLE_GRILLE = tailleGrille;
        NewWorld.map = new HashMap<>();
        for (int i = 0; i < tailleGrille; i++) {
            for (int j = 0; j < tailleGrille; j++) {
                NewWorld.map.put(new Point2D(i, j), null);
            }
        }
    }

    /**
     * Génère un monde aléatoire avec des positions pour chacun des personnages
     */
    public void creerMondeAlea(int nombrePersos) {
        int persoToPut = nombrePersos;
        Random random = new Random();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (random.nextInt(10) > 5) {
                    Creature c = getRandomPerso();
                    c.putOnMap(new Point2D(i, j));
                    persoToPut--;
                }
                if (persoToPut == 0) {
                    System.out.println("EMPTY " + i + " "  + j);
                    return;
                }
            }
        }
    }

    private Creature getRandomPerso() {
        Random random = new Random();
        int r = random.nextInt(4);
        switch (r) {
            case 0, 1:
                return new Archer("archer généré", random);
            case 2, 3:
                return new Mage("mage généré", random);
            case 4, 5:
                return new Guerrier("guerrier généré", random);
            case 6, 7:
                return new Loup("loup généré", random);
//            case 8:
//                return new Potion("potion", "blue");
        }
        return new Archer("archer généré", random);
    }


    @Override
    public String toString() {
        return "World{" +
                " Taille:  " + NewWorld.TAILLE_GRILLE +
                '}';
    }
}
