
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
    private JRadioButton perus;
    private JRadioButton aine;
    private JRadioButton syventava;
    private JRadioButton jatko;
    private JRadioButton muut;
    private JRadioButton kieli;
    private JRadioButton tvt;
    private JTextField erikoistumislinjaKentta;
    private JTextField kuvausKentta;
    private JTextField arvosanaKentta;
    private JTextField suoritusPvmKentta;
    private JButton lisaa;
    private JButton peruuta;
    
    private Taso taso;
    
    public KurssinLisaysKuuntelija (
    OpintojenSeurantajarjestelma jarjestelma, 
    JTextField nimiKentta, 
    JTextField kurssikoodiKentta, 
    JTextField opintopisteetKentta,
    JRadioButton perus,
    JRadioButton aine,
    JRadioButton syventava,
    JRadioButton jatko,
    JRadioButton muut,
    JRadioButton kieli,
    JRadioButton tvt,
    JTextField erikoistumislinjaKentta,
    JTextField kuvausKentta,
    JTextField arvosanaKentta,
    JTextField suoritusPvmKentta,
    JButton lisaa,
    JButton peruuta) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.kurssikoodiKentta = kurssikoodiKentta;
        this.opintopisteetKentta = opintopisteetKentta;
        this.perus = perus;
        this.aine = aine;
        this.syventava = syventava;
        this.jatko = jatko;
        this.muut = muut;
        this.kieli = kieli;
        this.tvt = tvt;
        this.erikoistumislinjaKentta = erikoistumislinjaKentta;
        this.kuvausKentta = kuvausKentta;
        this.arvosanaKentta = arvosanaKentta;
        this.suoritusPvmKentta = suoritusPvmKentta;
        this.lisaa = lisaa;
        this.peruuta = peruuta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.lisaa) {
            this.jarjestelma.lisaaKurssi(
                this.nimiKentta.getText(),
                this.kurssikoodiKentta.getText(),
                Integer.parseInt(this.opintopisteetKentta.getText()),
                this.taso,
                this.erikoistumislinjaKentta.getText(),
                this.kuvausKentta.getText(),
                Integer.parseInt(this.arvosanaKentta.getText()), 
                this.suoritusPvmKentta.getText()
             );
        } else if (ae.getSource() == this.peruuta) {
            
        } else if (ae.getSource() == this.perus) {
            this.taso = Taso.PERUSOPINNOT;
        } else if (ae.getSource() == this.aine) {
            this.taso = Taso.AINEOPINNOT;
        } else if (ae.getSource() == this.syventava) {
            this.taso = Taso.SYVENTAVAT_OPINNOT;
        } else if (ae.getSource() == this.jatko) {
            this.taso = Taso.JATKO_OPINNOT;
        } else if (ae.getSource() == this.muut) {
            this.taso = Taso.MUUT_OPINNOT;
        } else if (ae.getSource() == this.kieli) {
            this.taso = Taso.KIELIOPINNOT;
        } else if (ae.getSource() == this.tvt) {
            this.taso = Taso.TVT_OPINNOT;
        }
        
    }
    
    
}
