/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Remboursement;
import projetagile.jsonmodels.Statistique;
/**
 *
 * @author rene
 */
public class JsonFileHandler {
    
    public static ModeleJsonIn ouvrireFichier(String fichierEntree) throws InvalidArgumentException {
        ModeleJsonIn modele = new ModeleJsonIn();
        String jsonText = "";
        JSONObject racine;
        String numeroDossier;
        String mois;
        JSONArray reclamations;
         
        try {
            jsonText = Utf8File.loadFileIntoString(fichierEntree);
        }catch(IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON. " + e.getLocalizedMessage());
            System.exit(1);
        }

        try{
            racine = (JSONObject) JSONSerializer.toJSON(jsonText);
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Arguments invalides");
            
        }
                
       try{
            numeroDossier = racine.getString("dossier");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le dossier n'est pas présent.");
        }
        
        if(estNumeroDossierValide(numeroDossier)){
            modele.setClient(numeroDossier.substring(1));
            modele.setTypeContrat(numeroDossier.substring(0,1).charAt(0));
        } else {
            throw new InvalidArgumentException("Erreur! Le numero de dossier est invalide.");
        }
     
        try{
            mois = racine.getString("mois");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Le mois n'est pas présent.");
        }
        
        modele.setMois(mois);
        
         try{
            reclamations = racine.getJSONArray("reclamations");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de réclamations.");
        }
        
         
         
        for(int i = 0; i < reclamations.size(); i++){
            int soin;
            String date;
            Dollar montant;
            Reclamation nouvelleReclamation = new Reclamation();
            JSONObject reclamationCourrante = reclamations.getJSONObject(i);
            
            try{   
                soin = reclamationCourrante.getInt("soin");
            } catch (net.sf.json.JSONException e){
                throw new InvalidArgumentException("Erreur! Il n'y a pas de soin");
            }

            if(estNumeroSoinValide(soin)){
                nouvelleReclamation.setSoins(soin);
            } else {
                throw new InvalidArgumentException("Le numéro de soin est Invalide");
            }
            
            try{
                date = reclamationCourrante.getString("date");
            } catch(net.sf.json.JSONException e){
                throw new InvalidArgumentException("Erreur! La date n'est pas présent.");
            } 
            
            if(estDateValide(date, modele.getMois())){
                nouvelleReclamation.setDate(date);
            } else {
                throw new InvalidArgumentException("La date est invalide.");
            }
            
            try{
                montant = new Dollar(reclamationCourrante.getString("montant"));
            } catch(net.sf.json.JSONException e){
                throw new InvalidArgumentException("Erreur! Le montant n'est pas présent.");
            } 
            
            nouvelleReclamation.setMontant(montant);
            modele.ajouterReclamation(nouvelleReclamation);
        }
        
        return modele;
    }

