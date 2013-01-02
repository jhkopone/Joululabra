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
            System.out.println();
            int komento = Integer.parseInt(lukija.nextLine());
            
            if (komento == 7) {
                break;
            } else if (komento == 1) {
                lisaaOpiskelija();
            } else if (komento == 2) {
                
            } else if (komento == 3) {
                tulostaOpiskelija();
            } else if (komento == 4) {
                lisaaKurssi();
            } else if (komento == 5) {
                tulostaKurssit();
            } else if (komento == 6) {
                tulostaYleisarvosanat();
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
        System.out.println("6 - laske opintokokonaisuuksien yleisarvosanat");
        System.out.println("7 - lopeta");
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
        
        System.out.println("Syötä kurssin taso: ");
        Taso taso = this.kyseleKurssinTaso();
        
        System.out.print("Syötä erikoistumislinja: ");
        String erikoistumislinja = lukija.nextLine();
        
        System.out.print("Syötä kurssin kuvaus: ");
        String kuvaus = lukija.nextLine();
        
        System.out.print("Syötä kurssin arvosana: ");
        String arvosana = lukija.nextLine();
        
        System.out.print("Syötä kurssin suorituspäivämäärä (muodossa ppkkvv): ");
        String suoritusPvm = lukija.nextLine();
        
        this.jarjestelma.lisaaKurssi(nimi, kurssikoodi, opintopisteet, taso, erikoistumislinja, kuvaus, arvosana, suoritusPvm);
    }
    
    public Taso kyseleKurssinTaso() {
        Taso taso = null;
        
        System.out.println("PERUSOPINNOT (1)");
        System.out.println("AINEOPINNOT (2)"); 
        System.out.println("SYVENTAVAT_OPINNOT (3)"); 
        System.out.println("JATKO_OPINNOT (4)");
        System.out.println("MUUT_OPINNOT (5)");
        System.out.println("KIELIOPINNOT (6)");
        System.out.println("TVT_OPINNOT (7)");
        
        System.out.println("Valitse kurssin taso: ");
        int valinta = Integer.parseInt(lukija.nextLine());
        
        if (valinta == 1) {
            taso = Taso.PERUSOPINNOT;
        } else if (valinta == 2) {
            taso = Taso.AINEOPINNOT;
        } else if (valinta == 3) {
            taso = Taso.SYVENTAVAT_OPINNOT;
        } else if (valinta == 4) {
            taso = Taso.JATKO_OPINNOT;
        } else if (valinta == 5) {
            taso = Taso.MUUT_OPINNOT;
        } else if (valinta == 6) {
            taso = Taso.KIELIOPINNOT;
        } else if (valinta == 7) {
            taso = Taso.TVT_OPINNOT;
        }
        
        return taso;
    }
    
    public void tulostaKurssit() {
        Map<Taso, Opintokokonaisuus> tulostettavat = this.jarjestelma.getOpintokokonaisuudet();
        
        for (Taso taso : tulostettavat.keySet()) {
            System.out.println(tulostettavat.get(taso).getNimi());
            System.out.println();
            
            for (Kurssi kurssi : tulostettavat.get(taso).getKurssit()) {
                System.out.println(kurssi);
            }
            
            System.out.println();
        }
    }
    
    public void tulostaYleisarvosanat() {
        Map<Taso, Opintokokonaisuus> tulostettavat = this.jarjestelma.getOpintokokonaisuudet();
        
        System.out.println("Yleisarvosanat:");
        
        for (Taso taso : tulostettavat.keySet()) {
            System.out.println(tulostettavat.get(taso).getNimi() + ": " + tulostettavat.get(taso).yleisarvosana());
        }    
        
    }
}
