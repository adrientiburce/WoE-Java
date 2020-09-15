package org.centrale.projet.objet;

public class Archer extends Personnage {

    private int nbFleches;

    public Archer() {
        super();
        this.setNom("un archer");
        this.nbFleches = 0;
    }

    public Archer(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos, int nbFleches) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
        this.nbFleches = nbFleches;
    }

    /**
     * constructeur par recopie
     * @param a
     */
    public Archer(Archer a) {
        super(a.getNom(), a.getPtVie(), a.getPtMana(), a.getPourcentageAtt(), a.getPourcentagePar(), a.getPourcentageMag(), a.getPourcentageResistMag(), a.getDegAtt(), a.getDegMag(), a.getDistAttMax(), a.getPos());
        this.nbFleches = a.nbFleches;
    }

    public void affiche() {
        System.out.println("Archer{" +
                "nbFleches=" + nbFleches +
                "} " + super.toString());
    }
}