    public static void ecrireFichier(String fichierSortie, ModeleJsonOut modeleOut) {
       
        JSONObject remboursement = new JSONObject();
        Dollar montantTotal = new Dollar();
       
        remboursement.accumulate("dossier", modeleOut.getClient());
        remboursement.accumulate("mois", modeleOut.getMois());
        
        JSONArray remboursementTab = new JSONArray();//tableau de remboursement
        
        for(int i = 0; i < modeleOut.getRemboursement().size(); i++){
            JSONObject objetCourant = new JSONObject();
            Remboursement remboursementCourant = modeleOut.getRemboursement().get(i);
            
            objetCourant.accumulate("soin", remboursementCourant.getSoins());
            objetCourant.accumulate("date", remboursementCourant.getDate());
            objetCourant.accumulate("montant", remboursementCourant.getMontant().convertirEnString());
            remboursementTab.add(objetCourant);
            montantTotal.additionDollar(remboursementCourant.getMontant());
        }
        
        
        remboursement.accumulate("remboursements", remboursementTab);
        remboursement.accumulate("total", montantTotal.convertirEnString());
        
        try {
            Utf8File.saveStringIntoFile(fichierSortie, remboursement.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }

    }
    
    public static Statistique ouvrirFichierStatistique(String fichierEntree) throws InvalidArgumentException {
        Statistique stats = new Statistique();
        String jsonTxt = null;
        JSONObject racine;
        int reclamationValide;
        int reclamationRejete;
        int nbSoinMassotheratpie;
        int nbSoinOsteopathie;
        int nbSoinKinesitherapie;
        int nbSoinMGP;
        int nbSoinPsychologie;
        int nbSoinDentaire;
        int nbSoinNaturo;
        int nbSoinChiropratie;
        int nbSoinPhysiotherapie;
        int nbSoinOrthophonie;
        
        try {
            jsonTxt = Utf8File.loadFileIntoString(fichierEntree);
        } catch (IOException ex) {
            System.out.println("Erreur lors de la lecture du fichier statistique.json. " + ex.getLocalizedMessage());
            System.exit(1);
        }
        
        try {
            racine = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        } catch (JSONException e) {
            throw new InvalidArgumentException("Arguments invalides");
        }
        
        try{
            reclamationValide = racine.getInt("reclamations valides");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Les reclamations valides ne sont pas presentes.");
        }
        
        try{
            reclamationRejete = racine.getInt("reclamations rejetes");
        } catch(net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Les reclamations rejetes ne sont pas presentes.");
        }
         
        try{   
            nbSoinMassotheratpie = racine.getInt("massotherapie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de massotherapie");
        }

        try{   
            nbSoinOsteopathie = racine.getInt("ostheopathie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de ostheopathie");
        }

        try{   
            nbSoinKinesitherapie = racine.getInt("kinesitherapie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de kinesitherapie");
        }

        try{   
            nbSoinMGP = racine.getInt("medecin_generaliste_prive");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de medecin generaliste prive");
        }

        try{   
            nbSoinPsychologie = racine.getInt("psychologie_individuelle");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de psychologie individuelle");
        }

        try{   
            nbSoinDentaire = racine.getInt("soin_dentaire");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin dentaire");
        }

        try{   
            nbSoinNaturo = racine.getInt("naturopathie_acuponcture");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de naturopathie ou acuponcture");
        }

        try{   
            nbSoinChiropratie = racine.getInt("chiropratie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de chiropratie");
        }

        try{   
            nbSoinPhysiotherapie = racine.getInt("physiotherapie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de physiotherapie");
        }

        try{   
            nbSoinOrthophonie = racine.getInt("Orthophonie_ergotherapie");
        } catch (net.sf.json.JSONException e){
            throw new InvalidArgumentException("Erreur! Il n'y a pas de Orthophonie ou ergotherapie");
        }
            
        stats.setReclamationValide(reclamationValide);
        stats.setReclamationRejete(reclamationRejete);
        stats.setNbSoinMassotheratpie(nbSoinMassotheratpie);
        stats.setNbSoinOsteopathie(nbSoinOsteopathie);
        stats.setNbSoinKinesitherapie(nbSoinKinesitherapie);
        stats.setNbSoinMGP(nbSoinMGP);
        stats.setNbSoinPsychologie(nbSoinPsychologie);
        stats.setNbSoinDentaire(nbSoinDentaire);
        stats.setNbSoinNaturo(nbSoinNaturo);
        stats.setNbSoinChiropratie(nbSoinChiropratie);
        stats.setNbSoinPhysiotherapie(nbSoinPhysiotherapie);
        stats.setNbSoinOrthophonie(nbSoinOrthophonie);

        return stats;
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
    
    /*methode pour traiter les erreurs*/
    private static boolean estNumeroDossierValide(String dossier) {
        return dossier.length() == 7 && dossier.matches("[A-E][0-9]{6}");  
    }
    
    private static boolean estNumeroContratValide(char numeroContrat){
        if(numeroContrat == 'A' || numeroContrat == 'B' || numeroContrat == 'C'
                || numeroContrat == 'D' || numeroContrat == 'E'){
            return true;
        }
        return false;
    }
    
    private static boolean estNumeroSoinValide(int soin){
        boolean resultat = false;
        if(soin == 0 || soin == 100 || soin == 150 || soin == 175 || soin == 200 || (soin >= 300 && soin <= 400)
                || soin == 500 || soin == 600 || soin == 700){
            resultat = true;            
        }
        return resultat;
    }
    
    private static boolean estDateValide(String date, String mois){
        String test = date.substring(0, 7);
        boolean resultat = false;
        if(test.equals(mois)){
            resultat = true;            
        }
        
        return resultat;
    }

    
        
    
}
