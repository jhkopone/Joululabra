package paaohjelma;
import opintojenseurantajarjestelma.*;
import kayttoliittyma.*;
import java.util.*;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
/**
 * Paaohjelma on ohjelman pääluokka, jossa main()-metodi sijaitsee.
 * @author Koppa
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        OpintojenSeurantajarjestelma jarjestelma = new OpintojenSeurantajarjestelma(null);

        KayttajienHallinta hallinta = new KayttajienHallinta(jarjestelma, "opiskelijat.lista");
        KirjautumisIkkuna kirjautumisIkkuna = new KirjautumisIkkuna(hallinta);
        kirjautumisIkkuna.run();
    }
}
