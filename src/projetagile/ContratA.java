/*
 * Objet contrat A, avec les méthodes type de soins associées
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
public class ContratA extends InterfaceContrat{
    

    public ContratA(ModeleJsonIn modele) {
        
        super(modele);
    }
  
   
    //Type de soin
    //numero 0
    public Dollar massotherapie(Dollar montant){
        //double montantDouble = Dollar.convertirStringEnDouble(montant);
        //montantDouble = montantDouble * 0.25;
        //return Dollar.convertirDoubleEnString(montantDouble);
        Dollar remboursement ;
        remboursement = montant.calculerRemboursement(0.25);
        return remboursement;
    }
    
    //numero 100
    public Dollar osteopathie(Dollar montant){
        Dollar remboursement ;
        remboursement = montant.calculerRemboursement(0.35);
        if(remboursement.getMontant() > maximumMensuelOsteopahtie.getMontant()){
            remboursement.setMontant(maximumMensuelOsteopahtie.getMontant());
        }
        maximumMensuelOsteopahtie.soustractionDOllar(remboursement);
        return remboursement;
    }
    
    //numero 150
    public Dollar kinesitherapie (Dollar montant){
        //double montantDouble = Dollar.convertirStringEnDouble(montant);
        //montantDouble = montantDouble * 0.0;
       // return Dollar.convertirDoubleEnString(montantDouble);
       return new Dollar();
    }
    
    //numero 175
    public Dollar medecin_generaliste_prive (Dollar montant){
       // double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.5;
       // return Dollar.convertirDoubleEnString(montantDouble);
       return new Dollar();
    }
    
    //numero 200
    public Dollar psychologie_individuelle(Dollar montant){
       // double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.25;
       // return Dollar.convertirDoubleEnString(montantDouble);
       return new Dollar();
    }
    
    //numero 300 a 399
    public Dollar soin_dentaire(Dollar montant){
       // double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.0;
       // return Dollar.convertirDoubleEnString(montantDouble);
       return new Dollar();
    }
    
    //numero 400   
    public Dollar naturo_acuponcture(Dollar montant){
       // double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.0;
       // return Dollar.convertirDoubleEnString(montantDouble);
       return new Dollar();
    }
    
    //numero 500
    public Dollar chiropratie(Dollar montant){
        //double montantDouble = Dollar.convertirStringEnDouble(montant);
        //montantDouble = montantDouble * 0.25;
        //return Dollar.convertirDoubleEnString(montantDouble);
        return new Dollar();
    }
    
    //numero 600
    public Dollar physiotherapie(Dollar montant){
        //double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.40;
        //return Dollar.convertirDoubleEnString(montantDouble);
        return new Dollar();
    }
    //numero 700
    public Dollar orthophonie_ergotherapie(Dollar montant){
       // double montantDouble = Dollar.convertirStringEnDouble(montant);
       // montantDouble = montantDouble * 0.0;
       // return Dollar.convertirDoubleEnString(montantDouble);
        return new Dollar();
    }
}
