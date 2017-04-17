/*
 * Objet statistique kinesitherapie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsKinesitherapie extends MontantSoinStats {

    public StatsKinesitherapie() {
        super();
    }

    public StatsKinesitherapie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
