/*
 * To change this license header, choose License Headers in Project Properties
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
 * @author rene
 */
public class ContratATest {
    
    ModeleJsonIn jsonIn;
    
    public ContratATest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jsonIn = new ModeleJsonIn("100323", 'A', "2017-01");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of massotherapie method, of class ContratA.
     */
    @Test
    public void testMassotherapie() {
        Dollar montant = new Dollar("100.00$");
        ContratA instance = new ContratA(jsonIn);
        Dollar expResult = new Dollar("25.00$");
        
        Dollar result = instance.massotherapie(montant);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of osteopathie method, of class ContratA.
     */
    @Test
    public void testOsteopathie() {
        System.out.println("osteopathie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kinesitherapie method, of class ContratA.
     */
    @Test
    public void testKinesitherapie() {
        System.out.println("kinesitherapie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.kinesitherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of medecin_generaliste_prive method, of class ContratA.
     */
    @Test
    public void testMedecin_generaliste_prive() {
        System.out.println("medecin_generaliste_prive");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of psychologie_individuelle method, of class ContratA.
     */
    @Test
    public void testPsychologie_individuelle() {
        System.out.println("psychologie_individuelle");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of soin_dentaire method, of class ContratA.
     */
    @Test
    public void testSoin_dentaire() {
        System.out.println("soin_dentaire");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.soin_dentaire(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of naturo_acuponcture method, of class ContratA.
     */
    @Test
    public void testNaturo_acuponcture() {
        System.out.println("naturo_acuponcture");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.naturo_acuponcture(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiropratie method, of class ContratA.
     */
    @Test
    public void testChiropratie() {
        System.out.println("chiropratie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of physiotherapie method, of class ContratA.
     */
    @Test
    public void testPhysiotherapie() {
        System.out.println("physiotherapie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of orthophonie_ergotherapie method, of class ContratA.
     */
    @Test
    public void testOrthophonie_ergotherapie() {
        System.out.println("orthophonie_ergotherapie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
