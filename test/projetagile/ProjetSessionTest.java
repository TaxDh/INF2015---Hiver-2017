/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.Statistique;

/**
 *
 * @author rene
 */
public class ProjetSessionTest {
    
    public ProjetSessionTest() {
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
     * Test of main method, of class ProjetSession.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProjetSession.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of argumentReclamation method, of class ProjetSession.
     */
    @Test
    public void testArgumentReclamation() {
        System.out.println("argumentReclamation");
        String[] args = null;
        Statistique stats = null;
        ProjetSession.argumentReclamation(args, stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reclamtionInvalidArgumentException method, of class ProjetSession.
     */
    @Test
    public void testReclamtionInvalidArgumentException() {
        System.out.println("reclamtionInvalidArgumentException");
        String fichierEntree = "";
        String fichierSortie = "";
        Statistique stats = null;
        ProjetSession.reclamtionInvalidArgumentException(fichierEntree, fichierSortie, stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traiterReclamation method, of class ProjetSession.
     */
    @Test
    public void testTraiterReclamation() throws Exception {
        System.out.println("traiterReclamation");
        String fichierEntree = "";
        String fichierSortie = "";
        Statistique stats = null;
        ProjetSession.traiterReclamation(fichierEntree, fichierSortie, stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of argumentStatistique method, of class ProjetSession.
     */
    @Test
    public void testArgumentStatistique() {
        System.out.println("argumentStatistique");
        String[] args = null;
        Statistique stats = null;
        ProjetSession.argumentStatistique(args, stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ouvrirFichierJsonStatistique method, of class ProjetSession.
     */
    @Test
    public void testOuvrirFichierJsonStatistique() {
        System.out.println("ouvrirFichierJsonStatistique");
        Statistique stats = null;
        Statistique expResult = null;
        Statistique result = ProjetSession.ouvrirFichierJsonStatistique(stats);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrireStatistiques method, of class ProjetSession.
     */
    @Test
    public void testEcrireStatistiques() {
        System.out.println("ecrireStatistiques");
        Statistique stats = null;
        ProjetSession.ecrireStatistiques(stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrireFichierJsonStats method, of class ProjetSession.
     */
    @Test
    public void testEcrireFichierJsonStats() {
        System.out.println("ecrireFichierJsonStats");
        JSONObject statJson = null;
        ProjetSession.ecrireFichierJsonStats(statJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
