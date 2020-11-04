package org.centrale.projet.objet.Grille;

import junit.framework.TestCase;

public class Point2DTest extends TestCase {

    public void testAffiche() {
        assertEquals("[2;3]", (new Point2D(2, 3)).toString());
    }

    public void testTranslater() {
        Point2D pt = new Point2D(2, 3);
        Point2D pt1 = pt.translater(2, 5);
        assertEquals(new Point2D(4, 8), pt1);

        Point2D pt2 = pt1.translater(-5, -2);
        assertEquals(new Point2D(0, 6), pt2);
    }

    public void testDistance() {
        Point2D origine = new Point2D(0, 0);
        Point2D pt1 = new Point2D(0, 10);
        Point2D pt2 = new Point2D(4, 13);

        assertEquals(10.0, origine.distance(pt1));
        assertEquals(5.0, pt1.distance(pt2));
        assertEquals(5.0, pt2.distance(pt1));
    }
}
