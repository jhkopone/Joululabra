/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttajat;
import java.util.*;
import opintojenseurantajarjestelma.Tiedostonkasittelija;
/**
 *
 * @author Koppa
 */
public class KayttajienHallinta {
    private Tiedostonkasittelija tiedostonkasittelija;
    private List<Opiskelija> opiskelijat;
    
    public KayttajienHallinta() {
        this.tiedostonkasittelija = new Tiedostonkasittelija();
        lataaKayttajat();
    }
    
    public void lataaKayttajat() {
        try {
            this.opiskelijat = this.tiedostonkasittelija.lueOpiskelijat("kayttajat.lista");
        } catch (Exception e) {
      
        } 
    }
    
    public void tallennaKayttajat() {
        try {
           this.tiedostonkasittelija.kirjoitaOpiskelijat("kayttajat.lista", this.opiskelijat); 
        } catch (Exception e) {
            
        }
    }
    
    public boolean lisaaKayttaja(Opiskelija opiskelija) {
        if (this.opiskelijat == null) {
            this.opiskelijat = new ArrayList<Opiskelija>();
        }
        
        if (!this.opiskelijat.contains(opiskelija)) {
            this.opiskelijat.add(opiskelija);
            tallennaKayttajat();
            return true;
        }
        
        return false;
    }
    
    public boolean poistaKayttaja(Opiskelija opiskelija) {
        if (this.opiskelijat == null || !this.opiskelijat.contains(opiskelija)) {
            return false;
        }
        
        this.opiskelijat.remove(opiskelija);
        tallennaKayttajat();
        return false;
    }
    
    public boolean kirjauduSisaan() {
        return false;
    }
    
    public boolean kirjauduUlos() {
        return false;
    }
}
