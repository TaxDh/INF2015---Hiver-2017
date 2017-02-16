/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

/**
 *
 * @author DELL
 */
public interface Contrat {
    public final String CONTRAT_A = "A";
    public final String CONTRAT_B = "B";
    public final String CONTRAT_C = "C";
    public final String CONTRAT_D = "D";
    
    
    public int[] numero_soin = {0, 100, 200, 300, 399, 400, 500, 600, 700};
    public double[] pourcentage_remboursement = {0.0 , 0.25 , 0.4 , 0.5 , 0.7 , 0.9 , 1.0 };
    public int[] max_rembourser = {40 ,50 ,65 ,70 ,75 ,85 ,90 ,100};
}
