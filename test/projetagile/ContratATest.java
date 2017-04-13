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

}
