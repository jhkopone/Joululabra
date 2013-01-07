
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
/**
 * KirjautumisKuuntelija-luokka toteuttaa KirjautumisIkkuna-luokan toiminnalisuuden.
 * @author jhkopone
 */

public class KirjautumisKuuntelija implements ActionListener{
    private KayttajienHallinta jarjestelma;
    private JTextField tunnus;
    private JTextField salasana;
    private JButton kirjauduNappi;
    private JButton uusiKayttajaNappi;
    
    public KirjautumisKuuntelija(KayttajienHallinta jarjestelma, JTextField tunnus, JTextField salasana, JButton kirjauduNappi, JButton uusiKayttajaNappi) {
        this.jarjestelma = jarjestelma;
        this.tunnus = tunnus;
        this.salasana = salasana;
        this.kirjauduNappi = kirjauduNappi;
        this.uusiKayttajaNappi = uusiKayttajaNappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.kirjauduNappi) {
            this.jarjestelma.kirjauduSisaan(this.tunnus.getText(), this.salasana.getText());
            this.tunnus.setText("");
            this.salasana.setText("");
        } else if (ae.getSource() == this.uusiKayttajaNappi) {
            KayttajanLisaysIkkuna kayttajanLisaaminen = new KayttajanLisaysIkkuna(this.jarjestelma);
            kayttajanLisaaminen.run();
        }

    }
    
}
