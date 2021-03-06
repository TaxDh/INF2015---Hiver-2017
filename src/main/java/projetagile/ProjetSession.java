/* 
 *main du projet
 */
package projetagile;

import java.io.IOException;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Statistique;
import net.sf.json.JSONObject;
import projetagile.jsonmodels.MontantSoinStats;

public class ProjetSession {

    private static final String AFFICHAGE_STATS = "-S";
    private static final String EFFACE_STATS = "-SR";
    private static final String SANS_STATS = "-p";

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
        if (args[0].equals(SANS_STATS)) {
            argumentReclamation(args, null);
        } else {
            System.out.println(args[0]);
            System.out.println("Erreur! Si vous entrez 3 arguments il faut que ce soit"
                    + " -p et 2 fichier a traiter ");
        }
    }

    public static void argumentReclamation(String[] args, Statistique stats) {
        String fichierEntree;
        String fichierSortie;

        if (stats != null) {
            fichierEntree = args[0];
            fichierSortie = args[1];
        } else {
            fichierEntree = args[1];
            fichierSortie = args[2];
        }
        reclamtionInvalidArgumentException(fichierEntree, fichierSortie, stats);
    }

    public static void reclamtionInvalidArgumentException(String fichierEntree, String fichierSortie, Statistique stats) {
        try {
            traiterReclamation(fichierEntree, fichierSortie, stats);
        } catch (InvalidArgumentException e) {
            if (stats != null) {
                stats.setReclamationRejete(stats.getReclamationRejete() + 1);
            }
            EcrireFichierErreurJson.ecrireFichierErreur(fichierSortie, e);
        } finally {
            if (stats != null) {
                EcrireStatistiques.ecrireStatistiquesJson(stats);
            }
        }
    }

    public static void traiterReclamation(String fichierEntree, String fichierSortie,
            Statistique stats) throws InvalidArgumentException {
        ModeleJsonIn reclamation = LireJsonReclamation.ouvrireFichier(fichierEntree);
        InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
        ModeleJsonOut sortie = nouveauContrat.calculRemboursement();
        EcrireFichierJsonRemboursement.ecrireFichier(fichierSortie, sortie);
        if (stats != null) {
            stats.setReclamationValide(stats.getReclamationValide() + 1);
            stats.compterSoin(reclamation);
        }
    }

    public static void argumentStatistique(String[] args, Statistique stats) {
        if (args[0].contentEquals(AFFICHAGE_STATS)) {
            stats.afficherStatistiques();
        } else if (args[0].contentEquals(EFFACE_STATS)) {
            stats.reinitialise();
            EcrireStatistiques.ecrireStatistiquesJson(stats);
        } else {
            System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
        }
    }

    public static Statistique ouvrirFichierJsonStatistique(Statistique stats) {
        try {
            stats = LireStatistiques.ouvrirFichierStatistique("statistique.json");
        } catch (InvalidArgumentException e) {
            System.out.println("Erreur avec l'ouverture du fichier statistique.json" + e.getLocalizedMessage());
        }
        return stats;
    }
}
