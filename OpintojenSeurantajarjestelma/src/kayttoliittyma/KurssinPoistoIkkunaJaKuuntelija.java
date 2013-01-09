package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

/**
 * @author jhkopone
 */
public class KurssinPoistoIkkunaJaKuuntelija implements ActionListener, Runnable {
    
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;
    private JTextField koodiKentta;
    private JButton poistaNappi;
    private JButton peruutaNappi;
    
    public KurssinPoistoIkkunaJaKuuntelija(OpintojenSeurantajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Poista kurssi");
        frame.setPreferredSize(new Dimension(300,100));
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(2, 2));
        
        JLabel selite = new JLabel("Syötä kurssikoodi: ");
        koodiKentta = new JTextField();
        
        poistaNappi = new JButton("Poista");
        peruutaNappi = new JButton("Peruuta");
        poistaNappi.addActionListener(this);
        peruutaNappi.addActionListener(this);
        
        container.add(selite);
        container.add(koodiKentta);
        container.add(poistaNappi);
        container.add(peruutaNappi);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.poistaNappi) {
            this.jarjestelma.poistaKurssi(koodiKentta.getText());
        } else if (ae.getSource() == this.peruutaNappi) {
            this.frame.dispose();
        }
        
    }
    
    
}
