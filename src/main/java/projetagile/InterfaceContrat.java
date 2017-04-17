/* chaque soin est considéré comme une méthode
 *elle différe pour chaque objet (contrat), donc on utilise une classe
 *abstraite.
 */
package projetagile;

import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Remboursement;

public abstract class InterfaceContrat {

    protected Dollar maximumMensuelOsteopathie = new Dollar("250.00$");
    protected Dollar maximumMensuelMedGenPriv = new Dollar("200.00$");
    protected Dollar maximumMensuelPsychologieInd = new Dollar("250.00$");
    protected Dollar maximumMensuelChiropratie = new Dollar("150.00$");
    protected Dollar maximumMensuelPhysiotherapie = new Dollar("300.00$");

    private ModeleJsonIn modele;

    public InterfaceContrat(ModeleJsonIn modele) {

        this.modele = modele;
    }

    public ModeleJsonOut calculRemboursement() {
        ModeleJsonOut sortie = new ModeleJsonOut();
        sortie.setDossier(modele.getTypeContrat() + modele.getClient());
        sortie.setMois(modele.getMois());

        sortie = parcoursReclamation(sortie);
        return sortie;
    }

    public ModeleJsonOut parcoursReclamation(ModeleJsonOut sortie) {
        for (Reclamation reclamation : modele.getReclamations()) {
            Dollar montant = reclamation.getMontant();
            Dollar remboursementDollar = new Dollar();

            remboursementDollar = choixSoin(reclamation, remboursementDollar, montant);
            Remboursement nouveauRemboursement = new Remboursement(reclamation.getSoins(),
                    reclamation.getDate(), remboursementDollar);

            sortie.ajouterRemboursement(nouveauRemboursement);
        }
        return sortie;
    }

    public Dollar choixSoin(Reclamation reclamation, Dollar remboursementDollar, Dollar montant) {
        int numero = reclamation.getSoins();

        switch (numero) {
            case 0:
                remboursementDollar = massotherapie(montant);
                break;
            case 100:
                remboursementDollar = osteopathie(montant);
                break;
            case 150:
                remboursementDollar = kinesitherapie(montant);
                break;
            case 175:
                remboursementDollar = medecin_generaliste_prive(montant);
                break;
            case 200:
                remboursementDollar = psychologie_individuelle(montant);
                break;
            case 400:
                remboursementDollar = naturo_acuponcture(montant);
                break;
            case 500:
                remboursementDollar = chiropratie(montant);
                break;
            case 600:
                remboursementDollar = physiotherapie(montant);
                break;
            case 700:
                remboursementDollar = orthophonie_ergotherapie(montant);
                break;
            default:
                remboursementDollar = soin_dentaire(montant);
                break;
        }
        return remboursementDollar;
    }

    public abstract Dollar massotherapie(Dollar montant);

    public abstract Dollar osteopathie(Dollar montant);

    public abstract Dollar kinesitherapie(Dollar montant);

    public abstract Dollar medecin_generaliste_prive(Dollar montant);

    public abstract Dollar psychologie_individuelle(Dollar montant);

    public abstract Dollar soin_dentaire(Dollar montant);

    public abstract Dollar naturo_acuponcture(Dollar montant);

    public abstract Dollar chiropratie(Dollar montant);

    public abstract Dollar physiotherapie(Dollar montant);

    public abstract Dollar orthophonie_ergotherapie(Dollar montant);

}
