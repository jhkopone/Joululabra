/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttajat;

import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
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
public class KayttajienHallintaTest {
    private OpintojenSeurantajarjestelma jarjestelma;
    private KayttajienHallinta hallintaJarjestelma;
    
    public KayttajienHallintaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.jarjestelma = new OpintojenSeurantajarjestelma(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        this.hallintaJarjestelma = new KayttajienHallinta(this.jarjestelma);
    }
    
    @After
    public void tearDown() {
    }
    
   
    
}
