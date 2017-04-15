/*
 * Objet contenant les statistiques pour chaque soin
 */
package projetagile.jsonmodels;

import java.util.List;
import projetagile.Dollar;

public class MontantSoinStats {
    private List<Dollar> montantMassotherapie;
    private List<Dollar> montantOsteopathie;
    private List<Dollar> montantkinesitherapie;
    private List<Dollar> montantMGP;
    private List<Dollar> montantPsychologie;
    private List<Dollar> montantDentaire;
    private List<Dollar> montantNaturo;
    private List<Dollar> montantChiropratie;
    private List<Dollar> montantPhysiotherapie;
    private List<Dollar> montantOrthophonie;    

    public MontantSoinStats() {
    }

    public MontantSoinStats(List<Dollar> montantMassotherapie, List<Dollar> montantOsteopathie,
            List<Dollar> montantkinesitherapie, List<Dollar> montantMGP, List<Dollar> montantPsychologie,
            List<Dollar> montantDentaire, List<Dollar> montantNaturo, List<Dollar> montantChiropratie,
            List<Dollar> montantPhysiotherapie) {
        
        this.montantMassotherapie = montantMassotherapie;
        this.montantOsteopathie = montantOsteopathie;
        this.montantkinesitherapie = montantkinesitherapie;
        this.montantMGP = montantMGP;
        this.montantPsychologie = montantPsychologie;
        this.montantDentaire = montantDentaire;
        this.montantNaturo = montantNaturo;
        this.montantChiropratie = montantChiropratie;
        this.montantPhysiotherapie = montantPhysiotherapie;
    }

    public List<Dollar> getMontantMassotherapie() {
        return montantMassotherapie;
    }

    public void setMontantMassotherapie(List<Dollar> montantMassotherapie) {
        this.montantMassotherapie = montantMassotherapie;
    }

    public List<Dollar> getMontantOsteopathie() {
        return montantOsteopathie;
    }

    public void setMontantOsteopathie(List<Dollar> montantOsteopathie) {
        this.montantOsteopathie = montantOsteopathie;
    }

    public List<Dollar> getMontantkinesitherapie() {
        return montantkinesitherapie;
    }

    public void setMontantkinesitherapie(List<Dollar> montantkinesitherapie) {
        this.montantkinesitherapie = montantkinesitherapie;
    }

    public List<Dollar> getMontantMGP() {
        return montantMGP;
    }

    public void setMontantMGP(List<Dollar> montantMGP) {
        this.montantMGP = montantMGP;
    }

    public List<Dollar> getMontantPsychologie() {
        return montantPsychologie;
    }

    public void setMontantPsychologie(List<Dollar> montantPsychologie) {
        this.montantPsychologie = montantPsychologie;
    }

    public List<Dollar> getMontantDentaire() {
        return montantDentaire;
    }

    public void setMontantDentaire(List<Dollar> montantDentaire) {
        this.montantDentaire = montantDentaire;
    }

    public List<Dollar> getMontantNaturo() {
        return montantNaturo;
    }

    public void setMontantNaturo(List<Dollar> montantNaturo) {
        this.montantNaturo = montantNaturo;
    }

    public List<Dollar> getMontantChiropratie() {
        return montantChiropratie;
    }

    public void setMontantChiropratie(List<Dollar> montantChiropratie) {
        this.montantChiropratie = montantChiropratie;
    }

    public List<Dollar> getMontantPhysiotherapie() {
        return montantPhysiotherapie;
    }

    public void setMontantPhysiotherapie(List<Dollar> montantPhysiotherapie) {
        this.montantPhysiotherapie = montantPhysiotherapie;
    }

    public List<Dollar> getMontantOrthophonie() {
        return montantOrthophonie;
    }

    public void setMontantOrthophonie(List<Dollar> montantOrthophonie) {
        this.montantOrthophonie = montantOrthophonie;
    }
    
    public Dollar rechercheMontantMax(List<Dollar> montantSoin){
        Dollar maxTrouve = new Dollar("0.00$");
        
        for(Dollar montantCourant: montantSoin){
            if(maxTrouve.getMontant() < montantCourant.getMontant()){
                maxTrouve.setMontant(montantCourant.getMontant());
            }
        }
        
        return maxTrouve;
    }
    
    public Dollar montantMoyen(List<Dollar> montantSoin){
        Dollar sommeMontant = new Dollar("0.00$");
    }

}
