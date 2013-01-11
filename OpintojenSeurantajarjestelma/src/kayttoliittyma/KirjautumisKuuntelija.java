
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
    private JTextField viestiKentta;
    private JFrame frame;
    
    public KirjautumisKuuntelija(KayttajienHallinta jarjestelma, JTextField tunnus, JTextField salasana, JButton kirjauduNappi, JButton uusiKayttajaNappi, JTextField viestiKentta, JFrame frame) {
        this.jarjestelma = jarjestelma;
        this.tunnus = tunnus;
        this.salasana = salasana;
        this.kirjauduNappi = kirjauduNappi;
        this.uusiKayttajaNappi = uusiKayttajaNappi;
        this.viestiKentta = viestiKentta;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.kirjauduNappi) {
            this.viestiKentta.setText("");
            boolean kirjautuminen = this.jarjestelma.kirjauduSisaan(this.tunnus.getText(), this.salasana.getText());
            if (kirjautuminen) {
                PaaIkkuna paaIkkuna = new PaaIkkuna(this.jarjestelma.getJarjestelma(), this.jarjestelma);
                paaIkkuna.run();
                this.frame.dispose();
            }
            this.tunnus.setText("");
            this.salasana.setText("");
            this.viestiKentta.setText("virheellinen tunnus tai salasana!");
        } else if (ae.getSource() == this.uusiKayttajaNappi) {
            KayttajanLisaysIkkuna kayttajanLisaaminen = new KayttajanLisaysIkkuna(this.jarjestelma);
            kayttajanLisaaminen.run();
        }

    }
    
}
