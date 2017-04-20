/*
 *ecrit et lit les fichier json
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONObject;
import projetagile.jsonmodels.MontantSoinStats;
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

public class EcrireStatistiques {

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

    public static JSONObject ecrireStatsSpecifiqueJson(MontantSoinStats soins) {
        JSONObject soinsJson = new JSONObject();
        soinsJson.accumulate("compteur", soins.getCompteur());
        soinsJson.accumulate("somme", soins.getSomme().convertirEnStringDollar());
        soinsJson.accumulate("maximum", soins.getMaximum().convertirEnStringDollar());
        return soinsJson;
    }

    public static void ecrireFichierJsonStats(JSONObject statJson) {
        try {
            Utf8File.saveStringIntoFile("statistique.json", statJson.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }

    public static void ecrireStatistiquesJson(Statistique stats) {
        JSONObject statJson = new JSONObject();
        statJson.accumulate("reclamations valides", stats.getReclamationValide());
        statJson.accumulate("reclamations rejetes", stats.getReclamationRejete());
        statJson.accumulate("massotherapie", ecrireStatsSpecifiqueJson(stats.getMassotherapie()));
        statJson.accumulate("ostheopathie", ecrireStatsSpecifiqueJson(stats.getOstheopathie()));
        statJson.accumulate("kinesitherapie", ecrireStatsSpecifiqueJson(stats.getKinesitherapie()));
        statJson.accumulate("medecin_generaliste_prive", ecrireStatsSpecifiqueJson(stats.getMedecine()));
        statJson.accumulate("psychologie_individuelle", ecrireStatsSpecifiqueJson(stats.getPsychologie()));
        statJson.accumulate("soin_dentaire", ecrireStatsSpecifiqueJson(stats.getDentaire()));
        statJson.accumulate("naturopathie_acuponcture", ecrireStatsSpecifiqueJson(stats.getNaturopathie()));
        statJson.accumulate("chiropratie", ecrireStatsSpecifiqueJson(stats.getChiropratie()));
        statJson.accumulate("physiotherapie", ecrireStatsSpecifiqueJson(stats.getPhysiotherapie()));
        statJson.accumulate("Orthophonie_ergotherapie", ecrireStatsSpecifiqueJson(stats.getOrthophonie()));
        ecrireFichierJsonStats(statJson);
    }

}
