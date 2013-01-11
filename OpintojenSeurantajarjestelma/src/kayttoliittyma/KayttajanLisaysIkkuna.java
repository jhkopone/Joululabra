/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import kayttajat.KayttajienHallinta;
/**
 * KayttajanLisaysIkkuna-luokka käyttää KayttajienHallinta-luokkaa
 * tarjoten käyttöliittymän sen toiminnoille. Varsinainen toiminnallisuus
 * toteutetaan KayttajanLisaysKuuntelija-luokan avulla.
 * @author jhkopone
 */

public class KayttajanLisaysIkkuna implements Runnable {
    private JFrame frame;
    private KayttajienHallinta jarjestelma;
    
    public KayttajanLisaysIkkuna(KayttajienHallinta jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Lisää uusi käyttäjä");
        frame.setPreferredSize(new Dimension(400,300));
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {

        container.setLayout(new BorderLayout());
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        JPanel paneeli = new JPanel(new GridLayout(6, 2));
        
        JLabel etunimiTeksti = new JLabel("etunimi: ");
        JTextField etunimiKentta = new JTextField();
        
        JLabel sukunimiTeksti = new JLabel("sukunimi: ");
        JTextField sukunimiKentta = new JTextField();
        
        JLabel opiskelijanumeroTeksti = new JLabel("opiskelijanumero: ");
        JTextField opiskelijanumeroKentta = new JTextField();
        
        JLabel aloitusPvmTeksti = new JLabel("aloituspäivämäärä (ppkkvv): ");
        JTextField aloitusPvmKentta = new JTextField();
        
        JLabel tunnusTeksti = new JLabel("käyttäjätunnus: ");
        JTextField tunnusKentta = new JTextField();
        
        JLabel salasanaTeksti = new JLabel("salasana: ");
        JTextField salasanaKentta = new JTextField();
        
        paneeli.add(etunimiTeksti);
        paneeli.add(etunimiKentta);
        paneeli.add(sukunimiTeksti);
        paneeli.add(sukunimiKentta);
        paneeli.add(opiskelijanumeroTeksti);
        paneeli.add(opiskelijanumeroKentta);
        paneeli.add(aloitusPvmTeksti);
        paneeli.add(aloitusPvmKentta);
        paneeli.add(tunnusTeksti);
        paneeli.add(tunnusKentta);
        paneeli.add(salasanaTeksti);
        paneeli.add(salasanaKentta);
        
        JPanel napit = new JPanel(new GridLayout(1, 2));
        
        JButton lisaa = new JButton("lisaa");
        JButton peruuta = new JButton("peruuta");
        
        napit.add(lisaa);
        napit.add(peruuta);
        
        KayttajanLisaysKuuntelija kuuntelija = new KayttajanLisaysKuuntelija(this.jarjestelma, etunimiKentta, sukunimiKentta, opiskelijanumeroKentta, aloitusPvmKentta, tunnusKentta, salasanaKentta, this.frame, lisaa, peruuta);
        lisaa.addActionListener(kuuntelija);
        peruuta.addActionListener(kuuntelija);
        
        container.add(viestiKentta, BorderLayout.NORTH);
        container.add(paneeli, BorderLayout.CENTER);
        container.add(napit, BorderLayout.SOUTH);
        
    }
    
}
