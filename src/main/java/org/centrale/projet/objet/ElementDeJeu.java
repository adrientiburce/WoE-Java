package org.centrale.projet.objet;

import org.centrale.projet.objet.Grille.Point2D;

public class ElementDeJeu {

    /**
     * position de l'objet sur la grille
     */
    protected Point2D pos;


    /**
     * placement INITIALE sur la map
     *
     * @param newPos nouvelle position
     */
    public void putOnMap(Point2D newPos) throws Exception {
        if (NewWorld.map.get(newPos) == null) {
            this.setPos(newPos);
            NewWorld.map.put(newPos, this);
        } else {
            throw new Exception("Position occupée");
        }
    }


    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * formatage de l'objet pour sauvegarder la partie
     * chaque classe @Override la méthode et ajoute toutes les infos pour reconstruire l'objet
     */
    public String saveObject() {
        return "case vide";
    }

    /**
     * affichage court pour la carte de la CLI
     */
    public void afficheMap() {
        System.out.print("  o   ");
    }
}
