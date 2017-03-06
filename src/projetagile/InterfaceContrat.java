/* classe pour lier la reclamation pour un soin donné au bon type de contrat.
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Remboursement;


public abstract class InterfaceContrat {
    
    private ModeleJsonIn modele;
    
    public InterfaceContrat(ModeleJsonIn modele) {
        
        this.modele = modele;
    }

    
    public ModeleJsonOut calculRemboursement(){
        ModeleJsonOut sortie = new ModeleJsonOut();
        sortie.setDossier(modele.getTypeContrat() + modele.getClient());
        sortie.setMois(modele.getMois());
        
        parcoursLesReclamations(sortie);
        //modele.addReclamation(nouvelleReclamation);
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
    
    public static double convertirStringEnDouble(String strMontant){
        double montant;
        String stringSansDollar = strMontant.replace("$", "");
        
        if(contientVirgule(stringSansDollar)){
            stringSansDollar = stringSansDollar.replace(",", ".");
        }
        montant = Double.parseDouble(stringSansDollar);
        
        return montant;
    }
    
    
    
    public static boolean contientVirgule(String montant){
        boolean reponse = false;
        for(int i = 0; i < montant.length(); i++){
            if(montant.charAt(i) == ','){
                reponse = true;
            } 
        }
        return reponse;
    }
            
            
    public static String convertirDoubleEnString(double dblMontant){
        String montant;
        
        montant = String.format("%.2f", dblMontant);//vive le C
        montant = montant + "$";        
        montant = montant.replace(",", ".");
        
        return montant;
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
    
    
    
}
