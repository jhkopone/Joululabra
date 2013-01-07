/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.io.*;
import java.util.*;
import kayttajat.Opiskelija;

/**
 * Tiedostonkasittelija-luokka tarjoaa työkalut tiedostojen kirjoittamiseen ja
 * lukemiseen. Tällä hetkellä luokkaa käyttävät luokat OpintojenSeurantajarjestelma
 * sekä KayttajienHallinta.
 * @author Koppa
 */
public class Tiedostonkasittelija {
    
    private FileOutputStream ulosF;
    private ObjectOutputStream ulos;
    
    private FileInputStream sisaanF;
    private ObjectInputStream sisaan;
    
    private File tiedosto;
    private Scanner lukija;
    private FileWriter kirjoittaja;
    
    public Tiedostonkasittelija() {  
    }
    
//    public void kirjoita(String tiedosto, List<String> teksti) throws Exception {
//        this.kirjoittaja = new FileWriter(tiedosto);
//        
//        for (String kirjoitettava : teksti) {
//            this.kirjoittaja.write(kirjoitettava);
//        }
//        this.kirjoittaja.close();
//    }
    
//    public void kirjoita(String tiedosto, List<Object> teksti) throws Exception {
//        this.ulosF = new FileOutputStream(tiedosto);
//        this.ulos = new ObjectOutputStream(ulosF);
//        
//        this.ulos.writeObject(teksti);
//        
//        this.ulos.flush();
//        this.ulosF.close();
//    }
/**
 * Metodi kirjoittaa parametrina saamansa Opiskelija-olioita sisältävän listan parametrina
 * saamaansa tiedostoon.
 */      
    public void kirjoitaOpiskelijat(String tiedosto, List<Opiskelija> opiskelijat) throws Exception {
        this.ulosF = new FileOutputStream(tiedosto);
        this.ulos = new ObjectOutputStream(ulosF);
        
        this.ulos.writeObject(opiskelijat);
        
        this.ulos.flush();
        this.ulosF.close();
    }
/**
 * Metodi kirjoittaa parametrina saamansa Map-rajapinnan toteuttavan olion parametrina saamaansa tiedostoon.
 */      
    public void kirjoitaOpintokokonaisuudet(String tiedosto, Map<Taso, Opintokokonaisuus> opintokokonaisuudet) throws Exception {
        this.ulosF = new FileOutputStream(tiedosto);
        this.ulos = new ObjectOutputStream(ulosF);
        
        this.ulos.writeObject(opintokokonaisuudet);
        
        this.ulos.flush();
        this.ulosF.close();
    }
    
//    public List<Object> lue(String tiedosto) throws Exception {
//        this.sisaanF = new FileInputStream(tiedosto);
//        this.sisaan = new ObjectInputStream(sisaanF);
//        
//        List<Object> luettu = (List<Object>)sisaan.readObject();
//
//        return luettu;
//    }

/**
 * Metodi palauttaa parametrina saamastaan tiedostosta lukemansa Opiskelija-olioita sisältävän listan.
 */      
    public List<Opiskelija> lueOpiskelijat(String tiedosto) throws Exception {
        this.sisaanF = new FileInputStream(tiedosto);
        this.sisaan = new ObjectInputStream(sisaanF);
        
        List<Opiskelija> luettu = (List<Opiskelija>)sisaan.readObject();

        return luettu;
    }
/**
 * Metodi palauttaa parametrina saamastaan tiedostosta lukemansa Map-rajapinnan toteuttavan olion.
 */      
    public Map<Taso, Opintokokonaisuus> lueOpintokokonaisuudet(String tiedosto) throws Exception {
        this.sisaanF = new FileInputStream(tiedosto);
        this.sisaan = new ObjectInputStream(sisaanF);
        
        Map<Taso, Opintokokonaisuus> luettu = (Map<Taso, Opintokokonaisuus>)sisaan.readObject();

        return luettu;
    }
    
}
