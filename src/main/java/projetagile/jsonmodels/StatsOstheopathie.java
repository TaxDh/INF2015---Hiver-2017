/*
 * Objet statistique ostheopathie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsOstheopathie extends MontantSoinStats {

    public StatsOstheopathie() {
        super();
    }

    public StatsOstheopathie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
