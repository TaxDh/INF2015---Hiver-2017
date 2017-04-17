/*
 * l'objet que deviendra le fichier json.
 */
package projetagile.jsonmodels;

import java.util.ArrayList;
import java.util.List;

public class ModeleJsonOut {

    private String dossier;
    private String mois;
    private List<Remboursement> remboursement;
    private String totalStr;

    public ModeleJsonOut() {
        this.remboursement = new ArrayList<>();
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
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

    public void ajouterRemboursement(Remboursement nouveauRemboursement) {
        remboursement.add(nouveauRemboursement);
    }

    public String getTotalStr() {
        return totalStr;
    }

    public void setTotalStr(String totalStr) {
        this.totalStr = totalStr;
    }
}
