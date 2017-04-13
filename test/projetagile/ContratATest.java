/*
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetagile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projetagile.jsonmodels.ModeleJsonIn;

/**
 *
 * @author rene
 */
public class ContratATest {
    
    ModeleJsonIn jsonIn;
    ContratA instance;
    Dollar dollar100;
    
    public ContratATest() {
    }

    @Before
    public void setUp() {
        jsonIn = new ModeleJsonIn("100323", 'A', "2017-01");
        instance = new ContratA(jsonIn);
        dollar100 = new Dollar("100.00$");
    }
    
    @After
    public void tearDown() {
    }

/*
    @Test
    public void testMassotherapie() {
        Dollar montant = new Dollar("100.00$");
        Dollar expResult = new Dollar("25.00$");        
        Dollar result = instance.massotherapie(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }
    
    @Test
    public void testMassotherapiePetit() {
        Dollar montant = new Dollar("1.00$");
        Dollar expResult = new Dollar("0.25$");
        Dollar result = instance.massotherapie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   
    
   
 */

    @Test
    public void testOsteopathieMaxMensuelGrand() {
        Dollar montant = new Dollar("2000.00$");
        Dollar expResult = new Dollar("250.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
   @Test
    public void testOsteopathieMaxMensuelPetit() {
        Dollar montant = new Dollar("250.01$");
        Dollar expResult = new Dollar("87.50$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    
    @Test
    public void testKinesitherapie() {
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.kinesitherapie(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
   
    @Test
    public void testKinesitherapiePetit() {
        Dollar montant = new Dollar("100000.00$");
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.kinesitherapie(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());        
    }   
/*
    @Test
    public void testMedecin_generaliste_prive() {
        System.out.println("medecin_generaliste_prive");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.medecin_generaliste_prive(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPsychologie_individuelle() {
        System.out.println("psychologie_individuelle");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.psychologie_individuelle(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSoin_dentaire() {
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.soin_dentaire(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    @Test
    public void testSoin_dentaireGrand() {
        Dollar montant = new Dollar("1000000.00$");
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.soin_dentaire(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }

    @Test
    public void testNaturo_acuponcture() {
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.naturo_acuponcture(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    @Test
    public void testNaturo_acuponctureGrand() {
        Dollar montant = new Dollar("1000000.00$");
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.naturo_acuponcture(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }
/*
    @Test
    public void testChiropratie() {
        System.out.println("chiropratie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.chiropratie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPhysiotherapie() {
        System.out.println("physiotherapie");
        Dollar montant = null;
        ContratA instance = null;
        Dollar expResult = null;
        Dollar result = instance.physiotherapie(montant);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOrthophonie_ergotherapie() {
         Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.orthophonie_ergotherapie(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    @Test
    public void testOrthophonie_ergotherapieGrand() {
        Dollar montant = new Dollar("1000000.00$");
        Dollar expResult = new Dollar("0.00$");        
        Dollar result = instance.orthophonie_ergotherapie(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }
    */
    
}
