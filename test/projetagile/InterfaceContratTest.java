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
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;

/**
 *
 * @author rene
 */
public class InterfaceContratTest {
    
    public InterfaceContratTest() {
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

    /**
     * Test of calculRemboursement method, of class InterfaceContrat.
     */
    @Test
    public void testCalculRemboursement() {
        System.out.println("calculRemboursement");
        InterfaceContrat instance = null;
        ModeleJsonOut expResult = null;
        ModeleJsonOut result = instance.calculRemboursement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursReclamation method, of class InterfaceContrat.
     */
    @Test
    public void testParcoursReclamation() {
        System.out.println("parcoursReclamation");
        ModeleJsonOut sortie = null;
        InterfaceContrat instance = null;
        ModeleJsonOut expResult = null;
        ModeleJsonOut result = instance.parcoursReclamation(sortie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choixSoin method, of class InterfaceContrat.
     */
    @Test
    public void testChoixSoin() {
        System.out.println("choixSoin");
        Reclamation reclamation = null;
        Dollar remboursementDollar = null;
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.choixSoin(reclamation, remboursementDollar, montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of massotherapie method, of class InterfaceContrat.
     */
    @Test
    public void testMassotherapie() {
        System.out.println("massotherapie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.massotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of osteopathie method, of class InterfaceContrat.
     */
    @Test
    public void testOsteopathie() {
        System.out.println("osteopathie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kinesitherapie method, of class InterfaceContrat.
     */
    @Test
    public void testKinesitherapie() {
        System.out.println("kinesitherapie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.kinesitherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of medecin_generaliste_prive method, of class InterfaceContrat.
     */
    @Test
    public void testMedecin_generaliste_prive() {
        System.out.println("medecin_generaliste_prive");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of psychologie_individuelle method, of class InterfaceContrat.
     */
    @Test
    public void testPsychologie_individuelle() {
        System.out.println("psychologie_individuelle");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of soin_dentaire method, of class InterfaceContrat.
     */
    @Test
    public void testSoin_dentaire() {
        System.out.println("soin_dentaire");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.soin_dentaire(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of naturo_acuponcture method, of class InterfaceContrat.
     */
    @Test
    public void testNaturo_acuponcture() {
        System.out.println("naturo_acuponcture");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.naturo_acuponcture(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiropratie method, of class InterfaceContrat.
     */
    @Test
    public void testChiropratie() {
        System.out.println("chiropratie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of physiotherapie method, of class InterfaceContrat.
     */
    @Test
    public void testPhysiotherapie() {
        System.out.println("physiotherapie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of orthophonie_ergotherapie method, of class InterfaceContrat.
     */
    @Test
    public void testOrthophonie_ergotherapie() {
        System.out.println("orthophonie_ergotherapie");
        Dollar montant = null;
        InterfaceContrat instance = null;
        Dollar expResult = null;
        Dollar result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InterfaceContratImpl extends InterfaceContrat {

        public InterfaceContratImpl() {
            super(null);
        }

        public Dollar massotherapie(Dollar montant) {
            return null;
        }

        public Dollar osteopathie(Dollar montant) {
            return null;
        }

        public Dollar kinesitherapie(Dollar montant) {
            return null;
        }

        public Dollar medecin_generaliste_prive(Dollar montant) {
            return null;
        }

        public Dollar psychologie_individuelle(Dollar montant) {
            return null;
        }

        public Dollar soin_dentaire(Dollar montant) {
            return null;
        }

        public Dollar naturo_acuponcture(Dollar montant) {
            return null;
        }

        public Dollar chiropratie(Dollar montant) {
            return null;
        }

        public Dollar physiotherapie(Dollar montant) {
            return null;
        }

        public Dollar orthophonie_ergotherapie(Dollar montant) {
            return null;
        }
    }
    
}
