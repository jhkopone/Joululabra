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
/**
 * Järjestelmää käyttävä opiskelija
 */      
    private Opiskelija opiskelija;
/**
 * Järjestelmää käyttävän opiskelijan opintokokonaisuudet
 */      
    private Map<Taso, Opintokokonaisuus> opintokokonaisuudet;
    
/**
 * OpintojenSeurantajarjestelma-luokan konstruktori 
 * @param opiskelija järjestelmää käyttävä opiskelija
 */  
    public OpintojenSeurantajarjestelma(Opiskelija opiskelija) {
        this.opiskelija = opiskelija;
        this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
    }
/**
 * Metodi asettaa opiskelija-oliomuuttujan arvoksi viitteen parametrina saamaansa
 * Opiskelija-olioon.
 * @param opiskelija 
 */   
    public void setOpiskelija(Opiskelija opiskelija) {
        this.opiskelija = opiskelija;
    }

/**
 * Metodi palauttaa opiskelija-oliomuuttujaan tallennetun viitteen.
 * @return järjestelmää käyttävä opiskelija
 */
    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

/**
 * Metodi palauttaa opintokokonaisuudet-oliomuuttujaan tallennetun viitteen Map-rajapinnan
 * toteuttavaan olioon.
 * @return järjestelmää käyttävän opiskelijan suorittamat opinnot opintokokonaisuuksittain
 */    
    public Map<Taso, Opintokokonaisuus> getOpintokokonaisuudet() {
        lataaOpintokokonaisuudet();
        return this.opintokokonaisuudet;
    }

// Tiedostonkasittely

/**
 * Metodi lataa tiedostosta (joka määräytyy opiskelija-oliomuuttujan arvon mukaan) Map-rajapinnan
 * toteuttavan olion, johon kyseisen opiskelijan suorittamat kurssit on tallennettu opintokokonaisuuksittain.
 */     
    public void lataaOpintokokonaisuudet() {
        if (this.opiskelija != null) {
            try {
                this.opintokokonaisuudet = Tiedostonkasittelija.lueOpintokokonaisuudet(this.opiskelija.getTunnus());
            } catch (Exception e) {
                this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
            } 
        }
    }
/**
 * Metodi tallentaa tiedostoon (joka määräytyy opiskelija-oliomuuttujan arvon mukaan) opintokokonaisuudet-
 * oliomuuttujaan tallennetun Map-rajapinnan
 * toteuttavan olion, johon kyseisen opiskelijan suorittamat kurssit on tallennettu opintokokonaisuuksittain.
 */     
    public void tallennaOpintokokonaisuudet() {
        try {
           Tiedostonkasittelija.kirjoitaOpintokokonaisuudet(this.opiskelija.getTunnus(), this.opintokokonaisuudet); 
        } catch (Exception e) {
            System.out.println("virhe kurssien tallentamisessa!");
        }
    }

/**
 * Metodi luo ja lisää opiskelijan suorittamiin kursseihin uuden kurssin.
 * parametrit samoja kuin Kurssi-luokan oliomuuttujat
 * @param nimi
 * @param kurssikoodi
 * @param opintopisteet
 * @param taso
 * @param erikoistumislinja
 * @param kuvaus
 * @param arvosana
 * @param suoritusPvm 
 */ 
    public void lisaaKurssi(String nimi, String kurssikoodi, Integer opintopisteet, Taso taso, String erikoistumislinja, String kuvaus, Integer arvosana, String suoritusPvm) {
        Kurssi kurssi = new Kurssi(nimi, kurssikoodi, opintopisteet, taso, erikoistumislinja, kuvaus, arvosana, suoritusPvm);
        
        lataaOpintokokonaisuudet();
        
        if (!this.opintokokonaisuudet.containsKey(taso)) {
            this.opintokokonaisuudet.put(taso, new Opintokokonaisuus(taso));
        }
        
        this.opintokokonaisuudet.get(taso).lisaaKurssi(kurssi);
        
        tallennaOpintokokonaisuudet();
    }
    
 /**
  * Metodi poistaa kurssin opiskelijan suorittamien kurssien joukosta
  * @param kurssikoodi poistettavan kurssin kurssikoodi
  */ 
    public void poistaKurssi(String kurssiNimi) {
        lataaOpintokokonaisuudet();
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            this.opintokokonaisuudet.get(taso).poistaKurssi(kurssiNimi);
        }
        
        tallennaOpintokokonaisuudet();
    }
    
    public void muutaKurssinTietoja() {
        
    }


