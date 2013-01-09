
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
/**
 * Luokka toteuttaa PaaIkkuna-luokan toiminnallisuuden.
 * @author jhkopone
 */
public class PaaIkkunaKuuntelija implements ActionListener {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JTextArea tekstikentta;
    private JButton tulostaOpiskelijanTiedot;
    private JButton naytaKurssit;
    private JButton lisaaKurssi;
    private JButton poistaKurssi;
    private JButton naytaArvosanajakauma;
    private JButton naytaKurssitLukukausittain;
    private JButton poistaOmatTiedot;
         
    
    public PaaIkkunaKuuntelija(OpintojenSeurantajarjestelma jarjestelma, JTextArea tekstikentta, JButton tulostaOpiskelijanTiedot, JButton naytaKurssit, JButton lisaaKurssi, JButton poistaKurssi, JButton naytaArvosanajakauma, JButton naytaKurssitLukukausittain, JButton poistaOmatTiedot) {
        this.jarjestelma = jarjestelma;
        this.tekstikentta = tekstikentta;
        this.tulostaOpiskelijanTiedot = tulostaOpiskelijanTiedot;
        this.naytaKurssit = naytaKurssit;
        this.lisaaKurssi = lisaaKurssi;
        this.poistaKurssi = poistaKurssi;
        this.naytaArvosanajakauma = naytaArvosanajakauma;
        this.naytaKurssitLukukausittain = naytaKurssitLukukausittain;
        this.poistaOmatTiedot = poistaOmatTiedot;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.tulostaOpiskelijanTiedot) {
            this.tekstikentta.setText(this.jarjestelma.tulostaOpiskelija());
        } else if (ae.getSource() == this.naytaKurssit) {
            this.tekstikentta.setText(this.jarjestelma.tulostaKurssit());
        } else if (ae.getSource() == this.lisaaKurssi) {
            KurssinLisaysIkkuna kurssinLisaysIkkuna = new KurssinLisaysIkkuna(this.jarjestelma);
            kurssinLisaysIkkuna.run();
        } else if (ae.getSource() == this.poistaKurssi) {
            KurssinPoistoIkkunaJaKuuntelija kurssinPoistoIkkuna = new KurssinPoistoIkkunaJaKuuntelija(this.jarjestelma);
            kurssinPoistoIkkuna.run();
        } else if (ae.getSource() == this.poistaOmatTiedot) {
            KayttajanPoistoIkkunaJaKuuntelija kayttajanPoisto = new KayttajanPoistoIkkunaJaKuuntelija(this.jarjestelma);
            kayttajanPoisto.run();
        } else if (ae.getSource() == this.naytaArvosanajakauma) {
            this.tekstikentta.setText(this.jarjestelma.tulostaArvosanajakaumaTahtina());
        }
        
    }
    
}
