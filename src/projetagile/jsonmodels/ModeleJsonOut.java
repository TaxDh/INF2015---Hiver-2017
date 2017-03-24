/*
 *  l'objet que deviendra le fichier json
 */
package projetagile.jsonmodels;

import java.util.ArrayList;
import java.util.List;
import projetagile.Dollar;
import projetagile.InterfaceContrat;


public class ModeleJsonOut {
    private String dossier;
    private String mois;
    private List<Remboursement> remboursements;//c'est le meme objet que jsonIn
    private double total = 0;

    //ne sert a rien de construire l'objet avec parametre
    public ModeleJsonOut() {
        this.remboursements = new ArrayList<>();
    }

 
    public String getDossier() {
        return dossier;
    }

    public void setDossier(String client) {
        this.dossier = client;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
    
    public List<Remboursement> getRemboursement() {
        return remboursements;
    }

    public void setRemboursement(List<Remboursement> remboursements) {
        this.remboursements = remboursements;
    }
    
    public void addRemboursement(Remboursement nouveauRemboursement) {
        remboursements.add(nouveauRemboursement);
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public String totalEnString(double total){
        return Dollar.convertirDoubleEnString(total);
    }
}
