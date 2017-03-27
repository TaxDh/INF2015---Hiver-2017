/* main du projet*/
package projetagile;


import java.io.IOException;
import net.sf.json.JSONObject;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Statistique;


/**
 *
 * @author kf891141
 */
public class ProjetSession {
    
    public static final String affichageStats = "-S";
    public static final String effaceStats = "-SR";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statistique stats = new Statistique();
        
        try{
            stats = JsonFileHandler.ouvrirFichierStatistique("statistique.json");
        } catch (InvalidArgumentException e){
            System.out.println("Erreur avec l'ouverture du fichier statistique.json" + e.getLocalizedMessage());
        }

        if(args.length == 1){
            if(args[0].contentEquals(affichageStats)){
               stats.afficherStatistiques();
            } else if(args[0].contentEquals(effaceStats)){
                stats.reinitialise();
                ecrireStatistiques(stats);
            } else{
                System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
            }
        } else if(args.length == 2){

            String fichierEntree = args[0];
            String fichierSortie = args[1];

            try{
                ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(fichierEntree);
                InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
                ModeleJsonOut sortie = nouveauContrat.calculRemboursement();
                JsonFileHandler.ecrireFichier(fichierSortie, sortie);
                stats.setReclamationValide(stats.getReclamationValide() + 1);
                stats.compterSoin(sortie);
            } catch (InvalidArgumentException e) {
                stats.setReclamationRejete(stats.getReclamationRejete() + 1);
                JsonFileHandler.ecrireFichierErreur(fichierSortie, e);
            }
            finally{
                ecrireStatistiques(stats);
	
            }
        } else {
            System.out.println("Erreur! Vous devez mettre 1 ou 2 arguments.");
        }          
    }

    public static void ecrireStatistiques(Statistique stats) {
        JSONObject statJson = new JSONObject();
        statJson.accumulate("reclamations valides", stats.getReclamationValide());
        statJson.accumulate("reclamations rejetes", stats.getReclamationRejete());
        statJson.accumulate("massotherapie", stats.getNbSoinMassotheratpie());
        statJson.accumulate("ostheopathie", stats.getNbSoinOsteopathie());
        statJson.accumulate("kinesitherapie", stats.getNbSoinKinesitherapie());
        statJson.accumulate("medecin_generaliste_prive", stats.getNbSoinMGP());
        statJson.accumulate("psychologie_individuelle", stats.getNbSoinPsychologie());
        statJson.accumulate("soin_dentaire", stats.getNbSoinDentaire());
        statJson.accumulate("naturopathie_acuponcture", stats.getNbSoinNaturo());
        statJson.accumulate("chiropratie", stats.getNbSoinChiropratie());
        statJson.accumulate("physiotherapie", stats.getNbSoinPhysiotherapie());
        statJson.accumulate("Orthophonie_ergotherapie", stats.getNbSoinOrthophonie());
        
        try {
            Utf8File.saveStringIntoFile("statistique.json", statJson.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }

}
