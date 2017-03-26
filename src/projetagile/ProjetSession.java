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
            if(args[0].contentEquals(affichageStats)){
                System.out.println("Test -S");
                
            } else if(args[0].contentEquals(effaceStats)){
                System.out.println("Test efface -SR");
            } else{
                System.out.println("Erreur! Il faut soit entrer -S, ou -SR ou 2 fichiers");
            }
        } else if(args.length == 2){

            String inputFilePath = args[0];
            String outputFilePath = args[1];

            try{
                ModeleJsonIn reclamation = JsonFileHandler.ouvrireFichier(inputFilePath);
                InterfaceContrat nouveauContrat = ContratFactory.instancieContrat(reclamation);
                ModeleJsonOut test = nouveauContrat.calculRemboursement();
                JsonFileHandler.ecrireFichier(outputFilePath, test);
                
            } catch (InvalidArgumentException e) {
                //compteur ici
                JsonFileHandler.ecrireFichierErreur(outputFilePath, e);
            }
            finally{
                //ecrire les stats
            }
        } else {
            System.out.println("Erreur! Vous devez mettre 1 ou 2 arguments.");
        }          
    }
}
