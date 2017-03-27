/*
 * L'objet statistique pour le fichier json statistique
 */
package projetagile.jsonmodels;

import java.util.List;




/**
 *
 * @author rene
 */
public class Statistique {
    private int reclamationValide;
    private int reclamationRejete;
    private int nbSoinMassotheratpie;
    private int nbSoinOsteopathie;
    private int nbSoinKinesitherapie;
    private int nbSoinMGP;
    private int nbSoinPsychologie;
    private int nbSoinDentaire;
    private int nbSoinNaturo;
    private int nbSoinChiropratie;
    private int nbSoinPhysiotherapie;
    private int nbSoinOrthophonie;

    public Statistique(){
    }

    public Statistique(int reclamationValide, int reclamationRejete, int nbSoinMassotheratpie,
            int nbSoinOsteopathie, int nbSoinKinesitherapie, int nbSoinMGP, int nbSoinPsychologie,
            int nbSoinDentaire, int nbSoinNaturo, int nbSoinChiropratie, int nbSoinPhysiotherapie,
            int nbSoinOrthophonie) {
        
        this.reclamationValide = reclamationValide;
        this.reclamationRejete = reclamationRejete;
        this.nbSoinMassotheratpie = nbSoinMassotheratpie;
        this.nbSoinOsteopathie = nbSoinOsteopathie;
        this.nbSoinKinesitherapie = nbSoinKinesitherapie;
        this.nbSoinMGP = nbSoinMGP;
        this.nbSoinPsychologie = nbSoinPsychologie;
        this.nbSoinDentaire = nbSoinDentaire;
        this.nbSoinNaturo = nbSoinNaturo;
        this.nbSoinChiropratie = nbSoinChiropratie;
        this.nbSoinPhysiotherapie = nbSoinPhysiotherapie;
        this.nbSoinOrthophonie = nbSoinOrthophonie;
    }
    
    public int getReclamationValide() {
        return reclamationValide;
    }

    public void setReclamationValide(int reclamationValide) {
        this.reclamationValide = reclamationValide;
    }

    public int getReclamationRejete() {
        return reclamationRejete;
    }

    public void setReclamationRejete(int reclamationRejete) {
        this.reclamationRejete = reclamationRejete;
    }

    public int getNbSoinMassotheratpie() {
        return nbSoinMassotheratpie;
    }

    public void setNbSoinMassotheratpie(int nbSoinMassotheratpie) {
        this.nbSoinMassotheratpie = nbSoinMassotheratpie;
    }

    public int getNbSoinOsteopathie() {
        return nbSoinOsteopathie;
    }

    public void setNbSoinOsteopathie(int nbSoinOsteopathie) {
        this.nbSoinOsteopathie = nbSoinOsteopathie;
    }

    public int getNbSoinKinesitherapie() {
        return nbSoinKinesitherapie;
    }

    public void setNbSoinKinesitherapie(int nbSoinKinesitherapie) {
        this.nbSoinKinesitherapie = nbSoinKinesitherapie;
    }

    public int getNbSoinMGP() {
        return nbSoinMGP;
    }

    public void setNbSoinMGP(int nbSoinMGP) {
        this.nbSoinMGP = nbSoinMGP;
    }

    public int getNbSoinPsychologie() {
        return nbSoinPsychologie;
    }

    public void setNbSoinPsychologie(int nbSoinPsychologie) {
        this.nbSoinPsychologie = nbSoinPsychologie;
    }

    public int getNbSoinDentaire() {
        return nbSoinDentaire;
    }

    public void setNbSoinDentaire(int nbSoinDentaire) {
        this.nbSoinDentaire = nbSoinDentaire;
    }

    public int getNbSoinNaturo() {
        return nbSoinNaturo;
    }

    public void setNbSoinNaturo(int nbSoinNaturo) {
        this.nbSoinNaturo = nbSoinNaturo;
    }

    public int getNbSoinChiropratie() {
        return nbSoinChiropratie;
    }

    public void setNbSoinChiropratie(int nbSoinChiropratie) {
        this.nbSoinChiropratie = nbSoinChiropratie;
    }

    public int getNbSoinPhysiotherapie() {
        return nbSoinPhysiotherapie;
    }

    public void setNbSoinPhysiotherapie(int nbSoinPhysiotherapie) {
        this.nbSoinPhysiotherapie = nbSoinPhysiotherapie;
    }

    public int getNbSoinOrthophonie() {
        return nbSoinOrthophonie;
    }

    public void setNbSoinOrthophonie(int nbSoinOrthophonie) {
        this.nbSoinOrthophonie = nbSoinOrthophonie;
    }
    
    public void compterSoin(ModeleJsonOut sortie){
        List<Remboursement> listeRemboursement = sortie.getRemboursement();
        int soin;
        
        for(Remboursement remboursement: listeRemboursement){
            soin = remboursement.getSoins();
            
            if(soin == 0){
                this.nbSoinMassotheratpie++;
            } else if(soin == 100){
                this.nbSoinOsteopathie++;
            } else if(soin == 150){
                this.nbSoinKinesitherapie++;
            } else if(soin == 175){
                this.nbSoinMGP++;
            } else if(soin == 200){
                this.nbSoinPsychologie++;
            } else if(soin >= 300 && soin < 400){
                this.nbSoinDentaire++;
            } else if(soin == 400){
                this.nbSoinNaturo++;
            } else if(soin == 500){
                this.nbSoinChiropratie++;
            } else if(soin == 600){
                this.nbSoinPhysiotherapie++;
            } else if(soin == 700){
                this.nbSoinOrthophonie++;
            }
        }
    }
}

    
    
    