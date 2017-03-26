/*
 * Les statistiques pour chaque type de soin.
 */
package projetagile.jsonmodels;

/**
 *
 * @author rene
 */
public class StatSoin {
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

    public StatSoin(int nbSoinMassotheratpie, int nbSoinOsteopathie, int nbSoinKinesitherapie, int nbSoinMGP,
            int nbSoinPsychologie, int nbSoinDentaire, int nbSoinNaturo, int nbSoinChiropratie, 
            int nbSoinPhysiotherapie, int nbSoinOrthophonie) {
        
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
    
    public StatSoin(){
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
    
    
    
}
