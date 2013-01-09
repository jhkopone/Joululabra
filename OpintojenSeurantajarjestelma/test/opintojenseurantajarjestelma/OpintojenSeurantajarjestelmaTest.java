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
    
    @Before
    public void setUp() {
        jarjestelma = new OpintojenSeurantajarjestelma(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(this.jarjestelma.getOpiskelija(), null);
        assertEquals(this.jarjestelma.getOpintokokonaisuudet(), null);
    }

    @Test
    public void tulostaOpiskelijaToimii() {
        assertEquals(jarjestelma.tulostaOpiskelija(), "Juha Koponen (007) aloituspäivämäärä: 010101");
    }
    
    @Test
    public void kurssinLisaaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
    }
    
    @Test
    public void kurssinLisaaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
    }
    
    @Test
    public void kurssinPoistaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.poistaKurssi("007");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 0);
    }
    
    @Test
    public void kurssinPoistaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        jarjestelma.poistaKurssi("008");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 2);
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
    }

    @Test
    public void opintopisteidenLaskentaToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 5);
    }
    
    @Test
    public void opintopisteidenLaskentaToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 15);
    }
    
    @Test
    public void arvioValmistumisajankohdastaToimii() {
        
    }
    
    
    
}
