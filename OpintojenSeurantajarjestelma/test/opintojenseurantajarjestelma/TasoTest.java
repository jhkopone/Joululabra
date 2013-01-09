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
public class TasoTest {
    Taso taso;
    
    public TasoTest() {
    }
    
    @Before
    public void setUp() {
        taso = Taso.PERUSOPINNOT;
    }

    @Test
    public void konstruktoriToimii() {
        Integer luku = 1;
        assertEquals(taso.getTaso(), luku);
    }
}
