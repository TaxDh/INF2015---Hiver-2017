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
        this.montant = convertirStringDollarEnInt(montantStr);
    }
    
    public void additionDollar (Dollar dollar){
        this.montant += dollar.getMontant();
    }
    
    public void soustractionDollar(Dollar dollar){
        this.montant -= dollar.getMontant();
    }
    
    public Dollar divisionDollarParInt(int entier){
        return new Dollar(this.montant / entier);
    }
    
    public Dollar calculerRemboursement(double pourcentage){
        double pourcentageRemboursement = this.montant * pourcentage;
        Dollar remboursementDollar = new Dollar((int)pourcentageRemboursement);
        return remboursementDollar;
    }
    
    public static int convertirStringDollarEnInt(String strMontant){
        double dblMontant;
        int montant;
        
        dblMontant = convertirStringDollarEnDouble(strMontant);
        montant = convertirDoubleEnInt(dblMontant);
        
        return montant;
    }
    
    public static String convertirIntEnStringDollar(int intMontant){
        String montant;
        double dblMontant = convertirIntEnDouble(intMontant);
        
        montant = convertirDoubleEnStringDollar(dblMontant);
        
        return montant;
    }
    
    public String convertirEnStringDollar(){
        String montant;
        double dblMontant = convertirIntEnDouble(this.montant);
        
        montant = convertirDoubleEnStringDollar(dblMontant);
        
        return montant;
    }
 
    public static int convertirDoubleEnInt(double dblMontant){
        int montant;
        
        montant = (int) Math.round(dblMontant * 100);
                
        return montant;
    }
    
    public static double convertirIntEnDouble(int intMontant){
        double montant;
        double reste;
        
        montant = intMontant/100;
        reste = (double) intMontant % 100;
        montant += reste / 100;
        
        return montant;
    }    

    public static double convertirStringDollarEnDouble(String strMontant) {
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

    public static String convertirDoubleEnStringDollar(double dblMontant) {
        String montant;
        montant = String.format("%.2f", dblMontant); 
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
