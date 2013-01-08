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
    private List<Opiskelija> opiskelijat;
    private OpintojenSeurantajarjestelma jarjestelma;
    private String tiedosto;
    
    public KayttajienHallinta(OpintojenSeurantajarjestelma jarjestelma, String tiedosto) {
        this.jarjestelma = jarjestelma;
        this.tiedosto = tiedosto;
        lataaKayttajat();
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
 */ 
    
    public void kirjauduSisaan(String tunnus, String salasana) {
        for (Opiskelija o : this.opiskelijat) {
            if (o.getTunnus().equals(tunnus) && o.getSalasana().equals(salasana)) {
                this.jarjestelma.setOpiskelija(o);
                PaaIkkuna paaIkkuna = new PaaIkkuna(this.jarjestelma);
                paaIkkuna.run();
            }
        }
    }
/**
 * Metodi kirjaa käyttäjän ulos järjestelmästä. Toteutus toistaiseksi kesken.
 */     
    public boolean kirjauduUlos() {
        return false;
    }

/**
 * Metodi palauttaa opiskelijat-oliomuuttujan viittaaman taulukon.
 */       
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
    
    public void alustaTiedosto(String tiedosto) {
        List<Opiskelija> tyhjaLista = new ArrayList<Opiskelija>();
        
        try {
            Tiedostonkasittelija.kirjoitaOpiskelijat(tiedosto, tyhjaLista);
        } catch (Exception e) {
            
        }
    }
    
}
