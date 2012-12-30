/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.util.*;
import opintojenseurantajarjestelma.*;
/**
 *
 * @author jhkopone
 */
public class Tekstikayttoliittyma {
    private Scanner lukija;
    private OpintojenSeurantajarjestelma jarjestelma;
    
    public Tekstikayttoliittyma(Scanner lukija, OpintojenSeurantajarjestelma jarjestelma) {
        this.lukija = lukija;
        this.jarjestelma = jarjestelma;
    }
    
    public void run() {
        tulostaOtsikko();
        
        while (true) {
            tulostaValikko();
            int komento = Integer.parseInt(lukija.nextLine());
            
            if (komento == 6) {
                break;
            } else if (komento == 1) {
                lisaaOpiskelija();
            } else if (komento == 2) {
                
            } else if (komento == 3) {
                tulostaOpiskelija();
            }        
        }
        
        tulostaLopputeksti();
    }
    
    public void tulostaOtsikko() {
        System.out.println("*********************************");
        System.out.println("* Opintojen seurantajärjestelmä *");
        System.out.println("*********************************");
        System.out.println();
    }
    
    public void tulostaValikko() {
        System.out.println("KOMENNOT:");
        System.out.println();
        System.out.println("1 - lisää opiskelija");
        System.out.println("2 - kirjaudu sisään");
        System.out.println("3 - näytä opiskelijan tiedot");
        System.out.println("4 - lisää kurssi");
        System.out.println("5 - näytä suoritettujen kurssien tiedot");
        System.out.println("6 - lopeta");
        System.out.print("Syötä komento: ");
    }
    
    public void tulostaLopputeksti() {
        System.out.println("Hei, hei!");
    }
    
    public void lisaaOpiskelija() {
        System.out.print("Syötä etunimi: ");
        String etunimi = lukija.nextLine();
        System.out.print("Syötä sukunimi: ");
        String sukunimi = lukija.nextLine();
        System.out.print("Syötä opiskelijanumero: ");
        String opiskelijanumero = lukija.nextLine();
        System.out.print("Syötä opintojen aloituspäivämäärä (muodossa ppkkvv): ");
        String aloitusPvm = lukija.nextLine();
        
        this.jarjestelma.lisaaOpiskelija(etunimi, sukunimi, opiskelijanumero, aloitusPvm);
    }
    
    public void tulostaOpiskelija() {
        System.out.println(this.jarjestelma.tulostaOpiskelija());
    }
    
    public void lisaaKurssi(){
        System.out.println("Syötä kurssin nimi: ");
        String nimi = lukija.nextLine();
        
        System.out.print("Syötä kurssikoodi: ");
        String kurssikoodi = lukija.nextLine();
        
        System.out.print("Syötä opintopistemäärä: ");
        String opintopisteet = lukija.nextLine();
        
        System.out.print("Syötä kurssin taso: ");
        String taso = lukija.nextLine();
        
        System.out.print("Syötä erikoistumislinja: ");
        String erikoistumislinja = lukija.nextLine();
        
        System.out.print("Syötä kurssin kuvaus: ");
        String kuvaus = lukija.nextLine();
        
        System.out.print("Syötä kurssin arvosana: ");
        String arvosana = lukija.nextLine();
        
        System.out.print("Syötä kurssin suorituspäivämäärä (muodossa ppkkvv): ");
        String suoritusPvm = lukija.nextLine();
        
 
    }
}
