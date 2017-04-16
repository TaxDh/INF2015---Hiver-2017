/*
 * L'objet statistique pour le fichier json statistique
 */
package projetagile.jsonmodels;

import java.util.List;

public class Statistique {
    private int reclamationValide;
    private int reclamationRejete;
    private statsChiropratie chiropratie;
    private statsDentaire dentaire;
    private statsKinesitherapie kinesitherapie;
    private statsMGP medecine;
    private statsMassotherapie massotherapie;
    private statsNaturopathie naturopathie;
    private statsOrthophonie orthophonie;
    private statsOstheopathie ostheopathie;
    private statsPhysiotherapie physiotherapie;
    private statsPsychologie psychologie;
    
    public Statistique(){
    }

    public Statistique(int reclamationValide, int reclamationRejete, statsChiropratie chiropratie, 
            statsDentaire dentaire, statsKinesitherapie kinesitherapie, statsMGP medecine, 
            statsMassotherapie massotherapie, statsNaturopathie naturopathie, statsOrthophonie orthophonie,
            statsOstheopathie ostheopathie, statsPhysiotherapie physiotherapie, statsPsychologie psychologie) {
        
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

    public statsChiropratie getChiropratie() {
        return chiropratie;
    }

    public void setChiropratie(statsChiropratie chiropratie) {
        this.chiropratie = chiropratie;
    }

    public statsDentaire getDentaire() {
        return dentaire;
    }

    public void setDentaire(statsDentaire dentaire) {
        this.dentaire = dentaire;
    }

    public statsKinesitherapie getKinesitherapie() {
        return kinesitherapie;
    }

    public void setKinesitherapie(statsKinesitherapie kinesitherapie) {
        this.kinesitherapie = kinesitherapie;
    }

    public statsMGP getMedecine() {
        return medecine;
    }

    public void setMedecine(statsMGP medecine) {
        this.medecine = medecine;
    }

    public statsMassotherapie getMassotherapie() {
        return massotherapie;
    }

    public void setMassotherapie(statsMassotherapie massotherapie) {
        this.massotherapie = massotherapie;
    }

    public statsNaturopathie getNaturopathie() {
        return naturopathie;
    }

    public void setNaturopathie(statsNaturopathie naturopathie) {
        this.naturopathie = naturopathie;
    }

    public statsOrthophonie getOrthophonie() {
        return orthophonie;
    }

    public void setOrthophonie(statsOrthophonie orthophonie) {
        this.orthophonie = orthophonie;
    }

    public statsOstheopathie getOstheopathie() {
        return ostheopathie;
    }

    public void setOstheopathie(statsOstheopathie ostheopathie) {
        this.ostheopathie = ostheopathie;
    }

    public statsPhysiotherapie getPhysiotherapie() {
        return physiotherapie;
    }

    public void setPhysiotherapie(statsPhysiotherapie physiotherapie) {
        this.physiotherapie = physiotherapie;
    }

    public statsPsychologie getPsychologie() {
        return psychologie;
    }

    public void setPsychologie(statsPsychologie psychologie) {
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
        this.massotherapie = new statsMassotherapie();
        this.ostheopathie = new statsOstheopathie();
        this.kinesitherapie = new statsKinesitherapie();
        this.medecine = new statsMGP();
        this.psychologie = new statsPsychologie();
        this.dentaire = new statsDentaire();
        this.naturopathie = new statsNaturopathie();
        this.chiropratie = new statsChiropratie();
        this.physiotherapie = new statsPhysiotherapie();
        this.psychologie = new statsPsychologie();
        this.orthophonie = new statsOrthophonie();
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

    
    
    