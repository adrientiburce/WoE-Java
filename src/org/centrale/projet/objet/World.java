package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Monstre.Lapin;
import org.centrale.projet.objet.Player.Monstre.Loup;
import org.centrale.projet.objet.Player.Monstre.Monstre;
import org.centrale.projet.objet.Player.Personnage.*;
import org.centrale.projet.objet.Tools.Mana;
import org.centrale.projet.objet.Tools.Objet;
import org.centrale.projet.objet.Tools.Soin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class World {

    /**
     * ensemble des créaturse contenus dans notre monde
     */
    public List<Creature> creatures;

    /**
     * ensemble des objets de notre monde
     */
    public List<Objet> objets;

    /**
     * Map stoquant les positions des joueurs & objets dans notre monde
     * permet de vérifier que chaque joueur/object est sur une position différente avec les positions en clé
     */
    public static Map<Point2D, Integer> mapPositions;

    /**
     * crée et remplit mapPositions apres la création de notre monde
     *
     * @param monstres
     * @param personnages
     * @param objects
     */
    private void initMapPoisition(List<Monstre> monstres, List<Personnage> personnages, List<Objet> objects) {
        for (Personnage perso : personnages) {
            this.mapPositions.put(perso.getPos(), perso.hashCode());
        }
        for (Monstre m : monstres) {
            this.mapPositions.put(m.getPos(), m.hashCode());
        }
        for (Objet o : objects) {
            this.mapPositions.put(o.getPos(), o.hashCode());
        }
    }


    /**
     * constructeur par défaut
     */
    public World() {
        this.mapPositions = new HashMap<>();
        this.creatures = new ArrayList<>();
        this.objets = new ArrayList<>();
    }

    /**
     * Génére un monde aléatoire avec des positions pour cachun des personnages
     */
    public void creerMondeAlea() {
        Random radomGenerator = new Random();
        List<Archer> archers = Stream.generate(Archer::new).limit(25).collect(Collectors.toList());
        List<Mage> mages = Stream.generate(Mage::new).limit(25).collect(Collectors.toList());
        List<Guerrier> guerriers = Stream.generate(Guerrier::new).limit(25).collect(Collectors.toList());
        List<Paysan> paysans = Stream.generate(Paysan::new).limit(25).collect(Collectors.toList());
        this.creatures.addAll(archers);
        this.creatures.addAll(mages);
        this.creatures.addAll(guerriers);
        this.creatures.addAll(paysans);

        int i = 1;
        for (Creature c : this.creatures) {
            if(c.getClass().getSuperclass() == Personnage.class) {
               ((Personnage) c).deplace();
               ((Personnage) c).setNom(((Personnage) c).getNom() + i);
               i++;
            }
        }

        // on vérifie que nos personnages sont assez proche de la position initiale de l'archer
        // et que les positions sont différentes
//        while ((this.robin.getPos().distance(this.peon.getPos()) > 5) || (this.robin.getPos() == this.peon.getPos())) {
//            // si le paysan est trop loin on regénére  une position
//            this.peon.setPos(new Point2D());
//        }
//        while ((this.robin.getPos().distance(this.bugs.getPos()) > 5) || (this.robin.getPos() == this.bugs.getPos())) {
//            // si le lapin est trop loin on regénére une position
//            this.bugs.setPos(new Point2D());
//        }
    }

    @Override
    public String toString() {
        return "World{" +
                creatures.size() + " creatures, " +
                objets.size() + " objets" +
                '}';
    }
}
