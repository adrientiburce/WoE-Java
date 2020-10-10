package org.centrale.projet.objet.Player;

import junit.framework.TestCase;
import org.centrale.projet.objet.Grille.Point2D;
import org.centrale.projet.objet.NewWorld;
import org.centrale.projet.objet.Player.Personnage.Archer;

public class CreatureTest extends TestCase {


    private Archer archer;


    protected void setUp() throws Exception {
        new NewWorld(10);
        archer = new Archer("Attaquant", 90, 50, 10, 100, 88, 100, 80,
                25, 40, 15, new Point2D(18, 19), 11);

        archer.putOnMap(new Point2D(4, 4));
    }

    public void testMove() {
        assertSame(archer, NewWorld.map.get(new Point2D(4, 4)));
        archer.move(new Point2D(3, 4));
        assertSame(archer, NewWorld.map.get(new Point2D(3, 4)));
        assertSame(null, NewWorld.map.get(new Point2D(4, 4)));
    }

    public void testIllegalMove() {
        archer.move(new Point2D(2, 4));
        assertSame(archer, NewWorld.map.get(new Point2D(4, 4)));
        assertSame(null, NewWorld.map.get(new Point2D(2, 4)));
    }
}
