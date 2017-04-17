/*
 * Objet statistique soin dentaire.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsDentaire extends MontantSoinStats {

    public StatsDentaire() {
        super();
    }

    public StatsDentaire(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
