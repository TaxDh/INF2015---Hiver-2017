/*
 * Objet contrat C, avec les méthodes type de soins associées
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;

public class ContratC extends InterfaceContrat {

    public ContratC(ModeleJsonIn modele) {

        super(modele);
    }

    @Override
    public Dollar massotherapie(Dollar montant) {
        return montant.calculerRemboursement(0.90);
    }

    @Override
    public Dollar osteopathie(Dollar montant) {
        Dollar remboursement = montant.calculerRemboursement(0.95);
        if (remboursement.getMontant() > maximumMensuelOsteopathie.getMontant()) {
            remboursement.setMontant(maximumMensuelOsteopathie.getMontant());
        }
        maximumMensuelOsteopathie.soustractionDollar(remboursement);
        return remboursement;
    }

    @Override
    public Dollar kinesitherapie(Dollar montant) {
        return montant.calculerRemboursement(0.85);
    }

    @Override
    public Dollar medecin_generaliste_prive(Dollar montant) {
        Dollar remboursement = montant.calculerRemboursement(0.9);
        if (remboursement.getMontant() > maximumMensuelMedGenPriv.getMontant()) {
            remboursement.setMontant(maximumMensuelMedGenPriv.getMontant());
        }
        maximumMensuelMedGenPriv.soustractionDollar(remboursement);
        return remboursement;
    }

    @Override
    public Dollar psychologie_individuelle(Dollar montant) {
        Dollar remboursement = montant.calculerRemboursement(0.90);
        if (remboursement.getMontant() > maximumMensuelPsychologieInd.getMontant()) {
            remboursement.setMontant(maximumMensuelPsychologieInd.getMontant());
        }
        maximumMensuelPsychologieInd.soustractionDollar(remboursement);
        return remboursement;
    }

    @Override
    public Dollar soin_dentaire(Dollar montant) {
        return montant.calculerRemboursement(0.90);
    }

    @Override
    public Dollar naturo_acuponcture(Dollar montant) {
        return montant.calculerRemboursement(0.90);
    }

    @Override
    public Dollar chiropratie(Dollar montant) {
        Dollar remboursement = montant.calculerRemboursement(0.9);
        if (remboursement.getMontant() > maximumMensuelChiropratie.getMontant()) {
            remboursement.setMontant(maximumMensuelChiropratie.getMontant());
        }
        maximumMensuelChiropratie.soustractionDollar(remboursement);
        return remboursement;
    }

    @Override
    public Dollar physiotherapie(Dollar montant) {
        Dollar remboursement = montant.calculerRemboursement(0.75);
        if (remboursement.getMontant() > maximumMensuelPhysiotherapie.getMontant()) {
            remboursement.setMontant(maximumMensuelPhysiotherapie.getMontant());
        }
        maximumMensuelPhysiotherapie.soustractionDollar(remboursement);
        return remboursement;
    }

    @Override
    public Dollar orthophonie_ergotherapie(Dollar montant) {
        return montant.calculerRemboursement(0.90);
    }
}
