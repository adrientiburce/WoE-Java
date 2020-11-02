package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Nourriture.CigueToxique;
import org.centrale.projet.objet.Objects.Nourriture.Vitamine;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Soin;
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
    public static Map<Point2D, ElementDeJeu> map;

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
    public void creerMondeAlea(int nombrePersos) throws Exception {
        int persoToPut = nombrePersos;
        Random random = new Random();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (random.nextInt(TAILLE_GRILLE * TAILLE_GRILLE + nombrePersos) > nombrePersos && (i != 3 && j != 3)) {
                    ElementDeJeu elem = getRandomPerso();
                    elem.putOnMap(new Point2D(i, j));
                    persoToPut--;
                }
                if (persoToPut == 0) {
                    return;
                }
            }
        }
    }

    private ElementDeJeu getRandomPerso() {
        Random random = new Random();
        int r = random.nextInt(12);
        switch (r) {
            case 0:
                return new Archer("ArcherGénéré", random);
            case 1:
                return new Mage("mageGénéré", random);
            case 2:
                return new Guerrier("guerrierGénéré", random);
            case 3:
                return new Loup("loupGénéré", random);
            case 4:
            case 5:
                return new Soin("potionVie", random);
            case 6:
            case 7:
                return new Mana("potionMagique", random);
            case 8:
            case 9:
                return new CigueToxique("Cigüe", random);
            case 10:
            case 11:
                return new Vitamine("Vitamine", random);
        }
        return new Archer("archerGénéré", random);
    }


    @Override
    public String toString() {
        return "World{" +
                " Taille:  " + NewWorld.TAILLE_GRILLE +
                '}';
    }
}
