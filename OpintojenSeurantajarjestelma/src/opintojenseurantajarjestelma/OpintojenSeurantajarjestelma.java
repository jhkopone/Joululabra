/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.util.*;
import kayttajat.*;
/**
 *
 * @author jhkopone
 */
public class OpintojenSeurantajarjestelma {
    private Tiedostonkasittelija tiedostonkasittelija;
    
    private Opiskelija opiskelija;
    private List<Opiskelija> opiskelijat;
    private Map<Taso, Opintokokonaisuus> opintokokonaisuudet;
    
    
    public OpintojenSeurantajarjestelma() {
        this.tiedostonkasittelija = new Tiedostonkasittelija();
        
        this.opiskelija = null;
        this.opintokokonaisuudet = null;
        this.opiskelijat = new ArrayList<Opiskelija>();
    }

    // Getterit
    
    public Tiedostonkasittelija getTiedostonkasittelija() {
        return tiedostonkasittelija;
    }

    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

    public List<Opiskelija> getOpiskelijat() {
        return opiskelijat;
    }
    
    public Map<Taso, Opintokokonaisuus> getOpintokokonaisuudet() {
        return this.opintokokonaisuudet;
    }
    
    // Tiedostonkasittely
    
    public void lataaOpiskelijat() {
        try {
            this.opiskelijat = this.tiedostonkasittelija.lueOpiskelijat("kayttajat.lista");
        } catch (Exception e) {
            
        } 
    }
    
    public void tallennaOpiskelijat() {
        try {
           this.tiedostonkasittelija.kirjoitaOpiskelijat("kayttajat.lista", this.opiskelijat); 
        } catch (Exception e) {
            
        }
    }
    
    public void lataaOpintokokonaisuudet() {
        try {
            this.opintokokonaisuudet = this.tiedostonkasittelija.lueOpintokokonaisuudet(this.opiskelija.getTunnus());
        } catch (Exception e) {
            
        } 
    }
    
    public void tallennaOpintokokonaisuudet() {
        try {
           this.tiedostonkasittelija.kirjoitaOpintokokonaisuudet(this.opiskelija.getTunnus(), this.opintokokonaisuudet); 
        } catch (Exception e) {
            
        }
    }

    public boolean kirjaudu(String tunnus, String salasana) {
        try {
            lataaOpiskelijat();
            for (Opiskelija opiskelija : this.opiskelijat) {
                if (opiskelija.getTunnus().equals(tunnus) && opiskelija.getSalasana().equals(salasana)) {
                    this.opiskelija = opiskelija;
                    lataaOpintokokonaisuudet();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
    
    public void lisaaOpiskelija(String etunimi, String sukunimi, String opiskelijanumero, String aloituspvm, String tunnus, String salasana) {
        if (this.opiskelijat == null) {
            this.opiskelijat = new ArrayList<Opiskelija>();
        }
        
        try {
            this.opiskelija = new Opiskelija(etunimi, sukunimi, opiskelijanumero, aloituspvm, tunnus, salasana);
            this.opiskelijat.add(opiskelija);
            tallennaOpiskelijat();
        } catch (Exception e) {
            
        }
    }
    
    public void poistaOpiskelija() {
        this.opiskelijat.remove(this.opiskelija);
    }
    
    public void lisaaKurssi(String nimi, String kurssikoodi, String opintopisteet, Taso taso, String erikoistumislinja, String kuvaus, String arvosana, String suoritusPvm) {
        Kurssi kurssi = new Kurssi(nimi, kurssikoodi, opintopisteet, taso, erikoistumislinja, kuvaus, arvosana, suoritusPvm);
        
        if (this.opintokokonaisuudet == null) {
            this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
        }
        
        if (!this.opintokokonaisuudet.containsKey(taso)) {
            this.opintokokonaisuudet.put(taso, new Opintokokonaisuus(taso));
        }
        
        this.opintokokonaisuudet.get(taso).lisaaKurssi(kurssi);   
    }
    
    public void poistaKurssi(String kurssikoodi) {  
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            this.opintokokonaisuudet.get(taso).poistaKurssi(kurssikoodi);
        }
    }
    
    public void muutaKurssinTietoja() {
        
    }
    
    public String tulostaOpiskelija() {
        return this.opiskelija.toString();
    }
    

    
    public int kaikkienKurssienLukumaara() {
        int kurssienLukumaara = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            kurssienLukumaara = kurssienLukumaara + this.opintokokonaisuudet.get(taso).kurssienLukumaara();
        }
        
        return kurssienLukumaara;
    }
    
   public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            opintopisteet = opintopisteet + this.opintokokonaisuudet.get(taso).opintopisteetYhteensa();
        }
        
        return opintopisteet;
    }
    
    
}
