/*
 * ca choisi le contrat
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;


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
            case 'E' :
                contractHolder = new ContratE(modele);
                break;
        }
        return contractHolder;
    }
}
