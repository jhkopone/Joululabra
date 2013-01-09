package opintojenseurantajarjestelma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kayttajat.Opiskelija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonkasittelijaTest {
    List<Opiskelija> opiskelijaTesti;
    Map<Taso, Opintokokonaisuus> opintokokonaisuusTesti;
    
    public TiedostonkasittelijaTest() {
    }
    
    @Before
    public void setUp() {
        this.opintokokonaisuusTesti = new HashMap<Taso, Opintokokonaisuus>();
        this.opiskelijaTesti = new ArrayList<Opiskelija>();
    }
    
    @Test
    public void kirjoitaOpiskelijatToimii() {
        String testitiedosto = "testi1";
        boolean toimivuus = true;
        
        try{
            Tiedostonkasittelija.kirjoitaOpiskelijat(testitiedosto, opiskelijaTesti);
        } catch (Exception e) {
            toimivuus = false;
        } 
        
        assertEquals(toimivuus, true);
    }
    
    @Test
    public void kirjoitaOpintokokonaisuudetToimii() {
        String testitiedosto = "testi2";
        boolean toimivuus = true;
        
        try{
            Tiedostonkasittelija.kirjoitaOpintokokonaisuudet(testitiedosto, opintokokonaisuusTesti);
        } catch (Exception e) {
            toimivuus = false;
        } 
        
        assertEquals(toimivuus, true);
    }
    
    @Test
    public void lueOpiskelijatToimii() {
        String testitiedosto = "testi3";
        boolean toimivuus = true;
        
        try{
            Tiedostonkasittelija.kirjoitaOpiskelijat(testitiedosto, opiskelijaTesti);
        } catch (Exception e) {
            
        } 
        
        try{
            Tiedostonkasittelija.lueOpiskelijat(testitiedosto);
        } catch (Exception e) {
            toimivuus = false;
        } 
        
        assertEquals(toimivuus, true);
    }
    
    @Test
    public void lueOpintokokonaisuudetToimii() {
        String testitiedosto = "testi4";
        boolean toimivuus = true;
        
        try{
            Tiedostonkasittelija.kirjoitaOpintokokonaisuudet(testitiedosto, opintokokonaisuusTesti);
        } catch (Exception e) {
            
        } 
        
        try{
            Tiedostonkasittelija.lueOpintokokonaisuudet(testitiedosto);
        } catch (Exception e) {
            toimivuus = false;
        } 
        
        assertEquals(toimivuus, true);
    }
}
