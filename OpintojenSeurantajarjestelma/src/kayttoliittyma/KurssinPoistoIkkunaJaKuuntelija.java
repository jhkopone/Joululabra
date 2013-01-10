package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JComboBox kurssiNimiValitsin;
    
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
        
        String[] kurssienNimet = this.jarjestelma.kurssienNimet();
        kurssiNimiValitsin =  new JComboBox(kurssienNimet);
        kurssiNimiValitsin.setSelectedIndex(0);
        
        poistaNappi = new JButton("Poista");
        peruutaNappi = new JButton("Peruuta");
        poistaNappi.addActionListener(this);
        peruutaNappi.addActionListener(this);
        
        container.add(selite);
        container.add(kurssiNimiValitsin);
        container.add(poistaNappi);
        container.add(peruutaNappi);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.poistaNappi) {
            String valinta = (String)kurssiNimiValitsin.getSelectedItem();
            this.jarjestelma.poistaKurssi(valinta);
            this.frame.dispose();
        } else if (ae.getSource() == this.peruutaNappi) {
            this.frame.dispose();
        }
        
    }
    
    
}
