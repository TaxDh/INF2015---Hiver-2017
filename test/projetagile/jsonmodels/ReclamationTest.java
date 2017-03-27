/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile.jsonmodels;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.Dollar;

/**
 *
 * @author rene
 */
public class ReclamationTest {
    
    public ReclamationTest() {
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
     * Test of getSoins method, of class Reclamation.
     */
    @Test
    public void testGetSoins() {
        System.out.println("getSoins");
        Reclamation instance = new Reclamation();
        int expResult = 0;
        int result = instance.getSoins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Reclamation.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Reclamation instance = new Reclamation();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMontant method, of class Reclamation.
     */
    @Test
    public void testGetMontant() {
        System.out.println("getMontant");
        Reclamation instance = new Reclamation();
        Dollar expResult = null;
        Dollar result = instance.getMontant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSoins method, of class Reclamation.
     */
    @Test
    public void testSetSoins() {
        System.out.println("setSoins");
        int soins = 0;
        Reclamation instance = new Reclamation();
        instance.setSoins(soins);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Reclamation.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Reclamation instance = new Reclamation();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMontant method, of class Reclamation.
     */
    @Test
    public void testSetMontant() {
        System.out.println("setMontant");
        Dollar montant = null;
        Reclamation instance = new Reclamation();
        instance.setMontant(montant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
