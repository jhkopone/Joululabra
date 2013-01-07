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
    
    private boolean kirjautuminen;
    private Opiskelija opiskelija;
    private Map<Taso, Opintokokonaisuus> opintokokonaisuudet;
    
    
    public OpintojenSeurantajarjestelma(Opiskelija opiskelija) {
        this.tiedostonkasittelija = new Tiedostonkasittelija();
        this.kirjautuminen = false;
        
        this.opiskelija = opiskelija;
        this.opintokokonaisuudet = null;
    }
    
    public void setOpiskelija(Opiskelija opiskelija) {
        this.opiskelija = opiskelija;
    }

    // Getterit
    
    public Tiedostonkasittelija getTiedostonkasittelija() {
        return tiedostonkasittelija;
    }

    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

    
    public Map<Taso, Opintokokonaisuus> getOpintokokonaisuudet() {
        return this.opintokokonaisuudet;
    }
    
    public boolean getKirjautuminen() {
        return this.kirjautuminen;
    }
    
    // Tiedostonkasittely
    

    

    
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
   
   public String tulostaKurssit() {
       String tuloste = "";
       
       for (Taso taso : this.opintokokonaisuudet.keySet()) {
           for (Kurssi kurssi : this.opintokokonaisuudet.get(taso).getKurssit()) {
               tuloste = tuloste + kurssi.lyhytTuloste();
           }
       }

       return tuloste;
   }
    
    
}
