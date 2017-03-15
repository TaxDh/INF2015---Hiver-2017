/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile.jsonmodels;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kf891141
 */
public class ModeleJsonOutTest {
    
    public ModeleJsonOutTest() {
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
     * Test of getDossier method, of class ModeleJsonOut.
     */
    @Test
    public void testGetDossier() {
        System.out.println("getDossier");
        ModeleJsonOut instance = new ModeleJsonOut();
        String expResult = "";
        String result = instance.getDossier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDossier method, of class ModeleJsonOut.
     */
    @Test
    public void testSetDossier() {
        System.out.println("setDossier");
        String client = "";
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setDossier(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMois method, of class ModeleJsonOut.
     */
    @Test
    public void testGetMois() {
        System.out.println("getMois");
        ModeleJsonOut instance = new ModeleJsonOut();
        String expResult = "";
        String result = instance.getMois();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMois method, of class ModeleJsonOut.
     */
    @Test
    public void testSetMois() {
        System.out.println("setMois");
        String mois = "";
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setMois(mois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemboursement method, of class ModeleJsonOut.
     */
    @Test
    public void testGetRemboursement() {
        System.out.println("getRemboursement");
        ModeleJsonOut instance = new ModeleJsonOut();
        List<Remboursement> expResult = null;
        List<Remboursement> result = instance.getRemboursement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRemboursement method, of class ModeleJsonOut.
     */
    @Test
    public void testSetRemboursement() {
        System.out.println("setRemboursement");
        List<Remboursement> remboursements = null;
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setRemboursement(remboursements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRemboursement method, of class ModeleJsonOut.
     */
    @Test
    public void testAddRemboursement() {
        System.out.println("addRemboursement");
        Remboursement nouveauRemboursement = null;
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.addRemboursement(nouveauRemboursement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class ModeleJsonOut.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        ModeleJsonOut instance = new ModeleJsonOut();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class ModeleJsonOut.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalEnString method, of class ModeleJsonOut.
     */
    @Test
    public void testTotalEnString() {
        System.out.println("totalEnString");
        double total = 0.0;
        ModeleJsonOut instance = new ModeleJsonOut();
        String expResult = "";
        String result = instance.totalEnString(total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
