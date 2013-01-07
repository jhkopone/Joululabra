/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 * PaaIkkuna-luokka on graafisen käyttöliittymät pääikkunan muodostava luokka.
 * Luokkaan liittyy PaaIkkunaKuuntelija-luokka, joka toteuttaa ikkunan toiminnallisuuden.
 * @author Koppa
 */
public class PaaIkkuna implements Runnable {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;
    
    public PaaIkkuna(OpintojenSeurantajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        avaaPaaikkuna();
    }
    

    
    public void avaaPaaikkuna() {
        frame = new JFrame("Opintojen seurantajärjestelmä");
        frame.setPreferredSize(new Dimension(1000,600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
//      GridLayout layout = new GridLayout(1, 2);
        container.setLayout(layout);
        
        JLabel teksti = new JLabel("Kurssien tiedot tähän.");
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        container.add(viestiKentta, BorderLayout.NORTH);
        container.add(luoValikko(teksti), BorderLayout.WEST);
        container.add(teksti, BorderLayout.CENTER);
        
    }
    
    private JPanel luoValikko(JLabel teksti) {
        JPanel valikko = new JPanel(new GridLayout(6, 1));
        
        JButton tulostaOpiskelijanTiedot = new JButton("näytä opiskelijan tiedot");
        JButton lisaaKurssi = new JButton("lisää kurssi");
        JButton poistaKurssi = new JButton("poista kurssi");
        JButton naytaKurssit = new JButton("näytä kurssit");
        
        PaaIkkunaKuuntelija kuuntelija = new PaaIkkunaKuuntelija(this.jarjestelma, teksti);
        
        tulostaOpiskelijanTiedot.addActionListener(kuuntelija);
        naytaKurssit.addActionListener(kuuntelija);

        valikko.add(tulostaOpiskelijanTiedot);
        valikko.add(lisaaKurssi);
        valikko.add(poistaKurssi);
        valikko.add(naytaKurssit);
        valikko.add(new JButton("Testi5"));
        valikko.add(new JButton("Testi6"));
        
        return valikko;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
