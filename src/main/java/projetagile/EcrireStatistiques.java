/*
 *ecrit et lit les fichier json
 */
package projetagile;

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

}
