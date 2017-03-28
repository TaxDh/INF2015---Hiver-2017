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


/**
 *
 * @author rene
 */
public class DollarTest {
    
    public DollarTest() {
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
     * Test of additionDollar method, of class Dollar.
     */
    @Test
    public void testAdditionDollarNormal() {
        Dollar dollar1 = new Dollar(15);
        Dollar dollar2 = new Dollar(20);
        dollar1.additionDollar(dollar2);
        assertEquals(35, dollar1.getMontant());
    }
    
    @Test
    public void testAdditionDollarNul() {
        Dollar dollar1 = new Dollar(15);
        Dollar dollar2 = new Dollar(0);
        dollar1.additionDollar(dollar2);
        assertEquals(15, dollar1.getMontant());
    }
    
    @Test
    public void testAdditionDollarGrand() {
        Dollar dollar1 = new Dollar(15000);
        Dollar dollar2 = new Dollar(200000);
        dollar1.additionDollar(dollar2);
        assertEquals(215000, dollar1.getMontant());
    }
    
    @Test
    public void testAdditionDollarNegatif() {
        Dollar dollar1 = new Dollar(-150);
        Dollar dollar2 = new Dollar(-150);
        dollar1.additionDollar(dollar2);
        assertEquals(-300, dollar1.getMontant());
    }
    
    @Test
    public void testAdditionDollarPetit() {
        Dollar dollar1 = new Dollar(1);
        Dollar dollar2 = new Dollar(2);
        dollar1.additionDollar(dollar2);
        assertEquals(3, dollar1.getMontant());
    }
    
    @Test
    public void testAdditionDollarSAnnule() {
        Dollar dollar1 = new Dollar(-1000);
        Dollar dollar2 = new Dollar(1000);
        dollar1.additionDollar(dollar2);
        assertEquals(0, dollar1.getMontant());
    }
    
    @Test(expected=NumberFormatException.class)
    public void testAdditionDollarException() {
        Dollar dollar1 = new Dollar("hello");
        Dollar dollar2 = new Dollar(0);
        dollar1.additionDollar(dollar2);
        assertEquals(0, dollar1.getMontant());
    }

    
    @Test
    public void testSoustractionDollarNormal() {
        Dollar dollar1 = new Dollar(20);
        Dollar dollar2 = new Dollar(15);
        dollar1.soustractionDollar(dollar2);
        assertEquals(5, dollar1.getMontant());
    }
    
    @Test
    public void testSoustractionDollarNul() {
        Dollar dollar1 = new Dollar(15);
        Dollar dollar2 = new Dollar(0);
        dollar1.soustractionDollar(dollar2);
        assertEquals(15, dollar1.getMontant());
    }
    
    @Test
    public void testSoustractionDollarGrand() {
        Dollar dollar1 = new Dollar(200000);
        Dollar dollar2 = new Dollar(15000);
        dollar1.soustractionDollar(dollar2);
        assertEquals(185000, dollar1.getMontant());
    }
    
    @Test
    public void testSoustractionDollarNegatif() {
        Dollar dollar1 = new Dollar(-150);
        Dollar dollar2 = new Dollar(150);
        dollar1.soustractionDollar(dollar2);
        assertEquals(-300, dollar1.getMontant());
    }
    
    @Test
    public void testSoustractionDollarPetit() {
        Dollar dollar1 = new Dollar(3);
        Dollar dollar2 = new Dollar(2);
        dollar1.soustractionDollar(dollar2);
        assertEquals(1, dollar1.getMontant());
    }
    
    @Test
    public void testSoustractionDollarSAnnule() {
        Dollar dollar1 = new Dollar(1000);
        Dollar dollar2 = new Dollar(1000);
        dollar1.soustractionDollar(dollar2);
        assertEquals(0, dollar1.getMontant());
    }
    
    @Test(expected=NumberFormatException.class)
    public void testSoustractionDollarException() {
        Dollar dollar1 = new Dollar("hello");
        Dollar dollar2 = new Dollar(0);
        dollar1.soustractionDollar(dollar2);
        assertEquals(0, dollar1.getMontant());
    }

    /**
     * Test of calculerRemboursement method, of class Dollar.
     */
    @Test
    public void testCalculerRemboursementNormal() {
        
        Dollar dollar1 = new Dollar(100);
        Dollar dollar2 = dollar1.calculerRemboursement(0.25);
        assertEquals(25, dollar2.getMontant());
       
    }

    @Test
    public void testCalculerRemboursementNul() {
        
        Dollar dollar1 = new Dollar(100);
        Dollar dollar2 = dollar1.calculerRemboursement(0.0);
        assertEquals(0, dollar2.getMontant());
       
    }
    @Test
    public void testCalculerRemboursementMontantNul() {
        
        Dollar dollar1 = new Dollar(0);
        Dollar dollar2 = dollar1.calculerRemboursement(0.25);
        assertEquals(0, dollar2.getMontant());
       
    }
    
    @Test
    public void testCalculerRemboursementComplet() {
        
        Dollar dollar1 = new Dollar(100);
        Dollar dollar2 = dollar1.calculerRemboursement(1.0);
        assertEquals(100, dollar2.getMontant());
       
    }
    
    @Test
    public void testCalculerRemboursementGrandMontant() {
        
        Dollar dollar1 = new Dollar(3000000);
        Dollar dollar2 = dollar1.calculerRemboursement(0.75);
        assertEquals(2250000, dollar2.getMontant());
       
    }
    
    
    @Test
    public void testCalculerRemboursementPetitMontant() {
        
        Dollar dollar1 = new Dollar(10);
        Dollar dollar2 = dollar1.calculerRemboursement(0.80);
        assertEquals(8, dollar2.getMontant());
       
    }
    
    @Test(expected=NumberFormatException.class)
    public void testCalculerRemboursementException() {
        
        Dollar dollar1 = new Dollar("hey");
        Dollar dollar2 = dollar1.calculerRemboursement(0.25);
        assertEquals(0, dollar2.getMontant());
       
    }
    /**
     * Test of convertirStringEnInt method, of class Dollar.
     */
    @Test
    public void testConvertirStringEnIntNormal() {
        assertEquals(1200, Dollar.convertirStringEnInt("12"));
        assertEquals(0, Dollar.convertirStringEnInt("0"));
        assertEquals(50000, Dollar.convertirStringEnInt("500"));
    }
    
      @Test
    public void testConvertirStringEnIntNul() {
            assertEquals(0, Dollar.convertirStringEnInt("0"));        
    }
    
    @Test
    public void testConvertirStringEnIntGrand() {
            assertEquals(100000000, Dollar.convertirStringEnInt("1000000"));        
    }
    
      @Test
    public void testConvertirStringEnIntPetit() {
            assertEquals(100, Dollar.convertirStringEnInt("1"));        
    }

    
     @Test(expected=NumberFormatException.class)
    public void testConvertirStringEnIntException() {
            assertEquals(100, Dollar.convertirStringEnInt("patate"));        
    }
    
    /**
     * Test of convertirIntEnString method, of class Dollar.
     */
    //
    
    
    
    
    
    
    
    @Test
    public void testConvertirIntEnStringNormal() {
        assertEquals("0.12$", Dollar.convertirIntEnString(12));
        assertEquals("5.00$", Dollar.convertirIntEnString(500));
    }
    
      @Test
    public void testConvertirIntEnStringNul() {
            assertEquals("0.00$", Dollar.convertirIntEnString(0));        
    }
    
    @Test
    public void testConvertirIntEnStringGrand() {
            assertEquals("10000.00$", Dollar.convertirIntEnString(1000000));        
    }
    
      @Test
    public void testConvertirIntEnStringPetit() {
            assertEquals("0.01$", Dollar.convertirIntEnString(1));        
    }

    
     @Test
    public void testConvertirIntEnStringNegatif() {
            assertEquals("-0.10$", Dollar.convertirIntEnString(-10));        
    }
     
    
    
    
    
    
    
    //

    /**
     * Test of convertirEnString method, of class Dollar.
     */
    @Test
    public void testConvertirEnString() {
        System.out.println("convertirEnString");
        Dollar instance = new Dollar();
        String expResult = "";
        String result = instance.convertirEnString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirDoubleEnInt method, of class Dollar.
     */
    @Test
    public void testConvertirDoubleEnInt() {
        System.out.println("convertirDoubleEnInt");
        double dblMontant = 0.0;
        int expResult = 0;
        int result = Dollar.convertirDoubleEnInt(dblMontant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirIntEnDouble method, of class Dollar.
     */
    @Test
    public void testConvertirIntEnDouble() {
        System.out.println("convertirIntEnDouble");
        int intMontant = 0;
        double expResult = 0.0;
        double result = Dollar.convertirIntEnDouble(intMontant);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirStringEnDouble method, of class Dollar.
     */
    @Test
    public void testConvertirStringEnDouble() {
        System.out.println("convertirStringEnDouble");
        String strMontant = "";
        double expResult = 0.0;
        double result = Dollar.convertirStringEnDouble(strMontant);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contientVirgule method, of class Dollar.
     */
    @Test
    public void testContientVirgule() {
        System.out.println("contientVirgule");
        String montant = "";
        boolean expResult = false;
        boolean result = Dollar.contientVirgule(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirDoubleEnString method, of class Dollar.
     */
    @Test
    public void testConvertirDoubleEnString() {
        System.out.println("convertirDoubleEnString");
        double dblMontant = 0.0;
        String expResult = "";
        String result = Dollar.convertirDoubleEnString(dblMontant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMontant method, of class Dollar.
     */
    @Test
    public void testGetMontant() {
        System.out.println("getMontant");
        Dollar instance = new Dollar();
        int expResult = 0;
        int result = instance.getMontant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMontant method, of class Dollar.
     */
    @Test
    public void testSetMontant() {
        System.out.println("setMontant");
        int montant = 0;
        Dollar instance = new Dollar();
        instance.setMontant(montant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

