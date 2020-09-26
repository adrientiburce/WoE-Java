package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Monstre.Monstre;
import org.centrale.projet.objet.Player.Personnage.Archer;
import org.centrale.projet.objet.Player.Monstre.Lapin;
import org.centrale.projet.objet.Player.Personnage.Paysan;
import org.centrale.projet.objet.Player.Personnage.Personnage;
import org.centrale.projet.objet.Tools.Objet;
import org.centrale.projet.objet.Tools.Potion;
import org.centrale.projet.objet.Tools.Soin;


import java.util.*;

public class World {

    public Archer robin;

    public Paysan peon;

    public Lapin bugs;

    public Archer guillaumeT;

    public Potion potion1;

    /**
     * Map stoquant les positions des joueurs & objets dans notre monde
     * permet de vérifier que chaque joueur/object est sur une position différente
     */
    public Map<Integer, Point2D> mapPositions;

    /**
     * crée et remplit mapPositions apres la création de notre monde
     *
     * @param monstres
     * @param personnages
     * @param objects
     */
    private void initMapPoisition(List<Monstre> monstres, List<Personnage> personnages, List<Objet> objects) {
        this.mapPositions = new HashMap<>();
        for (Personnage perso : personnages) {
            this.mapPositions.put(perso.hashCode(), perso.getPos());
        }
        for (Monstre m : monstres) {
            this.mapPositions.put(m.hashCode(), m.getPos());
        }
        for (Objet o : objects) {
            this.mapPositions.put(o.hashCode(), o.getPos());
        }
    }

    public World() {
        this.robin = new Archer();
        this.robin.setNom("Robin");
        this.guillaumeT = new Archer(this.robin);
        this.guillaumeT.setNom("Guillaume");
        this.peon = new Paysan();
        this.bugs = new Lapin();

        this.potion1 = new Soin(3);

        initMapPoisition(
                Arrays.asList(this.bugs),
                Arrays.asList(this.robin, this.guillaumeT, this.peon),
                Arrays.asList(potion1)
        );
    }

    /**
     * Génére un monde aléatoire avec des positions pour cachun des personnages
     */
    public void creerMondeAlea() {
        World monMonde = new World();

        // on vérifie que nos personnages sont assez proche de la position initiale de l'archer
        // et que les positions sont différentes
        while ((this.robin.getPos().getDistance(this.peon.getPos()) > 5) || (this.robin.getPos() == this.peon.getPos())) {
            // si le paysan est trop loin on regénére  une position
            this.peon.setPos(new Point2D());
        }
        while ((this.robin.getPos().getDistance(this.bugs.getPos()) > 5) || (this.robin.getPos() == this.bugs.getPos())) {
            // si le lapin est trop loin on regénére une position
            this.bugs.setPos(new Point2D());
        }
    }
}
