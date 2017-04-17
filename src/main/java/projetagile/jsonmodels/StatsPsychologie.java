/*
 * Objet statistique psychologie.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsPsychologie extends MontantSoinStats {

    public StatsPsychologie() {
        super();
    }

    public StatsPsychologie(int compteur, Dollar somme, Dollar maximum) {
        super(compteur, somme, maximum);
    }

}
