/*ecrit et lit les fichier json*/
package projetagile;

import java.io.IOException;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Remboursement;
import projetagile.jsonmodels.Statistique;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.StatsChiropratie;
import projetagile.jsonmodels.StatsDentaire;
import projetagile.jsonmodels.StatsKinesitherapie;
import projetagile.jsonmodels.StatsMGP;
import projetagile.jsonmodels.StatsMassotherapie;
import projetagile.jsonmodels.StatsNaturopathie;
import projetagile.jsonmodels.StatsOrthophonie;
import projetagile.jsonmodels.StatsOstheopathie;
import projetagile.jsonmodels.StatsPhysiotherapie;
import projetagile.jsonmodels.StatsPsychologie;

public class JsonFileHandler {
    private static final Dollar dollar0 = new Dollar("0.00$");
    private static final Dollar dollar500 = new Dollar("500.00$");
    private static int compteurSoin = 0;
    

    public static ModeleJsonIn ouvrireFichier(String fichierEntree) throws InvalidArgumentException {
        String jsonText = litTexteJson(fichierEntree);
        JSONObject racine = JsonFileHandler.creeRacineJsonLire(jsonText);
        String numeroDossier = creeDossierJsonLire(racine);
        String mois = creeRacineJsonLire(racine);
        JSONArray reclamations = creeReclamationJsonLire(racine);
        ModeleJsonIn modele = creeModeleLire(numeroDossier, mois);

        parcoursDesReclamations(reclamations, modele);

        return modele;
    }

    private static ModeleJsonIn creeModeleLire(String numeroDossier, String mois) throws InvalidArgumentException {
        String client = "";
        char typeContrat = '\0';
        if (estNumeroDossierValide(numeroDossier)) {
            client = numeroDossier.substring(1);
            typeContrat = numeroDossier.substring(0, 1).charAt(0);
        } else {
            throw new InvalidArgumentException("Erreur! Le numero de dossier est invalide.");
        }
        return new ModeleJsonIn(client, typeContrat, mois);
    }

    public static void parcoursDesReclamations(JSONArray reclamations, ModeleJsonIn modele) 
            throws InvalidArgumentException {
        
        for (int i = 0; i < reclamations.size(); i++) {
            JSONObject reclamationCourrante = reclamations.getJSONObject(i);
            
            int soin = creeSoinJsonLire(reclamationCourrante);
            String date = creeDateJsonLire(reclamationCourrante);
            Dollar montant = creeMontantJsonLire(reclamationCourrante);
            compteurSoin++;
            
            valideNombreDeSoin();
            Reclamation nouvelleReclamation = creeReclamationLire(soin, date, montant, modele);
            modele.ajouterReclamation(nouvelleReclamation);
        }
    }

    private static void valideNombreDeSoin() throws InvalidArgumentException {
        if(compteurSoin > 4){
            throw new InvalidArgumentException("Il ne peut y avoir plus de 4 soins par reclamation");
        }
    }

    private static Reclamation creeReclamationLire(int soin, String date, Dollar montant, ModeleJsonIn modele)
            throws InvalidArgumentException {

        Reclamation nouvelleReclamation = new Reclamation();
        valideSoin(soin, nouvelleReclamation);
        valideDate(date, modele, nouvelleReclamation);
        valideMontant(montant, nouvelleReclamation);
        return nouvelleReclamation;
    }

