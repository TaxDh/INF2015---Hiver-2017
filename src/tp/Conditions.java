/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;
import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
/**
 *
 * @author DELL
 */
public class Conditions implements Contrat{
    public static boolean estNumerique(String chaine) {
        boolean esUnNombre = true;

        for (char c : chaine.toCharArray()) {
            if (!Character.isDigit(c)) {
                esUnNombre = false;
            }
        }

        return esUnNombre;
    }

    public static String getMontantSoin(String str) {
        String valeurString = "";
        if (str.length() > 0 && str.charAt(str.length() - 1) == '$') {
            valeurString = str.substring(0, str.length() - 1);
        }
        return valeurString;
    }

    public static boolean validerDateSoin(String dateSoin, String moisContrat) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false);
        boolean estDateSoinValide = sdf.parse(dateSoin, new ParsePosition(0)) != null;

        Date date1;
        Date date2 = new Date();

        if (!dateSoin.contains(moisContrat)) {
            estDateSoinValide = false;

        } else if (estDateSoinValide) {
            try {
                date1 = sdf.parse(dateSoin);

                if (date1.compareTo(date2) > 0) {
                    estDateSoinValide = false;
                }
            } catch (ParseException ex) {
                estDateSoinValide = false;
            }
        }

        return estDateSoinValide;

    }

    public static boolean validerFichierJson(String fichierEntree) {

        boolean estFichierValide = true;
        JSONObject fichierEntreeObj = JSONObject.fromObject(fichierEntree);

        String numeroClient = fichierEntreeObj.getString("client");
        String typeContrat = fichierEntreeObj.getString("contrat");
        String moisContrat = fichierEntreeObj.getString("mois");

        String numeroSoin;
        String dateSoin;
        String montant;

        if (validerNumeroClient(numeroClient)
                && validerTypeContrat(typeContrat)
                && validerMoisAnneeReclamations(moisContrat)) {

            JSONArray reclamationsListe = JSONArray.fromObject(fichierEntreeObj.getString("reclamations"));

            boolean boolValidationNumEtDateSoin = false;

            boolean boolValidationMontantSoin = false;

            for (int i = 0; i < reclamationsListe.size() && !boolValidationNumEtDateSoin && !boolValidationMontantSoin; i++) {

                JSONObject reclamation = reclamationsListe.getJSONObject(i);
                numeroSoin = reclamation.getString("soin");
                dateSoin = reclamation.getString("date");
                montant = reclamation.getString("montant");

                boolValidationNumEtDateSoin = !validerNumeroSoin(numeroSoin) || !validerDateSoin(dateSoin, moisContrat);
                boolValidationMontantSoin = !validerMontantSoin(montant);

                if (boolValidationNumEtDateSoin || boolValidationMontantSoin) {
                    estFichierValide = false;
                }
            }

        } else {
            estFichierValide = false;
        }

        return estFichierValide;

    }

    public static boolean validerMoisAnneeReclamations(String dateReclamations) {

        boolean dateValide = true;
        Calendar cal = Calendar.getInstance();

        if (dateReclamations.length() != 7 || !dateReclamations.contains("-")) {
            dateValide = false;

        } else {

            int mois = parseInt(dateReclamations.substring(5, 7));
            int annee = parseInt(dateReclamations.substring(0, 4));
            if (mois < 1 || mois > 12) {
                dateValide = false;

            } else if (annee > cal.get(Calendar.YEAR)) {
                dateValide = false;

            } else if (annee == cal.get(Calendar.YEAR) && mois > (cal.get(Calendar.MONTH) + 1)) {
                dateValide = false;

            }
        }

        return dateValide;
    }

    public static boolean validerMontantSoin(String str) {
        boolean estMontantNombre = true;
        String valeur = getMontantSoin(str);
        try {
            Double.parseDouble(valeur);
        } catch (NumberFormatException e) {
            estMontantNombre = false;
        }
        return estMontantNombre;
    }

    public static boolean validerNumeroClient(String numClient) {
        boolean estValide = true;

        if (numClient.length() != 6) {
            estValide = false;
        } else {
            if (!estNumerique(numClient)) {
                estValide = false;
            }
        }

        return estValide;
    }

    public static boolean validerNumeroSoin(String numSoin) {
        boolean estValide = false;
        if (estNumerique(numSoin)) {
            int numeroDeSoin = Integer.parseInt(numSoin);
            if (numeroDeSoin == numero_soin[0] || numeroDeSoin == numero_soin[1] || numeroDeSoin == numero_soin[2] 
                    || (numeroDeSoin >= numero_soin[3] && numeroDeSoin <= numero_soin[5]) || numeroDeSoin == numero_soin[6] 
                    || numeroDeSoin == numero_soin[7] || numeroDeSoin == numero_soin[8]) {
                estValide = true;
            }
        }
        return estValide;
    }

    public static boolean validerTypeContrat(String typeContrat) {
        boolean estValide = true;

        if (typeContrat.length() != 1) {
            estValide = false;
        } else {
            if (typeContrat.charAt(0) < 'A' || typeContrat.charAt(0) > 'D') {
                estValide = false;
            }
        }

        return estValide;
    }

    public static void creerFichierSortie(JSONObject remboursements, String nomFichierSortie) {
        File file = new File(nomFichierSortie);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(remboursements.toString(1));
            writer.flush();
            writer.close();
        } catch (IOException ex) {

        }

    }
}
