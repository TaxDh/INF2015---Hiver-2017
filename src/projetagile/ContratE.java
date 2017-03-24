/*
 * Objet contrat E, avec les méthodes type de soins associées
 */
package projetagile;



import projetagile.InterfaceContrat;
import static projetagile.Dollar.convertirDoubleEnString;
import static projetagile.Dollar.convertirStringEnDouble;
import projetagile.jsonmodels.ModeleJsonIn;



public class ContratE extends InterfaceContrat {
    
    public ContratE(ModeleJsonIn modele) {
        
        super(modele);
    }
  
   
    //Type de soin
    //numero 0
    public String massotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 100
    public String osteopathie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 150
    public String kinesitherapie (String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 175
    public String medecin_generaliste_prive (String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        if(montantDouble > 20){
            montantDouble = 20;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 200
    public String psychologie_individuelle(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.12;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 300 a 399
    public String soin_dentaire(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.6;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 400   
    public String naturo_acuponcture(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.25;
        if(montantDouble > 15){
            montantDouble = 15;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 500
    public String chiropratie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.30;
        if(montantDouble > 20){
            montantDouble = 20;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    
    //numero 600
    public String physiotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.15;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
    //numero 700
    public String orthophonie_ergotherapie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.22;
        return Dollar.convertirDoubleEnString(montantDouble);
    }
}
