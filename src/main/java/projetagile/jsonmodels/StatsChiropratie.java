/*
 * Objet statistique chiropratie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsChiropratie extends MontantSoinStats {

    public StatsChiropratie() {
        super();
    }

    public StatsChiropratie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
