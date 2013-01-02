/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 *
 * @author Koppa
 */
public class Tiedostonkasittelija {
    private File tiedosto;
    private Scanner lukija;
    private FileWriter kirjoittaja;
    
    public Tiedostonkasittelija() {  
    }
    
    public void kirjoita(String tiedosto, List<String> teksti) throws Exception {
        this.kirjoittaja = new FileWriter(tiedosto);
        
        for (String kirjoitettava : teksti) {
            this.kirjoittaja.write(kirjoitettava);
        }
        this.kirjoittaja.close();
    }
    
    public ArrayList<String> lue(String tiedosto) {
        this.lukija = new Scanner(tiedosto);
        ArrayList<String> luettu = new ArrayList<String>();
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            luettu.add(rivi);
        }
        
        this.lukija.close();
        return luettu;
    }
    
}
