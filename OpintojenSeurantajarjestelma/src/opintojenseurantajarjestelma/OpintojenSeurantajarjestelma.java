
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
    private Opiskelija opiskelija;
    private Map<Taso, Opintokokonaisuus> opintokokonaisuudet;
    
/**
 * OpintojenSeurantajarjestelma-luokan konstruktori. Vaatii parametrikseen
 * Opiskelija-luokan ilmentymän.
 */     
    public OpintojenSeurantajarjestelma(Opiskelija opiskelija) {
        this.opiskelija = opiskelija;
        this.opintokokonaisuudet = new HashMap<Taso, Opintokokonaisuus>();
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
 * Metodi lisää opiskelijan suorittamiin kursseihin uuden kurssin.
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
  * Metodi poistaa kurssin opiskelijan suorittamien kurssien joukosta.
  */   
    public void poistaKurssi(String kurssikoodi) {
        lataaOpintokokonaisuudet();
        
        for (Taso taso : this.opintokokonaisuudet.keySet()) {
            this.opintokokonaisuudet.get(taso).poistaKurssi(kurssikoodi);
        }
        
        tallennaOpintokokonaisuudet();
    }
    
    public void muutaKurssinTietoja() {
        
    }


/**
 * Metodi laskee ja palauttaa kokonaislukuna opiskelijan suorittamien kurssien
 * kokonaismäärän.
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
 * Metodi palauttaa kokonaislukuna opiskelijan suorittamien opintopisteiden yhteismäärän.
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
 * Metodi palauttaa merkkijonona lyhyen tulosteen kaikista opiskelijan suorittamista
 * kursseista.
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
 */    
    public String tulostaOpiskelija() {
        return this.opiskelija.toString();
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
   
   public String tulostaArvosanajakauma(List<Integer> arvosanat) {
       Integer korkeus = 0;
       
       for (int i : arvosanat) {
           if (i > korkeus) {
               korkeus = i;
           }
       }
       
       for (int i = korkeus; i >= 0; i--) {
           System.out.println("*" + "  " + "  " + "  " + "  " );
       }
       
       String arvosanaJakauma = "";
       
       
       
       return arvosanaJakauma;
   }
    
}
