
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

/**
 * Metodi kirjoittaa parametrina saamansa Opiskelija-olioita sisältävän listan parametrina
 * saamaansa tiedostoon.
 */      
    public static void kirjoitaOpiskelijat(String tiedosto, List<Opiskelija> opiskelijat) throws Exception {
        FileOutputStream ulosF = new FileOutputStream(tiedosto);
        ObjectOutputStream ulos = new ObjectOutputStream(ulosF);
        
        ulos.writeObject(opiskelijat);
        
        ulos.flush();
        ulosF.close();
    }
/**
 * Metodi kirjoittaa parametrina saamansa Map-rajapinnan toteuttavan olion parametrina saamaansa tiedostoon.
 */      
    public static void kirjoitaOpintokokonaisuudet(String tiedosto, Map<Taso, Opintokokonaisuus> opintokokonaisuudet) throws Exception {
        FileOutputStream ulosF = new FileOutputStream(tiedosto);
        ObjectOutputStream ulos = new ObjectOutputStream(ulosF);
        
        ulos.writeObject(opintokokonaisuudet);
        
        ulos.flush();
        ulosF.close();
    }
/**
 * Metodi palauttaa parametrina saamastaan tiedostosta lukemansa Opiskelija-olioita sisältävän listan.
 */      
    public static List<Opiskelija> lueOpiskelijat(String tiedosto) throws Exception {
        FileInputStream sisaanF = new FileInputStream(tiedosto);
        ObjectInputStream sisaan = new ObjectInputStream(sisaanF);
        
        List<Opiskelija> luettu = (List<Opiskelija>)sisaan.readObject();

        return luettu;
    }
/**
 * Metodi palauttaa parametrina saamastaan tiedostosta lukemansa Map-rajapinnan toteuttavan olion.
 */      
    public static Map<Taso, Opintokokonaisuus> lueOpintokokonaisuudet(String tiedosto) throws Exception {
        FileInputStream sisaanF = new FileInputStream(tiedosto);
        ObjectInputStream sisaan = new ObjectInputStream(sisaanF);
        
        Map<Taso, Opintokokonaisuus> luettu = null;
        
        try {
            luettu = (Map<Taso, Opintokokonaisuus>)sisaan.readObject();
        } catch (Exception e){
            luettu = new HashMap<Taso, Opintokokonaisuus>();
        }
        

        return luettu;
    }
    
}
