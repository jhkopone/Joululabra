/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        assertEquals(opintokokonaisuus.getNimi(), "perusopinnot");
    }
    
    @Test
    public void hajautustauluAlustettu() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 0);
    }
    
    @Test
    public void yhdenKurssinLisaaminenToimii() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        Kurssi kurssi = new Kurssi("testi", "007", 5, "perusopinnot", "ei ole", "testikurssi", 5);
        
        opintokokonaisuus.lisaaKurssi(kurssi);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 1);
        
    }
    
    @Test
    public void useammanKurssinLisaaminenToimii() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        Kurssi kurssi1 = new Kurssi("testi1", "007", 5, "perusopinnot", "ei ole", "testikurssi1", 5);
        Kurssi kurssi2 = new Kurssi("testi2", "008", 4, "perusopinnot", "ei ole", "testikurssi2", 5);
        Kurssi kurssi3 = new Kurssi("testi3", "009", 3, "perusopinnot", "ei ole", "testikurssi3", 5);
        
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.kurssienLukumaara(), 3); 
    }
    
    @Test
    public void yhdenKurssinOpintopisteidenLaskentaToimii() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        Kurssi kurssi = new Kurssi("testi", "007", 5, "perusopinnot", "ei ole", "testikurssi", 5);
        
        opintokokonaisuus.lisaaKurssi(kurssi);
        
        assertEquals(opintokokonaisuus.opintopisteetYhteensa(), 5);
    }
    
    @Test
    public void useammanKurssinOpintopisteidenLaskentaToimii() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        Kurssi kurssi1 = new Kurssi("testi1", "007", 5, "perusopinnot", "ei ole", "testikurssi1", 5);
        Kurssi kurssi2 = new Kurssi("testi2", "008", 4, "perusopinnot", "ei ole", "testikurssi2", 5);
        Kurssi kurssi3 = new Kurssi("testi3", "009", 3, "perusopinnot", "ei ole", "testikurssi3", 5);
        
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.opintopisteetYhteensa(), 12); 
    }
    
    @Test
    public void yleisarvosananLaskentaToimii() {
        Opintokokonaisuus opintokokonaisuus = new Opintokokonaisuus("perusopinnot");
        
        Kurssi kurssi1 = new Kurssi("testi1", "007", 5, "perusopinnot", "ei ole", "testikurssi1", 5);
        Kurssi kurssi2 = new Kurssi("testi2", "008", 4, "perusopinnot", "ei ole", "testikurssi2", 5);
        Kurssi kurssi3 = new Kurssi("testi3", "009", 3, "perusopinnot", "ei ole", "testikurssi3", 5);
        
        opintokokonaisuus.lisaaKurssi(kurssi1);
        opintokokonaisuus.lisaaKurssi(kurssi2);
        opintokokonaisuus.lisaaKurssi(kurssi3);
        
        assertEquals(opintokokonaisuus.yleisarvosana(), 5); 
    }
    
    
}
