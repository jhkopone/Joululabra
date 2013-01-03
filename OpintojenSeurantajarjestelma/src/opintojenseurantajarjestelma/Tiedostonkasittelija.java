/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.io.*;
import java.util.*;
import kayttajat.Opiskelija;

/**
 *
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
    
    public void kirjoita(String tiedosto, List<Object> teksti) throws Exception {
        this.ulosF = new FileOutputStream(tiedosto);
        this.ulos = new ObjectOutputStream(ulosF);
        
        this.ulos.writeObject(teksti);
        
        this.ulos.flush();
        this.ulosF.close();
    }
    
    public List<Object> lue(String tiedosto) throws Exception {
        this.sisaanF = new FileInputStream(tiedosto);
        this.sisaan = new ObjectInputStream(sisaanF);
        
        List<Object> luettu = (List<Object>)sisaan.readObject();

        return luettu;
    }
    
    public List<Opiskelija> lueOpiskelijat(String tiedosto) throws Exception {
        this.sisaanF = new FileInputStream(tiedosto);
        this.sisaan = new ObjectInputStream(sisaanF);
        
        List<Opiskelija> luettu = (List<Opiskelija>)sisaan.readObject();

        return luettu;
    }
    
}
