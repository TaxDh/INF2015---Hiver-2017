/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsOrthophonie extends MontantSoinStats{
    public StatsOrthophonie(){
        super();
    }
    
    public StatsOrthophonie(int compteur, Dollar somme, Dollar maximum){
        super(compteur, somme, maximum);
    }
    
}
