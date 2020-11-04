package org.centrale.projet.objet.Objects;

import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Combattant;
import org.centrale.projet.objet.Player.Creature;
import org.centrale.projet.objet.Player.Deplacable;

public class NuageToxique implements Combattant, Deplacable {
    @Override
    public void combattre(Creature defenseur) {

    }

    @Override
    public boolean move(Point2D newPos) {
        return false;
    }
}