    public static Dollar creeMontantJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        Dollar montant;
        try {
            montant = new Dollar(reclamationCourrante.getString("montant"));
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Le montant n'est pas présent.");
        }
        return montant;
    }

    public static void valideDate(String date, ModeleJsonIn modele, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        if (estDateValide(date, modele.getMois())) {
            nouvelleReclamation.setDate(date);
        } else {
            throw new InvalidArgumentException("La date est invalide.");
        }
    }

    public static String creeDateJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        String date;
        try {
            date = reclamationCourrante.getString("date");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! La date n'est pas présent.");
        }
        return date;
    }

    public static void valideSoin(int soin, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        if (estNumeroSoinValide(soin)) {
            nouvelleReclamation.setSoins(soin);
        } else {
            throw new InvalidArgumentException("Le numéro de soin est Invalide");
        }
    }
    
    public static void valideMontant(Dollar montant, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {
        
        if(montant.getMontant()>= dollar0.getMontant() && montant.getMontant() <= dollar500.getMontant()){
            nouvelleReclamation.setMontant(montant);
        } else {
            throw new InvalidArgumentException("Le montant est negatif ou superieur a 500$");
        }
    }

    public static int creeSoinJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        int soin;
        try {
            soin = reclamationCourrante.getInt("soin");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin");
        }
        return soin;
    }

    public static JSONArray creeReclamationJsonLire(JSONObject racine) throws InvalidArgumentException {
        JSONArray reclamations;
        try {
            reclamations = racine.getJSONArray("reclamations");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de réclamations.");
        }
        return reclamations;
    }

    public static String creeRacineJsonLire(JSONObject racine) throws InvalidArgumentException {
        String mois = "";
        try {
            mois = racine.getString("mois");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Le mois n'est pas présent.");
        }
        return mois;
    }

    public static String creeDossierJsonLire(JSONObject racine) throws InvalidArgumentException {
        String numeroDossier = "";
        try {
            numeroDossier = racine.getString("dossier");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Le dossier n'est pas présent.");
        }
        return numeroDossier;
    }

    public static JSONObject creeRacineJsonLire(String jsonText) throws InvalidArgumentException {
        JSONObject racine;
        try {
            racine = (JSONObject) JSONSerializer.toJSON(jsonText);
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Arguments invalides");
        }
        return racine;
    }

    public static String litTexteJson(String fichierEntree) {
        String jsonText = "";
        try {
            jsonText = Utf8File.loadFileIntoString(fichierEntree);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON. " + e.getLocalizedMessage());
            System.exit(1);
        }
        return jsonText;
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

    public static Statistique ouvrirFichierStatistique(String fichierEntree) throws InvalidArgumentException {
        Statistique stats = new Statistique();
        String jsonTxt = creeJsonTxtString(fichierEntree);
        JSONObject racine = JsonFileHandler.creeRacineJsonLire(jsonTxt);

        int reclamationValide = creeReclamationStat(racine);
        int reclamationRejete = creeReclamationRejeteStat(racine);
        StatsMassotherapie massotherapie = creeMassotherapieStat(racine);
        
        /*
        int nbSoinOsteopathie = creeOsteopathieStat(racine);
        int nbSoinKinesitherapie = creeKinesitherapieStat(racine);
        int nbSoinMGP = creeMedecinGenPriveStat(racine);
        int nbSoinPsychologie = creePsychologieStat(racine);
        int nbSoinDentaire = creeDentaireStat(racine);
        int nbSoinNaturo = creeNaturopathieStat(racine);
        int nbSoinChiropratie = creeChiropratieStat(racine);
        int nbSoinPhysiotherapie = creePhysiotherapieStat(racine);
        int nbSoinOrthophonie = creeOrthophonieStat(racine);*/

        ecrisLesStatistiques(stats, reclamationValide, reclamationRejete, nbSoinMassotheratpie, nbSoinOsteopathie, nbSoinKinesitherapie, nbSoinMGP, nbSoinPsychologie, nbSoinDentaire, nbSoinNaturo, nbSoinChiropratie, nbSoinPhysiotherapie, nbSoinOrthophonie);

        return stats;
    }

    public static void ecrisLesStatistiques(Statistique stats, int reclamationValide,
            int reclamationRejete, StatsMassotherapie massotherapie, StatsOstheopathie osteopathie,
            StatsKinesitherapie kinesitherapie, StatsMGP medecin, StatsPsychologie psychologie,
            StatsDentaire dentaire, StatsNaturopathie naturo, StatsChiropratie chiropratie,
            StatsPhysiotherapie physiotherapie, StatsOrthophonie orthophonie) {
        
        stats.setReclamationValide(reclamationValide);
        stats.setReclamationRejete(reclamationRejete);
        stats.setMassotherapie(massotherapie);
        stats.setOstheopathie(osteopathie);
        stats.setKinesitherapie(kinesitherapie);
        stats.setMedecine(medecin);
        stats.setPsychologie(psychologie);
        stats.setDentaire(dentaire);
        stats.setNaturopathie(naturo);
        stats.setChiropratie(chiropratie);
        stats.setPhysiotherapie(physiotherapie);
        stats.setOrthophonie(orthophonie);        
    }

    public static int creeOrthophonieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinOrthophonie;
        try {
            nbSoinOrthophonie = racine.getInt("Orthophonie_ergotherapie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de Orthophonie ou ergotherapie");
        }
        return nbSoinOrthophonie;
    }

    public static int creePhysiotherapieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinPhysiotherapie;
        try {
            nbSoinPhysiotherapie = racine.getInt("physiotherapie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de physiotherapie");
        }
        return nbSoinPhysiotherapie;
    }

    public static int creeChiropratieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinChiropratie;
        try {
            nbSoinChiropratie = racine.getInt("chiropratie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de chiropratie");
        }
        return nbSoinChiropratie;
    }

    public static int creeNaturopathieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinNaturo;
        try {
            nbSoinNaturo = racine.getInt("naturopathie_acuponcture");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de naturopathie ou acuponcture");
        }
        return nbSoinNaturo;
    }

    public static int creeDentaireStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinDentaire;
        try {
            nbSoinDentaire = racine.getInt("soin_dentaire");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin dentaire");
        }
        return nbSoinDentaire;
    }

    public static int creePsychologieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinPsychologie;
        try {
            nbSoinPsychologie = racine.getInt("psychologie_individuelle");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de psychologie individuelle");
        }
        return nbSoinPsychologie;
    }

    public static int creeMedecinGenPriveStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinMGP;
        try {
            nbSoinMGP = racine.getInt("medecin_generaliste_prive");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de medecin generaliste prive");
        }
        return nbSoinMGP;
    }

    public static int creeKinesitherapieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinKinesitherapie;
        try {
            nbSoinKinesitherapie = racine.getInt("kinesitherapie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de kinesitherapie");
        }
        return nbSoinKinesitherapie;
    }

    public static int creeOsteopathieStat(JSONObject racine) throws InvalidArgumentException {
        int nbSoinOsteopathie;
        try {
            nbSoinOsteopathie = racine.getInt("ostheopathie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de ostheopathie");
        }
        return nbSoinOsteopathie;
    }

    public static StatsMassotherapie creeMassotherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetMassotherapie;
        try {
            objetMassotherapie = racine.getJSONObject("massotherapie");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de massotherapie");
        }
        
        return new StatsMassotherapie(
                objetMassotherapie.getInt("compteur"), 
                new Dollar(objetMassotherapie.getString("somme")), 
                new Dollar(objetMassotherapie.getString("maximum"))
        );
    }

    public static int creeReclamationRejeteStat(JSONObject racine) throws InvalidArgumentException {
        int reclamationRejete;
        try {
            reclamationRejete = racine.getInt("reclamations rejetes");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Les reclamations rejetes ne sont pas presentes.");
        }
        return reclamationRejete;
    }

    public static int creeReclamationStat(JSONObject racine) throws InvalidArgumentException {
        int reclamationValide;
        try {
            reclamationValide = racine.getInt("reclamations valides");
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Erreur! Les reclamations valides ne sont pas presentes.");
        }
        return reclamationValide;
    }

    public static String creeJsonTxtString(String fichierEntree) {
        String jsonTxt = null;
        try {
            jsonTxt = Utf8File.loadFileIntoString(fichierEntree);
        } catch (IOException ex) {
            System.out.println("Erreur lors de la lecture du fichier statistique.json. " + ex.getLocalizedMessage());
            System.exit(1);
        }
        return jsonTxt;
    }

    public static void ecrireFichierErreur(String filePath, Exception e) {
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

    private static boolean estNumeroContratValide(char numeroContrat) {
        boolean resultat = false;
        if (numeroContrat == 'A' || numeroContrat == 'B' || numeroContrat == 'C' || numeroContrat == 'D'
                || numeroContrat == 'E') {
            resultat = true;
        }
        return resultat;
    }

    private static boolean estNumeroSoinValide(int soin) {
        boolean resultat = false;
        if (soin == 0 || soin == 100 || soin == 150 || soin == 175 || soin == 200 || (soin >= 300 && soin <= 400)
                || soin == 500 || soin == 600 || soin == 700) {
            resultat = true;
        }
        return resultat;
    }

    private static boolean estDateValide(String date, String mois) {
        String test = date.substring(0, 7);
        boolean resultat = false;
        if (test.equals(mois)) {
            resultat = true;
        }

        return resultat;
    }

}
