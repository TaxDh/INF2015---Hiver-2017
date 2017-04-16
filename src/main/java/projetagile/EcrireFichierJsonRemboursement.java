/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Remboursement;

public class EcrireFichierJsonRemboursement {

    public static void ajoutRemboursementJson(JSONObject remboursement, ModeleJsonOut modeleOut, JSONArray remboursementTab, Dollar montantTotal) {
        remboursement.accumulate("dossier", modeleOut.getDossier());
        remboursement.accumulate("mois", modeleOut.getMois());
        ajoutSoinDateMontantJson(modeleOut, remboursementTab, montantTotal);
        remboursement.accumulate("remboursements", remboursementTab);
        remboursement.accumulate("total", montantTotal.convertirEnStringDollar());
    }

    public static void ajoutSoinDateMontantJson(ModeleJsonOut modeleOut, JSONArray remboursementTab, Dollar montantTotal) {
        for (int i = 0; i < modeleOut.getRemboursement().size(); i++) {
            JSONObject objetCourant = new JSONObject();
            Remboursement remboursementCourant = modeleOut.getRemboursement().get(i);
            objetCourant.accumulate("soin", remboursementCourant.getSoins());
            objetCourant.accumulate("date", remboursementCourant.getDate());
            objetCourant.accumulate("montant", remboursementCourant.getMontant().convertirEnStringDollar());
            remboursementTab.add(objetCourant);
            montantTotal.additionDollar(remboursementCourant.getMontant());
        }
    }

    public static void ecrireFichier(String fichierSortie, ModeleJsonOut modeleOut) {
        JSONObject remboursement = new JSONObject();
        Dollar montantTotal = new Dollar();
        JSONArray remboursementTab = new JSONArray();
        ajoutRemboursementJson(remboursement, modeleOut, remboursementTab, montantTotal);
        try {
            Utf8File.saveStringIntoFile(fichierSortie, remboursement.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }
    
}
