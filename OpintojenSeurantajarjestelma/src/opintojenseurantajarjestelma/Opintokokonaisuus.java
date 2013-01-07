/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.io.Serializable;
import java.util.*;
/**
 *Opintokokonaisuus-luokka tallentaa yhteen kuuluvat Kurssi-luokan
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
 */      
    public Opintokokonaisuus (Taso nimi) {
        this.nimi = nimi;
        this.kurssit = new HashMap<String, Kurssi>();
    }

/**
 * Metodi lisää järjestelmään parametrinä saamansa kurssin.
 */      
    public boolean lisaaKurssi (Kurssi kurssi) {
        if (!this.kurssit.containsKey(kurssi.getKurssikoodi())) {
            this.kurssit.put(kurssi.getKurssikoodi(), kurssi);
            return true;
        }
        return false;
    }

/**
 * Metodi poistaa järjestelmästä parametrinä saamaansa kurssikoodia vastaavan
 * kurssin.
 */      
    public boolean poistaKurssi(String kurssikoodi) {
        if (this.kurssit.containsKey(kurssikoodi)) {
            this.kurssit.remove(kurssikoodi);
            return true;
        }
        return false;
    }
 
/**
 * Metodi laskee opintokokonaisuuteen kuuluvien kurssien opintopisteet yhteen.
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
 */      
    public int kurssienLukumaara() {
        return this.kurssit.size();
    }

/**
 * Metodi palauttaa kokonaislukuna opintokokonaisuuden yleisarvosanan.
 */      
    public int yleisarvosana() {
        int yleisarvosana = 0;
        
        
        for (Kurssi kurssi : this.kurssit.values()) {
            yleisarvosana = yleisarvosana + (kurssi.getArvosana() * kurssi.getOpintopisteet());
        }
        
        return yleisarvosana / this.opintopisteetYhteensa();
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
