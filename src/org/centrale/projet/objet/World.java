package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Personnage.Personnage;
import org.centrale.projet.objet.Tools.Objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World {

    /**
     * ensemble des créaturse contenus dans notre monde
     */
    public ArrayList<Creature> creatures;

    /**
     * ensemble des objets de notre monde
     */
    public ArrayList<Objet> objets;

    /**
     * Map stoquant les positions des joueurs & objets dans notre monde
     * permet de vérifier que chaque joueur/object est sur une position différente avec les positions en clé
     */
    public static Map<Point2D, Integer> mapPositions;

    /**
     * permet de définir la taille du monde
     */
    public static int TAILLE_GRILLE = 50;

    /**
     * constructeur par défaut
     */
    public World() {
        this.mapPositions = new HashMap<>();
        this.creatures = new ArrayList<>();
        this.objets = new ArrayList<>();
    }

    /**
     * constructeur
     *
     * @param tailleGrille taille du monde
     */
    public World(int tailleGrille) {
        TAILLE_GRILLE = tailleGrille;
        this.mapPositions = new HashMap<>();
        this.creatures = new ArrayList<>();
        this.objets = new ArrayList<>();
    }

    /**
     * Génére un monde aléatoire avec des positions pour chacun des personnages
     */
    public void creerMondeAlea(int nombrePersos) {
        if (TAILLE_GRILLE * TAILLE_GRILLE * 10 <= nombrePersos) {
            System.out.println("⛔ Grille trop petite");
            return;
        }

        for (int i = 0; i < nombrePersos; i++) {
            Archer a = new Archer();
            this.creatures.add(a);
            boolean newPosValide = false;
            // Be careful with the size of the world
            while (!newPosValide) {
                newPosValide = a.deplace();
            }
        }
    }

    /**
     * cacul du barycentre des positions des personnages
     *
     * @param world
     * @return
     */
    public static Point2D caculBarycentrePersos(World world) {
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
                objets.size() + " objets" +
                '}';
    }
}
