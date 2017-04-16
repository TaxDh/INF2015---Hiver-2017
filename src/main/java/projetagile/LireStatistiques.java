/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.Statistique;
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

public class LireStatistiques {

    public static JSONObject creeRacineJsonLire(String jsonText) throws InvalidArgumentException {
        JSONObject racine;
        try {
            racine = (JSONObject) JSONSerializer.toJSON(jsonText);
        } catch (net.sf.json.JSONException e) {
            throw new InvalidArgumentException("Arguments invalides");
        }
        return racine;
    }

    public static int creeReclamationStat(JSONObject racine) throws InvalidArgumentException {
        int reclamationValide;
        try {
            reclamationValide = racine.getInt("reclamations valides");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Les reclamations valides ne sont pas presentes.");
        }
        return reclamationValide;
    }

    public static StatsMGP creeMedecinGenPriveStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetMedecin;
        try {
            objetMedecin = racine.getJSONObject("medecin_generaliste_prive");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de medecin generaliste prive");
        }
        return new StatsMGP(objetMedecin.getInt("compteur"), new Dollar(objetMedecin.getString("somme")), new Dollar(objetMedecin.getString("maximum")));
    }

    public static Statistique ouvrirFichierStatistique(String fichierEntree) throws InvalidArgumentException {
        Statistique stats = new Statistique();
        String jsonTxt = creeJsonTxtString(fichierEntree);
        JSONObject racine = creeRacineJsonLire(jsonTxt);
        int reclamationValide = creeReclamationStat(racine);
        int reclamationRejete = creeReclamationRejeteStat(racine);
        StatsMassotherapie massotherapie = creeMassotherapieStat(racine);
        StatsOstheopathie ostheopathie = creeOsteopathieStat(racine);
        StatsKinesitherapie kinesitherapie = creeKinesitherapieStat(racine);
        StatsMGP medecin = creeMedecinGenPriveStat(racine);
        StatsPsychologie psychologie = creePsychologieStat(racine);
        StatsDentaire dentaire = creeDentaireStat(racine);
        StatsNaturopathie naturopathie = creeNaturopathieStat(racine);
        StatsChiropratie chiropratie = creeChiropratieStat(racine);
        StatsPhysiotherapie physiotherapie = creePhysiotherapieStat(racine);
        StatsOrthophonie orthophonie = creeOrthophonieStat(racine);
        EcrireStatistiques.ecrisLesStatistiques(stats, reclamationValide, reclamationRejete, massotherapie, ostheopathie, kinesitherapie, medecin, psychologie, dentaire, naturopathie, chiropratie, physiotherapie, orthophonie);
        return stats;
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

    public static StatsChiropratie creeChiropratieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetChiropratie;
        try {
            objetChiropratie = racine.getJSONObject("chiropratie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de chiropratie");
        }
        return new StatsChiropratie(objetChiropratie.getInt("compteur"), new Dollar(objetChiropratie.getString("somme")), new Dollar(objetChiropratie.getString("maximum")));
    }

    public static StatsPhysiotherapie creePhysiotherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetPhysiotherapie;
        try {
            objetPhysiotherapie = racine.getJSONObject("physiotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de physiotherapie");
        }
        return new StatsPhysiotherapie(objetPhysiotherapie.getInt("compteur"), new Dollar(objetPhysiotherapie.getString("somme")), new Dollar(objetPhysiotherapie.getString("maximum")));
    }

    public static StatsMassotherapie creeMassotherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetMassotherapie;
        try {
            objetMassotherapie = racine.getJSONObject("massotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de massotherapie");
        }
        System.out.println();
        return new StatsMassotherapie(objetMassotherapie.getInt("compteur"), new Dollar(objetMassotherapie.getString("somme")), new Dollar(objetMassotherapie.getString("maximum")));
    }

    public static int creeReclamationRejeteStat(JSONObject racine) throws InvalidArgumentException {
        int reclamationRejete;
        try {
            reclamationRejete = racine.getInt("reclamations rejetes");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Les reclamations rejetes ne sont pas presentes.");
        }
        return reclamationRejete;
    }

    public static StatsDentaire creeDentaireStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetSoinDentaire;
        try {
            objetSoinDentaire = racine.getJSONObject("soin_dentaire");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin dentaire");
        }
        return new StatsDentaire(objetSoinDentaire.getInt("compteur"), new Dollar(objetSoinDentaire.getString("somme")), new Dollar(objetSoinDentaire.getString("maximum")));
    }

    public static StatsPsychologie creePsychologieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetPsychologie;
        try {
            objetPsychologie = racine.getJSONObject("psychologie_individuelle");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de psychologie individuelle");
        }
        return new StatsPsychologie(objetPsychologie.getInt("compteur"), new Dollar(objetPsychologie.getString("somme")), new Dollar(objetPsychologie.getString("maximum")));
    }

    public static StatsNaturopathie creeNaturopathieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetNaturopathie;
        try {
            objetNaturopathie = racine.getJSONObject("naturopathie_acuponcture");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de naturopathie ou d'acuponcture");
        }
        return new StatsNaturopathie(objetNaturopathie.getInt("compteur"), new Dollar(objetNaturopathie.getString("somme")), new Dollar(objetNaturopathie.getString("maximum")));
    }

    public static StatsKinesitherapie creeKinesitherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetKinesitherapie;
        try {
            objetKinesitherapie = racine.getJSONObject("kinesitherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de kinesitherapie");
        }
        return new StatsKinesitherapie(objetKinesitherapie.getInt("compteur"), new Dollar(objetKinesitherapie.getString("somme")), new Dollar(objetKinesitherapie.getString("maximum")));
    }

    public static StatsOrthophonie creeOrthophonieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetOrthophonie;
        try {
            objetOrthophonie = racine.getJSONObject("Orthophonie_ergotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas dd'orthophonie ou ergotherapie");
        }
        return new StatsOrthophonie(objetOrthophonie.getInt("compteur"), new Dollar(objetOrthophonie.getString("somme")), new Dollar(objetOrthophonie.getString("maximum")));
    }

    public static StatsOstheopathie creeOsteopathieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetOstheopathie;
        try {
            objetOstheopathie = racine.getJSONObject("ostheopathie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de ostheopathie");
        }
        return new StatsOstheopathie(objetOstheopathie.getInt("compteur"), new Dollar(objetOstheopathie.getString("somme")), new Dollar(objetOstheopathie.getString("maximum")));
    }
}
