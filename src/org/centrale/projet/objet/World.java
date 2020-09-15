package org.centrale.projet.objet;

public class World {

    public Archer robin;

    public Paysan peon;

    public Lapin bugs;

    public World() {
        this.robin = new Archer();
        this.peon = new Paysan();
        this.bugs = new Lapin();
    }

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
