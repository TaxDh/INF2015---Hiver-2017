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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if(args.length == 1){
            
        }
        else if(args.length == 2){

            //String inputFilePath = ;
            //String outputFilePath = ;

            lectureEtEcritureFichier(args[0], args[1]);
        } else {
            System.out.println("Il y a une erreur avec les arguments");
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
