/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;
import projetagile.jsonmodels.Statistique;
import projetagile.jsonmodels.StatSoin;

/**
 *
 * @author rene
 */
public class AffichageStats {
    
    public static void afficherStatistiques(Statistique stat){
        System.out.println("Le nombre de reclamations valides" + stat.getReclamationValide());
        System.out.println("Le nombre de reclamations rejetes" + stat.getReclamationRejete());
        System.out.println("Le nombre de massotherapie traitees" + stat.getSoin().getNbMassotherapie);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        "massotherapie": 0
	}, {
		"ostheopathie": 0
	}, {
		"kinesitherapie": 0
	}, {
		"medecin_generaliste_prive": 0
	}, {
		"psychologie_individuelle": 0
	}, {
		"soin_dentaire": 0
	}, {
		"naturopathie_acuponcture": 0
	}, {
		"chiropratie": 0
	}, {
		"physiotherapie": 0
	}, {
		"Orthophonie_ergotherapie": 0
        
    }
    
}
