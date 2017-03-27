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
public class ModeleJsonInTest {
    
    public ModeleJsonInTest() {
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
     * Test of getClient method, of class ModeleJsonIn.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        ModeleJsonIn instance = new ModeleJsonIn();
        String expResult = "";
        String result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClient method, of class ModeleJsonIn.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        String client = "";
        ModeleJsonIn instance = new ModeleJsonIn();
        instance.setClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeContrat method, of class ModeleJsonIn.
     */
    @Test
    public void testGetTypeContrat() {
        System.out.println("getTypeContrat");
        ModeleJsonIn instance = new ModeleJsonIn();
        char expResult = ' ';
        char result = instance.getTypeContrat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeContrat method, of class ModeleJsonIn.
     */
    @Test
    public void testSetTypeContrat() {
        System.out.println("setTypeContrat");
        char typeContrat = ' ';
        ModeleJsonIn instance = new ModeleJsonIn();
        instance.setTypeContrat(typeContrat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMois method, of class ModeleJsonIn.
     */
    @Test
    public void testGetMois() {
        System.out.println("getMois");
        ModeleJsonIn instance = new ModeleJsonIn();
        String expResult = "";
        String result = instance.getMois();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMois method, of class ModeleJsonIn.
     */
    @Test
    public void testSetMois() {
        System.out.println("setMois");
        String mois = "";
        ModeleJsonIn instance = new ModeleJsonIn();
        instance.setMois(mois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReclamations method, of class ModeleJsonIn.
     */
    @Test
    public void testGetReclamations() {
        System.out.println("getReclamations");
        ModeleJsonIn instance = new ModeleJsonIn();
        List<Reclamation> expResult = null;
        List<Reclamation> result = instance.getReclamations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReclamations method, of class ModeleJsonIn.
     */
    @Test
    public void testSetReclamations() {
        System.out.println("setReclamations");
        List<Reclamation> reclamations = null;
        ModeleJsonIn instance = new ModeleJsonIn();
        instance.setReclamations(reclamations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterReclamation method, of class ModeleJsonIn.
     */
    @Test
    public void testAjouterReclamation() {
        System.out.println("ajouterReclamation");
        Reclamation nouvelleReclamation = null;
        ModeleJsonIn instance = new ModeleJsonIn();
        instance.ajouterReclamation(nouvelleReclamation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
