/* main du projet*/
package projetagile;

import java.io.IOException;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Statistique;
import net.sf.json.JSONObject;
import projetagile.jsonmodels.Reclamation;

public class ProjetSession {

    private static final String AFFICHAGE_STATS = "-S";
    private static final String EFFACE_STATS = "-SR";
    private static final String SANS_STATS = "-p";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statistique stats = new Statistique();
        stats = ouvrirFichierJsonStatistique(stats);

        switch (args.length) {
            case 1:
                argumentStatistique(args, stats);
                break;
            case 2:
                argumentReclamation(args, stats);
                break;
            case 3:
                validationModeSansStats(args);
                break;
            default:
                System.out.println("Erreur! Vous devez mettre 1 a 3 arguments.");
        }
    }

    private static void validationModeSansStats(String[] args) {
        if(args[0].equals(SANS_STATS)){
            argumentReclamation(args, null);
        } else {
            System.out.println(args[0]);
            System.out.println("Erreur! Si vous entrez 3 arguments il faut que ce soit"
                    + " -p et 2 fichier a traiter ");
        }
    }

    public static void argumentReclamation(String[] args, Statistique stats) {
        String fichierEntree = args[1];
        String fichierSortie = args[2];
        
        if(stats != null){
            fichierEntree = args[0];
            fichierSortie = args[1];
        }
        reclamtionInvalidArgumentException(fichierEntree, fichierSortie, stats);
    }

    public static void reclamtionInvalidArgumentException(String fichierEntree, String fichierSortie, Statistique stats) {
        try {
            traiterReclamation(fichierEntree, fichierSortie, stats);
        } catch (InvalidArgumentException e) {
            if(stats != null) {
                stats.setReclamationRejete(stats.getReclamationRejete() + 1);
            }
            JsonFileHandler.ecrireFichierErreur(fichierSortie, e);
        } finally {
            if(stats != null)
                ecrireStatistiques(stats);
        }
    }

    public static void traiterReclamation(String fichierEntree, String fichierSortie, Statistique stats) throws InvalidArgumentException {
        ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(fichierEntree);
        InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
        ModeleJsonOut sortie = nouveauContrat.calculRemboursement();
        JsonFileHandler.ecrireFichier(fichierSortie, sortie);
        if(stats != null){
            stats.setReclamationValide(stats.getReclamationValide() + 1);
            stats.compterSoin(sortie);
        }
    }

    public static void argumentStatistique(String[] args, Statistique stats) {
        if (args[0].contentEquals(AFFICHAGE_STATS)) {
            stats.afficherStatistiques();
        } else if (args[0].contentEquals(EFFACE_STATS)) {
            stats.reinitialise();
            ecrireStatistiques(stats);
        } else {
            System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
        }
    }

    public static Statistique ouvrirFichierJsonStatistique(Statistique stats) {
        try {
            stats = JsonFileHandler.ouvrirFichierStatistique("statistique.json");
        } catch (InvalidArgumentException e) {
            System.out.println("Erreur avec l'ouverture du fichier statistique.json" + e.getLocalizedMessage());
        }
        return stats;
    }

    public static void ecrireStatistiques(Statistique stats) {
        JSONObject statJson = new JSONObject();
        statJson.accumulate("reclamations valides", stats.getReclamationValide());
        statJson.accumulate("reclamations rejetes", stats.getReclamationRejete());
        
        statJson.accumulate("massotherapie", stats.getMassotherapie());
        statJson.accumulate("ostheopathie", stats.getOstheopathie());
        statJson.accumulate("kinesitherapie", stats.getKinesitherapie());
        statJson.accumulate("medecin_generaliste_prive", stats.getMedecine());
        statJson.accumulate("psychologie_individuelle", stats.getPsychologie());
        statJson.accumulate("soin_dentaire", stats.getDentaire());
        statJson.accumulate("naturopathie_acuponcture", stats.getNaturopathie());
        statJson.accumulate("chiropratie", stats.getChiropratie());
        statJson.accumulate("physiotherapie", stats.getPhysiotherapie());
        statJson.accumulate("Orthophonie_ergotherapie", stats.getOrthophonie());

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
