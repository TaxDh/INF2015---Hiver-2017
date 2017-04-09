/* main du projet*/
package ca.uqam.inf2015.projetagile;


import java.io.IOException;
import ca.uqam.inf2015.projetagile.jsonmodels.ModeleJsonIn;
import ca.uqam.inf2015.projetagile.jsonmodels.ModeleJsonOut;
import ca.uqam.inf2015.projetagile.jsonmodels.Statistique;
import net.sf.json.JSONObject;

public class ProjetSession {
    
    public static final String affichageStats = "-S";
    public static final String effaceStats = "-SR";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statistique stats = new Statistique();
        
        stats = ouvrirFichierJsonStatistique(stats);

        if(args.length == 1){
            argumentStatistique(args, stats);
        } else if(args.length == 2){
            argumentReclamation(args, stats);
        } else {
            System.out.println("Erreur! Vous devez mettre 1 ou 2 arguments.");
        }          
    }

    public static void argumentReclamation(String[] args, Statistique stats) {
        String fichierEntree = args[0];
        String fichierSortie = args[1];
        
        reclamtionInvalidArgumentException(fichierEntree, fichierSortie, stats);
    }

    public static void reclamtionInvalidArgumentException(String fichierEntree, String fichierSortie, Statistique stats) {
        try{
            traiterReclamation(fichierEntree, fichierSortie, stats);
        } catch (InvalidArgumentException e) {
            stats.setReclamationRejete(stats.getReclamationRejete() + 1);
            JsonFileHandler.ecrireFichierErreur(fichierSortie, e);
        }
        finally{
            ecrireStatistiques(stats);
        }
    }

    public static void traiterReclamation(String fichierEntree, String fichierSortie, Statistique stats) throws InvalidArgumentException {
        ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(fichierEntree);
        InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
        ModeleJsonOut sortie = nouveauContrat.calculRemboursement();
        JsonFileHandler.ecrireFichier(fichierSortie, sortie);
        stats.setReclamationValide(stats.getReclamationValide() + 1);
        stats.compterSoin(sortie);
    }

    public static void argumentStatistique(String[] args, Statistique stats) {
        if(args[0].contentEquals(affichageStats)){
            stats.afficherStatistiques();
        } else if(args[0].contentEquals(effaceStats)){
            stats.reinitialise();
            ecrireStatistiques(stats);
        } else{
            System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
        }
    }

    public static Statistique ouvrirFichierJsonStatistique(Statistique stats) {
        try{
            stats = JsonFileHandler.ouvrirFichierStatistique("statistique.json");
        } catch (InvalidArgumentException e){
            System.out.println("Erreur avec l'ouverture du fichier statistique.json" + e.getLocalizedMessage());
        }
        return stats;
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
        
        ecrireFichierJsonStats(statJson);
    }

    public static void ecrireFichierJsonStats(JSONObject statJson) {
        try {
            Utf8File.saveStringIntoFile("statistique.json", statJson.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }

}
