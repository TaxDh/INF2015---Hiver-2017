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
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("85$")).getMontant()){
            remboursement = new Dollar("85$");
        }
        return remboursement;
    }
    
    //numero 100
    public Dollar osteopathie(Dollar montant){
       Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("75$")).getMontant()){
            remboursement = new Dollar("75$");
        }
        if(remboursement.getMontant() > maximumMensuelOsteopahtie.getMontant()){
            remboursement.setMontant(maximumMensuelOsteopahtie.getMontant());
        }
        maximumMensuelOsteopahtie.soustractionDollar(remboursement);
        return remboursement;
    }
        //numero 150
    public Dollar kinesitherapie (Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("150$")).getMontant()){
            remboursement = new Dollar("150$");
        }
        return remboursement;
    }
    
    //numero 175
    public Dollar medecin_generaliste_prive (Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(0.95);
        if(remboursement.getMontant() > maximumMensuelMedGenPriv.getMontant()){
            remboursement.setMontant(maximumMensuelMedGenPriv.getMontant());
        }
        maximumMensuelMedGenPriv.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 200
    public Dollar psychologie_individuelle(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("100$")).getMontant()){
            remboursement = new Dollar("100$");
        }
        if(remboursement.getMontant() > maximumMensuelPsychologieInd.getMontant()){
            remboursement.setMontant(maximumMensuelPsychologieInd.getMontant());
        }
        maximumMensuelPsychologieInd.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 300 a 399
    public Dollar soin_dentaire(Dollar montant){
        return montant.calculerRemboursement(1.0);
    }
    
    //numero 400   
    public Dollar naturo_acuponcture(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("65$")).getMontant()){
            remboursement = new Dollar("65$");
        }
        return remboursement;
    }
    
    //numero 500
    public Dollar chiropratie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > maximumMensuelChiropratie.getMontant()){
            remboursement.setMontant(maximumMensuelChiropratie.getMontant());
        }
        maximumMensuelChiropratie.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 600
    public Dollar physiotherapie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("100$")).getMontant()){
            remboursement = new Dollar("100$");
        }
        if(remboursement.getMontant() > maximumMensuelPhysiotherapie.getMontant()){
            remboursement.setMontant(maximumMensuelPhysiotherapie.getMontant());
        }
        maximumMensuelPhysiotherapie.soustractionDollar(remboursement);
        return remboursement;
    }
    //numero 700
    public Dollar orthophonie_ergotherapie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(1.0);
        if(remboursement.getMontant() > (new Dollar("90$")).getMontant()){
            remboursement = new Dollar("90$");
        }
        return remboursement;
    }
   
}
