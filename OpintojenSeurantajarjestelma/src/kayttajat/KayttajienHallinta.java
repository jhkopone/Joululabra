package kayttajat;
import java.util.*;
import kayttoliittyma.PaaIkkuna;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
import opintojenseurantajarjestelma.Tiedostonkasittelija;

public class KayttajienHallinta {
    private Tiedostonkasittelija tiedostonkasittelija;
    private List<Opiskelija> opiskelijat;
    
    private OpintojenSeurantajarjestelma jarjestelma;
    
    public KayttajienHallinta(OpintojenSeurantajarjestelma jarjestelma) {
        this.tiedostonkasittelija = new Tiedostonkasittelija();
        this.jarjestelma = jarjestelma;
        lataaKayttajat();
    }
    
    public void lataaKayttajat() {
        try {
            this.opiskelijat = this.tiedostonkasittelija.lueOpiskelijat("kayttajat.lista");
        } catch (Exception e) {
            
        } 
    }
    
    public void tallennaKayttajat() {
        try {
           this.tiedostonkasittelija.kirjoitaOpiskelijat("kayttajat.lista", this.opiskelijat); 
        } catch (Exception e) {
            
        }
    }
    
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
    
    public boolean poistaKayttaja(Opiskelija opiskelija) {
        if (this.opiskelijat == null || !this.opiskelijat.contains(opiskelija)) {
            return false;
        }
        
        this.opiskelijat.remove(opiskelija);
        tallennaKayttajat();
        return false;
    }
    
    public void kirjauduSisaan(String tunnus, String salasana) {
        for (Opiskelija o : this.opiskelijat) {
            if (o.getTunnus().equals(tunnus) && o.getSalasana().equals(salasana)) {
                this.jarjestelma.setOpiskelija(o);
                PaaIkkuna paaIkkuna = new PaaIkkuna(this.jarjestelma);
                paaIkkuna.run();
            }
        }
    }
    
    public boolean kirjauduUlos() {
        return false;
    }
    
}
