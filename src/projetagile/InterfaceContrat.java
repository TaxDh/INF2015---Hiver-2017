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
    /*méthode pour chaque type de soin défini de manière générale pour 
    chaque contrat*/
    
    private ModeleJsonIn modele;
    
    public InterfaceContrat(ModeleJsonIn modele) {
        
        this.modele = modele;
    }
    //parametre un int pour le numero et le cout, je pense
    public ModeleJsonOut calculRemboursement(){
        ModeleJsonOut sortie = new ModeleJsonOut();
        sortie.setClient(modele.getClient());
        sortie.setMois(modele.getMois());
        
        for(Reclamation reclamation : modele.getReclamations()){
            String strMontant = reclamation.getMontant();
            String strRemboursement = "";
            
            Remboursement nouveauRemboursement = new Remboursement();
            nouveauRemboursement.setSoins(reclamation.getSoins());
            nouveauRemboursement.setDate(reclamation.getDate());
            
            if(reclamation.getSoins() == 0){
                strRemboursement =  massotherapie(strMontant);
            } else if(reclamation.getSoins() == 100){
                strRemboursement = kinésithérapie(strMontant);
            } else if(reclamation.getSoins() == 150){
                strRemboursement = medecin_generalistep(strMontant);
             } else if(reclamation.getSoins() == 175){
                strRemboursement = osteopathie(strMontant);
            } else if(reclamation.getSoins() == 200){
                strRemboursement = psychologie_individuelle(strMontant);
            } else if(reclamation.getSoins() >= 300 && reclamation.getSoins() < 400){
                strRemboursement = soin_dentaire(strMontant);
            } else if(reclamation.getSoins() == 400){
                strRemboursement = naturo_acup(strMontant);
            } else if(reclamation.getSoins() == 500){
                strRemboursement = chiropratie(strMontant);
            } else if(reclamation.getSoins() == 600){
                strRemboursement = physiotherapie(strMontant);
            } else if(reclamation.getSoins() == 700){
                strRemboursement = ortho_ergo(strMontant);
            }
            
            nouveauRemboursement.setMontant(strRemboursement);
            
            sortie.addRemboursement(nouveauRemboursement);
        }
        //modele.addReclamation(nouvelleReclamation);
        return sortie;
    }
    
    //Methode pour transformer un montant en double
    public static double convertirStringEnDouble(String strMontant){
        double montant;
        String stringSansDollar = strMontant.replace("$", "");
        
        if(contientVirgule(stringSansDollar)){
            stringSansDollar = stringSansDollar.replace(",", ".");
        }
        
        montant = Double.parseDouble(stringSansDollar);
        
        return montant;
    }
    
    
    //methode pour savoir s'il faut remplacer la virgule par un point
    //dans le montant
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
        
        return montant;
    }
    
    
    //numero 0
    public abstract String massotherapie(String montant);
    
    //numero 100
    public abstract String osteopathie(String montant);
    
    //numero 150
    public abstract String kinesitherapie (String montant);
    
    //numero 175
    public abstract String medecin_generalistep (String montant);
    
    //numero 200
    public abstract String psychologie_individuelle(String montant);
    
    //numero 300 a 399
    public abstract String soin_dentaire(String montant);
    
   //numero 400    
    public abstract String naturo_acup(String montant);
    
   //numero 500
    public abstract String chiropratie(String montant);
    
    //numero 600
    public abstract String physiotherapie(String montant);
    
    //numero 700
    public abstract String ortho_ergo(String montant);
    
    
    
}
