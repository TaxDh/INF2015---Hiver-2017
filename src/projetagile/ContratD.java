/*
 * Objet contrat D, avec les méthodes type de soins associées
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
public class ContratD extends InterfaceContrat{
     public ContratD(ModeleJsonIn modele) {
        
        super(modele);
    }
    
    //Type de soin
    //numero 0
    public Dollar massotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 85){
            montantDouble = 85;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 100
    public Dollar osteopathie(Dollar montant){
       /* double montantDouble = Dollar.convertirStringEnDouble(montant);
       montantDouble = montantDouble * 1.0;
        if(montantDouble > 75){
            montantDouble = 75;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
        //numero 150
    public Dollar kinesitherapie (Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 150){
            montantDouble = 150;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 175
    public Dollar medecin_generaliste_prive (Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.95;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 200
    public Dollar psychologie_individuelle(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 100){
            montantDouble = 100;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 300 a 399
    public Dollar soin_dentaire(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 400   
    public Dollar naturo_acuponcture(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 65){
            montantDouble = 65;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 500
    public Dollar chiropratie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 600
    public Dollar physiotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 100){
            montantDouble = 100;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    //numero 700
    public Dollar orthophonie_ergotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 1.0;
        if(montantDouble > 90){
            montantDouble = 90;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
   
}
