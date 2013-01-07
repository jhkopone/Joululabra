
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
/**
 * Luokka toteuttaa PaaIkkuna-luokan toiminnallisuuden.
 * @author jhkopone
 */
public class PaaIkkunaKuuntelija implements ActionListener {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JLabel tekstikentta;
//    private JButton
//    private JButton
//    private JButton
//    private JButton
//    private JButton
//    private JButton        
         
    
    public PaaIkkunaKuuntelija(OpintojenSeurantajarjestelma jarjestelma, JLabel tekstikentta) {
        this.jarjestelma = jarjestelma;
        this.tekstikentta = tekstikentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.tekstikentta.setText(this.jarjestelma.tulostaOpiskelija());
    }
    
}
