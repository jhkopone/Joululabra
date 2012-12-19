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
public class Kurssi {
    private String nimi;
    private String kurssikoodi;
    private int opintopisteet;
    private String taso;
    private String erikoistumislinja;
    private String kuvaus;
    private int arvosana;
    
    public Kurssi() {  
    }
    
    public Kurssi (String nimi, String kurssikoodi, int opintopisteet, String taso, String erikoistumislinja, String kuvaus, int arvosana) {
        this.nimi = nimi;
        this.kurssikoodi = kurssikoodi;
        this.opintopisteet = opintopisteet;
        this.taso = taso;
        this.erikoistumislinja = erikoistumislinja;
        this.kuvaus = kuvaus;    
        this.arvosana = arvosana;
    }
    
    // setterit
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void setKurssikoodi(String kurssikoodi) {
        this.kurssikoodi = kurssikoodi;
    }
    
    public void setOpintopisteet(int opintopisteet) {
        this.opintopisteet = opintopisteet;
    }
    
    public void setTaso(String taso) {
        this.taso = taso;
    }
    
    public void setErikoistumislinja (String erikoistumislinja) {
        this.erikoistumislinja = erikoistumislinja;
    }
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;
    }

    // getterit

    public String getNimi() {
        return nimi;
    }
    
    public String getKurssikoodi() {
        return kurssikoodi;
    }

    public int getOpintopisteet() {
        return opintopisteet;
    }

    public String getTaso() {
        return taso;
    }

    public String getErikoistumislinja() {
        return erikoistumislinja;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public int getArvosana() {
        return arvosana;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
