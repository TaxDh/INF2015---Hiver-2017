/*
 * Objet statistique naturopathie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsNaturopathie extends MontantSoinStats {

    public StatsNaturopathie() {
        super();
    }

    public StatsNaturopathie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
