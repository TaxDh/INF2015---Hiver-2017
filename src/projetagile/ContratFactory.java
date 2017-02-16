/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;

/**
 *
 * @author rene
 */
public class ContratFactory {
    public static InterfaceContrat instancieContrat(ModeleJsonIn modele){
        char typeContrat = modele.getTypeContrat();
        InterfaceContrat contractHolder = null;
        switch(typeContrat){
            case 'A':
                contractHolder = new ContratA(modele);
                break;
            case 'B':
                contractHolder = new ContratB(modele);
                break;
            case 'C':
                contractHolder = new ContratC(modele);
                break;
            case 'D':
                contractHolder = new ContratD(modele);
                break;
        }
        return contractHolder;
    }
}
