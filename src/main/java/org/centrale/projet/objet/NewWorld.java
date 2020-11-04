package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Nourriture.CigueToxique;
import org.centrale.projet.objet.Objects.Nourriture.Vitamine;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Soin;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Mage;

import java.util.*;

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
     * Enlève les créature mortes et déplace les autres
     */
    public static void removeDeadCreatureAndMoveCreatures(Joueur joueur) {
        for (int i = 1; i <= TAILLE_GRILLE; i++) {
            for (int j = 1; j <= TAILLE_GRILLE; j++) {
                Point2D pt = new Point2D(i, j);

                removeDeadCreature(pt);
                moveAllCreature(pt, joueur);
            }
        }
    }

    /**
     * supprimes les créatures qui n'ont plus de vie
     */
    private static void removeDeadCreature(Point2D pt) {
        if (NewWorld.map.get(pt) instanceof Creature) {
            Creature c = (Creature) NewWorld.map.get(pt);
            if (c.getPtVie() <= 0) {
                System.out.printf("==> La créature %s est morte !\n", c.getNom());
                NewWorld.map.remove(pt);
            }
        }
    }

    /**
     * déplace aléatoire les créatures sur la Map
     */
    private static void moveAllCreature(Point2D pt, Joueur joueur) {
        if (NewWorld.map.get(pt) instanceof Creature && !pt.equals(joueur.perso.getPos())) {
            Creature c = (Creature) NewWorld.map.get(pt);
            for (Point2D newPos : getAdjacentPos(c.pos)) {
                if (NewWorld.map.get(newPos) == null) {
                    c.move(newPos);
                    break;
                }
            }
        }
    }

    public static ArrayList<Point2D> getAdjacentPos(Point2D pt) {
        ArrayList<Point2D> res = new ArrayList<>();
        if (pt.getX() > 1) {
            Point2D newPt = pt.translater(-1, 0);
            res.add(newPt);
        }
        if (pt.getX() < NewWorld.TAILLE_GRILLE) {
            Point2D newPt = pt.translater(1, 0);
            res.add(newPt);
        }
        if (pt.getY() < NewWorld.TAILLE_GRILLE) {
            Point2D newPt = pt.translater(0, 1);
            res.add(newPt);
        }
        if (pt.getY() > 1) {
            Point2D newPt = pt.translater(0, -1);
            res.add(newPt);
        }
        Collections.shuffle(res);
        return res;
    }

    /**
     * Génère un monde aléatoire avec des positions pour chacun des personnages
     */
    public void creerMondeAlea(int nombrePersos) {
        int persoToPut = nombrePersos;
        Random random = new Random();

        for (int i = 1; i <= TAILLE_GRILLE; i++) {
            for (int j = 1; j <= TAILLE_GRILLE; j++) {
                if (random.nextInt(TAILLE_GRILLE * TAILLE_GRILLE + nombrePersos) > nombrePersos && (i != 3 && j != 3)) {
                    try {
                        ElementDeJeu elem = getRandomPerso();
                        elem.putOnMap(new Point2D(i, j));
                        persoToPut--;
                    } catch (Exception e) {
                        System.out.println("perso non placé");
                    }
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
                return new Archer("archerGénéré", random);
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

    public static void showMap(Joueur joueur) {
        for (int j = TAILLE_GRILLE; j >= 1; j--) {
            System.out.print("|"); // début ligne
            for (int i = 1; i <= TAILLE_GRILLE; i++) {
                Point2D pt = new Point2D(i, j);
                System.out.print(" ");
                if (map.get(pt) == null) {
                    System.out.print("      "); // 5 espaces
                } else if (pt.equals(joueur.perso.getPos())) {
                    joueur.afficheMap();
                } else {
                    map.get(pt).afficheMap();
                }
                System.out.print(" |");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "World{" +
                " Taille:  " + NewWorld.TAILLE_GRILLE +
                '}';
    }
}
