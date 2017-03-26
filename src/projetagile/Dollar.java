/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

/**
 *
 * @author kf891141
 */
public class Dollar {    
    
    private int montant;

    public Dollar(){
        this.montant = 0;
    }
    
    public Dollar(int montantInt){
        this.montant = montantInt;
    }
    
    public Dollar(double montantDbl){
        this.montant = convertirDoubleEnInt(montantDbl);
    }
    
    public Dollar (String montantStr){
        this.montant = convertirStringEnInt(montantStr);
    }
    
    public static String calculMontant(String montant, double pourcentage, boolean maximum,
            int maximumRemboursement, String maximumMensuel){
        
        int maxMensuelInt = convertirStringEnInt(maximumMensuel);
        int intRemboursement = convertirStringEnInt(montant);
        
        intRemboursement *= pourcentage;
        intRemboursement = siMaximumAtteint(maximum, intRemboursement, maximumRemboursement);
        if(intRemboursement > maxMensuelInt){
            intRemboursement = maxMensuelInt;
            
        }
        return convertirIntEnString(intRemboursement);
    }

    private static int siMaximumAtteint(boolean maximum, int intRemboursement, int maximumRemboursement) {
        if(maximum){
            if(intRemboursement > maximumRemboursement*100){
                intRemboursement = maximumRemboursement*100;
            }
        }
        return intRemboursement;
    }
    
    public void additionDollar (Dollar dollar){
        this.montant += dollar.getMontant();
    }
    
    public void soustractionDollar(Dollar dollar){
        this.montant -= dollar.getMontant();
    }
    
    public Dollar calculerRemboursement(double pourcentage){
        double pourcentageRemboursement = this.montant * pourcentage;
        Dollar remboursementDollar = new Dollar((int)pourcentageRemboursement);
        return remboursementDollar;
    }
    
    public static int convertirStringEnInt(String strMontant){
        double dblMontant;
        int montant;
        
        dblMontant = convertirStringEnDouble(strMontant);
        montant = convertirDoubleEnInt(dblMontant);
        
        return montant;
    }
    
    public static String convertirIntEnString(int intMontant){
        String montant;
        double dblMontant = convertirIntEnDouble(intMontant);
        
        montant = convertirDoubleEnString(dblMontant);
        
        return montant;
    }
    
    public String convertirEnString(){
        String montant;
        double dblMontant = convertirIntEnDouble(this.montant);
        
        montant = convertirDoubleEnString(dblMontant);
        
        return montant;
    }
 
    public static int convertirDoubleEnInt(double dblMontant){
        int montant;
        
        dblMontant *= 100;
        montant = (int) dblMontant;
                
        return montant;
    }
    
    public static double convertirIntEnDouble(int intMontant){
        double montant;
        
        montant = intMontant/100 + (double) intMontant % 100;
        
        return montant;
    }    

    public static double convertirStringEnDouble(String strMontant) {
        double montant;
        String stringSansDollar = strMontant.replace("$", "");
        if (contientVirgule(stringSansDollar)) {
            stringSansDollar = stringSansDollar.replace(",", ".");
        }
        montant = Double.parseDouble(stringSansDollar);
        return montant;
    }

    public static boolean contientVirgule(String montant) {
        boolean reponse = false;
        for (int i = 0; i < montant.length(); i++) {
            if (montant.charAt(i) == ',') {
                reponse = true;
            }
        }
        return reponse;
    }

    public static String convertirDoubleEnString(double dblMontant) {
        String montant;
        montant = String.format("%.2f", dblMontant); //vive le C
        montant = montant + "$";
        montant = montant.replace(",", ".");
        return montant;
    }
    
     public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
