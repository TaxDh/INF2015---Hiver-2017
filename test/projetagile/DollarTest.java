/*
 * Classe pour tester les méthodes de la classe Dollar.
 */
package projetagile;

import org.junit.Test;
import static org.junit.Assert.*;



public class DollarTest {

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

    @Test
    public void testConvertirStringDollarEnIntNormal() {
        assertEquals(1200, Dollar.convertirStringDollarEnInt("12"));
        assertEquals(0, Dollar.convertirStringDollarEnInt("0"));
        assertEquals(50000, Dollar.convertirStringDollarEnInt("500"));
    }
    
      @Test
    public void testConvertirStringDollarEnIntNul() {
            assertEquals(0, Dollar.convertirStringDollarEnInt("0"));        
    }
    
    @Test
    public void testConvertirStringDollarEnIntGrand() {
            assertEquals(100000000, Dollar.convertirStringDollarEnInt("1000000"));        
    }
    
    @Test
    public void testConvertirStringDollarEnIntPetit() {
            assertEquals(100, Dollar.convertirStringDollarEnInt("1"));        
    }

    
    @Test(expected=NumberFormatException.class)
    public void testConvertirStringDollarEnIntException() {
            assertEquals(100, Dollar.convertirStringDollarEnInt("patate"));        
    }

    @Test
    public void testConvertirIntEnStringDollarNormal() {
        assertEquals("0.12$", Dollar.convertirIntEnStringDollar(12));
        assertEquals("5.00$", Dollar.convertirIntEnStringDollar(500));
    }
    
      @Test
    public void testConvertirIntEnStringDollarNul() {
            assertEquals("0.00$", Dollar.convertirIntEnStringDollar(0));        
    }
    
    @Test
    public void testConvertirIntEnStringDollarGrand() {
            assertEquals("10000.00$", Dollar.convertirIntEnStringDollar(1000000));        
    }
    
    @Test
    public void testConvertirIntEnStringDollarPetit() {
            assertEquals("0.01$", Dollar.convertirIntEnStringDollar(1));        
    }

    @Test
    public void testConvertirIntEnStringDollarNegatif() {
            assertEquals("-0.10$", Dollar.convertirIntEnStringDollar(-10));        
    }

    @Test
    public void testConvertirEnStringDollarNormal() {
        Dollar dollar1= new Dollar(20);
        assertEquals("0.20$",dollar1.convertirEnStringDollar());
    }

    @Test
    public void testConvertirEnStringDollarNul() {
        Dollar dollar1= new Dollar(0);
        assertEquals("0.00$",dollar1.convertirEnStringDollar());
    }
    
    @Test
    public void testConvertirEnStringDollarGrand() {
        Dollar dollar1= new Dollar(1000000);
        assertEquals("10000.00$",dollar1.convertirEnStringDollar());
    }
    
    @Test
    public void testConvertirEnStringDollarPetit() {
        Dollar dollar1= new Dollar(1);
        assertEquals("0.01$",dollar1.convertirEnStringDollar());
    }
    
    @Test(expected=NumberFormatException.class)
    public void testConvertirEnStringDollarException() {
        Dollar dollar1= new Dollar("hey");
        assertEquals("0.01$",dollar1.convertirEnStringDollar());
    }
    
    @Test
    public void testConvertirDoubleEnIntNormal() {
        assertEquals(35050, Dollar.convertirDoubleEnInt(350.50));
        assertEquals(1000, Dollar.convertirDoubleEnInt(10.00));
        assertEquals(3498, Dollar.convertirDoubleEnInt(34.98));
    }
    
    @Test
    public void testConvertirDoubleEnIntPetit() {
        assertEquals(150, Dollar.convertirDoubleEnInt(1.50));
        assertEquals(90, Dollar.convertirDoubleEnInt(0.90));
        assertEquals(2, Dollar.convertirDoubleEnInt(0.02));
    }
    
    @Test
    public void testConvertirDoubleEnIntnul() {
        assertEquals(0, Dollar.convertirDoubleEnInt(0));
    }
   
    
    @Test
    public void testConvertirDoubleEnIntGrand() {
            assertEquals(100000000, Dollar.convertirDoubleEnInt(1000000));
            assertEquals(1123581300, Dollar.convertirDoubleEnInt(11235813));
    }
    
    
    @Test
    public void testConvertirIntEnDoubleNormal() {
        assertEquals(12.0, Dollar.convertirIntEnDouble(1200), 0);
        assertEquals(32.50,Dollar.convertirIntEnDouble(3250), 0); 
        assertEquals(6.66,Dollar.convertirIntEnDouble(666), 0);
    }
    
