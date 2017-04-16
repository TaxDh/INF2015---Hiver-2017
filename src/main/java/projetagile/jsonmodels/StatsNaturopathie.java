/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class StatsNaturopathie extends MontantSoinStats{
    public StatsNaturopathie(){
        super();
    }
    
    public StatsNaturopathie(int compteur, Dollar somme, Dollar maximum){
        super(compteur, somme, maximum);
    }
    
}
