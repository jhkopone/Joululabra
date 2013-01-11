
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;
import opintojenseurantajarjestelma.Taso;
/**
 * KurssinLisaysIkkuna-luokan ilmentymän avulla lisätään uusi kurssi opiskelijan
 * suoritettujen kurssien joukkoon. Toiminnallisuus toteutetaan KurssinLisaysKuuntelija-
 * luokan avulla.
 * @author jhkopone
 */
public class KurssinLisaysIkkuna implements Runnable {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;
    
    public KurssinLisaysIkkuna(OpintojenSeurantajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Lisää uusi kurssi");
        frame.setPreferredSize(new Dimension(600,400));
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        JPanel paneeli = new JPanel(new GridLayout(8, 2));
          
        JLabel nimiTeksti = new JLabel("kurssin nimi: ");
        JTextField nimiKentta = new JTextField("");
        
        JLabel kurssikoodiTeksti = new JLabel("kurssikoodi: ");
        JTextField kurssikoodiKentta = new JTextField("");
        
        JLabel opintopisteetTeksti = new JLabel("opintopisteet: ");
        JTextField opintopisteetKentta = new JTextField("");
        
        JLabel tasoTeksti = new JLabel("valitse kurssin taso: ");
        Taso[] kurssiTasot = {Taso.PERUSOPINNOT, Taso.AINEOPINNOT, Taso.SYVENTAVAT_OPINNOT, Taso.JATKO_OPINNOT, Taso.MUUT_OPINNOT, Taso.KIELIOPINNOT, Taso.TVT_OPINNOT};
        JComboBox tasoValitsin = new JComboBox(kurssiTasot);
        tasoValitsin.setSelectedIndex(0);
        
        JLabel erikoistumislinjaTeksti = new JLabel("erikoistumislinja: ");
        JTextField erikoistumislinjaKentta = new JTextField("");
        
        JLabel kuvausTeksti = new JLabel("kuvaus: ");
        JTextField kuvausKentta = new JTextField("");
        
        JLabel arvosanaTeksti = new JLabel("arvosana: ");
        Integer[] arvosanat = {1, 2, 3, 4, 5};
        JComboBox arvosanatValitsin = new JComboBox(arvosanat);
        arvosanatValitsin.setSelectedIndex(0);
        
        JLabel suoritusPvmTeksti = new JLabel("suorituspäivämäärä (ppkkvv): ");
        JTextField suoritusPvmKentta = new JTextField("");
        
        paneeli.add(nimiTeksti);
        paneeli.add(nimiKentta);
        paneeli.add(kurssikoodiTeksti);
        paneeli.add(kurssikoodiKentta);
        paneeli.add(opintopisteetTeksti);
        paneeli.add(opintopisteetKentta);
        paneeli.add(tasoTeksti);
        paneeli.add(tasoValitsin);
        paneeli.add(erikoistumislinjaTeksti);
        paneeli.add(erikoistumislinjaKentta);
        paneeli.add(kuvausTeksti);
        paneeli.add(kuvausKentta);
        paneeli.add(arvosanaTeksti);
        paneeli.add(arvosanatValitsin);
        paneeli.add(suoritusPvmTeksti);
        paneeli.add(suoritusPvmKentta);
        
        JPanel napit = new JPanel(new GridLayout(1, 2));
        
        JButton lisaa = new JButton("lisaa");
        JButton peruuta = new JButton("peruuta");
        
        napit.add(lisaa);
        napit.add(peruuta);
        
        KurssinLisaysKuuntelija kuuntelija = new KurssinLisaysKuuntelija(this.jarjestelma, nimiKentta, kurssikoodiKentta, opintopisteetKentta, tasoValitsin, erikoistumislinjaKentta, kuvausKentta, suoritusPvmKentta, lisaa, peruuta, this.frame, arvosanatValitsin);
        lisaa.addActionListener(kuuntelija);
        peruuta.addActionListener(kuuntelija);
        
        container.add(viestiKentta, BorderLayout.NORTH);
        container.add(paneeli, BorderLayout.CENTER);
        container.add(napit, BorderLayout.SOUTH);
    }
    
}
