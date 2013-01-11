package kayttajat;
import java.util.*;
import kayttoliittyma.PaaIkkuna;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
import opintojenseurantajarjestelma.Tiedostonkasittelija;
/**
 * Luokka hallinnoi Opiskelija-olioita. Luokan avulla onnistuu mm.
 * uuden opiskelijan lisääminen, opiskelijan poisto sekä kirjautuminen.
 */   
public class KayttajienHallinta {
/**
 * Järjestelmään käyttäjätunnuksen luoneet opiskelijat
 */      
    private List<Opiskelija> opiskelijat;
/**
 * OpintojenSeurantajärjestelmä, jonka käyttöoikeuksia valvotaan
 */      
    private OpintojenSeurantajarjestelma jarjestelma;
/**
 * Tiedosto, johon käyttäjien tunnistautumistiedot tallennetaan
 */      
    private String tiedosto;
    
/**
 * KayttajienHallinta-luokan konstruktori
 * @param jarjestelma OpintojenSeurantajarjestelma -luokan ilmentymä
 * @param tiedosto tiedoston nimi, johon käyttäjät tallennetaan.
 */    
    public KayttajienHallinta(OpintojenSeurantajarjestelma jarjestelma, String tiedosto) {
        this.jarjestelma = jarjestelma;
        this.tiedosto = tiedosto;
        lataaKayttajat();
    }
    
    public OpintojenSeurantajarjestelma getJarjestelma() {
        return this.jarjestelma;
    }

/**
 * Metodi lataa Opiskelija-olioita sisältävän listan ja tallentaa sen opiskelijat
 * oliomuuttujaan.
 */          
    public void lataaKayttajat() {
        try {
            this.opiskelijat = Tiedostonkasittelija.lueOpiskelijat(this.tiedosto);
        } catch (Exception e) {
            
        } 
    }

/**
 * Metodi tallentaa opiskelijat-oliomuuttujaan tallennetun Opiskelija-olioita sisältävän
 * listan tiedostoon.
 */     
    public void tallennaKayttajat() {
        try {
           Tiedostonkasittelija.kirjoitaOpiskelijat(this.tiedosto, this.opiskelijat); 
        } catch (Exception e) {
            
        }
    }
/**
 * Metodi lisää parametrina annetun Opiskelija-olion opiskelijat-oliomuuttujaan.
 * @param opiskelija lisättävä käyttäjä
 * @return metodi palauttaa boolean arvon true jos lisääminen onnistuu, muutoin false.
 */    
    public boolean lisaaKayttaja(Opiskelija opiskelija) {
        if (this.opiskelijat == null) {
            this.opiskelijat = new ArrayList<Opiskelija>();
        }
        
        if (!this.opiskelijat.contains(opiskelija)) {
            this.opiskelijat.add(opiskelija);
            tallennaKayttajat();
            return true;
        }
        
        return false;
    }
/**
 * Metodi poistaa parametrina annetun Opiskelija-olion opiskelijat-oliomuuttujan
 * sisältämästä listasta.
 * @param opiskelija poistettava käyttäjä
 * @return metodi palauttaa boolean arvon true jos poisto onnistuu, muutoin false.
 */    
    public boolean poistaKayttaja(Opiskelija opiskelija) {
        if (this.opiskelijat == null || !this.opiskelijat.contains(opiskelija)) {
            return false;
        }
        
        this.opiskelijat.remove(opiskelija);
        tallennaKayttajat();
        return false;
    }
/**
 * Metodin avulla tarkistetaan löytyykö parametrina annettu tunnus-salasana-yhdistelmä
 * järjestelmään tallennettujen yhdistelmien joukosta.
 * @param tunnus käyttäjän antama syöte
 * @param salasana käyttäjän antama syöte
 */ 
    
    public boolean kirjauduSisaan(String tunnus, String salasana) {
        for (Opiskelija o : this.opiskelijat) {
            if (o.getTunnus().equals(tunnus) && o.getSalasana().equals(salasana)) {
                this.jarjestelma.setOpiskelija(o);
                return true;
            }
        }
        return false;
    }
    
    public List<Opiskelija> getOpiskelijat() {
        return this.opiskelijat;
    }
    
    public void setOpiskelijat(List<Opiskelija> opiskelijaLista) {
        this.opiskelijat = opiskelijaLista;
    }
    
    public String getTiedosto() {
        return this.tiedosto;
    }
    
    public void setTiedosto(String tiedosto) {
        this.tiedosto = tiedosto;
    }
/**
 * Metodi tallentaa tyhjän listan parametrina saamaansa tiedostoon.
 * @param tiedosto alustettavan tiedoston nimi.
 */    
    public void alustaTiedosto(String tiedosto) {
        List<Opiskelija> tyhjaLista = new ArrayList<Opiskelija>();
        
        try {
            Tiedostonkasittelija.kirjoitaOpiskelijat(tiedosto, tyhjaLista);
        } catch (Exception e) {
            
        }
    }
    
}
