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
 * @author kf891141
 */
public class Utf8FileTest {
    
    public Utf8FileTest() {
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
     * Test of loadFileIntoString method, of class Utf8File.
     */
    @Test
    public void testLoadFileIntoString() throws Exception {
        System.out.println("loadFileIntoString");
        String filePath = "";
        String expResult = "";
        String result = Utf8File.loadFileIntoString(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveStringIntoFile method, of class Utf8File.
     */
    @Test
    public void testSaveStringIntoFile() throws Exception {
        System.out.println("saveStringIntoFile");
        String filePath = "";
        String content = "";
        Utf8File.saveStringIntoFile(filePath, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
