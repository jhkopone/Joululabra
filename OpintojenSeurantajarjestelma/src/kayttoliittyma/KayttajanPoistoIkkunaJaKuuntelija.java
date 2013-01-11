
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 * @author jhkopone
 */
public class KayttajanPoistoIkkunaJaKuuntelija implements ActionListener, Runnable {
        
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;
    JButton poistaNappi;
    JButton peruutaNappi;

    
    public KayttajanPoistoIkkunaJaKuuntelija(OpintojenSeurantajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Poista omat tietosi");
        frame.setPreferredSize(new Dimension(300,100));
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(2, 1));
        
        JLabel selite = new JLabel("Haluatko poistaa kaikki tietosi?");

        
        poistaNappi = new JButton("Poista");
        peruutaNappi = new JButton("Peruuta");
        JPanel paneeli = new JPanel();
        paneeli.add(poistaNappi);
        paneeli.add(peruutaNappi);
        
        poistaNappi.addActionListener(this);
        peruutaNappi.addActionListener(this);
        
        container.add(selite);
        container.add(paneeli);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.poistaNappi) {
            this.jarjestelma.poistaKaikkiKurssit();
            this.frame.dispose();
        } else if (ae.getSource() == this.peruutaNappi) {
            this.frame.dispose();
        }
    }
    
    
}
