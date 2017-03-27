/*
 * l'objet json que le programme lit.
*/
package projetagile.jsonmodels;

import java.util.ArrayList;
import java.util.List;

public class ModeleJsonIn {
    private String client;
    private char typeContrat;
    private String mois;
    private List<Reclamation> reclamations;

    public ModeleJsonIn(String client, char typeContrat, String mois) {
        this.client = client;
        this.typeContrat = typeContrat;
        this.mois = mois;
        this.reclamations = new ArrayList<>();
    }

    public ModeleJsonIn() {
        this.reclamations = new ArrayList<>();
    }

    
    
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public char getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(char typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
    
    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }
    
    public void ajouterReclamation(Reclamation nouvelleReclamation) {
        reclamations.add(nouvelleReclamation);
    }
    
}
