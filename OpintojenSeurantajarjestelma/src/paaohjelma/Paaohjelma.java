/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paaohjelma;
import opintojenseurantajarjestelma.*;
import kayttoliittyma.*;
import java.util.*;
/**
 *
 * @author Koppa
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);       
        OpintojenSeurantajarjestelma jarjestelma = new OpintojenSeurantajarjestelma();
        
        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma(lukija, jarjestelma);
        tekstikayttoliittyma.run();
    }
}
