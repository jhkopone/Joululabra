/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.util.*;
/**
 *
 * @author jhkopone
 */
public class Opintokokonaisuus {
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
    
    public boolean poistaKurssi(Kurssi kurssi) {
        if (this.kurssit.containsKey(kurssi.getKurssikoodi())) {
            this.kurssit.remove(kurssi.getKurssikoodi());
            return true;
        }
        return false;
    }
    
    public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (String kurssi : this.kurssit.keySet()) {
            opintopisteet += Integer.parseInt(this.kurssit.get(kurssi).getOpintopisteet());
        }
        
        return opintopisteet;
    }
    
    public int kurssienLukumaara() {
        return this.kurssit.size();
    }
    
    public int yleisarvosana() {
        int yleisarvosana = 0;
        
        
        for (String kurssi : this.kurssit.keySet()) {
            yleisarvosana = yleisarvosana + (Integer.parseInt(this.kurssit.get(kurssi).getArvosana()) * Integer.parseInt(this.kurssit.get(kurssi).getOpintopisteet()));
        }
        
        return yleisarvosana / this.opintopisteetYhteensa();
    }
    
    public Taso getNimi() {
        return this.nimi;
    }
}
