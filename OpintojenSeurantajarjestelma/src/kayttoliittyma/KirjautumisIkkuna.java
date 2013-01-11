package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
/**
 * KirjautumisIkkuna-luokka käyttää KayttajienHallinta-luokkaa
 * kirjautumisen hallintaan. Toiminnallisuus toteutetaan KirjautumisKuuntelija-
 * luokan avulla.
 * @author jhkopone
 */
public class KirjautumisIkkuna implements Runnable{
    private JFrame frame;
    private KayttajienHallinta jarjestelma;
    
    public KirjautumisIkkuna(KayttajienHallinta jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        luoIkkuna();
    }
    
    public void luoIkkuna() {
        frame = new JFrame("Opintojen seurantajärjestelmä: Kirjaudu");
        frame.setPreferredSize(new Dimension(400,200));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        JPanel paneeli = new JPanel(new GridLayout(3, 2));
        
        JLabel tunnusTeksti = new JLabel("käyttäjätunnus:");
        JTextField tunnusKentta = new JTextField();
        JLabel salasanaTeksti = new JLabel("salasana: ");
        JPasswordField salasanaKentta = new JPasswordField();
        
        JButton kirjauduNappi = new JButton("kirjaudu");
        JButton uusiKayttajaNappi = new JButton("uusi käyttäjä");
        
        KirjautumisKuuntelija kuuntelija = new KirjautumisKuuntelija(this.jarjestelma, tunnusKentta, salasanaKentta, kirjauduNappi, uusiKayttajaNappi, viestiKentta, this.frame);
        kirjauduNappi.addActionListener(kuuntelija);
        uusiKayttajaNappi.addActionListener(kuuntelija);

        paneeli.add(tunnusTeksti);
        paneeli.add(tunnusKentta);
        paneeli.add(salasanaTeksti);
        paneeli.add(salasanaKentta);
        paneeli.add(uusiKayttajaNappi);
        paneeli.add(kirjauduNappi);
        
        container.add(viestiKentta);
        container.add(paneeli);
    }
    
    
    
}
