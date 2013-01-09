package kayttajat;

import java.util.ArrayList;
import java.util.List;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author jhkopone
 */
public class KayttajienHallintaTest {
    private OpintojenSeurantajarjestelma jarjestelma;
    private KayttajienHallinta hallintaJarjestelma;
    private Opiskelija anni;
    private String testiTiedosto;
    
    public KayttajienHallintaTest() {
    }
    
    @Before
    public void setUp() {
        this.jarjestelma = new OpintojenSeurantajarjestelma(null);
        this.testiTiedosto = "opiskelijat.testi";
        this.hallintaJarjestelma = new KayttajienHallinta(this.jarjestelma, testiTiedosto);
        this.anni = new Opiskelija("Anni", "Opiskelija", "313", "020304", "anni", "ansku");
    }
    
    @Test
    public void lataaKayttajatToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.lisaaKayttaja(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        
        List<Opiskelija> lisattava = new ArrayList<Opiskelija>();
        this.hallintaJarjestelma.setOpiskelijat(lisattava);
        
        this.hallintaJarjestelma.lataaKayttajat();
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 2);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }
    
    @Test
    public void tallennaKayttajatToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.lisaaKayttaja(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        
        List<Opiskelija> lisattava = new ArrayList<Opiskelija>();
        this.hallintaJarjestelma.setOpiskelijat(lisattava);
        
        this.hallintaJarjestelma.lataaKayttajat();
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 2);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }

    @Test
    public void lisaaKayttajaToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 1);
        
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }
    
    @Test
    public void lisaaKayttajaToimiiUseammallaKayttajalla() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.lisaaKayttaja(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 2);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }
    
    @Test
    public void kirjauduSisaanToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.kirjauduSisaan("anni", "ansku");
        assertEquals(this.jarjestelma.getOpiskelija(), this.anni);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }

    @Test
    public void poistaKayttajaToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.poistaKayttaja(this.anni);
        
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 0);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }
    
    @Test
    public void poistaKayttajaToimiiUseammallaKayttajalla() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.lisaaKayttaja(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        this.hallintaJarjestelma.poistaKayttaja(this.anni);
        
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 1);
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
    }
    
    @Test
    public void alustaTiedostoToimii() {
        this.hallintaJarjestelma.lisaaKayttaja(this.anni);
        this.hallintaJarjestelma.lisaaKayttaja(new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis"));
        
        this.hallintaJarjestelma.alustaTiedosto(testiTiedosto);
        this.hallintaJarjestelma.lataaKayttajat();
        
        List<Opiskelija> opiskelijat = this.hallintaJarjestelma.getOpiskelijat();
        
        assertEquals(opiskelijat.size(), 0);
    }
    

    
   
    
}
