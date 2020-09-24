package org.centrale.projet.objet.Grille;

import java.util.Random;

public class Point2D {

    private int x;

    private int y;

    /**
     * génération d'un point avec une position aléatoire sur notre grille de 100*100
     */
    public Point2D() {
        Random radomGenerator = new Random();
        this.x = radomGenerator.nextInt(101);
        this.y = radomGenerator.nextInt(101);
    }


    public Point2D(int x, int y) {
        if (x <= 100 && y <= 100) {
            this.x = x;
            this.y = y;
        } else {
            // on vérifie que les coordonées sont dans la grille,
            // si en dehors on réaffecte aléatoirement
            Random radomGenerator = new Random();
            this.x = radomGenerator.nextInt(101);
            this.y = radomGenerator.nextInt(101);
        }
    }

    public Point2D(Point2D point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void affiche() {
        System.out.println("[" + this.x + " ; " + this.y + "]");
    }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void translater(int dx, int dy) {
        this.x += dx;
        this.y += dy;

        // si x sort de la grille on le met en bordure de la grille.
        if (this.x > 100) {
            this.x = 100;
        } else if (this.x < 0) {
            this.x = 0;
        }
        // même chose pour y
        if (this.y > 100) {
            this.y = 100;
        } else if (this.y < 0) {
            this.y = 0;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x <= 100 && x >= 0) {
            this.x = x;
        } else {
            Random radomGenerator = new Random();
            this.x = radomGenerator.nextInt(101);
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0 && y <= 100) {
            this.y = y;
        } else {
            Random radomGenerator = new Random();
            this.y = radomGenerator.nextInt(101);
        }
    }

    public double getDistance(Point2D point) {
        return Math.sqrt((this.y - point.y) * (this.y - point.y) + (this.x - point.x) * (this.x - point.x));
    }

    @Override
    public String toString() {
        return "[" + this.x + " ; " + this.y + "]";
    }
}
