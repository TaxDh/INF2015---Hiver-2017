/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;
import java.text.DecimalFormat ;
import net.sf.json.JSONArray ;
import net.sf.json.JSONObject ;

/**
 *
 * @author DELL
 */
public class Assurer implements Contrat {
    
    public JSONObject faireReclamation (String fichier ){
        
        String mnt;
        double montant;
        double montantRemboursement;
        int numeroSoin;
        DecimalFormat dec = new DecimalFormat("0.00");
        JSONObject reclamationsRemboursements = JSONObject.fromObject(fichier);
        JSONObject remboursements = new JSONObject();
        remboursements.accumulate("client", reclamationsRemboursements.getString("client"));
        remboursements.accumulate("mois", reclamationsRemboursements.getString("mois"));
        JSONArray reclamations = new JSONArray();
        JSONArray reclamationsArray = JSONArray.fromObject(reclamationsRemboursements.get("reclamations"));

        
         for (int i = 0; i < reclamationsArray.size(); i++) {

            JSONObject reclamationArray = reclamationsArray.getJSONObject(i);
            // Creation de tableau representant un remboursement
            JSONObject remboursementArray = new JSONObject();
            remboursementArray.accumulate("soin", reclamationArray.getInt("soin"));
            remboursementArray.accumulate("date", reclamationArray.getString("date"));
            mnt = reclamationArray.getString("montant");
            mnt = Conditions.getMontantSoin(mnt);
            montant = Double.parseDouble(mnt);
            montantRemboursement = 0.0;
            numeroSoin = reclamationArray.getInt("soin");
            String contrat = reclamationsRemboursements.getString("contrat");

            switch (contrat) {

                case CONTRAT_A:
                    if (numeroSoin == numero_soin[0] || numeroSoin == numero_soin[1] || numeroSoin == numero_soin[2] || numeroSoin == numero_soin[6]) {
                        montantRemboursement = montant * pourcentage_remboursement[1];
                    } else if (numeroSoin >= numero_soin[3] && numeroSoin <= numero_soin[5] || numeroSoin == numero_soin[8]) {
                        montantRemboursement = montant * pourcentage_remboursement[0];
                    } else if (numeroSoin == numero_soin[7]) {
                        montantRemboursement = montant * pourcentage_remboursement[2];
                    }
                    break;

                case CONTRAT_B:
                    if (numeroSoin == numero_soin[0]) {
                        montantRemboursement = montant * pourcentage_remboursement[3];
                        if (montantRemboursement > max_rembourser[0]) {
                            montantRemboursement = max_rembourser[0];
                        }
                    } else if (numeroSoin == numero_soin[1] || numeroSoin == numero_soin[6]) {
                        montantRemboursement = montant * pourcentage_remboursement[3];
                        if (montantRemboursement > max_rembourser[1]) {
                            montantRemboursement = max_rembourser[1];
                        }
                    } else if (numeroSoin == numero_soin[2]) {
                        montantRemboursement = montant;
                        if (montantRemboursement > max_rembourser[3]) {
                            montantRemboursement = max_rembourser[3];
                        }
                    } else if (numeroSoin >= numero_soin[3] && numeroSoin <= numero_soin[4]) {
                        montantRemboursement = montant * pourcentage_remboursement[3];
                    } else if (numeroSoin == numero_soin[5]) {
                        montantRemboursement = montant * pourcentage_remboursement[0];
                    } else if (numeroSoin == numero_soin[7]) {
                        montantRemboursement = montant * pourcentage_remboursement[6];
                    } else if (numeroSoin == numero_soin[8]) {
                        montantRemboursement = montant * pourcentage_remboursement[4];
                    }
                    break;

                case CONTRAT_C:
                    if (Conditions.validerNumeroSoin(numeroSoin + "")) {
                        montantRemboursement = montant * pourcentage_remboursement[5];
                    }
                    break;

                case CONTRAT_D:
                    montantRemboursement = montant * pourcentage_remboursement[6];
                    if (numeroSoin == numero_soin[0] && montant > max_rembourser[5]) {
                        montantRemboursement = max_rembourser[5];
                    } else if (numeroSoin == numero_soin[1] || numeroSoin == numero_soin[6] && montant > max_rembourser[4]) {
                        montantRemboursement = max_rembourser[4];
                    } else if (numeroSoin == numero_soin[2] || numeroSoin == numero_soin[7] && montant > max_rembourser[7]) {
                        montantRemboursement = max_rembourser[7];
                    } else if (numeroSoin == numero_soin[5] && montant > max_rembourser[2]) {
                        montantRemboursement = max_rembourser[2];
                    } else if (numeroSoin == numero_soin[8] && montant > max_rembourser[6]) {
                        montantRemboursement = max_rembourser[6];
                    }
                    break;
            }

            remboursementArray.accumulate("montant", dec.format(montantRemboursement) + "$");
            reclamations.add(remboursementArray);
        }
         
         
          remboursements.accumulate("remboursements", reclamations);

        return remboursements;
         
        
    } 

    
}
