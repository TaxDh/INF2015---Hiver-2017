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


package tp;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Tp {
    
    public static void main(String[] args) {
        JSONObject album1 = new JSONObject();
        album1.accumulate("type", "album");
        album1.accumulate("artist", "Unearth");
        album1.accumulate("title", "Darkness in the Light");
        album1.accumulate("publication", 2011);
        album1.accumulate("rating", 5);

        JSONObject album2 = new JSONObject();
        album2.accumulate("type", "album");
        album2.accumulate("artist", "Iron Maiden");
        album2.accumulate("title", "Brave New World");
        album2.accumulate("publication", 2000);
        album2.accumulate("rating", 5);

        JSONObject album3 = new JSONObject();
        album3.accumulate("type", "album");
        album3.accumulate("artist", "Three Days Grace");
        album3.accumulate("title", "One X");
        album3.accumulate("publication", 2006);
        album3.accumulate("rating", 5);

        JSONArray collection = new JSONArray();
        collection.add(album1);
        collection.add(album2);
        collection.add(album3);
        
        JSONObject root = new JSONObject();
        root.accumulate("collection", collection);
        
        try {
            Utf8File.saveStringIntoFile("sortie.json", root.toString(2));
        } catch (IOException ex) {
            System.out.println("Erreur avec le fichier de sortie : " + ex.getLocalizedMessage());
        }
    }
}