
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
import kayttajat.Opiskelija;
/**
 * KayttajanLisaysKuuntelija-luokka toteuttaa luokan KayttajanLisaysIkkuna
 * toiminnallisuuden.
 * @author jhkopone
 */
public class KayttajanLisaysKuuntelija implements ActionListener {
    private KayttajienHallinta jarjestelma;
    
    private JTextField etunimiKentta; 
    private JTextField sukunimiKentta;
    private JTextField opiskelijanumeroKentta;
    private JTextField aloitusPvmKentta;
    private JTextField tunnusKentta;
    private JTextField salasanaKentta;
    private JFrame frame;
    
    private JButton lisaa;
    private JButton peruuta;
    
    public KayttajanLisaysKuuntelija
       (KayttajienHallinta jarjestelma,
        JTextField etunimiKentta, 
        JTextField sukunimiKentta,
        JTextField opiskelijanumeroKentta,
        JTextField aloitusPvmKentta,
        JTextField tunnusKentta,
        JTextField salasanaKentta,
        JFrame frame,
        JButton lisaa,
        JButton peruuta) {
        
        this.jarjestelma = jarjestelma;
        this.etunimiKentta = etunimiKentta;
        this.sukunimiKentta = sukunimiKentta;
        this.opiskelijanumeroKentta = opiskelijanumeroKentta;
        this.aloitusPvmKentta = aloitusPvmKentta;
        this.tunnusKentta = tunnusKentta;
        this.salasanaKentta = salasanaKentta;
        this.frame = frame;
        this.lisaa = lisaa;
        this.peruuta = peruuta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lisaa) {
            this.jarjestelma.lisaaKayttaja(new Opiskelija(this.etunimiKentta.getText(), this.sukunimiKentta.getText(), this.opiskelijanumeroKentta.getText(), this.aloitusPvmKentta.getText(), this.tunnusKentta.getText(), this.salasanaKentta.getText()));
            this.jarjestelma.kirjauduSisaan(this.tunnusKentta.getText(), this.salasanaKentta.getText());
            this.frame.dispose();
        } else if (ae.getSource() == peruuta) {
            
        }
    }
    
}
