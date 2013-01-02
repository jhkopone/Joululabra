/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opintojenseurantajarjestelma;

/**
 *
 * @author jhkopone
 */
public enum Taso {
    PERUSOPINNOT (1), 
    AINEOPINNOT (2), 
    SYVENTAVAT_OPINNOT(3), 
    JATKO_OPINNOT(4), 
    MUUT_OPINNOT(5), 
    KIELIOPINNOT(6), 
    TVT_OPINNOT(7);
    
    private Integer taso;
    
    private Taso(Integer taso) {
        this.taso = taso;
    }
    
    public Integer getTaso() {
        return this.taso;
    }
}
