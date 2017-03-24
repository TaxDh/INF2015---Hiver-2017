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
    
    
    public static int convertirStringEnInt(String strMontant){
        double dblMontant;
        int montant;
        
        dblMontant = convertirStringEnDouble(strMontant);
        montant = convertirDoubleEnInt(dblMontant);
        
        return montant;
    }
    
    public static String convertirIntEnString(int intMontant){
        String montant;
        double dblMontant = convertirDoubleEnInt(intMontant);
        
        montant = convertirDoubleEnString(dblMontant);
        return "";
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
        montant = String.format("%.2f", dblMontant); 
        montant = montant + "$";
        montant = montant.replace(",", ".");
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
    
    
    
    /*public static String calculMontant(String montant, int pourcentage, boolean maximum, int maximumRemboursement){
        
        
        
        return "";
    }*/
    
    /*public String osteopathie(String montant){
        double montantDouble = Dollar.convertirStringEnDouble(montant);
        montantDouble = montantDouble * 0.50;
        if(montantDouble > 50){
            montantDouble = 50;
        }
        return Dollar.convertirDoubleEnString(montantDouble);
    }*/
    
    
}
