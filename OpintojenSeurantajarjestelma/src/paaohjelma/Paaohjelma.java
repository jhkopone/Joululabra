/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
//        Scanner lukija = new Scanner(System.in);       
        OpintojenSeurantajarjestelma jarjestelma = new OpintojenSeurantajarjestelma(null);
        
//        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma(lukija, jarjestelma);
//        tekstikayttoliittyma.run();
        KayttajienHallinta hallinta = new KayttajienHallinta(jarjestelma);
        KirjautumisIkkuna kirjautumisIkkuna = new KirjautumisIkkuna(hallinta);
        kirjautumisIkkuna.run();
        
        
//        GraafinenKayttoliittyma gui = new GraafinenKayttoliittyma(jarjestelma);
//        SwingUtilities.invokeLater(gui);
        
    }
}
