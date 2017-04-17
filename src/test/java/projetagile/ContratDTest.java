package projetagile;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.ModeleJsonIn;

public class ContratDTest {

    ModeleJsonIn jsonIn;
    ContratD instance;
    Dollar dollar100;

    @Before
    public void setUp() {
        jsonIn = new ModeleJsonIn("100323", 'D', "2017-01");
        instance = new ContratD(jsonIn);
        dollar100 = new Dollar("100.00$");
    }

    @Test
    public void testMassotherapie() {
        Dollar montant = new Dollar("80.00$");
        Dollar expResult = new Dollar("80.00$");
        Dollar result = instance.massotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testMassotherapieMaximum() {
        Dollar montant = new Dollar("90.00$");
        Dollar expResult = new Dollar("85.00$");
        Dollar result = instance.massotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testOsteopathieMaxMensuel() {
        Dollar montant = new Dollar("500.00$");
        Dollar expResult = new Dollar("75.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOsteopathieGrand() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("75.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOsteopathie() {
        Dollar montant = new Dollar("75.00$");
        Dollar expResult = new Dollar("75.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOsteopathieMaxMensuelDepasse() {
        Dollar montant = new Dollar("500.00$");
        Dollar expResult = new Dollar("0.00$");
        Dollar result = instance.osteopathie(montant);
        for (int i = 0; i < 5; i++) {
            result = instance.osteopathie(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testKinesitherapie() {
        Dollar expResult = dollar100;
        Dollar result = instance.kinesitherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testKinesitherapieMaximum() {
        Dollar montant = new Dollar("100000.00$");
        Dollar expResult = new Dollar("150.00$");
        Dollar result = instance.kinesitherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_prive() {
        Dollar expResult = new Dollar("95.00$");
        Dollar result = instance.medecin_generaliste_prive(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelPetit() {
        Dollar montant = new Dollar("200.00$");
        Dollar expResult = new Dollar("190.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("200.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelDepasse() {
        Dollar montant = new Dollar("200.00$");
        Dollar expResult = new Dollar("0.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        for (int i = 0; i < 5; i++) {
            result = instance.medecin_generaliste_prive(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPsychologie_individuelle() {
        Dollar expResult = dollar100;
        Dollar result = instance.psychologie_individuelle(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPsychologie_individuellePetit() {
        Dollar montant = new Dollar("90.00$");
        Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPsychologie_individuelleMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = dollar100;
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPsychologie_individuelleMaxMensuelDepasse() {
        Dollar montant = dollar100;
        Dollar expResult = new Dollar("0.00$");
        Dollar result = instance.psychologie_individuelle(montant);
        for (int i = 0; i < 5; i++) {
            result = instance.psychologie_individuelle(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testSoin_dentaire() {
        Dollar expResult = dollar100;
        Dollar result = instance.soin_dentaire(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testSoin_dentaireGrand() {
        Dollar montant = new Dollar("10000.00$");
        Dollar expResult = new Dollar("10000.00$");
        Dollar result = instance.soin_dentaire(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testNaturo_acuponcture() {
        Dollar expResult = new Dollar("65.00$");
        Dollar result = instance.naturo_acuponcture(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testNaturo_acuponcturePetit() {
        Dollar montant = new Dollar("50.00$");
        Dollar expResult = new Dollar("50.00$");
        Dollar result = instance.naturo_acuponcture(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testChiropratie() {
        Dollar expResult = dollar100;
        Dollar result = instance.chiropratie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testChiropratiePetit() {
        Dollar montant = new Dollar("75.00$");
        Dollar expResult = new Dollar("75.00$");
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testChiropratieMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("150.00$");
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPhysiotherapie() {
        Dollar expResult = dollar100;
        Dollar result = instance.physiotherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPhysiotherapiePetit() {
        Dollar montant = new Dollar("50.00$");
        Dollar expResult = new Dollar("50.00$");
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPhysiotherapieMaxMensuelGrand() {
        Dollar montant = new Dollar("1000.00$");
        Dollar expResult = dollar100;
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testPhysiotherapieMaxMensuelDepasse() {
        Dollar montant = dollar100;
        Dollar expResult = new Dollar("0.00$");
        Dollar result = instance.physiotherapie(montant);
        for (int i = 0; i < 5; i++) {
            result = instance.physiotherapie(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOrthophonie_ergotherapie() {
        Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.orthophonie_ergotherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOrthophonie_ergotherapiePetit() {
        Dollar montant = new Dollar("50.00$");
        Dollar expResult = new Dollar("50.00$");
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOrthophonie_ergotherapieGrand() {
        Dollar montant = new Dollar("900.00$");
        Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
}
