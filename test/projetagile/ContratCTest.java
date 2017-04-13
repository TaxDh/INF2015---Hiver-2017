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

/**
 *
 * @author jg891159
 */
public class ContratCTest {
    
    public ContratCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMassotherapie() {
        System.out.println("massotherapie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.massotherapie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOsteopathie() {
        System.out.println("osteopathie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testKinesitherapie() {
        System.out.println("kinesitherapie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.kinesitherapie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMedecin_generaliste_prive() {
        System.out.println("medecin_generaliste_prive");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPsychologie_individuelle() {
        System.out.println("psychologie_individuelle");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSoin_dentaire() {
        System.out.println("soin_dentaire");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.soin_dentaire(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNaturo_acuponcture() {
        System.out.println("naturo_acuponcture");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.naturo_acuponcture(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testChiropratie() {
        System.out.println("chiropratie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPhysiotherapie() {
        System.out.println("physiotherapie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOrthophonie_ergotherapie() {
        System.out.println("orthophonie_ergotherapie");
        Dollar montant = null;
        ContratC instance = null;
        Dollar expResult = null;
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
