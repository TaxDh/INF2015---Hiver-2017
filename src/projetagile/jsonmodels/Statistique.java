/*
 * L'objet statistique pour le fichier json statistique
 */
package projetagile.jsonmodels;

import java.util.List;

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
    
    public void reinitialise(){
        this.setReclamationValide(0);
        this.setReclamationRejete(0);
        this.setNbSoinMassotheratpie(0);
        this.setNbSoinOsteopathie(0);
        this.setNbSoinKinesitherapie(0);
        this.setNbSoinMGP(0);
        this.setNbSoinPsychologie(0);
        this.setNbSoinDentaire(0);
        this.setNbSoinNaturo(0);
        this.setNbSoinChiropratie(0);
        this.setNbSoinPhysiotherapie(0);
        this.setNbSoinOrthophonie(0);
    }
    
    public void afficherStatistiques(){
        System.out.println("Le nombre de reclamations valides" + this.getReclamationValide());
        System.out.println("Le nombre de reclamations rejetes" + this.getReclamationRejete());
        System.out.println("Le nombre de massotherapies traitees " + this.getNbSoinMassotheratpie());
        System.out.println("Le nombre de osteopathies traitees " + this.getNbSoinOsteopathie());
        System.out.println("Le nombre de kinesitherapies traitees " + this.getNbSoinKinesitherapie());
        System.out.println("Le nombre de medecins generalistes prives traitees " +this.getNbSoinMGP());
        System.out.println("Le nombre de psychologies individuelles traitees " + this.getNbSoinPsychologie());
        System.out.println("Le nombre de soins dentaires traitees " + this.getNbSoinDentaire());
        System.out.println("Le nombre de naturopathies et/ou acuponctures traitees " + this.getNbSoinNaturo());
        System.out.println("Le nombre de chiropratie traitees " + this.getNbSoinChiropratie());
        System.out.println("Le nombre de physiotherapies traitees " + this.getNbSoinPhysiotherapie());
        System.err.println("Le nombre d'orthophonies et/ou d'ergotherapies traitees " + this.getNbSoinOrthophonie()); 
    }
}

    
    
    