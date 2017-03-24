/*
 * Objet contrat B, avec les méthodes type de soins associées
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Remboursement;

/**
 *
 * @author kf891141
 */
public class ContratB extends InterfaceContrat{
     public ContratB(ModeleJsonIn modele) {
        
        super(modele);
    }
    
    //Type de soin
    //numero 0
    public String massotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 100
    public String osteopathie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.50;
        if(montantDouble > 50){
            montantDouble = 50;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 150
    public String kinesitherapie (String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.0;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 175
    public String medecin_generaliste_prive (String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.75;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 200
    public String psychologie_individuelle(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
         montantDouble = montantDouble * 1.0;
        
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 300 a 399
    public String soin_dentaire(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.50;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 400   
    public String naturo_acuponcture(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.0;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 500
    public String chiropratie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
         montantDouble = montantDouble * 0.50;
        if(montantDouble > 50){
            montantDouble = 50;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 600
    public String physiotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    //numero 700
    public String orthophonie_ergotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.70;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
}
