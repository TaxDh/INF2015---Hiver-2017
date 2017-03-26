/*
 * Affiche les statistiques
 */
package projetagile;
import projetagile.jsonmodels.Statistique;


public class AffichageStats {
    
    public static void afficherStatistiques(Statistique stat){
        System.out.println("Le nombre de reclamations valides" + stat.getReclamationValide());
        System.out.println("Le nombre de reclamations rejetes" + stat.getReclamationRejete());
        System.out.println("Le nombre de massotherapies traitees " + stat.getNbSoinMassotheratpie());
        System.out.println("Le nombre de osteopathies traitees " + stat.getNbSoinOsteopathie());
        System.out.println("Le nombre de kinesitherapies traitees " + stat.getNbSoinKinesitherapie());
        System.out.println("Le nombre de medecins generalistes prives traitees " +stat.getNbSoinMGP());
        System.out.println("Le nombre de psychologies individuelles traitees " + stat.getNbSoinPsychologie());
        System.out.println("Le nombre de soins dentaires traitees " + stat.getNbSoinDentaire());
        System.out.println("Le nombre de naturopathies et/ou acuponctures traitees " + stat.getNbSoinNaturo());
        System.out.println("Le nombre de chiropratie traitees " + stat.getNbSoinChiropratie());
        System.out.println("Le nombre de physiotherapies traitees " + stat.getNbSoinPhysiotherapie());
        System.err.println("Le nombre d'orthophonies et/ou d'ergotherapies traitees " + stat.getNbSoinOrthophonie()); 
    }
    
}
