/*
 * Objet contenant les statistiques pour chaque soin.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public abstract class MontantSoinStats {

    protected int compteur;
    protected Dollar somme;
    protected Dollar maximum;

    public MontantSoinStats() {
        compteur = 0;
        somme = new Dollar("0.00$");
        maximum = new Dollar("0.00$");
    }

    public MontantSoinStats(int compteur, Dollar somme, Dollar maximum) {
        this.compteur = compteur;
        this.somme = somme;
        this.maximum = maximum;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public Dollar getSomme() {
        return somme;
    }

    public void setSomme(Dollar somme) {
        this.somme = somme;
    }

    public Dollar getMaximum() {
        return maximum;
    }

    public void setMaximum(Dollar maximum) {
        this.maximum = maximum;
    }

    public void incrementerCompteur() {
        this.compteur++;
    }

    public void additionnerCompteur(int valeur) {
        this.compteur += valeur;
    }

    public void ajouterSomme(Dollar montant) {
        this.somme.additionDollar(montant);
    }

    public Dollar calculerMoyenne() {
        return this.somme.divisionDollarParInt(compteur);
    }
}
