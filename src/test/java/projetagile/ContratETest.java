/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.ModeleJsonIn;

/**
 *
 * @author jg891159
 */
public class ContratETest {

    ModeleJsonIn jsonIn;
    ContratE instance;
    Dollar dollar100;

    public ContratETest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        jsonIn = new ModeleJsonIn("100323", 'B', "2017-01");
        instance = new ContratE(jsonIn);
        dollar100 = new Dollar("100.00$");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMassotherapie() {
        Dollar expResult = new Dollar("15.00$");
        Dollar result = instance.massotherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMassotherapiePetit() {
        Dollar montant = new Dollar("1.00$");
        Dollar expResult = new Dollar("0.15$");
        Dollar result = instance.massotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());

    }

    @Test
    public void testOsteopathieMaxMensuelGrand() {
        Dollar montant = new Dollar("2000.00$");
        Dollar expResult = new Dollar("250.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOsteopathieMaxMensuelPetit() {
        Dollar montant = new Dollar("250.01$");
        Dollar expResult = new Dollar("62.50$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOsteopathie() {
        Dollar expResult = new Dollar("25.00$");
        Dollar result = instance.osteopathie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testKinesitherapie() {
        Dollar expResult = new Dollar("15.00$");
        Dollar result = instance.kinesitherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testKinesitherapiePetit() {
        Dollar montant = new Dollar("100000.00$");
        Dollar expResult = new Dollar("15000.00$");
        Dollar result = instance.kinesitherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_prive() {
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.medecin_generaliste_prive(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelPetit() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testMedecin_generaliste_priveMaxMensuelDepasse() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.medecin_generaliste_prive(montant);
        for (int i = 0; i < 9; i++) {
            result = instance.medecin_generaliste_prive(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPsychologie_individuelle() {
        Dollar expResult = new Dollar("12.00$");
        Dollar result = instance.psychologie_individuelle(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPsychologie_individuellePetit() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("36.00$");
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPsychologie_individuelleMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("250.00$");
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testSoin_dentaire() {
        Dollar expResult = new Dollar("60.00$");
        Dollar result = instance.soin_dentaire(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testSoin_dentaireGrand() {
        Dollar montant = new Dollar("1000000.00$");
        Dollar expResult = new Dollar("600000.00$");
        Dollar result = instance.soin_dentaire(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testNaturo_acuponcture() {
        Dollar expResult = new Dollar("15.00$");
        Dollar result = instance.naturo_acuponcture(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testNaturo_acuponcturePetit() {
        Dollar montant = new Dollar("50.00$");
        Dollar expResult = new Dollar("12.50$");
        Dollar result = instance.naturo_acuponcture(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testChiropratie() {
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.chiropratie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testChiropratiePetit() {
        Dollar montant = new Dollar("15.00$");
        Dollar expResult = new Dollar("4.50$");
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testChiropratieMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("20.00$");
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPhysiotherapie() {
        Dollar expResult = new Dollar("15.00$");
        Dollar result = instance.physiotherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPhysiotherapiePetit() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("45.00$");
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testPhysiotherapieMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("300.00$");
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testChiropratieMaxMensuelDepasse() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("10.00$");
        Dollar result = instance.chiropratie(montant);
        for (int i = 0; i < 7; i++) {
            result = instance.chiropratie(montant);
        }
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOrthophonie_ergotherapie() {
        Dollar expResult = new Dollar("22.00$");
        Dollar result = instance.orthophonie_ergotherapie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }

    @Test
    public void testOrthophonie_ergotherapieGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("660.00$");
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
}
