/* classe pour lier la reclamation pour un soin donné au bon type de contrat.
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Remboursement;


public abstract class InterfaceContrat {
    
    public final String maximumMensuelOsteopahtie = "250.00$";
    public final String maximumMensuelMedGenPriv = "200.00$";
    public final String maximumMensuelPsychologieInd = "250.00$";
    public final String maximumMensuelChiropratie = "150.00$";
    public final String maximumMensuelPhysiotherapie = "300.00$";
            
    private ModeleJsonIn modele;
    
    public String compteurOsteopathie = "0";
    public String compteurMedGenPriv = "0";
    public String compteurPsychologieInd = "0";
    public String compteurChiropratie = "0";
    public String compteurPhysiotherapie = "0";
    
    public InterfaceContrat(ModeleJsonIn modele) {
        
        this.modele = modele;
    }

    
    public ModeleJsonOut calculRemboursement(){
        ModeleJsonOut sortie = new ModeleJsonOut();
        sortie.setDossier(modele.getTypeContrat() + modele.getClient());
        sortie.setMois(modele.getMois());
        
        parcoursLesReclamations(sortie);
        return sortie;
    }

    private void parcoursLesReclamations(ModeleJsonOut sortie) {
        for(Reclamation reclamation : modele.getReclamations()){
            String strMontant = reclamation.getMontant();
            String strRemboursement = "";
            
            Remboursement nouveauRemboursement = setLeNouveauRemboursement(reclamation);
            
            strRemboursement = choixDuSoinATraiter(reclamation, strRemboursement, strMontant);
            nouveauRemboursement.setMontant(strRemboursement);
            
            sortie.addRemboursement(nouveauRemboursement);
        }
    }

    private Remboursement setLeNouveauRemboursement(Reclamation reclamation) {
        Remboursement nouveauRemboursement = new Remboursement();
        nouveauRemboursement.setSoins(reclamation.getSoins());
        nouveauRemboursement.setDate(reclamation.getDate());
        return nouveauRemboursement;
    }

    private String choixDuSoinATraiter(Reclamation reclamation, String strRemboursement, String strMontant) {
        if(reclamation.getSoins() == 0){
            strRemboursement =  massotherapie(strMontant);
        } else if(reclamation.getSoins() == 100){
            strRemboursement = osteopathie(strMontant);
        } else if(reclamation.getSoins() == 150){
            strRemboursement = kinesitherapie(strMontant);
        } else if(reclamation.getSoins() == 175){
            strRemboursement = medecin_generaliste_prive(strMontant);
        } else if(reclamation.getSoins() == 200){
            strRemboursement = psychologie_individuelle(strMontant);
        } else if(reclamation.getSoins() >= 300 && reclamation.getSoins() < 400){
            strRemboursement = soin_dentaire(strMontant);
        } else if(reclamation.getSoins() == 400){
            strRemboursement = naturo_acuponcture(strMontant);
        } else if(reclamation.getSoins() == 500){
            strRemboursement = chiropratie(strMontant);
        } else if(reclamation.getSoins() == 600){
            strRemboursement = physiotherapie(strMontant);
        } else if(reclamation.getSoins() == 700){
            strRemboursement = orthophonie_ergotherapie(strMontant);
        }
        return strRemboursement;
    }
    
    
    
    //numero 0
    public abstract String massotherapie(String montant);
    
    //numero 100
    public abstract String osteopathie(String montant);
    
    //numero 150
    public abstract String kinesitherapie (String montant);
    
    //numero 175
    public abstract String medecin_generaliste_prive (String montant);
    
    //numero 200
    public abstract String psychologie_individuelle(String montant);
    
    //numero 300 a 399
    public abstract String soin_dentaire(String montant);
    
   //numero 400    
    public abstract String naturo_acuponcture(String montant);
    
   //numero 500
    public abstract String chiropratie(String montant);
    
    //numero 600
    public abstract String physiotherapie(String montant);
    
    //numero 700
    public abstract String orthophonie_ergotherapie(String montant);
    
    public static String maxMensuel (){
        
        return "";
    }
       
    
}
