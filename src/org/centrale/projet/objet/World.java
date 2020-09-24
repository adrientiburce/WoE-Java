package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Archer;
import org.centrale.projet.objet.Player.Lapin;
import org.centrale.projet.objet.Player.Paysan;

public class World {

    public Archer robin;

    public Paysan peon;

    public Lapin bugs;

    public Archer guillaumeT;

    public World() {
        this.robin = new Archer();
        this.robin.setNom("Robin");
        this.guillaumeT = new Archer(this.robin);
        this.guillaumeT.setNom("Guillaume");
        this.peon = new Paysan();
        this.bugs = new Lapin();
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
