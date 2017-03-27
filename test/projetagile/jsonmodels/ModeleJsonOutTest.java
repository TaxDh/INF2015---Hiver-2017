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
 * @author rene
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
     * Test of setClient method, of class ModeleJsonOut.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        String client = "";
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setClient(client);
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
        List<Remboursement> emboursement = null;
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setRemboursement(emboursement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterRemboursement method, of class ModeleJsonOut.
     */
    @Test
    public void testAjouterRemboursement() {
        System.out.println("ajouterRemboursement");
        Remboursement nouveauRemboursement = null;
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.ajouterRemboursement(nouveauRemboursement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalStr method, of class ModeleJsonOut.
     */
    @Test
    public void testGetTotalStr() {
        System.out.println("getTotalStr");
        ModeleJsonOut instance = new ModeleJsonOut();
        String expResult = "";
        String result = instance.getTotalStr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalStr method, of class ModeleJsonOut.
     */
    @Test
    public void testSetTotalStr() {
        System.out.println("setTotalStr");
        String totalStr = "";
        ModeleJsonOut instance = new ModeleJsonOut();
        instance.setTotalStr(totalStr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
