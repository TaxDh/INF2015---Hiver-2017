/*
 * Objet Dollar pour faire les calculs de montant
 */
package projetagile;

public class Dollar {    

    static Object convertirDoubleEnInt(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
        int montantModuloInt;
        double montantModuloDbl;
        
        montant = intMontant/100;
        montantModuloInt = intMontant % 100;
        montantModuloDbl = (double) montantModuloInt;
        montant += montantModuloDbl / 100;
        
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
