
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
import opintojenseurantajarjestelma.Taso;
/**
 * KurssinLisaysKuuntelija-luokka toteuttaa KurssinLisaysIkkuna-luokan
 * toiminnallisuuden.
 * @author jhkopone
 */
public class KurssinLisaysKuuntelija implements ActionListener {
    private OpintojenSeurantajarjestelma jarjestelma;

    private JTextField nimiKentta;
    private JTextField kurssikoodiKentta;
    private JTextField opintopisteetKentta;
    private JComboBox tasoValitsin;
    private JTextField erikoistumislinjaKentta;
    private JTextField kuvausKentta;
    private JTextField suoritusPvmKentta;
    private JButton lisaa;
    private JButton peruuta;
    private JFrame frame;
    private JComboBox arvosanatValitsin;
    
    private Taso taso;
    
    public KurssinLisaysKuuntelija (
    OpintojenSeurantajarjestelma jarjestelma, 
    JTextField nimiKentta, 
    JTextField kurssikoodiKentta, 
    JTextField opintopisteetKentta,
    JComboBox tasoValitsin,
    JTextField erikoistumislinjaKentta,
    JTextField kuvausKentta,
    JTextField suoritusPvmKentta,
    JButton lisaa,
    JButton peruuta,
    JFrame frame,
    JComboBox arvosanatValitsin) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.kurssikoodiKentta = kurssikoodiKentta;
        this.opintopisteetKentta = opintopisteetKentta;
        this.tasoValitsin = tasoValitsin;
        this.erikoistumislinjaKentta = erikoistumislinjaKentta;
        this.kuvausKentta = kuvausKentta;
        this.suoritusPvmKentta = suoritusPvmKentta;
        this.lisaa = lisaa;
        this.peruuta = peruuta;
        this.frame = frame;
        this.arvosanatValitsin = arvosanatValitsin;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.lisaa) {
            this.taso = (Taso)this.tasoValitsin.getSelectedItem();
            this.jarjestelma.lisaaKurssi(
                this.nimiKentta.getText(),
                this.kurssikoodiKentta.getText(),
                Integer.parseInt(this.opintopisteetKentta.getText()),
                this.taso,
                this.erikoistumislinjaKentta.getText(),
                this.kuvausKentta.getText(),
                Integer.parseInt(this.arvosanatValitsin.getSelectedItem().toString()), 
                this.suoritusPvmKentta.getText()
             );
        } else if (ae.getSource() == this.peruuta) {
            this.frame.dispose();
        }
        
    }
    
    
}
