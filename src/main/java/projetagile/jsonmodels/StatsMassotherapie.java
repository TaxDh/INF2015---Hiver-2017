/*
 * Objet statistique massotherapie;
 */
package projetagile.jsonmodels;

import projetagile.Dollar;


public class StatsMassotherapie extends MontantSoinStats {
    public StatsMassotherapie(){
        super();
    }
    
    public StatsMassotherapie(int compteur, Dollar somme, Dollar maximum){
        super(compteur, somme, maximum);
    }
}
