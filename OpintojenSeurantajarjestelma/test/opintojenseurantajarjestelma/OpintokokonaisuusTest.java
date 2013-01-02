
package opintojenseurantajarjestelma;

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
public class OpintokokonaisuusTest {
    
    Opintokokonaisuus opintokokonaisuus;
    Kurssi kurssi1;
    Kurssi kurssi2;
    Kurssi kurssi3;
    
    public OpintokokonaisuusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        opintokokonaisuus = new Opintokokonaisuus(Taso.PERUSOPINNOT);
        kurssi1 = new Kurssi("testi1", "007","5", "perusopinnot", "ei ole", "testikurssi1", "5");
        kurssi2 = new Kurssi("testi2", "008", "4", "perusopinnot", "ei ole", "testikurssi2", "5");
        kurssi3 = new Kurssi("testi3", "009", "3", "perusopinnot", "ei ole", "testikurssi3", "5");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(opintokokonaisuus.getNimi(), Taso.PERUSOPINNOT);
    }
    
    @Test
    public void hajautustauluAlustettu() { 
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 0);
    }
    
    @Test
    public void yhdenKurssinLisaaminenToimii() {
        opintokokonaisuus.lisaaKurssi(kurssi1);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 1);
    }
    
    @Test
    public void useammanKurssinLisaaminenToimii() {   
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 3); 
    }
    
    @Test
    public void yhdenKurssinPoistaminenToimii() {
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        
        opintokokonaisuus.poistaKurssi(kurssi1);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 1);
    }
    
    @Test
    public void useammanKurssinPoistaminenToimii() {
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        opintokokonaisuus.poistaKurssi(kurssi1);
        opintokokonaisuus.poistaKurssi(kurssi2);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 1);
    }
    
    @Test
    public void yhdenKurssinOpintopisteidenLaskentaToimii() { 
        opintokokonaisuus.lisaaKurssi(kurssi1);
        
        assertEquals(opintokokonaisuus.opintopisteetYhteensa(), 5);
    }
    
    @Test
    public void useammanKurssinOpintopisteidenLaskentaToimii() {     
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.opintopisteetYhteensa(), 12); 
    }
    
    @Test
    public void yleisarvosananLaskentaToimii() {    
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.yleisarvosana(), 5); 
    }
    
    
    
    
}
