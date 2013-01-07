
package kayttoliittyma;
import java.awt.*;
import javax.swing.*;
import opintojenseurantajarjestelma.OpintojenSeurantajarjestelma;

public class KurssinLisaysIkkuna implements Runnable {
    private OpintojenSeurantajarjestelma jarjestelma;
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Lisää uusi käyttäjä");
        frame.setPreferredSize(new Dimension(400,300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        
        JTextField viestiKentta = new JTextField();
        viestiKentta.setEnabled(false);
        
        JPanel paneeli = new JPanel(new GridLayout(6, 2));
        
      //  String nimi, String kurssikoodi, Integer opintopisteet, Taso taso, String erikoistumislinja, String kuvaus, Integer arvosana, String suoritusPvm
        
        JLabel nimiTeksti = new JLabel("kurssin nimi: ");
        JTextField nimiKentta = new JTextField();
        
        JLabel kurssikoodiTeksti = new JLabel("kurssikoodi: ");
        JTextField kurssikoodiKentta = new JTextField();
        
        JLabel opintopisteetTeksti = new JLabel("opintopisteet: ");
        JTextField opintopisteetKentta = new JTextField();
        
        JLabel tasoTeksti = new JLabel("valitse kurssin taso: ");
        JRadioButton perus = new JRadioButton("perusopinnot");
        JRadioButton aine = new JRadioButton("aineopinnot");
        JRadioButton syventava = new JRadioButton("syventävät opinnot");
        JRadioButton jatko = new JRadioButton("jatko-opinnot");
        JRadioButton muut = new JRadioButton("muut opinnot");
        JRadioButton kieli = new JRadioButton("kieliopinnot");
        JRadioButton tvt = new JRadioButton("tvt-opinnot");
        
        ButtonGroup valintanapit = new ButtonGroup();
        valintanapit.add(perus);
        valintanapit.add(aine);
        valintanapit.add(syventava);
        valintanapit.add(jatko);
        valintanapit.add(muut);
        valintanapit.add(kieli);
        valintanapit.add(tvt);
        
        JLabel erikoistumislinjaTeksti = new JLabel("erikoistumislinja: ");
        JTextField erikoistumislinjaKentta = new JTextField();
        
        JLabel kuvausTeksti = new JLabel("kuvaus: ");
        JTextField kuvausKentta = new JTextField();
        
        JLabel arvosanaTeksti = new JLabel("arvosana: ");
        JTextField arvosanaKentta = new JTextField();
        
        JLabel suoritusPvmTeksti = new JLabel("suorituspäivämäärä: ");
        JTextField suoritusPvmKentta = new JTextField();
        
        paneeli.add(nimiTeksti);
        paneeli.add(nimiKentta);
        paneeli.add(kurssikoodiTeksti);
        paneeli.add(kurssikoodiKentta);
        paneeli.add(opintopisteetTeksti);
        paneeli.add(opintopisteetKentta);
        paneeli.add(tasoTeksti);
//        paneeli.add(valintanapit);
        paneeli.add(erikoistumislinjaTeksti);
        paneeli.add(erikoistumislinjaKentta);
        paneeli.add(kuvausTeksti);
        paneeli.add(kuvausKentta);
        paneeli.add(arvosanaTeksti);
        paneeli.add(arvosanaKentta);
        paneeli.add(suoritusPvmTeksti);
        paneeli.add(suoritusPvmKentta);
        
        JPanel napit = new JPanel(new GridLayout(1, 2));
        
        JButton lisaa = new JButton("lisaa");
        JButton peruuta = new JButton("peruuta");
        
        napit.add(lisaa);
        napit.add(peruuta);
        
//        KurssinLisaysKuuntelija kuuntelija = new KurssinLisaysKuuntelija(this.jarjestelma, etunimiKentta, sukunimiKentta, opiskelijanumeroKentta, aloitusPvmKentta, tunnusKentta, salasanaKentta, lisaa, peruuta);
//        lisaa.addActionListener(kuuntelija);
//        peruuta.addActionListener(kuuntelija);
        
        container.add(viestiKentta, BorderLayout.NORTH);
        container.add(paneeli, BorderLayout.CENTER);
        container.add(napit, BorderLayout.SOUTH);
    }
    
}
