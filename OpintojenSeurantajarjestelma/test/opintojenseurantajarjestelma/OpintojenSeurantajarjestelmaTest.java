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
        assertEquals(this.jarjestelma.tulostaOpiskelija(), "Juha Koponen (007) aloituspäivämäärä: 010101");
    }

    @Test
    public void tulostaOpiskelijaToimii() {
        assertEquals(jarjestelma.tulostaOpiskelija(), "Juha Koponen (007) aloituspäivämäärä: 010101");
    }
    
    @Test
    public void kurssinLisaaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void kurssinLisaaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void kurssinPoistaminenToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.poistaKurssi("007");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 0);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void kurssinPoistaminenToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        jarjestelma.poistaKurssi("008");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 2);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 1);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void kaikkienKurssienLukumaaraToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE1", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.kaikkienKurssienLukumaara(), 3);
        this.jarjestelma.alustaTiedosto("Juhis");
    }

    @Test
    public void opintopisteidenLaskentaToimiiYhdellaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 5);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void opintopisteidenLaskentaToimiiUseammallaKurssilla() {
        jarjestelma.lisaaKurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE2", "008", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        jarjestelma.lisaaKurssi("OHPE3", "009", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
        
        assertEquals(jarjestelma.opintopisteetYhteensa(), 15);
        this.jarjestelma.alustaTiedosto("Juhis");
    }
    
    @Test
    public void arvioValmistumisajankohdastaToimii() {
        
    }
    

    
    
    
}
