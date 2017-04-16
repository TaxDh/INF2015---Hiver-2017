/*
 * L'objet statistique pour le fichier json statistique
 */
package projetagile.jsonmodels;

import java.util.List;

public class Statistique {
    private int reclamationValide;
    private int reclamationRejete;
    private StatsChiropratie chiropratie;
    private StatsDentaire dentaire;
    private StatsKinesitherapie kinesitherapie;
    private StatsMGP medecine;
    private StatsMassotherapie massotherapie;
    private StatsNaturopathie naturopathie;
    private StatsOrthophonie orthophonie;
    private StatsOstheopathie ostheopathie;
    private StatsPhysiotherapie physiotherapie;
    private StatsPsychologie psychologie;
    
    public Statistique(){
    }

    public Statistique(int reclamationValide, int reclamationRejete, StatsChiropratie chiropratie, 
            StatsDentaire dentaire, StatsKinesitherapie kinesitherapie, StatsMGP medecine, 
            StatsMassotherapie massotherapie, StatsNaturopathie naturopathie, StatsOrthophonie orthophonie,
            StatsOstheopathie ostheopathie, StatsPhysiotherapie physiotherapie, StatsPsychologie psychologie) {
        
        this.reclamationValide = reclamationValide;
        this.reclamationRejete = reclamationRejete;
        this.chiropratie = chiropratie;
        this.dentaire = dentaire;
        this.kinesitherapie = kinesitherapie;
        this.medecine = medecine;
        this.massotherapie = massotherapie;
        this.naturopathie = naturopathie;
        this.orthophonie = orthophonie;
        this.ostheopathie = ostheopathie;
        this.physiotherapie = physiotherapie;
        this.psychologie = psychologie;
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

    public StatsChiropratie getChiropratie() {
        return chiropratie;
    }

    public void setChiropratie(StatsChiropratie chiropratie) {
        this.chiropratie = chiropratie;
    }

    public StatsDentaire getDentaire() {
        return dentaire;
    }

    public void setDentaire(StatsDentaire dentaire) {
        this.dentaire = dentaire;
    }

    public StatsKinesitherapie getKinesitherapie() {
        return kinesitherapie;
    }

    public void setKinesitherapie(StatsKinesitherapie kinesitherapie) {
        this.kinesitherapie = kinesitherapie;
    }

    public StatsMGP getMedecine() {
        return medecine;
    }

    public void setMedecine(StatsMGP medecine) {
        this.medecine = medecine;
    }

    public StatsMassotherapie getMassotherapie() {
        return massotherapie;
    }

    public void setMassotherapie(StatsMassotherapie massotherapie) {
        this.massotherapie = massotherapie;
    }

    public StatsNaturopathie getNaturopathie() {
        return naturopathie;
    }

    public void setNaturopathie(StatsNaturopathie naturopathie) {
        this.naturopathie = naturopathie;
    }

    public StatsOrthophonie getOrthophonie() {
        return orthophonie;
    }

    public void setOrthophonie(StatsOrthophonie orthophonie) {
        this.orthophonie = orthophonie;
    }

    public StatsOstheopathie getOstheopathie() {
        return ostheopathie;
    }

    public void setOstheopathie(StatsOstheopathie ostheopathie) {
        this.ostheopathie = ostheopathie;
    }

    public StatsPhysiotherapie getPhysiotherapie() {
        return physiotherapie;
    }

    public void setPhysiotherapie(StatsPhysiotherapie physiotherapie) {
        this.physiotherapie = physiotherapie;
    }

    public StatsPsychologie getPsychologie() {
        return psychologie;
    }

    public void setPsychologie(StatsPsychologie psychologie) {
        this.psychologie = psychologie;
    }    
   
    public void compterSoin(ModeleJsonOut sortie){
        List<Remboursement> listeRemboursement = sortie.getRemboursement();
        int soin;
        
        for(Remboursement remboursement: listeRemboursement){
            soin = remboursement.getSoins();
            choixDuSoin(soin);
        }
    }

    public void choixDuSoin(int soin) {
        switch(soin){
            case 0:
                this.massotherapie.incrementerCompteur();
                break;
            case 100:
                this.ostheopathie.incrementerCompteur();
                break;
            case 150:
                this.kinesitherapie.incrementerCompteur();
                break;
            case 175:
                this.medecine.incrementerCompteur();
                break;
            case 200:
                this.psychologie.incrementerCompteur();
                break;
            case 400:
                this.naturopathie.incrementerCompteur();
                break;
            case 500:
                this.chiropratie.incrementerCompteur();
                break;
            case 600:
                this.physiotherapie.incrementerCompteur();
                break;
            case 700:
                this.orthophonie.incrementerCompteur();
                break;
            default:
                this.dentaire.incrementerCompteur();
                break;
        }
    }
    
    public void reinitialise(){
        this.setReclamationValide(0);
        this.setReclamationRejete(0);
        this.massotherapie = new StatsMassotherapie();
        this.ostheopathie = new StatsOstheopathie();
        this.kinesitherapie = new StatsKinesitherapie();
        this.medecine = new StatsMGP();
        this.psychologie = new StatsPsychologie();
        this.dentaire = new StatsDentaire();
        this.naturopathie = new StatsNaturopathie();
        this.chiropratie = new StatsChiropratie();
        this.physiotherapie = new StatsPhysiotherapie();
        this.psychologie = new StatsPsychologie();
        this.orthophonie = new StatsOrthophonie();
    }
    
    public void afficherStatistiques(){
        System.out.println("Le nombre de reclamations valides: " + this.getReclamationValide());
        System.out.println("Le nombre de reclamations rejetes: " + this.getReclamationRejete());
        System.out.println("Le nombre de massotherapies traitees: " + this.massotherapie.getCompteur());
        /*System.out.println("Le nombre de osteopathies traitees: " + this.getNbSoinOsteopathie());
        System.out.println("Le nombre de kinesitherapies traitees: " + this.getNbSoinKinesitherapie());
        System.out.println("Le nombre de medecins generalistes prives traitees: " +this.getNbSoinMGP());
        System.out.println("Le nombre de psychologies individuelles traitees: " + this.getNbSoinPsychologie());
        System.out.println("Le nombre de soins dentaires traitees: " + this.getNbSoinDentaire());
        System.out.println("Le nombre de naturopathies et/ou acuponctures traitees: " + this.getNbSoinNaturo());
        System.out.println("Le nombre de chiropratie traitees: " + this.getNbSoinChiropratie());
        System.out.println("Le nombre de physiotherapies traitees: " + this.getNbSoinPhysiotherapie());
        System.out.println("Le nombre d'orthophonies et/ou d'ergotherapies traitees: " + this.getNbSoinOrthophonie());*/ 
    }
}

    
    
    