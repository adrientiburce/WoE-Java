package org.centrale.projet.objet.Player;

import org.centrale.projet.objet.Player.Personnage.Personnage;

public interface Combattant {

    /**
     * méthode pour combattre une autre créature
     */
    public void combattre(Creature defenseur);
}
