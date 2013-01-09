package opintojenseurantajarjestelma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author jhkopone
 */
public class KurssiTest {
    Kurssi kurssi;
    
    public KurssiTest() {
    }
    
    @Before
    public void setUp() {
        kurssi = new Kurssi("OHPE", "007", 5, Taso.PERUSOPINNOT, "Ohjelmistojärjestelmät", "Java-peruskurssi", 5, "010101");
    }
    
    @Test
    public void toStringToimii() {
        assertEquals(this.kurssi.toString(), "OHPE" + ", " + "5" + " op" + " (" + "007" + ")\n"
               + "\t" + "Java-peruskurssi" + "\n"
               + "\t" + "arvosana: " + "5" + ", suorituspäivämäärä: " + "010101");
    }
    
    @Test
    public void lyhytTulosteToimii() {
        assertEquals(this.kurssi.lyhytTuloste(), "OHPE (007)");
    }
}
