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
public class Kurssi implements Serializable{
    private String nimi;
    private String kurssikoodi;
    private Integer opintopisteet;
    private Taso taso;
    private String erikoistumislinja;
    private String kuvaus;
    private Integer arvosana;
    private String suoritusPvm;
    
    public Kurssi() {  
    }
    
    public Kurssi (String nimi, String kurssikoodi, Integer opintopisteet, Taso taso, String erikoistumislinja, String kuvaus, Integer arvosana, String suoritusPvm) {
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
    
    public void setOpintopisteet(Integer opintopisteet) {
        this.opintopisteet = opintopisteet;
    }
    
    public void setTaso(Taso taso) {
        this.taso = taso;
    }
    
    public void setErikoistumislinja (String erikoistumislinja) {
        this.erikoistumislinja = erikoistumislinja;
    }
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void setArvosana(Integer arvosana) {
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

    public Integer getOpintopisteet() {
        return opintopisteet;
    }

    public Taso getTaso() {
        return taso;
    }

    public String getErikoistumislinja() {
        return erikoistumislinja;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public Integer getArvosana() {
        return arvosana;
    }

    public String getSuoritusPvm() {
        return suoritusPvm;
    }
    
    
    
    @Override
    public String toString() {
        return this.nimi + ", " + this.opintopisteet + " op" + " (" + this.kurssikoodi + ")\n"
               + "\t" + this.kuvaus + "\n"
               + "\t" + "arvosana: " + this.arvosana + ", suorituspäivämäärä: " + this.suoritusPvm;
    }
    
    public String lyhytTuloste() {
        return this.nimi + " (" + this.kurssikoodi + ") ";
    }
}
