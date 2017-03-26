package projetagile;



import projetagile.InterfaceContrat;
import static projetagile.Dollar.convertirDoubleEnString;
import static projetagile.Dollar.convertirStringEnDouble;
import projetagile.jsonmodels.ModeleJsonIn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jg891159
 */
public class ContratE extends InterfaceContrat {
    
    public ContratE(ModeleJsonIn modele) {
        
        super(modele);
    }
  
   
     //Type de soin
    //numero 0
    public Dollar massotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 100
    public Dollar osteopathie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 150
    public Dollar kinesitherapie (Dollar montant){
       /* double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 175
    public Dollar medecin_generaliste_prive (Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        if(montantDouble > 20){
            montantDouble = 20;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 200
    public Dollar psychologie_individuelle(Dollar montant){
       /* double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.12;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 300 a 399
    public Dollar soin_dentaire(Dollar montant){
       /* double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.6;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 400   
    public Dollar naturo_acuponcture(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        if(montantDouble > 15){
            montantDouble = 15;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 500
    public Dollar chiropratie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.30;
        if(montantDouble > 20){
            montantDouble = 20;
        }
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    
    //numero 600
    public Dollar physiotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
    //numero 700
    public Dollar orthophonie_ergotherapie(Dollar montant){
        /*double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.22;
        return Dollar.convertirDoubleEnString(montantDouble);*/
        return new Dollar();
    }
}
