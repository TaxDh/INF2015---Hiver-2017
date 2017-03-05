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
    private static  JSONObject root;
    private static JSONArray reclamations;
    private static ModeleJsonIn modele;
    private static String jsonText;
    private static String dossier;
    private static String mois;
    
    public static ModeleJsonIn ouvrireFichier(String filePath) throws InvalidArgumentException {
            try {
                initialiserObjetsJSON(filePath);
            } catch(IOException e) {
                System.out.println("Erreur lors de la lecture du fichier JSON. " + e.getLocalizedMessage());
                System.exit(1);
            }
            if(estNumeroDossierValide(dossier)){
                modele = new ModeleJsonIn(dossier.substring(1), dossier.substring(0,1).charAt(0), mois);
            } else {
                throw new InvalidArgumentException("Arguments invalides");
            }
            createReclamations(reclamations);
            return modele;
    }

    private static void initialiserObjetsJSON(String filePath) throws IOException {
        jsonText = Utf8File.loadFileIntoString(filePath);
        root = (JSONObject) JSONSerializer.toJSON(jsonText);
        reclamations = root.getJSONArray("reclamations");
        dossier = root.getString("dossier");
        mois = root.getString("mois");
    }
    
    

    public static void createReclamations(JSONArray reclamations) throws InvalidArgumentException {
    
           for(int i = 0; i < reclamations.size(); i++){
            //cree reclamation
                    JSONObject reclamationCourrante = reclamations.getJSONObject(i);
                    Reclamation nouvelleReclamation = new Reclamation();
                    
                    traiterSoinsReclamation(reclamationCourrante, nouvelleReclamation);
                    traiterDateReclamation(reclamationCourrante, nouvelleReclamation);
                    traiterMontantReclamation(reclamationCourrante, nouvelleReclamation);
        }
        
    }

    private static void traiterMontantReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation) {
        String montant = reclamationCourrante.getString("montant");
        nouvelleReclamation.setMontant(montant);
        modele.addReclamation(nouvelleReclamation);
    }

    private static void traiterDateReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        String date = reclamationCourrante.getString("date");
        if(estDateValide(date, modele.getMois())) nouvelleReclamation.setDate(date);
        else throw new InvalidArgumentException("Arguments invalides");
    }

    private static void traiterSoinsReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        int soin = reclamationCourrante.getInt("soin");
        //test soin
        if(estNumeroSoinValide(soin)) nouvelleReclamation.setSoins(soin);
        else throw new InvalidArgumentException("Arguments invalides");
    }
    
    public static void ecrireFichier(String filePath, ModeleJsonOut modeleOut) {
        
        JSONObject remboursement = new JSONObject();
        
        remboursement.accumulate("dossier", modeleOut.getDossier());
        remboursement.accumulate("mois", modeleOut.getMois());
        JSONArray remboursementTab = new JSONArray();//tableau de remboursement
        for(Remboursement remboursementCourant : modeleOut.getRemboursement()){
            JSONObject objetCourant = new JSONObject();
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
        return dossier.length() == 7 && dossier.matches("[A-E][0-9]{6}");  
    }
    

    private static boolean estNumeroSoinValide(int soin){
        return soin == 0 || soin == 100 || soin == 150 || soin == 175 ||
                soin == 200 || (soin >= 300 && soin <= 400)|| 
                soin == 500 || soin == 600 || soin == 700;
    }
    
    private static boolean estDateValide(String date, String mois){
        String test = date.substring(0, 7);
        return test.equals(mois);
    }
        
    
}
