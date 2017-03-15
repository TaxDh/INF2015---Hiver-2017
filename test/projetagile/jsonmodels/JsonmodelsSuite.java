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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author kf891141
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({projetagile.jsonmodels.ReclamationTest.class, projetagile.jsonmodels.ModeleJsonOutTest.class, projetagile.jsonmodels.RemboursementTest.class, projetagile.jsonmodels.ModeleJsonInTest.class})
public class JsonmodelsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
