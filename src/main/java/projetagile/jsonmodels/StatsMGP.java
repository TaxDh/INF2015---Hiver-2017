/*
 * Objet statistique medecin generaliste prive.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsMGP extends MontantSoinStats {

    public StatsMGP() {
        super();
    }

    public StatsMGP(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
