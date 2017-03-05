/*
 *  l'objet que deviendra le fichier json
 */
package projetagile.jsonmodels;

import java.util.ArrayList;
import java.util.List;


public class ModeleJsonOut {
    private String dossier;
    private String mois;
    private List<Remboursement> remboursement;//c'est le meme objet que jsonIn

    //ne sert a rien de construire l'objet avec parametre
    public ModeleJsonOut() {
        this.remboursement = new ArrayList<>();
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
        return remboursement;
    }

    public void setRemboursement(List<Remboursement> emboursement) {
        this.remboursement = remboursement;
    }
    
    public void addRemboursement(Remboursement nouveauRemboursement) {
        remboursement.add(nouveauRemboursement);
    }
}
