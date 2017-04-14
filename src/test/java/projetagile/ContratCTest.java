/*
JUnits pour contrat C
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
 * @author jg891159
 */
public class ContratCTest {
    ModeleJsonIn jsonIn;
    ContratC instance;
    Dollar dollar100;
    
    public ContratCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jsonIn = new ModeleJsonIn("100323", 'C', "2017-01");
        instance = new ContratC(jsonIn);
        dollar100 = new Dollar("100.00$");
    }
    
    @After
    public void tearDown() {
    }

        @Test
    public void testMassotherapie() {
        Dollar montant = new Dollar("100.00$");
        Dollar expResult = new Dollar("90.00$");        
        Dollar result = instance.massotherapie(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }
    
    @Test
    public void testMassotherapiePetit() {
        Dollar montant = new Dollar("1.00$");
        Dollar expResult = new Dollar("0.90$");
        Dollar result = instance.massotherapie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }  

@Test
    public void testOsteopathieMaxMensuelGrand() {
        Dollar montant = new Dollar("1000.00$");
        Dollar expResult = new Dollar("250.00$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
   @Test
    public void testOsteopathieMaxMensuelPetit() {
        Dollar montant = new Dollar("250.01$");
        Dollar expResult = new Dollar("237.50$");
        Dollar result = instance.osteopathie(montant);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
      @Test
    public void testOsteopathie() {
        Dollar expResult = new Dollar("95.00$");
        Dollar result = instance.osteopathie(dollar100);
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    

@Test
    public void testKinesitherapie() {
        Dollar expResult = new Dollar("85.00$");        
        Dollar result = instance.kinesitherapie(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
   
    @Test
    public void testKinesitherapiePetit() {
        Dollar montant = new Dollar("100000.00$");
        Dollar expResult = new Dollar("85000.00$");        
        Dollar result = instance.kinesitherapie(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());        
    }   

@Test
    public void testMedecin_generaliste_prive() {
        Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.medecin_generaliste_prive(dollar100); 
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    
    @Test
    public void testMedecin_generaliste_priveMaxMensuelPetit() {
        Dollar montant = new Dollar("10.00$");
        Dollar expResult = new Dollar("9.00$");
        Dollar result = instance.medecin_generaliste_prive(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   
    
    
    @Test
    public void testMedecin_generaliste_priveMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("200.00$");
        Dollar result = instance.medecin_generaliste_prive(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    } 

@Test
    public void testPsychologie_individuelle() {
          Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.psychologie_individuelle(dollar100); 
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    
    @Test
    public void testPsychologie_individuellePetit() {
        Dollar montant = new Dollar("250.00$");
        Dollar expResult = new Dollar("225.00$");
        Dollar result = instance.psychologie_individuelle(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   
    
    
    @Test
    public void testPsychologie_individuelleMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("250.00$");
        Dollar result = instance.psychologie_individuelle(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   

@Test
    public void testSoin_dentaire() {
        Dollar expResult = new Dollar("90.00$");        
        Dollar result = instance.soin_dentaire(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    @Test
    public void testSoin_dentaireGrand() {
        Dollar montant = new Dollar("1000.00$");
        Dollar expResult = new Dollar("900.00$");        
        Dollar result = instance.soin_dentaire(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }

        @Test
    public void testNaturo_acuponcture() {
        Dollar expResult = new Dollar("90.00$");        
        Dollar result = instance.naturo_acuponcture(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
@Test
    public void testNaturo_acuponctureGrand() {
        Dollar montant = new Dollar("1000.00$");
        Dollar expResult = new Dollar("900.00$");        
        Dollar result = instance.naturo_acuponcture(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }

@Test
    public void testChiropratie() {
        Dollar expResult = new Dollar("90.00$");
        Dollar result = instance.chiropratie(dollar100); 
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    
    @Test
    public void testChiropratiePetit() {
        Dollar montant = new Dollar("150.00$");
        Dollar expResult = new Dollar("135.00$");
        Dollar result = instance.chiropratie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   
    
    
    @Test
    public void testChiropratieMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("150.00$");
        Dollar result = instance.chiropratie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   

    @Test
    public void testPhysiotherapie() {
         Dollar expResult = new Dollar("75.00$");
        Dollar result = instance.physiotherapie(dollar100); 
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    
    
    @Test
    public void testPhysiotherapiePetit() {
        Dollar montant = new Dollar("300.00$");
        Dollar expResult = new Dollar("225.00$");
        Dollar result = instance.physiotherapie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }   
    
    
    @Test
    public void testPhysiotherapieMaxMensuelGrand() {
        Dollar montant = new Dollar("3000.00$");
        Dollar expResult = new Dollar("300.00$");
        Dollar result = instance.physiotherapie(montant); 
        assertEquals(expResult.getMontant(), result.getMontant());
        
    } 
    

    @Test
    public void testOrthophonie_ergotherapie() {
        Dollar expResult = new Dollar("90.00$");        
        Dollar result = instance.naturo_acuponcture(dollar100);        
        assertEquals(expResult.getMontant(), result.getMontant());
    }
    @Test
    public void testOrthophonie_ergotherapiePetit() {
        Dollar montant = new Dollar("1000.00$");
        Dollar expResult = new Dollar("900.00$");        
        Dollar result = instance.naturo_acuponcture(montant);        
        assertEquals(expResult.getMontant(), result.getMontant());
        
    }
}
