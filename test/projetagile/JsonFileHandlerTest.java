/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import net.sf.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;

/**
 *
 * @author kf891141
 */
public class JsonFileHandlerTest {
    
    public JsonFileHandlerTest() {
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
     * Test of ouvrireFichier method, of class JsonFileHandler.
     */
    @Test
    public void testOuvrireFichier() throws Exception {
        System.out.println("ouvrireFichier");
        String filePath = "";
        ModeleJsonIn expResult = null;
        ModeleJsonIn result = JsonFileHandler.ouvrireFichier(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrireFichier method, of class JsonFileHandler.
     */
    @Test
    public void testEcrireFichier() {
        System.out.println("ecrireFichier");
        String filePath = "";
        ModeleJsonOut modeleOut = null;
        JsonFileHandler.ecrireFichier(filePath, modeleOut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createReclamations method, of class JsonFileHandler.
     */
    @Test
    public void testCreateReclamations() throws Exception {
        System.out.println("createReclamations");
        JSONArray reclamations = null;
        JsonFileHandler.createReclamations(reclamations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrireFichierErreur method, of class JsonFileHandler.
     */
    @Test
    public void testEcrireFichierErreur() {
        System.out.println("ecrireFichierErreur");
        String filePath = "";
        Exception e = null;
        JsonFileHandler.ecrireFichierErreur(filePath, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
