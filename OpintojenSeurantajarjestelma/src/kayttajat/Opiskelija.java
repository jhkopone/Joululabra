
package kayttajat;
import java.io.Serializable;
import java.util.*;

/**
 * Kuvataan Opiskelijaa, joka toimii Opintojen seurantajärjestelmän käyttäjänä.
 * Konstruktorin lisäksi luokka sisältää ainoastaan Gettereitä ja Settereitä.
 * @author jhkopone
 */
public class Opiskelija implements Serializable{
 
    private String etunimi;
    private String sukunimi;
    private String opiskelijanumero;
    private String aloituspvm;
    
    private String tunnus;
    private String salasana;

/**
 * Opiskelija-luokan konstruktori.
 * @param etunimi 
 * @param sukunimi
 * @param opiskelijanumero
 * @param aloituspvm
 * @param tunnus
 * @param salasana 
 */  
    public Opiskelija(String etunimi, String sukunimi, String opiskelijanumero, String aloituspvm, String tunnus, String salasana) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opiskelijanumero = opiskelijanumero;
        this.aloituspvm = aloituspvm;
        
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    
    public String getNimi() {
        return this.etunimi + " " + this.sukunimi;
    }

    public String getOpiskelijanumero() {
        return opiskelijanumero;
    }

    public String getAloituspvm() {
        return aloituspvm;
    }

    public String getTunnus() {
        return tunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }
/**
 * Opiskelija-luoka toString()-metodi
 * @return metodi palauttaa opiskelijan nimen kokonaisuudessaan sekä aloituspäivämäärän.
 */
    @Override
    public String toString() {
        return this.getNimi() + " (" + this.opiskelijanumero + ") aloituspäivämäärä: " + this.aloituspvm;
    }
}
