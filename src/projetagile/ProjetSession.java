/* main du projet*/
package projetagile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Statistique;
import projetagile.AffichageStats;


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
            System.out.println("Erreur avec l'ouverture du fichier statistique.json");
        }

        if(args.length == 1){
            if(args[0].contentEquals(affichageStats)){
               AffichageStats.afficherStatistiques(stats);
            } else if(args[0].contentEquals(effaceStats)){
                ReinitialiseStats.reinitialise(stats);
            } else{
                System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
            }
        } else if(args.length == 2){

            String fichierEntree = args[0];
            String fichierSortie = args[1];

            try{
                ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(fichierEntree);
                InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
                ModeleJsonOut test = nouveauContrat.calculRemboursement();
                JsonFileHandler.ecrireFichier(fichierSortie, test);
                
            } catch (InvalidArgumentException e) {
                stats.setReclamationRejete(stats.getReclamationRejete() + 1);
                JsonFileHandler.ecrireFichierErreur(fichierSortie, e);
            }
            finally{
                //ecrire les stats
            }
        } else {
            System.out.println("Erreur! Vous devez mettre 1 ou 2 arguments.");
        }          
    }

}
