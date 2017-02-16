/*
 * Copyright 2016 Jacques Berger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//test


package tp;

import net.sf.json.JSONObject;

public class Main {
    
    public static void main(String[] args) {
        JSONObject fichierSortie;

        if ((args.length != 2) || !args[0].endsWith(".json") || !args[1].endsWith(".json")) {
            fichierSortie = new JSONObject();
            fichierSortie.accumulate("message:", "Donnees invalides");
        } else {
            try {
                String fichierEntree;
                fichierEntree = Utf8File.loadFileIntoString(args[0]);

                if (Conditions.validerFichierJson(fichierEntree)) {
                    Assurer reclam = new Assurer();
                    fichierSortie = reclam.faireReclamation(fichierEntree);
                } else {
                    fichierSortie = new JSONObject();
                    fichierSortie.accumulate("message:", "Données invalides");
                }

            }
            catch (Exception ex) {
                fichierSortie = new JSONObject();
                fichierSortie.accumulate("message:", "Données invalides");
            }
        }

        Conditions.creerFichierSortie(fichierSortie, args[1]);
    }
}
