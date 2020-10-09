package org.centrale.projet.objet.Player.Personnage;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.Player.Monstre.Loup;

public class GuerrierTest extends TestCase {

    public void testCombattre() {
        Guerrier attaquant = new Guerrier("Hulk", 70, 50, 12, 100, 32, 20, 90,
                50, 90, 20, new Point2D(21, 23));

        Loup loup = new Loup( "Loup Garou", 70, 70, 12, 33, new Point2D(22, 23));

        attaquant.combattre(loup);
        assertEquals(20, loup.getPtVie());

        loup.setPos(new Point2D(20, 20));
        attaquant.combattre(loup);
        assertEquals(20, loup.getPtVie());
    }
}
