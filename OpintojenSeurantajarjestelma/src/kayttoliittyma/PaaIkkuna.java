/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 * PaaIkkuna-luokka on graafisen käyttöliittymät pääikkunan muodostava luokka.
 * Luokkaan liittyy PaaIkkunaKuuntelija-luokka, joka toteuttaa ikkunan toiminnallisuuden.
 * @author Koppa
 */
public class PaaIkkuna implements Runnable {
    private OpintojenSeurantajarjestelma jarjestelma;
    private KayttajienHallinta hallintaJarjestelma;
    private JFrame frame;
    
    public PaaIkkuna(OpintojenSeurantajarjestelma jarjestelma, KayttajienHallinta hallintaJarjestelma) {
        this.jarjestelma = jarjestelma;
        this.hallintaJarjestelma = hallintaJarjestelma;
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
        container.setLayout(layout);
        
        JTextArea teksti = new JTextArea("Kurssien tiedot tähän.");
        JScrollPane rullaus = new JScrollPane();
        rullaus.add(teksti);
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        container.add(viestiKentta, BorderLayout.NORTH);
        container.add(luoValikko(teksti), BorderLayout.WEST);
        container.add(teksti, BorderLayout.CENTER);
    }
    
    private JPanel luoValikko(JTextArea teksti) {
        JPanel valikko = new JPanel(new GridLayout(7, 1));
        
        JButton tulostaOpiskelijanTiedot = new JButton("näytä opiskelijan tiedot");
        JButton naytaKurssit = new JButton("näytä kurssit");
        JButton lisaaKurssi = new JButton("lisää kurssi");
        JButton poistaKurssi = new JButton("poista kurssi");
        JButton naytaArvosanajakauma = new JButton("näytä arvosanajakauma");
        JButton suljeOhjelma = new JButton("sulje ohjelma");
        JButton poistaOmatTiedot = new JButton("poista kaikki kurssit");

        PaaIkkunaKuuntelija kuuntelija = new PaaIkkunaKuuntelija(this.jarjestelma, this.hallintaJarjestelma, this.frame, teksti, tulostaOpiskelijanTiedot, naytaKurssit,lisaaKurssi, poistaKurssi, naytaArvosanajakauma, suljeOhjelma, poistaOmatTiedot);
        
        tulostaOpiskelijanTiedot.addActionListener(kuuntelija);
        naytaKurssit.addActionListener(kuuntelija);
        lisaaKurssi.addActionListener(kuuntelija);
        poistaKurssi.addActionListener(kuuntelija);
        naytaArvosanajakauma.addActionListener(kuuntelija);
        suljeOhjelma.addActionListener(kuuntelija);
        poistaOmatTiedot.addActionListener(kuuntelija);

        valikko.add(tulostaOpiskelijanTiedot);
        valikko.add(naytaKurssit);
        valikko.add(lisaaKurssi);
        valikko.add(poistaKurssi);       
        valikko.add(naytaArvosanajakauma);
        valikko.add(suljeOhjelma);
        valikko.add(poistaOmatTiedot);
        
        return valikko;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
