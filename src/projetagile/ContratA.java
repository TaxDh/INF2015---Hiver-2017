/*
 * Objet contrat A, avec les méthodes type de soins associées.
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;

public class ContratA extends InterfaceContrat{
    

    public ContratA(ModeleJsonIn modele) {
        
        super(modele);
    }
  
   
    //Type de soin
    //numero 0
    @Override
    public Dollar massotherapie(Dollar montant){
        return montant.calculerRemboursement(0.25);
    }
    
    //numero 100
    @Override
    public Dollar osteopathie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(0.35);
        if(remboursement.getMontant() > maximumMensuelOsteopahtie.getMontant()){
            remboursement.setMontant(maximumMensuelOsteopahtie.getMontant());
        }
        maximumMensuelOsteopahtie.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 150
    @Override
    public Dollar kinesitherapie (Dollar montant){
       return montant.calculerRemboursement(0.0);
    }
    
    //numero 175
    @Override
    public Dollar medecin_generaliste_prive (Dollar montant){
       Dollar remboursement = montant.calculerRemboursement(0.5);
        if(remboursement.getMontant() > maximumMensuelMedGenPriv.getMontant()){
            remboursement.setMontant(maximumMensuelMedGenPriv.getMontant());
        }
        maximumMensuelMedGenPriv.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 200
    @Override
    public Dollar psychologie_individuelle(Dollar montant){
       Dollar remboursement = montant.calculerRemboursement(0.25);
        if(remboursement.getMontant() > maximumMensuelPsychologieInd.getMontant()){
            remboursement.setMontant(maximumMensuelPsychologieInd.getMontant());
        }
        maximumMensuelPsychologieInd.soustractionDollar(remboursement);
        return remboursement;
    }

    
    //numero 300 a 399
    @Override
    public Dollar soin_dentaire(Dollar montant){
       return montant.calculerRemboursement(0.0);
    }
    
    //numero 400
    @Override
    public Dollar naturo_acuponcture(Dollar montant){
       return montant.calculerRemboursement(0.0);
    }
    
    //numero 500
    @Override
    public Dollar chiropratie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(0.25);
        if(remboursement.getMontant() > maximumMensuelChiropratie.getMontant()){
            remboursement.setMontant(maximumMensuelChiropratie.getMontant());
        }
        maximumMensuelChiropratie.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 600
    @Override
    public Dollar physiotherapie(Dollar montant){
        Dollar remboursement = montant.calculerRemboursement(0.4);
        if(remboursement.getMontant() > maximumMensuelPhysiotherapie.getMontant()){
            remboursement.setMontant(maximumMensuelPhysiotherapie.getMontant());
        }
        maximumMensuelPhysiotherapie.soustractionDollar(remboursement);
        return remboursement;
    }
    
    //numero 700
    @Override
    public Dollar orthophonie_ergotherapie(Dollar montant){
        return montant.calculerRemboursement(0.0);
    }
    
}
