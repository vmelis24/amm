/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;


public class UtentiVenditori extends Utenti {
    
    protected ArrayList<Oggetti> oggettiInseriti = new ArrayList<Oggetti>(); 
    
    /* Costruttore */
    public UtentiVenditori()
    {
        super();
    }
    /* Metodi */

    /** 
     * @return 
     */
    public ArrayList<Oggetti> getOggettiInseriti() {
        return oggettiInseriti;
    }

    /**
     * @param inseriti
     */
    public void setOggettiInseriti(ArrayList<Oggetti> inseriti) {
        this.oggettiInseriti = inseriti;  
    }  
    
}


