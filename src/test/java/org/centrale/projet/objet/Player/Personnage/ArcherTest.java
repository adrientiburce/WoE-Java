package org.centrale.projet.objet.Player.Personnage;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Nourriture.CigueToxique;
import org.centrale.projet.objet.Objects.Nourriture.VitamineB2;

public class ArcherTest extends TestCase {

    private Archer attaquant;

    private Archer defenseur;

    private VitamineB2 vitamine;
    private CigueToxique cigue;


    protected void setUp() throws Exception {
        super.setUp();
        attaquant = new Archer("Attaquant", 90, 50, 10, 100, 88, 100, 80,
                25, 40, 15, new Point2D(18, 19), 11);
        defenseur = new Archer("Defenseur", 90, 50, 10, 85, 0, 20, 0,
                18, 40, 15, new Point2D(18, 21), 3);


        new NewWorld(10);
        vitamine = new VitamineB2("vitamine", 2, 6);
        cigue = new CigueToxique("cigue", 1, 3);
        vitamine.putOnMap(new Point2D(18, 18));
        cigue.putOnMap(new Point2D(19, 19));
    }

    public void testCombattre() {
        attaquant.combattre(defenseur);
        assertEquals(90 - 25, defenseur.getPtVie());
        assertEquals(10, attaquant.getNbFleches());
    }

    public void testCombatPointDeViePositif() {
        defenseur.setPtVie(20);
        attaquant.combattre(defenseur);
        assertEquals(0, defenseur.getPtVie());
    }

    public void testCombatSansFleches() {
        attaquant.setNbFleches(0);
        attaquant.combattre(defenseur);
        assertEquals(90, defenseur.getPtVie());
    }

    public void testCombatAvecVitamine() {
        attaquant.ramasseNourriture(vitamine);
        attaquant.combattre(defenseur);
        // prend en compte le bonus vitamine
        assertEquals(90 - 25 - 6, defenseur.getPtVie());
        assertEquals(1, vitamine.getDureeEffet());
    }

    public void testCombatAvecCigueDureeUnique() {
        attaquant.ramasseNourriture(cigue);
        attaquant.combattre(defenseur);
        // prend en compte le malus
        assertEquals(90 - 25 + 3, defenseur.getPtVie());
        assertEquals(0, attaquant.getNourritures().size());
    }

    public void testCombatAvecBonusEtMalus() {
        attaquant.ramasseNourriture(vitamine);
        attaquant.ramasseNourriture(cigue);
        assertEquals(2, attaquant.getNourritures().size());

        attaquant.combattre(defenseur);
        assertEquals(90 - 25 - 6 + 3, defenseur.getPtVie());
        assertEquals(1, attaquant.getNourritures().size());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        attaquant = null;
        defenseur = null;
    }
}
