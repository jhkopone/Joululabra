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
    private String opintopisteet;
    private String taso;
    private String erikoistumislinja;
    private String kuvaus;
    private String arvosana;
    private String suoritusPvm;
    
    public Kurssi() {  
    }
    
    public Kurssi (String nimi, String kurssikoodi, String opintopisteet, String taso, String erikoistumislinja, String kuvaus, String arvosana, String suoritusPvm) {
        this.nimi = nimi;
        this.kurssikoodi = kurssikoodi;
        this.opintopisteet = opintopisteet;
        this.taso = taso;
        this.erikoistumislinja = erikoistumislinja;
        this.kuvaus = kuvaus;    
        this.arvosana = arvosana;
        this.suoritusPvm = suoritusPvm;
    }
    
    // setterit
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void setKurssikoodi(String kurssikoodi) {
        this.kurssikoodi = kurssikoodi;
    }
    
    public void setOpintopisteet(String opintopisteet) {
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
    
    public void setArvosana(String arvosana) {
        this.arvosana = arvosana;
    }

    public void setSuoritusPvm(String suoritusPvm) {
        this.suoritusPvm = suoritusPvm;
    }
    
    

    // getterit

    public String getNimi() {
        return nimi;
    }
    
    public String getKurssikoodi() {
        return kurssikoodi;
    }

    public String getOpintopisteet() {
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

    public String getArvosana() {
        return arvosana;
    }

    public String getSuoritusPvm() {
        return suoritusPvm;
    }
    
    
    
    @Override
    public String toString() {
        return "";
    }
}
