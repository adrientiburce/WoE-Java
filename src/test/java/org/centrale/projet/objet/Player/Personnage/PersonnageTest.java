package org.centrale.projet.objet.Player.Personnage;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Objects.Nourriture.Vitamine;
import org.centrale.projet.objet.Objects.Potion.Mana;
import org.centrale.projet.objet.Objects.Potion.Soin;

public class PersonnageTest extends TestCase {

    private Guerrier guerrier;

    private Soin soinVie;

    private Mana mana;

    private Vitamine vitamine;

    protected void setUp() throws Exception {
        new NewWorld(10);
        soinVie = new Soin("vie", 5);
        mana = new Mana("potion magique", 8);
        vitamine = new Vitamine("vitamine", 2, 6);

        guerrier = new Guerrier("Hulk", 70, 50, 12, 100, 32, 20, 90,
                50, 90, 20, new Point2D(3, 3));

        soinVie.putOnMap(new Point2D(2, 3));
        mana.putOnMap(new Point2D(3, 4));
        guerrier.putOnMap(new Point2D(3, 3));
    }

    public void testBoirePotionVie() {
        guerrier.boirePotion(soinVie);
        assertEquals(75, guerrier.getPtVie());
    }

    public void testDeplaceEtBoirePotion() throws Exception {
        // check attributs
        guerrier.deplaceEtBoirePotion(soinVie);
        assertEquals(75, guerrier.getPtVie());

        // check déplacement
        assertSame(guerrier, NewWorld.map.get(new Point2D(2, 3)));
        assertSame(null, NewWorld.map.get(new Point2D(3, 3)));

    }

    public void testDeplaceEtBoirePotionNotOnMap() {
        NewWorld.map.remove(new Point2D(2, 3));
        guerrier.deplaceEtBoirePotion(soinVie);
        assertEquals(70, guerrier.getPtVie());
    }

    public void testBoirePotionMana() {
        guerrier.boirePotion(mana);
        assertEquals(58, guerrier.getPtMana());
    }

    public void testRamasseNourriture() throws Exception {
        vitamine.putOnMap(new Point2D(4, 4));
        assertEquals(0, guerrier.getNourritures().size());

        guerrier.ramasseNourriture(vitamine);
        assertEquals(1, guerrier.getNourritures().size());

        // check déplacement
        assertSame(guerrier, NewWorld.map.get(new Point2D(4, 4)));
        assertSame(null, NewWorld.map.get(new Point2D(3, 3)));
    }


}
