/*
 * Objet reclamation, celui qui se trouve dans le tableau reclamation
 */
package projetagile.jsonmodels;
import projetagile.Dollar;

public class Reclamation {
    
    private int soins;
    private String date;
    private Dollar montant;

    public Reclamation() {
    }

    public Reclamation(int soins, String date, Dollar montant) {
        this.soins = soins;
        this.date = date;
        this.montant = montant;
    }
    
    
    
    public int getSoins() {
        return soins;
    }

    public String getDate() {
        return date;
    }

    public Dollar getMontant() {
        return montant;
    }

    public void setSoins(int soins) {
        this.soins = soins;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMontant(Dollar montant) {
        this.montant = montant;
    }

}
