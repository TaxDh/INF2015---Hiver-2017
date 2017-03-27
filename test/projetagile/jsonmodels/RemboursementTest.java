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
public class RemboursementTest {
    
    public RemboursementTest() {
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
     * Test of getSoins method, of class Remboursement.
     */
    @Test
    public void testGetSoins() {
        System.out.println("getSoins");
        Remboursement instance = new Remboursement();
        int expResult = 0;
        int result = instance.getSoins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Remboursement.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Remboursement instance = new Remboursement();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMontant method, of class Remboursement.
     */
    @Test
    public void testGetMontant() {
        System.out.println("getMontant");
        Remboursement instance = new Remboursement();
        Dollar expResult = null;
        Dollar result = instance.getMontant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSoins method, of class Remboursement.
     */
    @Test
    public void testSetSoins() {
        System.out.println("setSoins");
        int soins = 0;
        Remboursement instance = new Remboursement();
        instance.setSoins(soins);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Remboursement.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Remboursement instance = new Remboursement();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMontant method, of class Remboursement.
     */
    @Test
    public void testSetMontant() {
        System.out.println("setMontant");
        Dollar montant = null;
        Remboursement instance = new Remboursement();
        instance.setMontant(montant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
