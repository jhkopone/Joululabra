/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttajat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhkopone
 */
public class OpiskelijaTest {
    Opiskelija opiskelija;
    
    public OpiskelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        opiskelija = new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(this.opiskelija.toString(), "Juha Koponen 007");
    }
    
}
