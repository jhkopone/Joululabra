/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.util.*;
import java.text.*;
import kayttajat.*;

/**
 * OpintojenSeurantajarjestelma-luokka on ohjelman pääluokka. Siitä muodostetut oliot
 * toimivat järjestelmässä niin sanottuina ohjausolioina.
 * @author jhkopone
 */
public class OpintojenSeurantajarjestelma {
    private Tiedostonkasittelija tiedostonkasittelija;
    
    private Opiskelija opiskelija;
    private Map<Taso, Opintokokonaisuus> opintokokonaisuudet;
    
/**
 * OpintojenSeurantajarjestelma-luokan konstruktori. Vaatii parametrikseen
 * Opiskelija-luokan ilmentymän.
 */     
    public OpintojenSeurantajarjestelma(Opiskelija opiskelija) {
        this.tiedostonkasittelija = new Tiedostonkasittelija();
        
        this.opiskelija = opiskelija;
        this.opintokokonaisuudet = null;
    }
/**
 * Metodi asettaa opiskelija-oliomuuttujan arvoksi viitteen parametrina saamaansa
 * Opiskelija-olioon.
 */     
    public void setOpiskelija(Opiskelija opiskelija) {
        this.opiskelija = opiskelija;
    }

    // Getterit
/**
 * Metodi palauttaa tiedostonkasittelija-oliomuuttujaan tallennetun viitteen.
 */     
    public Tiedostonkasittelija getTiedostonkasittelija() {
        return tiedostonkasittelija;
    }
/**
 * Metodi palauttaa opiskelija-oliomuuttujaan tallennetun viitteen.
 */ 
    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

/**
 * Metodi palauttaa opintokokonaisuudet-oliomuuttujaan tallennetun viitteen Map-rajapinnan
 * toteuttavaan olioon.
 */     
    public Map<Taso, Opintokokonaisuus> getOpintokokonaisuudet() {
        return this.opintokokonaisuudet;
    }
    
    
    // Tiedostonkasittely
    

    

/**
 * Metodi lataa tiedostosta (joka määräytyy opiskelija-oliomuuttujan arvon mukaan) Map-rajapinnan
 * toteuttavan olion, johon kyseisen opiskelijan suorittamat kurssit on tallennettu opintokokonaisuuksittain.
 */     
    public void lataaOpintokokonaisuudet() {
        try {
            this.opintokokonaisuudet = this.tiedostonkasittelija.lueOpintokokonaisuudet(this.opiskelija.getTunnus());
        } catch (Exception e) {
            System.out.println("ongelmia opintojen lataamisessa!");
        } 
    }
/**
 * Metodi tallentaa tiedostoon (joka määräytyy opiskelija-oliomuuttujan arvon mukaan) opintokokonaisuudet-
 * oliomuuttujaan tallennetun Map-rajapinnan
 * toteuttavan olion, johon kyseisen opiskelijan suorittamat kurssit on tallennettu opintokokonaisuuksittain.
 */     
    public void tallennaOpintokokonaisuudet() {
        try {
           this.tiedostonkasittelija.kirjoitaOpintokokonaisuudet(this.opiskelija.getTunnus(), this.opintokokonaisuudet); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    

/**
 * Metodi lisää opiskelijan suorittamiin kursseihin uuden kurssin.
 */    
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
 /**
  * Metodi poistaa kurssin opiskelijan suorittamien kurssien joukosta.
  */   
    public void poistaKurssi(String kurssikoodi) {  
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            this.opintokokonaisuudet.get(taso).poistaKurssi(kurssikoodi);
        }
    }
    
    public void muutaKurssinTietoja() {
        
    }
/**
 * Metodi palauttaa merkkijonona tiedot opiskelija-oliomuuttujan viittaamasta
 * Opiskelija-oliosta.
 */    
    public String tulostaOpiskelija() {
        return this.opiskelija.toString();
    }
    

/**
 * Metodi laskee ja palauttaa kokonaislukuna opiskelijan suorittamien kurssien
 * kokonaismäärän.
 */      
    public int kaikkienKurssienLukumaara() {
        int kurssienLukumaara = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            kurssienLukumaara = kurssienLukumaara + this.opintokokonaisuudet.get(taso).kurssienLukumaara();
        }
        
        return kurssienLukumaara;
    }
/**
 * Metodi palauttaa kokonaislukuna opiskelijan suorittamien opintopisteiden yhteismäärän.
 */      
   public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            opintopisteet = opintopisteet + this.opintokokonaisuudet.get(taso).opintopisteetYhteensa();
        }
        
        return opintopisteet;
    }
/**
 * Metodi palauttaa merkkijonona arvion opiskelijan valmistumisajankohdasta (tällä hetkellä
 * kandidaatiksi valmistumisen ajankohdasta)
 */     
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
/**
 * Metodi palauttaa merkkijonona lyhyen tulosteen kaikista opiskelijan suorittamista
 * kursseista.
 */     
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
