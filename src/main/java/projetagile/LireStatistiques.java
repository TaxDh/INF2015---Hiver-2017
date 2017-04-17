/*
 * Lit le fichier json statistiques qui est a la racine du projet
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

        EcrireStatistiques.ecrisLesStatistiques(stats, reclamationValide, reclamationRejete,
                massotherapie, ostheopathie, kinesitherapie, medecin, psychologie,
                dentaire, naturopathie, chiropratie, physiotherapie, orthophonie);
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

    public static int creeReclamationStat(JSONObject racine) throws InvalidArgumentException {
        int reclamationValide;
        try {
            reclamationValide = racine.getInt("reclamations valides");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Les reclamations valides ne sont pas presentes.");
        }
        return reclamationValide;
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

    public static StatsChiropratie creeChiropratieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetChiropratie;
        int chiropratieCompteur;
        Dollar chiropratieSomme;
        Dollar chiropratieMax;

        try {
            objetChiropratie = racine.getJSONObject("chiropratie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de chiropratie");
        }

        chiropratieCompteur = objetChiropratie.getInt("compteur");
        chiropratieSomme = new Dollar(objetChiropratie.getString("somme"));
        chiropratieMax = new Dollar(objetChiropratie.getString("maximum"));

        return new StatsChiropratie(chiropratieCompteur, chiropratieSomme, chiropratieMax);
    }

    public static StatsPhysiotherapie creePhysiotherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetPhysiotherapie;
        int physiotherapieCompteur;
        Dollar physiotherapieSomme;
        Dollar physiotherapieMax;

        try {
            objetPhysiotherapie = racine.getJSONObject("physiotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de physiotherapie");
        }
        
        physiotherapieCompteur = objetPhysiotherapie.getInt("compteur");
        physiotherapieSomme = new Dollar(objetPhysiotherapie.getString("somme"));
        physiotherapieMax = new Dollar(objetPhysiotherapie.getString("maximum"));
        
        return new StatsPhysiotherapie(physiotherapieCompteur, physiotherapieSomme, physiotherapieMax);
    }

    public static StatsMassotherapie creeMassotherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetMassotherapie;
        int massotherapieCompteur;
        Dollar massotherapieSomme;
        Dollar massotherapieMax;

        try {
            objetMassotherapie = racine.getJSONObject("massotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de massotherapie");
        }
        
        massotherapieCompteur = objetMassotherapie.getInt("compteur");
        massotherapieSomme = new Dollar(objetMassotherapie.getString("somme"));
        massotherapieMax = new Dollar(objetMassotherapie.getString("maximum"));

        return new StatsMassotherapie();
    }

    public static StatsMGP creeMedecinGenPriveStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetMedecin;
        int medecinCompteur;
        Dollar medecinSomme;
        Dollar medecinMax;
        
        try {
            objetMedecin = racine.getJSONObject("medecin_generaliste_prive");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de medecin generaliste prive");
        }
        return new StatsMGP(objetMedecin.getInt("compteur"), new Dollar(objetMedecin.getString("somme")),
                new Dollar(objetMedecin.getString("maximum")));
    }

    public static StatsDentaire creeDentaireStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetSoinDentaire;
        int dentaireCompeutr;
        Dollar dentaireSomme;
        Dollar dentaireMax;
        
        try {
            objetSoinDentaire = racine.getJSONObject("soin_dentaire");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de soin dentaire");
        }
        return new StatsDentaire(objetSoinDentaire.getInt("compteur"), new Dollar(objetSoinDentaire.getString("somme")), new Dollar(objetSoinDentaire.getString("maximum")));
    }

    public static StatsPsychologie creePsychologieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetPsychologie;
        int psychologieCompteur;
        Dollar psychologieSomme;
        Dollar psychologieMax;
        
        try {
            objetPsychologie = racine.getJSONObject("psychologie_individuelle");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de psychologie individuelle");
        }
        return new StatsPsychologie(objetPsychologie.getInt("compteur"), new Dollar(objetPsychologie.getString("somme")), new Dollar(objetPsychologie.getString("maximum")));
    }

    public static StatsNaturopathie creeNaturopathieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetNaturopathie;
        int naturopathieCompteur;
        Dollar naturopathieSomme;
        Dollar naturopathieMax;
        
        try {
            objetNaturopathie = racine.getJSONObject("naturopathie_acuponcture");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de naturopathie ou d'acuponcture");
        }
        return new StatsNaturopathie(objetNaturopathie.getInt("compteur"), new Dollar(objetNaturopathie.getString("somme")), new Dollar(objetNaturopathie.getString("maximum")));
    }

    public static StatsKinesitherapie creeKinesitherapieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetKinesitherapie;
        int kinesitherapieCompteur;
        Dollar kinesitherapieSomme;
        Dollar kinesitherapieMax;
        
        try {
            objetKinesitherapie = racine.getJSONObject("kinesitherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de kinesitherapie");
        }
        return new StatsKinesitherapie(objetKinesitherapie.getInt("compteur"), new Dollar(objetKinesitherapie.getString("somme")), new Dollar(objetKinesitherapie.getString("maximum")));
    }

    public static StatsOrthophonie creeOrthophonieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetOrthophonie;
        int orthophonieCompteur;
        Dollar orthophonieSomme;
        Dollar orthophonieMax;
        
        try {
            objetOrthophonie = racine.getJSONObject("Orthophonie_ergotherapie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas dd'orthophonie ou ergotherapie");
        }
        return new StatsOrthophonie(objetOrthophonie.getInt("compteur"), new Dollar(objetOrthophonie.getString("somme")), new Dollar(objetOrthophonie.getString("maximum")));
    }

    public static StatsOstheopathie creeOsteopathieStat(JSONObject racine) throws InvalidArgumentException {
        JSONObject objetOstheopathie;
        int ostheopathieCompteur;
        Dollar ostheopathieSomme;
        Dollar ostheopathieMax;
        
        try {
            objetOstheopathie = racine.getJSONObject("ostheopathie");
        } catch (JSONException e) {
            throw new InvalidArgumentException("Erreur! Il n'y a pas de ostheopathie");
        }
        return new StatsOstheopathie(objetOstheopathie.getInt("compteur"), new Dollar(objetOstheopathie.getString("somme")), new Dollar(objetOstheopathie.getString("maximum")));
    }
}
