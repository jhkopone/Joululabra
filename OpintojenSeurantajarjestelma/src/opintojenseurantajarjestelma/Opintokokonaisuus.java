/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author jhkopone
 */
public class Opintokokonaisuus implements Serializable{
    private Taso nimi;
    private Map<String, Kurssi> kurssit;

    
    public Opintokokonaisuus (Taso nimi) {
        this.nimi = nimi;
        this.kurssit = new HashMap<String, Kurssi>();
    }
    
    public boolean lisaaKurssi (Kurssi kurssi) {
        if (!this.kurssit.containsKey(kurssi.getKurssikoodi())) {
            this.kurssit.put(kurssi.getKurssikoodi(), kurssi);
            return true;
        }
        return false;
    }
    
    public boolean poistaKurssi(String kurssikoodi) {
        if (this.kurssit.containsKey(kurssikoodi)) {
            this.kurssit.remove(kurssikoodi);
            return true;
        }
        return false;
    }
    
    public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (Kurssi kurssi : this.kurssit.values()) {
            opintopisteet += kurssi.getOpintopisteet();
        }
        
        return opintopisteet;
    }
    
    public int kurssienLukumaara() {
        return this.kurssit.size();
    }
    
    public int yleisarvosana() {
        int yleisarvosana = 0;
        
        
        for (Kurssi kurssi : this.kurssit.values()) {
            yleisarvosana = yleisarvosana + (kurssi.getArvosana() * kurssi.getOpintopisteet());
        }
        
        return yleisarvosana / this.opintopisteetYhteensa();
    }
    
    public Taso getNimi() {
        return this.nimi;
    }
    
    public List<Kurssi> getKurssit() {
        return new ArrayList<Kurssi>(this.kurssit.values());
    }
}
