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
import projetagile.InvalidArgumentException;
/**
 *
 * @author rene
 */
public class JsonFileHandler {
    private static  JSONObject racine;
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
            creationModeleJsonIn();
            return modele;
    }
    
    public static void ecrireFichier(String filePath, ModeleJsonOut modeleOut) {
        
        JSONObject remboursement = EcritureJsonObjetSortie(modeleOut);   
        try {
            Utf8File.saveStringIntoFile(filePath, remboursement.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }
    
    private static void creationModeleJsonIn() throws InvalidArgumentException {
        
        if(estNumeroDossierValide(dossier)){
        modele = new ModeleJsonIn(dossier.substring(1), dossier.substring(0,1).charAt(0), mois);
        } else {
            throw new InvalidArgumentException("Erreur! Le numero de dossier est invalide.");
        }
        
        createReclamations(reclamations);
    }

    private static void initialiserObjetsJSON(String filePath) throws IOException, InvalidArgumentException {
        jsonText = Utf8File.loadFileIntoString(filePath);
        racine = (JSONObject) JSONSerializer.toJSON(jsonText);
        exceptionProprieteJsonReclamation();
        exceptionProprieteJsonDossier();
        exceptionProprieteJsonMois();
    }

    public static void createReclamations(JSONArray reclamations) throws InvalidArgumentException {
    
           for(int i = 0; i < reclamations.size(); i++){
                    JSONObject reclamationCourrante = reclamations.getJSONObject(i);
                    Reclamation nouvelleReclamation = new Reclamation();
                    
                    traiterSoinsReclamation(reclamationCourrante, nouvelleReclamation);
                    traiterDateReclamation(reclamationCourrante, nouvelleReclamation);
                    traiterMontantReclamation(reclamationCourrante, nouvelleReclamation);
        }
        
    }

    private static void traiterMontantReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {
        String montant = "";
        montant = exceptionProprieteJsonMontant(montant, reclamationCourrante);
        nouvelleReclamation.setMontant(montant);
        modele.addReclamation(nouvelleReclamation);
    }

    private static String exceptionProprieteJsonMontant(String montant, JSONObject reclamationCourrante) throws InvalidArgumentException {
        try {
            montant = reclamationCourrante.getString("montant");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le montant n'est pas présent.");
        }
        return montant;
    }

    private static JSONObject EcritureJsonObjetSortie(ModeleJsonOut modeleOut) {
        double montantCourant, montantTotal = 0;
        String montant = "";
        
        JSONObject remboursement = new JSONObject();
        JSONArray remboursementTab = EcritureEnTeteSortieJson(remboursement, modeleOut);
        
        montantTotal = parcoursDeToutLesRemboursement(modeleOut, remboursementTab, montantTotal);
        
        montant = totalDevienString(modeleOut, montantTotal);
        
        ajoutJsonRemboursementEtTotal(remboursement, remboursementTab, montant);
        return remboursement;
    }

    private static String totalDevienString(ModeleJsonOut modeleOut, double montantTotal) {
        String montant;
        modeleOut.setTotal(montantTotal);
        montant = modeleOut.totalEnString(modeleOut.getTotal());
        return montant;
    }

    private static void ajoutJsonRemboursementEtTotal(JSONObject remboursement, JSONArray remboursementTab, String montant) {
        remboursement.accumulate("remboursements", remboursementTab);
        remboursement.accumulate("total", montant);
    }

    private static double parcoursDeToutLesRemboursement(ModeleJsonOut modeleOut, JSONArray remboursementTab, double montantTotal) {
        double montantCourant;
        for(Remboursement remboursementCourant : modeleOut.getRemboursement()){
            JSONObject objetCourant = new JSONObject();
            ajoutSoinDateMontantAJson(objetCourant, remboursementCourant);
            remboursementTab.add(objetCourant);
            montantTotal = calculMontantTotal(remboursementCourant, montantTotal);
        }
        return montantTotal;
    }

    private static void ajoutSoinDateMontantAJson(JSONObject objetCourant, Remboursement remboursementCourant) {
        objetCourant.accumulate("soin", remboursementCourant.getSoins());
        objetCourant.accumulate("date", remboursementCourant.getDate());
        objetCourant.accumulate("montant", remboursementCourant.getMontant());
    }

    private static double calculMontantTotal(Remboursement remboursementCourant, double montantTotal) {
        double montantCourant;
        montantCourant = Dollar.convertirStringEnDouble(remboursementCourant.getMontant());
        montantTotal += montantCourant;
        return montantTotal;
    }

    private static JSONArray EcritureEnTeteSortieJson(JSONObject remboursement, ModeleJsonOut modeleOut) {
        remboursement.accumulate("dossier", modeleOut.getDossier());
        remboursement.accumulate("mois", modeleOut.getMois());
        JSONArray remboursementTab = new JSONArray();//tableau de remboursement
        return remboursementTab;
    }

    public static void ecrireFichierErreur(String filePath, Exception e){
        JSONObject erreur = new JSONObject();
        erreur.accumulate("message", e.getLocalizedMessage());
        
        try {
            Utf8File.saveStringIntoFile(filePath, erreur.toString(4));
            
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }
    
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
    
    private static void exceptionProprieteJsonMois() throws InvalidArgumentException {
        try{
            mois = racine.getString("mois");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le mois n'est pas présent.");
        }
    }

    private static void exceptionProprieteJsonDossier() throws InvalidArgumentException {
        try{
            dossier = racine.getString("dossier");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le dossier n'est pas présent.");
        }
    }

    private static void exceptionProprieteJsonReclamation() throws InvalidArgumentException {
        try{
            reclamations = racine.getJSONArray("reclamations");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de réclamations.");
        }
    }
    
    private static void traiterDateReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {
        try {
            String date = reclamationCourrante.getString("date");
            if(estDateValide(date, modele.getMois())){
                nouvelleReclamation.setDate(date);
            }
            else {
                throw new InvalidArgumentException("Erreur! La date est invalide");
            }
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! La date n'est pas présente.");
        }
    }

    private static void traiterSoinsReclamation(JSONObject reclamationCourrante, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {
        try{
            validationErreurNumeroSoin(reclamationCourrante, nouvelleReclamation);
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le numéro de soin n'est pas présent.");
        }
    }

    private static void validationErreurNumeroSoin(JSONObject reclamationCourrante, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        int soin = reclamationCourrante.getInt("soin");
        //test soin
        if(estNumeroSoinValide(soin)){
            nouvelleReclamation.setSoins(soin);
        }
        else {
            throw new InvalidArgumentException("Erreur! Le numero de soin est invalide");
        }
    }
}
