/*
 * Objet contenant les statistiques pour chaque soin
 */
package projetagile.jsonmodels;

import projetagile.Dollar;

public class MontantSoinStats {
    private Dollar montantMaxMassotherapie;
    private Dollar montantMaxOsteopathie;
    private Dollar montantMaxkinesitherapie;
    private Dollar montantMaxMGP;
    private Dollar montantMaxPsychologie;
    private Dollar montantMaxDentaire;
    private Dollar montantMaxNaturo;
    private Dollar montantMaxChiropratie;
    private Dollar montantMaxPhysiotherapie;
    private Dollar montantMaxOrthophonie;    
    

    public MontantSoinStats(Dollar montantMaxMassotherapie, Dollar montantMaxOsteopathie, Dollar montantMaxkinesitherapie,
            Dollar montantMaxMGP, Dollar montantMaxPsychologie, Dollar montantMaxDentaire, Dollar montantMaxNaturo,
            Dollar montantMaxChiropratie, Dollar montantMaxPhysiotherapie, Dollar montantMaxOrthophonie) {
        
        this.montantMaxMassotherapie = montantMaxMassotherapie;
        this.montantMaxOsteopathie = montantMaxOsteopathie;
        this.montantMaxkinesitherapie = montantMaxkinesitherapie;
        this.montantMaxMGP = montantMaxMGP;
        this.montantMaxPsychologie = montantMaxPsychologie;
        this.montantMaxDentaire = montantMaxDentaire;
        this.montantMaxNaturo = montantMaxNaturo;
        this.montantMaxChiropratie = montantMaxChiropratie;
        this.montantMaxPhysiotherapie = montantMaxPhysiotherapie;
        this.montantMaxOrthophonie = montantMaxOrthophonie;
    }
    
    public MontantSoinStats(){        
    }
    
    public Dollar getMontantMaxMassotherapie() {
        return montantMaxMassotherapie;
    }

    public void setMontantMaxMassotherapie(Dollar montantMaxMassotherapie) {
        this.montantMaxMassotherapie = montantMaxMassotherapie;
    }

    public Dollar getMontantMaxOsteopathie() {
        return montantMaxOsteopathie;
    }

    public void setMontantMaxOsteopathie(Dollar montantMaxOsteopathie) {
        this.montantMaxOsteopathie = montantMaxOsteopathie;
    }

    public Dollar getMontantMaxkinesitherapie() {
        return montantMaxkinesitherapie;
    }

    public void setMontantMaxkinesitherapie(Dollar montantMaxkinesitherapie) {
        this.montantMaxkinesitherapie = montantMaxkinesitherapie;
    }

    public Dollar getMontantMaxMGP() {
        return montantMaxMGP;
    }

    public void setMontantMaxMGP(Dollar montantMaxMGP) {
        this.montantMaxMGP = montantMaxMGP;
    }

    public Dollar getMontantMaxPsychologie() {
        return montantMaxPsychologie;
    }

    public void setMontantMaxPsychologie(Dollar montantMaxPsychologie) {
        this.montantMaxPsychologie = montantMaxPsychologie;
    }

    public Dollar getMontantMaxDentaire() {
        return montantMaxDentaire;
    }

    public void setMontantMaxDentaire(Dollar montantMaxDentaire) {
        this.montantMaxDentaire = montantMaxDentaire;
    }

    public Dollar getMontantMaxNaturo() {
        return montantMaxNaturo;
    }

    public void setMontantMaxNaturo(Dollar montantMaxNaturo) {
        this.montantMaxNaturo = montantMaxNaturo;
    }

    public Dollar getMontantMaxChiropratie() {
        return montantMaxChiropratie;
    }

    public void setMontantMaxChiropratie(Dollar montantMaxChiropratie) {
        this.montantMaxChiropratie = montantMaxChiropratie;
    }

    public Dollar getMontantMaxPhysiotherapie() {
        return montantMaxPhysiotherapie;
    }

    public void setMontantMaxPhysiotherapie(Dollar montantMaxPhysiotherapie) {
        this.montantMaxPhysiotherapie = montantMaxPhysiotherapie;
    }

    public Dollar getMontantMaxOrthophonie() {
        return montantMaxOrthophonie;
    }

    public void setMontantMaxOrthophonie(Dollar montantMaxOrthophonie) {
        this.montantMaxOrthophonie = montantMaxOrthophonie;
    }
    
}
