/*
 * Classe qui set toutes les statistiques a 0.
 */
package projetagile;
import projetagile.jsonmodels.Statistique;

public class ReinitialiseStats {

    public static void reinitialise(Statistique stats){
        stats.setReclamationValide(0);
        stats.setReclamationRejete(0);
        stats.setNbSoinMassotheratpie(0);
        stats.setNbSoinOsteopathie(0);
        stats.setNbSoinKinesitherapie(0);
        stats.setNbSoinMGP(0);
        stats.setNbSoinPsychologie(0);
        stats.setNbSoinDentaire(0);
        stats.setNbSoinNaturo(0);
        stats.setNbSoinChiropratie(0);
        stats.setNbSoinPhysiotherapie(0);
        stats.setNbSoinOrthophonie(0);
    }  
}
