/*
 Ecris le fichier d'erreur sous format json.
 */
package projetagile;

import java.io.IOException;
import net.sf.json.JSONObject;

public class EcrireFichierErreurJson {

    public static void ecrireFichierErreur(String filePath, Exception e) {
        JSONObject erreur = new JSONObject();
        erreur.accumulate("message", e.getLocalizedMessage());
        try {
            Utf8File.saveStringIntoFile(filePath, erreur.toString(4));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }

}
