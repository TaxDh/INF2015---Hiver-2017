/*
 * Objet statistique physiotherapie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsPhysiotherapie extends MontantSoinStats {

    public StatsPhysiotherapie() {
        super();
    }

    public StatsPhysiotherapie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