/**
 * Metodi laskee ja palauttaa kokonaislukuna opiskelijan suorittamien kurssien
 * kokonaismäärän.
 * @return opiskelijan suorittamien kurssien kokonaismäärä
 */     
    public int kaikkienKurssienLukumaara() {
        lataaOpintokokonaisuudet();
        
        if (this.opintokokonaisuudet.isEmpty()) {
            return 0;
        }
        
        int kurssienLukumaara = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            kurssienLukumaara += this.opintokokonaisuudet.get(taso).kurssienLukumaara();
        }
        
        return kurssienLukumaara;
    }
/**
 * Metodi kurssienNimet() palauttaa opiskelijan järjestelmään tallentamien
 * kurssien nimet merkkijonotaulukkona
 * @return kaikkien kurssien nimet merkkijonotaulukkona
 */    
    public String[] kurssienNimet(){
        if (this.kaikkienKurssienLukumaara() == 0) {
            String[] eiYhtaanKurssia = new String[1];
            eiYhtaanKurssia[0] = "ei suoritettuja kursseja!";
            return eiYhtaanKurssia;
        }
        
        String[] kurssienNimet = new String[this.kaikkienKurssienLukumaara()];
        int indeksi = 0;
        
        for (Opintokokonaisuus opintokokonaisuus : this.opintokokonaisuudet.values()) {
            for (Kurssi kurssi : opintokokonaisuus.getKurssit()) {
                kurssienNimet[indeksi] = kurssi.getNimi();
                indeksi++;
            }
                
        }
        
        return kurssienNimet;
    }
/**
 * Metodi laskee opiskelijan suorittamien opintopisteiden yhteismäärän.
 * @return opiskelijan suorittamien opintopisteiden yhteismäärä
 */    
   public int opintopisteetYhteensa() {
       lataaOpintokokonaisuudet();
       
       if (this.opintokokonaisuudet.isEmpty()) {
           return 0;
       }
       
       int opintopisteet = 0;
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            opintopisteet += this.opintokokonaisuudet.get(taso).opintopisteetYhteensa();
        }

        return opintopisteet;
    }

