package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Objects.Objet;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Guerrier;
import org.centrale.projet.objet.Player.Personnage.Personnage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @deprecated used before TP6, now use NewWorld
 */
public class World {

    /**
     * ensemble des créatures contenus dans notre monde
     */
    public List<Creature> creatures;

    /**
     * ensemble des objets de notre monde
     */
    public List<Objet> objets;

    /**
     * Map stockant les positions des joueurs & objets dans notre monde
     * permet de vérifier que chaque joueur/object est sur une position différente avec les positions en clé
     */
    public static Map<Point2D, Integer> mapPositions;


    public static int TAILLE_GRILLE = 50;

    /**
     * constructeur par défaut
     */
    public World() {
        this.mapPositions = new HashMap<>();
        this.creatures = new ArrayList<>();
        this.objets = new ArrayList<>();
    }

    public World(int tailleGrille) {
        TAILLE_GRILLE = tailleGrille;
        this.mapPositions = new HashMap<>();
        this.creatures = new ArrayList<>();
        this.objets = new ArrayList<>();
    }

    /**
     * Génère un monde aléatoire avec des positions pour chacun des personnages
     */
    public void creerMondeAlea(int nombrePersos) {
        if (TAILLE_GRILLE * TAILLE_GRILLE * 10 <= nombrePersos) {
            System.out.println("⛔ Grille trop petite");
            return;
        }
        // generate all personnages
        List<Archer> archers = Stream.generate(Archer::new).limit(nombrePersos).collect(Collectors.toList());
        List<Loup> loups = Stream.generate(Loup::new).limit(nombrePersos).collect(Collectors.toList());
        List<Guerrier> guerriers = Stream.generate(Guerrier::new).limit(nombrePersos).collect(Collectors.toList());
        this.creatures.addAll(archers);
        this.creatures.addAll(loups);
        this.creatures.addAll(guerriers);

        for (Creature c : this.creatures) {
            boolean newPosValide = false;
            while (!newPosValide) {
                newPosValide = c.deplace();
            }
        }
    }

    /**
     * ajouter une créature au monde
     * @param creature
     */
    public void addToWorld(Creature creature) {
        this.creatures.add(creature);
        boolean newPosValide = false;
        while (!newPosValide) {
            newPosValide = creature.deplace();
        }

    }


    /**
     * method used in TP4 to calculate List performance
     * @param world
     * @return Point: barycentre
     */
    public static Point2D calculBarycentrePersos(World world) {
        int xG = 0;
        int yG = 0;

        for (Creature c : world.creatures) {
            xG += ((Personnage) c).getPos().getX();
            yG += ((Personnage) c).getPos().getY();
        }
//        Iterator<Creature> it = world.creatures.iterator();
//        while (it.hasNext()) {
//            Creature c = it.next();
//            xG += ((Personnage) c).getPos().getX();
//            yG += ((Personnage) c).getPos().getY();
//        }
        xG = xG / world.creatures.size();
        yG = yG / world.creatures.size();
        return new Point2D(xG, yG);
    }

    @Override
    public String toString() {
        return "World{" +
                creatures.size() + " creatures, " +
                objets.size() + " objets, " +
                " Taille:  " + World.TAILLE_GRILLE +
                '}';
    }
}
