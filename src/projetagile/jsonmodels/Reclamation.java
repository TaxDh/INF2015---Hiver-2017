/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile.jsonmodels;
import projetagile.Dollar;

/**
 *
 * @author rene
 */
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
