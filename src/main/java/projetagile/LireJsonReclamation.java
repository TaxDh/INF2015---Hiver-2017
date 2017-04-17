/*
 Lit les fichiers sous format json en arguments.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.Reclamation;

public class LireJsonReclamation {

    private static final Dollar DOLLAR0 = new Dollar("0.00$");
    private static final Dollar DOLLAR500 = new Dollar("500.00$");
    private static int compteurSoin = 0;

    public static ModeleJsonIn ouvrireFichier(String fichierEntree) throws InvalidArgumentException {
        String jsonText = litTexteJson(fichierEntree);
        JSONObject racine = creeRacineJsonLire(jsonText);
        String numeroDossier = creeDossierJsonLire(racine);
        String mois = creeRacineJsonLire(racine);
        JSONArray reclamations = creeReclamationJsonLire(racine);
        ModeleJsonIn modele = creeModeleLire(numeroDossier, mois);
        parcoursDesReclamations(reclamations, modele);
        return modele;
    }

    private static void valideNombreDeSoin() throws InvalidArgumentException {
        if (compteurSoin > 4) {
            throw new InvalidArgumentException("Il ne peut y avoir plus de 4 soins par reclamation");
        }
    }

    public static void parcoursDesReclamations(JSONArray reclamations, ModeleJsonIn modele) throws InvalidArgumentException {
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

    private static ModeleJsonIn creeModeleLire(String numeroDossier, String mois) throws InvalidArgumentException {
        String client = "";
        char typeContrat = '\u0000';
        if (estNumeroDossierValide(numeroDossier)) {
            client = numeroDossier.substring(1);
            typeContrat = numeroDossier.substring(0, 1).charAt(0);
        } else {
            throw new InvalidArgumentException("Erreur! Le numero de dossier est invalide.");
        }
        return new ModeleJsonIn(client, typeContrat, mois);
    }

    private static boolean estNumeroDossierValide(String dossier) {
        return dossier.length() == 7 && dossier.matches("[A-E][0-9]{6}");
    }

    public static String creeRacineJsonLire(JSONObject racine) throws InvalidArgumentException {
        String mois = "";
        try {
            mois = racine.getString("mois");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Le mois n'est pas present.");
        }
        return mois;
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

    public static String creeDateJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        String date;
        try {
            date = reclamationCourrante.getString("date");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! La date n'est pas present.");
        }
        return date;
    }

    private static Reclamation creeReclamationLire(int soin, String date, Dollar montant, ModeleJsonIn modele)
            throws InvalidArgumentException {

        Reclamation nouvelleReclamation = new Reclamation();
        valideSoin(soin, nouvelleReclamation);
        valideDate(date, modele, nouvelleReclamation);
        valideMontant(montant, nouvelleReclamation);
        return nouvelleReclamation;
    }

    public static int creeSoinJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        int soin;
        try {
            soin = reclamationCourrante.getInt("soin");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin");
        }
        return soin;
    }

    public static Dollar creeMontantJsonLire(JSONObject reclamationCourrante) throws InvalidArgumentException {
        Dollar montant;
        try {
            montant = new Dollar(reclamationCourrante.getString("montant"));
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Le montant n'est pas present.");
        }
        return montant;
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

    public static void valideDate(String date, ModeleJsonIn modele, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {

        if (estDateValide(date, modele.getMois())) {
            nouvelleReclamation.setDate(date);
        } else {
            throw new InvalidArgumentException("La date est invalide.");
        }
    }

    public static void valideSoin(int soin, Reclamation nouvelleReclamation) throws InvalidArgumentException {
        if (estNumeroSoinValide(soin)) {
            nouvelleReclamation.setSoins(soin);
        } else {
            throw new InvalidArgumentException("Le numero de soin est Invalide");
        }
    }

    public static void valideMontant(Dollar montant, Reclamation nouvelleReclamation)
            throws InvalidArgumentException {

        if (montant.getMontant() >= DOLLAR0.getMontant() && montant.getMontant() <= DOLLAR500.getMontant()) {
            nouvelleReclamation.setMontant(montant);
        } else {
            throw new InvalidArgumentException("Le montant est negatif ou superieur a 500$");
        }
    }

    public static String creeDossierJsonLire(JSONObject racine) throws InvalidArgumentException {
        String numeroDossier = "";
        try {
            numeroDossier = racine.getString("dossier");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Le dossier n'est pas present.");
        }
        return numeroDossier;
    }

    public static JSONArray creeReclamationJsonLire(JSONObject racine) throws InvalidArgumentException {
        JSONArray reclamations;
        try {
            reclamations = racine.getJSONArray("reclamations");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de reclamations.");
        }
        return reclamations;
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
