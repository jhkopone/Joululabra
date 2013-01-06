/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 *
 * @author Koppa
 */
public class OpintojenSeurantajarjestelmaKuuntelija implements ActionListener {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JLabel tekstikentta;
    
    public OpintojenSeurantajarjestelmaKuuntelija(OpintojenSeurantajarjestelma jarjestelma, JLabel tekstikentta) {
        this.jarjestelma = jarjestelma;
        this.tekstikentta = tekstikentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.tekstikentta.setText(this.jarjestelma.tulostaOpiskelija());
    }
    
}
