/* chaque soin est considéré comme une méthode
elle différe pour chaque objet (contrat), donc on utilise une classe
abstraite.
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
public abstract class InterfaceContrat {
    protected Dollar maximumMensuelOsteopahtie = new Dollar("250.00$");
    protected Dollar maximumMensuelMedGenPriv = new Dollar("200.00$");
    protected Dollar maximumMensuelPsychologieInd = new Dollar("250.00$");
    protected Dollar maximumMensuelChiropratie = new Dollar("150.00$");
    protected Dollar maximumMensuelPhysiotherapie = new Dollar("300.00$");
   
    private ModeleJsonIn modele;
    
    public InterfaceContrat(ModeleJsonIn modele) {
        
        this.modele = modele;
    }

    public ModeleJsonOut calculRemboursement(){
        ModeleJsonOut sortie = new ModeleJsonOut();
        sortie.setClient(modele.getClient());
        sortie.setMois(modele.getMois());
        
        for(Reclamation reclamation : modele.getReclamations()){
            Dollar montant = reclamation.getMontant();
            Dollar remboursementDollar = new Dollar();
            
            Remboursement nouveauRemboursement = new Remboursement();
            nouveauRemboursement.setSoins(reclamation.getSoins());
            nouveauRemboursement.setDate(reclamation.getDate());
            
            
            if(reclamation.getSoins() == 0){
                remboursementDollar =  massotherapie(montant);
            } else if(reclamation.getSoins() == 100){
                remboursementDollar = osteopathie(montant);
            } else if(reclamation.getSoins() == 150){
                remboursementDollar = kinesitherapie(montant);
            } else if(reclamation.getSoins() == 175){
                remboursementDollar = medecin_generaliste_prive(montant);
            } else if(reclamation.getSoins() == 200){
                remboursementDollar = psychologie_individuelle(montant);
            } else if(reclamation.getSoins() >= 300 && reclamation.getSoins() < 400){
                remboursementDollar = soin_dentaire(montant);
            } else if(reclamation.getSoins() == 400){
                remboursementDollar = naturo_acuponcture(montant);
            } else if(reclamation.getSoins() == 500){
                remboursementDollar = chiropratie(montant);
            } else if(reclamation.getSoins() == 600){
                remboursementDollar = physiotherapie(montant);
            } else if(reclamation.getSoins() == 700){
                remboursementDollar = orthophonie_ergotherapie(montant);
            }
            
            nouveauRemboursement.setMontant(remboursementDollar);
            
            sortie.ajouterRemboursement(nouveauRemboursement);
        }
        //modele.addReclamation(nouvelleReclamation);
        return sortie;
    }
    
    
    //numero 0
    public abstract Dollar massotherapie(Dollar montant);
    
    //numero 100
    public abstract Dollar osteopathie(Dollar montant);
    
    //numero 150
    public abstract Dollar kinesitherapie (Dollar montant);
    
    //numero 175
    public abstract Dollar medecin_generaliste_prive (Dollar montant);
    
    //numero 200
    public abstract Dollar psychologie_individuelle(Dollar montant);
    
    //numero 300 a 399
    public abstract Dollar soin_dentaire(Dollar montant);
    
   //numero 400    
    public abstract Dollar naturo_acuponcture(Dollar montant);
    
   //numero 500
    public abstract Dollar chiropratie(Dollar montant);
    
    //numero 600
    public abstract Dollar physiotherapie(Dollar montant);
    
    //numero 700
    public abstract Dollar orthophonie_ergotherapie(Dollar montant);
    
    
    
}
