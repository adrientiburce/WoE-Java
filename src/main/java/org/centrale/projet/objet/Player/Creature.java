package org.centrale.projet.objet.Player;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.World;

public class Creature implements Deplacable {


    /**
     * position du personnage
     */
    private Point2D pos;

    /**
     * action de déplacement aléatoire (de 1 unité maximum selon X et Y)
     */
    public boolean deplace() {
        Point2D newPos = new Point2D(this.pos);
        newPos.getNextPosition();
        if (this.verifDeplacement(this, newPos)) {
            this.setPos(newPos);
            return true;
        }
        return false;
    }

    /**
     * action de déplacement avec la nouvelle position
     *
     * @param newPos nouvelle position
     */
    public boolean deplace(Point2D newPos) {
        if (this.getPos().distance(newPos) > Math.sqrt(2)) {
            System.out.println("⛔ déplacement non autorisé");
        } else if (this.verifDeplacement(this, newPos)) {
            this.setPos(newPos);
            return true;
        }
        return false;
    }

    private boolean verifDeplacement(Creature c, Point2D newPos) {
        if (!World.mapPositions.containsKey(newPos)) {
            World.mapPositions.remove(this.getPos());
            World.mapPositions.put(newPos, c.hashCode());
            return true;
        } else {
            return false;
        }
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

}