/**
 * Metodi muodostaa merkkijono, joka sisältää lyhyen koosteen kaikista opiskelijan suorittamista
 * kursseista.
 * @return kooste opiskelijan kursseista
 */   
   public String tulostaKurssit() {
       lataaOpintokokonaisuudet();
       
       if (this.opintokokonaisuudet.isEmpty()) {
           return "ei suoritettuja kursseja";
       }
       
       String tuloste = "";
       tuloste += "Kursseja yhteensä: " + kaikkienKurssienLukumaara() + ", opintopisteitä yhteensä: " + opintopisteetYhteensa() + "\n\n";
       
       for (Taso taso : this.opintokokonaisuudet.keySet()) {
           tuloste += taso + ", yleisarvosana: " + this.opintokokonaisuudet.get(taso).yleisarvosana() + "\n\n";
           for (Kurssi kurssi : this.opintokokonaisuudet.get(taso).getKurssit()) {
               tuloste += kurssi.lyhytTuloste() + "\n";
           }
           tuloste += "\n";
       }
       
       tuloste += "Arvioitu valmistumisajankohta: " + arvioValmistumisajankohdasta();
       return tuloste;
   }
   
 /**
 * Metodi palauttaa merkkijonona tiedot opiskelija-oliomuuttujan viittaamasta
 * Opiskelija-oliosta.
 * @return 
 */    
    public String tulostaOpiskelija() {
        return this.opiskelija.toString();
    }
    
 /**
 * Metodi laskee arvion opiskelijan valmistumisajankohdasta (tällä hetkellä
 * kandidaatiksi valmistumisen ajankohdasta)
 * @return arvio opiskelijan valmistumisajankohdasta
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
       
       int opintopisteetYhteensa = opintopisteetYhteensa();
       long aikaaPerOpintopiste = 0;
       
       if (opintopisteetYhteensa == 0) {
            return "valmistumisaikaa ei voida arvioida";
       }
       

       aikaaPerOpintopiste = erotus / opintopisteetYhteensa();
       int opintopisteitaKandiksi = 180 - opintopisteetYhteensa();
       
       int opintopisteitaMaisteriksi = 300 - opintopisteetYhteensa();
       
       Date valmistuminenKandiksi = new Date(paivamaara.getTime() + (aikaaPerOpintopiste * opintopisteitaKandiksi));
       
       Date valmistuminenMaisteriksi = new Date(paivamaara.getTime() + (aikaaPerOpintopiste * opintopisteitaKandiksi));
       
       String tuloste = df.format(valmistuminenKandiksi);
       
       
       return tuloste;
   }
  
   /**
    * Metodi muodostaa merkkijonon, joka sisältää opiskelijan suorittamien kurssien arvosanajakauman asteriskeina.
    * @return opiskelijan suorittamien kurssien arvosanajakauma asteriskeina
    */
   public String tulostaArvosanajakaumaTahtina() {
       List<String> arvosanatTahtina = arvosanajakaumaTahtina(laskeArvosanajakauma());
       
       String arvosanaJakauma = "";

       arvosanaJakauma += "ARVOSANAJAKAUMA\n\n";
       
       arvosanaJakauma += "arvosana  kuvaaja\n\n";
       
       for (int i = 0; i < 5; i++) {
           arvosanaJakauma += (i + 1) + "         " + arvosanatTahtina.get(i) + "\n";
       }

       return arvosanaJakauma;
   }
   
   /**
    * Metodi laskee opiskelijan kullakin arvosanalla suorittamien kurssien lukumäärän ja tallentaa tuloksen taulukkoon
    * selitystekstien kera
    * @return opiskelijan kullakin arvosanalla suorittamien kurssien lukumäärä
    */
   public List<Integer> laskeArvosanajakauma() {
       lataaOpintokokonaisuudet();
       List<Integer> arvosanaJakauma = new ArrayList<Integer>();
       
       for (int i = 0; i < 5; i++) {
           arvosanaJakauma.add(0);
       }
       
       for (Opintokokonaisuus opintokokonaisuus : this.opintokokonaisuudet.values()) {
           List<Kurssi> laskettava = opintokokonaisuus.getKurssit();
           for (Kurssi kurssi : laskettava) {
               int arvosana = kurssi.getArvosana() - 1;
               Integer lisattava = arvosanaJakauma.get(arvosana);
               lisattava++;
               arvosanaJakauma.add(arvosana, lisattava);
           }
       }

       return arvosanaJakauma;
   }
   
   /**
    * Metodi muodostaa taulukon, joka sisältää opiskelijan kullakin arvosanalla suorittamien kurssien lukumäärän
    * asteriskeillä kuvattuna
    * @param arvosanaJakauma kokonaislukuja sisältävä taulukko (kuvaa opiskelijan kullakin arvosanalla suorittamien kurssien lukumäärää)
    * @return 
    */
   public List<String> arvosanajakaumaTahtina(List<Integer> arvosanaJakauma) {
       List<String> arvosanajakaumaTahtina = new ArrayList<String>();
       
       for (Integer i : arvosanaJakauma) {
           String tahdet = "";
           
           for (int j = 1; j <= i; j++) {
               tahdet += "*";
           }
           
           arvosanajakaumaTahtina.add(tahdet);
       }
       
       return arvosanajakaumaTahtina;
       
   }
   /**
    * Metodi poistaKaikkiKurssit() poistaa järjestelmästä kaikki kirjautuneena olevan 
    * opiskelijan kurssit. Metodi kutsuu metodia alustaTiedosto, joka tallentaa opiskelijan
    * tunnuksella yksilöityyn tiedostoon tyhjän hajautustaulun
    */
   public void poistaKaikkiKurssit() {
       this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
       alustaTiedosto(this.opiskelija.getTunnus());
   }
           
           
   /**
    * Metodi alustaa parametrina saamansa nimisen tiedoston tallentamalla sinne tyhjän Map-olion
    * @param tiedosto alustettavan tiedoston nimi
    */
   public void alustaTiedosto(String tiedosto) {
        Map<Taso, Opintokokonaisuus> tyhjaTaulu = new HashMap<Taso, Opintokokonaisuus>();
        
        try {
            Tiedostonkasittelija.kirjoitaOpintokokonaisuudet(tiedosto, tyhjaTaulu);
        } catch (Exception e) {
            
        }
    }
    
}
