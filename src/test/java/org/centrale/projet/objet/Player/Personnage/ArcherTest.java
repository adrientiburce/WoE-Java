package org.centrale.projet.objet.Player.Personnage;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;

public class ArcherTest extends TestCase {

    private Archer attaquant;

    private Archer defenseur;

    protected void setUp() throws Exception {
        super.setUp();
        attaquant = new Archer("Attaquant", 90, 50, 10, 100, 88, 100, 80,
                25, 40, 15, new Point2D(18, 19), 11);

        defenseur = new Archer("Defenseur", 90, 50, 10, 85, 0, 20, 0,
                18, 40, 15, new Point2D(18, 21), 3);
    }

    public void testCombattre() {
        attaquant.combattre(defenseur);
        assertEquals(90 - 25, defenseur.getPtVie());
        assertEquals(10, attaquant.getNbFleches());
    }

    public void testPointDeViePositif() {
        defenseur.setPtVie(20);
        attaquant.combattre(defenseur);
        assertEquals(0, defenseur.getPtVie());
    }

    public void testCombatSansFleches() {
        attaquant.setNbFleches(0);
        attaquant.combattre(defenseur);
        assertEquals(90, defenseur.getPtVie());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        attaquant = null;
        defenseur = null;
    }
}
