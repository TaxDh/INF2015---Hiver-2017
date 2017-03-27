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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author rene
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({projetagile.JsonFileHandlerTest.class, projetagile.ProjetSessionTest.class, projetagile.ContratCTest.class, projetagile.jsonmodels.JsonmodelsSuite.class, projetagile.Utf8FileTest.class, projetagile.ContratBTest.class, projetagile.ContratETest.class, projetagile.DollarTest.class, projetagile.ContratFactoryTest.class, projetagile.ContratATest.class, projetagile.InvalidArgumentExceptionTest.class, projetagile.InterfaceContratTest.class, projetagile.ContratDTest.class})
public class ProjetagileSuite {

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
