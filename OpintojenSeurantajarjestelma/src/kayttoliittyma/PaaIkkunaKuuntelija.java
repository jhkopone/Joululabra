
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
/**
 * Luokka toteuttaa PaaIkkuna-luokan toiminnallisuuden.
 * @author jhkopone
 */
public class PaaIkkunaKuuntelija implements ActionListener {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JLabel tekstikentta;
    private JButton tulostaOpiskelijanTiedot;
    private JButton naytaKurssit;
    private JButton lisaaKurssi;
    private JButton poistaKurssi;
    private JButton naytaArvosanajakauma;
    private JButton naytaKurssitLukukausittain;      
         
    
    public PaaIkkunaKuuntelija(OpintojenSeurantajarjestelma jarjestelma, JLabel tekstikentta, JButton tulostaOpiskelijanTiedot, JButton naytaKurssit, JButton lisaaKurssi, JButton poistaKurssi, JButton naytaArvosanajakauma, JButton naytaKurssitLukukausittain) {
        this.jarjestelma = jarjestelma;
        this.tekstikentta = tekstikentta;
        this.tulostaOpiskelijanTiedot = tulostaOpiskelijanTiedot;
        this.naytaKurssit = naytaKurssit;
        this.lisaaKurssi = lisaaKurssi;
        this.poistaKurssi = poistaKurssi;
        this.naytaArvosanajakauma = naytaArvosanajakauma;
        this.naytaKurssitLukukausittain = naytaKurssitLukukausittain;
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
        }
        
    }
    
}
