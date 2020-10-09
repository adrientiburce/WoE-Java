package org.centrale.projet.objet.Player.Personnage;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;

public class MageTest extends TestCase {

    private Mage attaquant;

    private Mage defenseur;

    protected void setUp() throws Exception {
        super.setUp();
        attaquant = new Mage("attaquant", 90, 50, 10, 50, 88, 100, 80,
                25, 40, 15, new Point2D(18, 20));

        defenseur = new Mage("defenseur", 90, 50, 10, 85, 50, 20, 0,
                18, 40, 15, new Point2D(18, 18));
    }

    public void testCombattreSansParade() {
        attaquant.combattre(defenseur);
        assertEquals(90 - 40, defenseur.getPtVie());
        assertEquals(49, attaquant.getPtMana());
    }

    public void testCombattreAvecParade() {
        defenseur.setPourcentageResistMag(100);
        attaquant.combattre(defenseur);
        assertEquals(90 - 40 + 10, defenseur.getPtVie());
        assertEquals(49, attaquant.getPtMana());
    }

    public void testCombattreSansPtMana() {
        attaquant.setPtMana(0);
        attaquant.combattre(defenseur);
        assertEquals(90, defenseur.getPtVie());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        attaquant = null;
        defenseur = null;
    }
}
