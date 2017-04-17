/*
 * L'objet statistique pour le fichier json statistique.
 */
package projetagile.jsonmodels;

import java.util.List;
import projetagile.Dollar;

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

    public Statistique() {
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

    public void compterSoin(ModeleJsonIn entree) {
        List<Reclamation> listeReclamation = entree.getReclamations();
        int soin;
        Dollar valeurReclamation;

        for (Reclamation reclamation : listeReclamation) {
            soin = reclamation.getSoins();
            valeurReclamation = reclamation.getMontant();
            choixDuSoin(soin, valeurReclamation);
        }
    }

    public void choixDuSoin(int soin, Dollar montant) {
        switch (soin) {
            case 0:
                miseAJourMassotherapieStats(montant);
                break;
            case 100:
                miseAJourOstheopathieStats(montant);
                break;
            case 150:
                miseAJourKinesitherapieStats(montant);
                break;
            case 175:
                miseAJourMGPStats(montant);
                break;
            case 200:
                miseAJourPsychologieStats(montant);
                break;
            case 400:
                miseAJourNaturopathieStats(montant);
                break;
            case 500:
                miseAJourChiropratieStats(montant);
                break;
            case 600:
                miseAJourPhysiotherapieStats(montant);
                break;
            case 700:
                miseAJourOrthophonieStats(montant);
                break;
            default:
                miseAJourDentaireStats(montant);
                break;
        }
    }

    private void miseAJourDentaireStats(Dollar montant) {
        dentaire.incrementerCompteur();
        dentaire.ajouterSomme(montant);
        if (montant.getMontant() > dentaire.getMaximum().getMontant()) {
            dentaire.setMaximum(montant);
        }
    }

    private void miseAJourOrthophonieStats(Dollar montant) {
        orthophonie.incrementerCompteur();
        orthophonie.ajouterSomme(montant);
        if (montant.getMontant() > orthophonie.getMaximum().getMontant()) {
            orthophonie.setMaximum(montant);
        }
    }

    private void miseAJourPhysiotherapieStats(Dollar montant) {
        physiotherapie.incrementerCompteur();
        physiotherapie.ajouterSomme(montant);
        if (montant.getMontant() > physiotherapie.getMaximum().getMontant()) {
            physiotherapie.setMaximum(montant);
        }
    }

    private void miseAJourChiropratieStats(Dollar montant) {
        chiropratie.incrementerCompteur();
        chiropratie.ajouterSomme(montant);
        if (montant.getMontant() > chiropratie.getMaximum().getMontant()) {
            chiropratie.setMaximum(montant);
        }
    }

    private void miseAJourNaturopathieStats(Dollar montant) {
        naturopathie.incrementerCompteur();
        naturopathie.ajouterSomme(montant);
        if (montant.getMontant() > naturopathie.getMaximum().getMontant()) {
            naturopathie.setMaximum(montant);
        }
    }

    private void miseAJourPsychologieStats(Dollar montant) {
        psychologie.incrementerCompteur();
        psychologie.ajouterSomme(montant);
        if (montant.getMontant() > psychologie.getMaximum().getMontant()) {
            psychologie.setMaximum(montant);
        }
    }

    private void miseAJourMGPStats(Dollar montant) {
        medecine.incrementerCompteur();
        medecine.ajouterSomme(montant);
        if (montant.getMontant() > medecine.getMaximum().getMontant()) {
            medecine.setMaximum(montant);
        }
    }

    private void miseAJourKinesitherapieStats(Dollar montant) {
        kinesitherapie.incrementerCompteur();
        kinesitherapie.ajouterSomme(montant);
        if (montant.getMontant() > kinesitherapie.getMaximum().getMontant()) {
            kinesitherapie.setMaximum(montant);
        }
    }

    private void miseAJourOstheopathieStats(Dollar montant) {
        ostheopathie.incrementerCompteur();
        ostheopathie.ajouterSomme(montant);
        if (montant.getMontant() > ostheopathie.getMaximum().getMontant()) {
            ostheopathie.setMaximum(montant);
        }
    }

    private void miseAJourMassotherapieStats(Dollar montant) {
        massotherapie.incrementerCompteur();
        massotherapie.ajouterSomme(montant);
        if (montant.getMontant() > massotherapie.getMaximum().getMontant()) {
            massotherapie.setMaximum(montant);
        }
    }

    public void reinitialise() {
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

    public void afficherStatistiques() {
        System.out.println("Le nombre de reclamations valides: " + this.getReclamationValide());
        System.out.println("Le nombre de reclamations rejetes: " + this.getReclamationRejete());

        System.out.println("Le nombre de massotherapies traitees: ");
        afficherStatsSoin(massotherapie);
        System.out.println("Le nombre de osteopathies traitees: ");
        afficherStatsSoin(ostheopathie);
        System.out.println("Le nombre de kinesitherapies traitees: ");
        afficherStatsSoin(kinesitherapie);
        System.out.println("Le nombre de medecins generalistes prives traitees: ");
        afficherStatsSoin(medecine);
        System.out.println("Le nombre de psychologies individuelles traitees: ");
        afficherStatsSoin(psychologie);
        System.out.println("Le nombre de soins dentaires traitees: ");
        afficherStatsSoin(dentaire);
        System.out.println("Le nombre de naturopathies et/ou acuponctures traitees: ");
        afficherStatsSoin(naturopathie);
        System.out.println("Le nombre de chiropratie traitees: ");
        afficherStatsSoin(chiropratie);
        System.out.println("Le nombre de physiotherapies traitees: ");
        afficherStatsSoin(physiotherapie);
        System.out.println("Le nombre d'orthophonies et/ou d'ergotherapies traitees: ");
        afficherStatsSoin(orthophonie);
    }

    public void afficherStatsSoin(MontantSoinStats soin) {
        System.out.println("\tNombre: " + soin.getCompteur());
        if (soin.compteur == 0) {
            System.out.println("\tMoyenne: 0");
        } else {
            System.out.println("\tMoyenne: " + soin.getSomme().divisionDollarParInt(soin.getCompteur()).convertirEnStringDollar());
        }
        System.out.println("\tMontant maximum: " + soin.getMaximum().convertirEnStringDollar());
    }
}
