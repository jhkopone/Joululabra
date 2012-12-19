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
    private String nimi;
    private Map<String, Kurssi> kurssit;

    
    public Opintokokonaisuus (String nimi) {
        this.nimi = nimi;
        this.kurssit = new HashMap<String, Kurssi>();
    }
    
    public void lisaaKurssi (Kurssi kurssi) {
        this.kurssit.put(kurssi.getKurssikoodi(), kurssi);
    }
    
    public int opintopisteetYhteensa() {
        int opintopisteet = 0;
        
        for (String kurssi : this.kurssit.keySet()) {
            opintopisteet += this.kurssit.get(kurssi).getOpintopisteet();
        }
        
        return opintopisteet;
    }
    
    public int kurssienLukumaara() {
        return this.kurssit.size();
    }
    
    public int yleisarvosana() {
        int yleisarvosana = 0;
        
        for (String kurssi : this.kurssit.keySet()) {
            yleisarvosana = yleisarvosana + this.kurssit.get(kurssi).getArvosana();
        }
        
        return yleisarvosana / this.kurssit.size();
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
