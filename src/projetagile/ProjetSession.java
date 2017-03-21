/* main du projet*/
package projetagile;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;


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
        
        if(args.length == 1){
            argumentStatTraitement(args);
        }
        else if(args.length == 2){
            lectureEtEcritureFichier(args[0], args[1]);
        } else {
            System.out.println("Il y a une erreur avec les arguments");
        }       
        
    }

    private static void argumentStatTraitement(String[] args) {
        if(args[0].contentEquals(affichageStats)){
            System.out.println("Test -S");
        } else if(args[0].contentEquals(effaceStats)){
            System.out.println("Test efface -SR");
        } else{
            System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers json");
        }
    }

    private static void lectureEtEcritureFichier(String fichierEntree, String fichierSortie) {
        try{
            ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(fichierEntree);
            InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
            ModeleJsonOut test = nouveauContrat.calculRemboursement();
            JsonFileHandler.ecrireFichier(fichierSortie, test);
        } catch (InvalidArgumentException e) {
            //TODO WRITE TO ERROR FILE
            JsonFileHandler.ecrireFichierErreur(fichierSortie, e);
            System.exit(0);
        }
    }
    
}
