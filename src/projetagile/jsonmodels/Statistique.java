/*
 * L'objet statistique pour le fichier json statistique
 */
package projetagile.jsonmodels;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rene
 */
public class Statistique {
    private int reclamationValide;
    private int reclamationRejete;
    private List<StatSoin> soin;

    
    
    public Statistique(int reclamationValide, int reclamationRejete){
        this.reclamationValide = reclamationValide;
        this.reclamationRejete = reclamationRejete;
        this.soin = new ArrayList<>();
    }
    
     public Statistique(){
        this.soin = new ArrayList<>();
    }
     
    public int getReclamationValide() {
        return reclamationValide;
    }

    public void setReclamationValide(int reclamationValide) {
        this.reclamationValide = reclamationValide;
    }

    public int getReclamationRejete() {
        return reclamationRejete;
    }

    public void setReclamationRejete(int reclamationRejete) {
        this.reclamationRejete = reclamationRejete;
    }

    public List<StatSoin> getSoin() {
        return soin;
    }

    public void setSoin(List<StatSoin> soin) {
        this.soin = soin;
    }
    
    public void ajouterSoin(StatSoin nouveauSoin) {
        soin.add(nouveauSoin);
    }
   
}
