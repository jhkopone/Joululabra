package opintojenseurantajarjestelma;
import java.io.Serializable;
import java.util.*;
/**
 * Opintokokonaisuus-luokka tallentaa yhteenkuuluvat Kurssi-luokan
 * ilmentymät oliomuuttujaan ja tarjoaa palveluja kursseihin liittyvien
 * tietojen esittämiseen.
 * @author jhkopone
 */
public class Opintokokonaisuus implements Serializable{
    private Taso nimi;
    private Map<String, Kurssi> kurssit;

/**
 * Opintokokonaisuus-luokan konstruktori, joka saa parametrikseen Taso-luokan
 * ilmentymän.
 * @param nimi Taso-luokan ilmentymä
 */    
    public Opintokokonaisuus (Taso nimi) {
        this.nimi = nimi;
        this.kurssit = new HashMap<String, Kurssi>();
    }

/**
 * Metodi lisää järjestelmään parametrinä saamansa kurssin.
 * @param kurssi lisättävä kurssi
 * @return boolean arvo true jos lisääminen onnistuu, muutoin false
 */   
    public boolean lisaaKurssi (Kurssi kurssi) {
        if (!this.kurssit.containsKey(kurssi.getNimi())) {
            this.kurssit.put(kurssi.getNimi(), kurssi);
            return true;
        }
        return false;
    }

/**
 * Metodi poistaa järjestelmästä parametrinä saamaansa kurssikoodia vastaavan
 * kurssin.
 * @param kurssikoodi käyttäjän syöte
 * @return boolean arvo true jos poisto onnistuu, muutoin false
 */     
    public boolean poistaKurssi(String kurssiNimi) {
        if (this.kurssit.containsKey(kurssiNimi)) {
            this.kurssit.remove(kurssiNimi);
            return true;
        }
        return false;
    }
 
/**
 * Metodi laskee opintokokonaisuuteen kuuluvien kurssien opintopisteet yhteen.
 * @return opintopisteiden yhteismäärä
 */     
    public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (Kurssi kurssi : this.kurssit.values()) {
            opintopisteet += kurssi.getOpintopisteet();
        }
        
        return opintopisteet;
    }

/**
 * Metodi palauttaa kokonaislukuna opintokokonaisuuden sisältämien kurssien lukumäärän.
 * @return kurssien yhteismäärä
 */    
    public int kurssienLukumaara() {
        return this.kurssit.size();
    }

/**
 * Metodi palauttaa kokonaislukuna opintokokonaisuuden yleisarvosanan.
 * @return opintopistemäärillä painotettu keskiarvo opintokokonaisuuden arvosanoista
 */     
    public int yleisarvosana() {
        int yleisarvosana = 0;
        
        
        for (Kurssi kurssi : this.kurssit.values()) {
            yleisarvosana += (kurssi.getArvosana() * kurssi.getOpintopisteet());
        }
        
        if (this.opintopisteetYhteensa() != 0) {
            return yleisarvosana / this.opintopisteetYhteensa();
        }
        return 0;
    }

/**
 * Metodi palauttaa nimi-oliomuuttujan arvon.
 */      
    public Taso getNimi() {
        return this.nimi;
    }
/**
 * Metodi palauttaa listan opintokokonaisuuden sisältämistä Kurssi-olioista.
 */      
    public List<Kurssi> getKurssit() {
        return new ArrayList<Kurssi>(this.kurssit.values());
    }
}
