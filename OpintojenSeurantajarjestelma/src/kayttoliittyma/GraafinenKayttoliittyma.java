/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 *
 * @author Koppa
 */
public class GraafinenKayttoliittyma implements Runnable {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;
    
    public GraafinenKayttoliittyma(OpintojenSeurantajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Opintojen seurantajärjestelmä");
        frame.setPreferredSize(new Dimension(400,600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 2);
        container.setLayout(layout);
        
        JLabel teksti = new JLabel("Kurssien tiedot tähän.");
        
        container.add(luoValikko(teksti));
        container.add(teksti);
        
    }
    
    private JPanel luoValikko(JLabel teksti) {
        JPanel valikko = new JPanel(new GridLayout(6, 1));
        
        JButton tulostaOpiskelijanTiedot = new JButton("Tulosta opiskelijan tiedot");
        OpintojenSeurantajarjestelmaKuuntelija kuuntelija = new OpintojenSeurantajarjestelmaKuuntelija(this.jarjestelma, teksti);
        tulostaOpiskelijanTiedot.addActionListener(kuuntelija);
        
        valikko.add(tulostaOpiskelijanTiedot);
        valikko.add(new JButton("Testi2"));
        valikko.add(new JButton("Testi3"));
        valikko.add(new JButton("Testi4"));
        valikko.add(new JButton("Testi5"));
        valikko.add(new JButton("Testi6"));
        
        return valikko;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
