package org.centrale.projet.objet.Grille;

import org.centrale.projet.objet.World;

import java.util.Objects;
import java.util.Random;

public class Point2D {

    private int x;

    private int y;


    /**
     * génération d'un point avec une position aléatoire sur notre grille de World.TAILLE_GRILLE*World.TAILLE_GRILLE
     */
    public Point2D() {
        Random radomGenerator = new Random();
        this.x = radomGenerator.nextInt(World.TAILLE_GRILLE);
        this.y = radomGenerator.nextInt(World.TAILLE_GRILLE);
    }


    public Point2D(int x, int y) {
        if (x <= World.TAILLE_GRILLE && y <= World.TAILLE_GRILLE) {
            this.x = x;
            this.y = y;
        } else {
            // on vérifie que les coordonées sont dans la grille,
            // si en dehors on réaffecte aléatoirement
            Random radomGenerator = new Random();
            this.x = radomGenerator.nextInt(World.TAILLE_GRILLE + 1);
            this.y = radomGenerator.nextInt(World.TAILLE_GRILLE + 1);
        }
    }

    public Point2D(Point2D point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void affiche() {
        System.out.println("[" + this.x + ";" + this.y + "]");
    }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * genere aléatoirement la prochaine positon d'un perso
     */
    public void getNextPosition() {
        Random radomGenerator = new Random();
        int dX = 0;
        int dY = 0;
        // we check next position is not the same
        while (dX == 0 && dY == 0) {
            dX = radomGenerator.nextInt(3) - 1;
            dY = radomGenerator.nextInt(3) - 1;
        }
        this.translater(dX, dY);
    }

    /**
     * translatte un point en vérifiant qu'il reste dans la grille
     *
     * @param dx distance de translation selon X
     * @param dy distance de translation selon Y
     */
    public void translater(int dx, int dy) {
        this.x += dx;
        this.y += dy;

        // si x sort de la grille on le met en bordure de la grille.
        if (this.x > World.TAILLE_GRILLE) {
            this.x = World.TAILLE_GRILLE;
        } else if (this.x < 0) {
            this.x = 0;
        }
        // même chose pour y
        if (this.y > World.TAILLE_GRILLE) {
            this.y = World.TAILLE_GRILLE;
        } else if (this.y < 0) {
            this.y = 0;
        }
    }

    public boolean isPositionValable() {
        // si x sort de la grille
        if (this.x > World.TAILLE_GRILLE | this.x <= 0) {
            return false;
        }
        // même chose pour y
        if (this.y > World.TAILLE_GRILLE | this.y <= 0) {
            return false;
        }
        return true;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x <= World.TAILLE_GRILLE && x >= 0) {
            this.x = x;
        } else {
            Random radomGenerator = new Random();
            this.x = radomGenerator.nextInt(World.TAILLE_GRILLE + 1);
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0 && y <= World.TAILLE_GRILLE) {
            this.y = y;
        } else {
            Random radomGenerator = new Random();
            this.y = radomGenerator.nextInt(World.TAILLE_GRILLE + 1);
        }
    }

    public double distance(Point2D point) {
        return Math.sqrt(Math.pow(this.y - point.y, 2) + Math.pow(this.x - point.x, 2));
    }

    @Override
    public String toString() {
        return "[" + this.x + ";" + this.y + "]";
    }


    /**
     * override equals for our HashMap of position
     *
     * @param o objet à tester
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Point2D)) {
            return false;
        }
        Point2D pt = (Point2D) o;
        return x == pt.x && y == pt.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
