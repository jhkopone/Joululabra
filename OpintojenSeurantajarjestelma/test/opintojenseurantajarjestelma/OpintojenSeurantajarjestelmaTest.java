package opintojenseurantajarjestelma;

import java.util.ArrayList;
import kayttajat.Opiskelija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OpintojenSeurantajarjestelmaTest {
    OpintojenSeurantajarjestelma jarjestelma;
    
    public OpintojenSeurantajarjestelmaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jarjestelma = new OpintojenSeurantajarjestelma();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(this.jarjestelma.getOpiskelija(), null);
        assertEquals(this.jarjestelma.getOpintokokonaisuudet(), null);
        assertEquals(this.jarjestelma.getOpiskelijat().isEmpty(), true);
    }
    
    @Test
    public void lisaaOpiskelijaLisaaOpiskelijan() {
        jarjestelma.lisaaOpiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
        
        assertEquals(jarjestelma.getOpiskelijat().size(), 1);
    }
    
    @Test
    public void useammanOpiskelijanLisaaminenToimii() {
        jarjestelma.lisaaOpiskelija("Juha1", "Koponen1", "007", "010101", "Juhis1", "Juhis1");
        jarjestelma.lisaaOpiskelija("Juha2", "Koponen2", "008", "010101", "Juhis2", "Juhis2");
        jarjestelma.lisaaOpiskelija("Juha3", "Koponen3", "009", "010101", "Juhis3", "Juhis3");
        
        assertEquals(jarjestelma.getOpiskelijat().size(), 3);
    }
    
    @Test
    public void poistaOpiskelijaToimiiYhdellaOpiskelijalla() {
        jarjestelma.lisaaOpiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
        jarjestelma.poistaOpiskelija();
        
        assertEquals(jarjestelma.getOpiskelijat().size(), 0);
    }
    
    @Test
    public void poistaOpiskelijaToimiiUseammallaOpiskelijalla() {
        jarjestelma.lisaaOpiskelija("Juha1", "Koponen1", "007", "010101", "Juhis1", "Juhis1");
        jarjestelma.lisaaOpiskelija("Juha2", "Koponen2", "008", "010101", "Juhis2", "Juhis2");
        jarjestelma.lisaaOpiskelija("Juha3", "Koponen3", "009", "010101", "Juhis3", "Juhis3");
        
        jarjestelma.poistaOpiskelija();
        
        assertEquals(jarjestelma.getOpiskelijat().size(), 2);
    }
    
    @Test
    public void tulostaOpiskelijaToimii() {
        jarjestelma.lisaaOpiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
        
        assertEquals(jarjestelma.tulostaOpiskelija(), "Juha Koponen 007");
    }
    
    @Test
    public void kurssinLisaaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
    }
    
    @Test
    public void kurssinLisaaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
    }
    
    @Test
    public void kurssinPoistaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.poistaKurssi("007");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 0);
    }
    
    @Test
    public void kurssinPoistaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        jarjestelma.poistaKurssi("008");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 2);
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
    }
    
    @Test
    public void kirjautuminenPalauttaaTrueKunTiedotOikein() {
        jarjestelma.lisaaOpiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
        
        assertEquals(jarjestelma.kirjaudu("Juhis", "Juhis"), true);
    }
    
    @Test
    public void kirjautuminenPalauttaaFalseKunTiedotVaarin() {
        jarjestelma.lisaaOpiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
        
        assertEquals(jarjestelma.kirjaudu("Juhis", "Juha"), false);
    }
    
    @Test
    public void opintopisteidenLaskentaToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 5);
    }
    
    @Test
    public void opintopisteidenLaskentaToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", "5", Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", "5", "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 15);
    }
    
    
    
}
