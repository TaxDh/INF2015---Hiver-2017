/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Remboursement;
/**
 *
 * @author rene
 */
public class JsonFileHandler {
    public  static  JSONObject root;
    public  static JSONArray reclamations = root.getJSONArray("reclamations");
    public static ModeleJsonIn modele;
    public static String jsonText = "";
    public static String dossier = root.getString("client");
    public static String mois = root.getString("mois");
    public static ModeleJsonIn ouvrireFichier(String filePath) throws InvalidArgumentException {
        try {      jsonText = Utf8File.loadFileIntoString(filePath);
        }catch(IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON. " + e.getLocalizedMessage());
            System.exit(1);
        }
        try{ root = (JSONObject) JSONSerializer.toJSON(jsonText);            
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Arguments invalides");         
        }
        if(estNumeroDossierValide(dossier)){
            modele.setClient(dossier.substring(1));    modele.setTypeContrat(dossier.substring(0,1).charAt(0));
        } else {            throw new InvalidArgumentException("Arguments invalides");        }
        modele.setMois(mois);
        forMethode(reclamations);
        return modele;
    }//fin ouvrireFichier

    public static void forMethode(JSONArray reclamations) throws InvalidArgumentException {
    
           for(int i = 0; i < reclamations.size(); i++){
            //cree reclamation
            Reclamation nouvelleReclamation = new Reclamation();
            JSONObject reclamationCourrante = reclamations.getJSONObject(i);
            int soin = reclamationCourrante.getInt("soin");
            //test soin
            if(estNumeroSoinValide(soin)){
                nouvelleReclamation.setSoins(soin);
            } else {
                throw new InvalidArgumentException("Arguments invalides");
            }
            //get and test date
            
            String date = reclamationCourrante.getString("date");
            
            if(estDateValide(date, modele.getMois())){
                nouvelleReclamation.setDate(date);
            } else {
                throw new InvalidArgumentException("Arguments invalides");
            }
            
            String montant = reclamationCourrante.getString("montant");
            nouvelleReclamation.setMontant(montant);
            modele.addReclamation(nouvelleReclamation);
        }
    
    
    
    
    
    }
    
    public static void ecrireFichier(String filePath, ModeleJsonOut modeleOut) {
        JSONObject remboursement = new JSONObject();
        remboursement.accumulate("client", modeleOut.getClient());
        remboursement.accumulate("mois", modeleOut.getMois());
        JSONArray remboursementTab = new JSONArray();//tableau de remboursement
        for(int i = 0; i < modeleOut.getRemboursement().size(); i++){
            JSONObject objetCourant = new JSONObject();
            Remboursement remboursementCourant = modeleOut.getRemboursement().get(i); 
            objetCourant.accumulate("soin", remboursementCourant.getSoins());
            objetCourant.accumulate("date", remboursementCourant.getDate());
            objetCourant.accumulate("montant", remboursementCourant.getMontant());
            remboursementTab.add(objetCourant);
        } 
        remboursement.accumulate("remboursements", remboursementTab);   
        try {
            Utf8File.saveStringIntoFile(filePath, remboursement.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }

    }

    public static void ecrireFichierErreur(String filePath){
        JSONObject erreur = new JSONObject();
        erreur.accumulate("message", "Données invalides");
        
        try {
            Utf8File.saveStringIntoFile(filePath, erreur.toString(4));
            
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }
    
    /*methode pour traiter les erreurs*/
    private static boolean estNumeroDossierValide(String dossier) {
        return dossier.substring(0,1).matches("[A-E]+") && dossier.length() == 7 && dossier.substring(1).matches("[09]+");    
    }
    

    private static boolean estNumeroSoinValide(int soin){
        return soin == 0 || soin == 100 || soin == 200 || (soin >= 300 && soin <= 400)
                || soin == 500 || soin == 600 || soin == 700;
    }
    
    private static boolean estDateValide(String date, String mois){
        String test = date.substring(0, 7);
        return test.equals(mois);
    }
        
    
}
