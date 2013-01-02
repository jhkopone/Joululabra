/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttajat;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author jhkopone
 */
public class Opiskelija implements Serializable{
    private String etunimi;
    private String sukunimi;
    private String opiskelijanumero;
    private String aloituspvm;
    
    public Opiskelija(String etunimi, String sukunimi, String opiskelijanumero, String aloituspvm) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opiskelijanumero = opiskelijanumero;
        this.aloituspvm = aloituspvm;
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
    
    @Override
    public String toString() {
        return this.getNimi() + " " + this.opiskelijanumero;
    }
}
