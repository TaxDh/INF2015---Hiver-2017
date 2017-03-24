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

/**
 *
 * @author kf891141
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
     * Test of convertirStringEnDouble method, of class InterfaceContrat.
     */
    @Test
    public void testConvertirStringEnDouble() {
        System.out.println("convertirStringEnDouble");
        String strMontant = "";
        double expResult = 0.0;
        double result = Dollar.convertirStringEnDouble(strMontant);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contientVirgule method, of class InterfaceContrat.
     */
    @Test
    public void testContientVirgule() {
        System.out.println("contientVirgule");
        String montant = "";
        boolean expResult = false;
        boolean result = Dollar.contientVirgule(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirDoubleEnString method, of class InterfaceContrat.
     */
    @Test
    public void testConvertirDoubleEnString() {
        System.out.println("convertirDoubleEnString");
        double dblMontant = 0.0;
        String expResult = "";
        String result = Dollar.convertirDoubleEnString(dblMontant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.massotherapie(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.osteopathie(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.kinesitherapie(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.medecin_generaliste_prive(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.psychologie_individuelle(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.soin_dentaire(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.naturo_acuponcture(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.chiropratie(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.physiotherapie(montant);
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
        String montant = "";
        InterfaceContrat instance = null;
        String expResult = "";
        String result = instance.orthophonie_ergotherapie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InterfaceContratImpl extends InterfaceContrat {

        public InterfaceContratImpl() {
            super(null);
        }

        public String massotherapie(String montant) {
            return "";
        }

        public String osteopathie(String montant) {
            return "";
        }

        public String kinesitherapie(String montant) {
            return "";
        }

        public String medecin_generaliste_prive(String montant) {
            return "";
        }

        public String psychologie_individuelle(String montant) {
            return "";
        }

        public String soin_dentaire(String montant) {
            return "";
        }

        public String naturo_acuponcture(String montant) {
            return "";
        }

        public String chiropratie(String montant) {
            return "";
        }

        public String physiotherapie(String montant) {
            return "";
        }

        public String orthophonie_ergotherapie(String montant) {
            return "";
        }
    }
    
}
