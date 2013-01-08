
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

    @Before
    public void setUp() {
        opiskelija = new Opiskelija("Juha", "Koponen", "007", "010101", "Juhis", "Juhis");
    }
    
    @Test
    public void konstruktoriToimii() {
        Opiskelija uusiOpiskelija = new Opiskelija("Anni", "Opiskelija", "313", "020304", "anni", "ansku");
        
        assertEquals(uusiOpiskelija.toString(), "Anni Opiskelija (313) aloituspäivämäärä: 020304");
    }

    @Test        
    public void getNimiToimii() {
        assertEquals(this.opiskelija.getNimi(), "Juha Koponen");
    }

    @Test
    public void getOpiskelijanumeroToimii() {
        assertEquals(this.opiskelija.getOpiskelijanumero(), "007");
    }

    @Test
    public void getAloituspvmToimii() {
        assertEquals(this.opiskelija.getAloituspvm(), "010101");
    }

    @Test
    public void getTunnusToimii() {
        assertEquals(this.opiskelija.getTunnus(), "Juhis");
    }
    
    @Test
    public void getSalasanaToimii() {
        assertEquals(this.opiskelija.getSalasana(), "Juhis");
    }
    
    @Test
    public void setSalasanaToimii() {
        this.opiskelija.setSalasana("salasana");
        assertEquals(this.opiskelija.getSalasana(), "salasana");
    }

    @Test
    public void toStringToimii() {
        assertEquals(this.opiskelija.toString(), "Juha Koponen (007) aloituspäivämäärä: 010101");
    }        
    
}
