/*
 * Objet statistique orthophonie;
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsOrthophonie extends MontantSoinStats {

    public StatsOrthophonie() {
        super();
    }

    public StatsOrthophonie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
