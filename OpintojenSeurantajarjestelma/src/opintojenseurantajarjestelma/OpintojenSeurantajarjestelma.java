/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.util.*;
import java.text.*;
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
            System.out.println("ongelmia opintojen lataamisessa!");
        } 
    }
    
    public void tallennaOpintokokonaisuudet() {
        try {
           this.tiedostonkasittelija.kirjoitaOpintokokonaisuudet(this.opiskelija.getTunnus(), this.opintokokonaisuudet); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean kirjaudu(String tunnus, String salasana) {
        try {
            lataaOpiskelijat();
            for (Opiskelija o : this.opiskelijat) {
                if (o.getTunnus().equals(tunnus) && o.getSalasana().equals(salasana)) {
                    this.opiskelija = o;
                    lataaOpintokokonaisuudet();
                    System.out.println("kirjautuminen ok!");
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
    
    public void lisaaKurssi(String nimi, String kurssikoodi, Integer opintopisteet, Taso taso, String erikoistumislinja, String kuvaus, Integer arvosana, String suoritusPvm) {
        Kurssi kurssi = new Kurssi(nimi, kurssikoodi, opintopisteet, taso, erikoistumislinja, kuvaus, arvosana, suoritusPvm);
        
        if (this.opintokokonaisuudet == null) {
            this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
        }
        
        if (!this.opintokokonaisuudet.containsKey(taso)) {
            this.opintokokonaisuudet.put(taso, new Opintokokonaisuus(taso));
        }
        
        this.opintokokonaisuudet.get(taso).lisaaKurssi(kurssi);
        this.tallennaOpintokokonaisuudet();
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
   
   public String arvioValmistumisajankohdasta() {
       DateFormat df = new SimpleDateFormat("ddMMyy");
       Date opiskelijanAloitusPvm = new Date();
       try {
          opiskelijanAloitusPvm = df.parse(this.opiskelija.getAloituspvm()); 
       } catch (Exception e) {
           
       }
       
       Date paivamaara = new Date();
       long aloitus = opiskelijanAloitusPvm.getTime();
       long nyt = paivamaara.getTime();
       
       long erotus = nyt - aloitus;
       
       long aikaaPerOpintopiste = erotus / opintopisteetYhteensa();
       
       int opintopisteitaKandiksi = 180 - opintopisteetYhteensa();
       
       int opintopisteitaMaisteriksi = 300 - opintopisteetYhteensa();
       
       Date valmistuminenKandiksi = new Date(paivamaara.getTime() + (aikaaPerOpintopiste * opintopisteitaKandiksi));
       
       Date valmistuminenMaisteriksi = new Date(paivamaara.getTime() + (aikaaPerOpintopiste * opintopisteitaKandiksi));
       
       String tuloste = df.format(valmistuminenKandiksi);
       
       
       return tuloste;
   }
    
    
}
