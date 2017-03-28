/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.ModeleJsonIn;
import projetagile.jsonmodels.ModeleJsonOut;
import projetagile.jsonmodels.Reclamation;
import projetagile.jsonmodels.Statistique;

/**
 *
 * @author rene
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
     * @throws java.lang.Exception
     */
    @Test
    public void testOuvrireFichier() throws Exception {
        System.out.println("ouvrireFichier");
        String fichierEntree = "";
        ModeleJsonIn expResult = null;
        ModeleJsonIn result = JsonFileHandler.ouvrireFichier(fichierEntree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursDesReclamations method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testParcoursDesReclamations() throws Exception {
        System.out.println("parcoursDesReclamations");
        JSONArray reclamations = null;
        ModeleJsonIn modele = null;
        JsonFileHandler.parcoursDesReclamations(reclamations, modele);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeMontantJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeMontantJsonLire() throws Exception {
        System.out.println("creeMontantJsonLire");
        JSONObject reclamationCourrante = null;
        Dollar expResult = null;
        Dollar result = JsonFileHandler.creeMontantJsonLire(reclamationCourrante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideDate method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValideDate() throws Exception {
        System.out.println("valideDate");
        String date = "";
        ModeleJsonIn modele = null;
        Reclamation nouvelleReclamation = null;
        JsonFileHandler.valideDate(date, modele, nouvelleReclamation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeDateJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeDateJsonLire() throws Exception {
        System.out.println("creeDateJsonLire");
        JSONObject reclamationCourrante = null;
        String expResult = "";
        String result = JsonFileHandler.creeDateJsonLire(reclamationCourrante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideSoin method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValideSoin() throws Exception {
        System.out.println("valideSoin");
        int soin = 0;
        Reclamation nouvelleReclamation = null;
        JsonFileHandler.valideSoin(soin, nouvelleReclamation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeSoinJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeSoinJsonLire() throws Exception {
        System.out.println("creeSoinJsonLire");
        JSONObject reclamationCourrante = null;
        int expResult = 0;
        int result = JsonFileHandler.creeSoinJsonLire(reclamationCourrante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeReclamationJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeReclamationJsonLire() throws Exception {
        System.out.println("creeReclamationJsonLire");
        JSONObject racine = null;
        JSONArray expResult = null;
        JSONArray result = JsonFileHandler.creeReclamationJsonLire(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeRacineJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeRacineJsonLire_JSONObject() throws Exception {
        System.out.println("creeRacineJsonLire");
        JSONObject racine = null;
        String expResult = "";
        String result = JsonFileHandler.creeRacineJsonLire(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeDossierJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeDossierJsonLire() throws Exception {
        System.out.println("creeDossierJsonLire");
        JSONObject racine = null;
        String expResult = "";
        String result = JsonFileHandler.creeDossierJsonLire(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeRacineJsonLire method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeRacineJsonLire_String() throws Exception {
        System.out.println("creeRacineJsonLire");
        String jsonText = "";
        JSONObject expResult = null;
        JSONObject result = JsonFileHandler.creeRacineJsonLire(jsonText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of litTexteJson method, of class JsonFileHandler.
     */
    @Test
    public void testLitTexteJson() {
        System.out.println("litTexteJson");
        String fichierEntree = "";
        String expResult = "";
        String result = JsonFileHandler.litTexteJson(fichierEntree);
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
        String fichierSortie = "";
        ModeleJsonOut modeleOut = null;
        JsonFileHandler.ecrireFichier(fichierSortie, modeleOut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajoutRemboursementJson method, of class JsonFileHandler.
     */
    @Test
    public void testAjoutRemboursementJson() {
        System.out.println("ajoutRemboursementJson");
        JSONObject remboursement = null;
        ModeleJsonOut modeleOut = null;
        JSONArray remboursementTab = null;
        Dollar montantTotal = null;
        JsonFileHandler.ajoutRemboursementJson(remboursement, modeleOut, remboursementTab, montantTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajoutSoinDateMontantJson method, of class JsonFileHandler.
     */
    @Test
    public void testAjoutSoinDateMontantJson() {
        System.out.println("ajoutSoinDateMontantJson");
        ModeleJsonOut modeleOut = null;
        JSONArray remboursementTab = null;
        Dollar montantTotal = null;
        JsonFileHandler.ajoutSoinDateMontantJson(modeleOut, remboursementTab, montantTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ouvrirFichierStatistique method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testOuvrirFichierStatistique() throws Exception {
        System.out.println("ouvrirFichierStatistique");
        String fichierEntree = "";
        Statistique expResult = null;
        Statistique result = JsonFileHandler.ouvrirFichierStatistique(fichierEntree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrisLesStatistiques method, of class JsonFileHandler.
     */
    @Test
    public void testEcrisLesStatistiques() {
        System.out.println("ecrisLesStatistiques");
        Statistique stats = null;
        int reclamationValide = 0;
        int reclamationRejete = 0;
        int nbSoinMassotheratpie = 0;
        int nbSoinOsteopathie = 0;
        int nbSoinKinesitherapie = 0;
        int nbSoinMGP = 0;
        int nbSoinPsychologie = 0;
        int nbSoinDentaire = 0;
        int nbSoinNaturo = 0;
        int nbSoinChiropratie = 0;
        int nbSoinPhysiotherapie = 0;
        int nbSoinOrthophonie = 0;
        JsonFileHandler.ecrisLesStatistiques(stats, reclamationValide, reclamationRejete, nbSoinMassotheratpie, nbSoinOsteopathie, nbSoinKinesitherapie, nbSoinMGP, nbSoinPsychologie, nbSoinDentaire, nbSoinNaturo, nbSoinChiropratie, nbSoinPhysiotherapie, nbSoinOrthophonie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeOrthophonieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeOrthophonieStat() throws Exception {
        System.out.println("creeOrthophonieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeOrthophonieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creePhysiotherapieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreePhysiotherapieStat() throws Exception {
        System.out.println("creePhysiotherapieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creePhysiotherapieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeChiropratieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeChiropratieStat() throws Exception {
        System.out.println("creeChiropratieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeChiropratieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeNaturopathieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeNaturopathieStat() throws Exception {
        System.out.println("creeNaturopathieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeNaturopathieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeDentaireStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeDentaireStat() throws Exception {
        System.out.println("creeDentaireStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeDentaireStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creePsychologieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreePsychologieStat() throws Exception {
        System.out.println("creePsychologieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creePsychologieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeMedecinGenPriveStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeMedecinGenPriveStat() throws Exception {
        System.out.println("creeMedecinGenPriveStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeMedecinGenPriveStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeKinesitherapieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeKinesitherapieStat() throws Exception {
        System.out.println("creeKinesitherapieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeKinesitherapieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeOsteopathieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeOsteopathieStat() throws Exception {
        System.out.println("creeOsteopathieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeOsteopathieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeMassotherapieStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeMassotherapieStat() throws Exception {
        System.out.println("creeMassotherapieStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeMassotherapieStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeReclamationRejeteStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeReclamationRejeteStat() throws Exception {
        System.out.println("creeReclamationRejeteStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeReclamationRejeteStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeReclamationStat method, of class JsonFileHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreeReclamationStat() throws Exception {
        System.out.println("creeReclamationStat");
        JSONObject racine = null;
        int expResult = 0;
        int result = JsonFileHandler.creeReclamationStat(racine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creeJsonTxtString method, of class JsonFileHandler.
     */
    @Test
    public void testCreeJsonTxtString() {
        System.out.println("creeJsonTxtString");
        String fichierEntree = "";
        String expResult = "";
        String result = JsonFileHandler.creeJsonTxtString(fichierEntree);
        assertEquals(expResult, result);
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