    @Test
    public void testConvertirIntEnDoublePetit() {
        assertEquals(0.12, Dollar.convertirIntEnDouble(12), 0);
        assertEquals(3.58,Dollar.convertirIntEnDouble(358), 0); 
        assertEquals(0.01,Dollar.convertirIntEnDouble(1), 0);
    }
    
    @Test
    public void testConvertirIntEnDoubleNul() {
        assertEquals(0.00, Dollar.convertirIntEnDouble(0), 0);
    }
    
    @Test
    public void testConvertirIntEnDoubleGrand() {
        assertEquals(358740.25, Dollar.convertirIntEnDouble(35874025), 0);
        assertEquals(100.00,Dollar.convertirIntEnDouble(10000), 0); 
        assertEquals(3141592.65,Dollar.convertirIntEnDouble(314159265), 0);
    }
    
   
    @Test
    public void testConvertirStringDollarEnDoublePetit() {
        assertEquals(3.15, Dollar.convertirStringDollarEnDouble("3.15$"), 0.0);
        assertEquals(0.03, Dollar.convertirStringDollarEnDouble("0.03$"), 0.0);
        assertEquals(0.10, Dollar.convertirStringDollarEnDouble("0,10$"), 0.0);
    }
    
    @Test
    public void testConvertirStringDollarEnDoubleNormal() {
       assertEquals(54.45, Dollar.convertirStringDollarEnDouble("54.45$"), 0.0);
       assertEquals(2254.45, Dollar.convertirStringDollarEnDouble("2254.45$"), 0.0);
       assertEquals(545.34, Dollar.convertirStringDollarEnDouble("545.34$"), 0.0);
    }
    
    @Test
    public void testConvertirStringDollarEnDoubleGrand() {
       assertEquals(10000.358, Dollar.convertirStringDollarEnDouble("10000.358$"), 0.0);
       assertEquals(35201587493.00, Dollar.convertirStringDollarEnDouble("35201587493.00$"), 0.0);
       assertEquals(123456897.17, Dollar.convertirStringDollarEnDouble("123456897,17$"), 0.0);
    }
    
    @Test
    public void testConvertirStringDollarEnDoubleNul() {
        assertEquals(0.0, Dollar.convertirStringDollarEnDouble("0.00$"), 0.0);
    }
   
    @Test(expected=NumberFormatException.class)
    public void testConvertirStringDollarEnDoubleException() {
       assertEquals(0.0, Dollar.convertirStringDollarEnDouble("patate$"), 0.0);
    }
    
    @Test
    public void testContientVirguleFalse() {
        assertFalse(Dollar.contientVirgule("392.34$"));
        assertFalse(Dollar.contientVirgule("1.05$"));
        assertFalse(Dollar.contientVirgule("1000.01$"));
    }
    
    @Test
    public void testContientVirguleTrue() {
        assertTrue(Dollar.contientVirgule("392,34$"));
        assertTrue(Dollar.contientVirgule("1,05$"));
        assertTrue(Dollar.contientVirgule("1000,01$"));
    }

    @Test
    public void testConvertirDoubleEnStringDollarPetit() {
        assertEquals("1.01$", Dollar.convertirDoubleEnStringDollar(1.01));
        assertEquals("0.02$", Dollar.convertirDoubleEnStringDollar(0.02));
        assertEquals("9.99$", Dollar.convertirDoubleEnStringDollar(9.99));
    }
    
    @Test
    public void testConvertirDoubleEnStringDollarNormal() {
        assertEquals("100.01$", Dollar.convertirDoubleEnStringDollar(100.01));
        assertEquals("987.22$", Dollar.convertirDoubleEnStringDollar(987.22));
        assertEquals("999.99$", Dollar.convertirDoubleEnStringDollar(999.99));
    }
    
    @Test
    public void testConvertirDoubleEnStringDollarGrand() {
        assertEquals("10000.97$", Dollar.convertirDoubleEnStringDollar(10000.97));
        assertEquals("3521478932.25$", Dollar.convertirDoubleEnStringDollar(3521478932.25));
        assertEquals("4508795.37$", Dollar.convertirDoubleEnStringDollar(4508795.37));
    }
    
    @Test
    public void testConvertirDoubleEnStringDollarNul() {
        assertEquals("0.00$", Dollar.convertirDoubleEnStringDollar(0.0));
    }
    

    @Test
    public void testSetMontant() {
        Dollar dollarTest = new Dollar(20);
        dollarTest.setMontant(15);
        assertEquals(15, dollarTest.getMontant());
    }
    
}

