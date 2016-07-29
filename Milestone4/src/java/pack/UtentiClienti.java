/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;


public class UtentiClienti extends Utenti {
  
         private ArrayList<Oggetti> oggettiAcquistati = new ArrayList<Oggetti>(); 
         
          /* Costruttore */
    public UtentiClienti()
    {
        super();
    }
    /* Metodi */

    /** 
     * @return 
     */
    public ArrayList<Oggetti> getOggettiAcquistati() {
        return oggettiAcquistati;
    }

    /**
     * @param acquistati
     */
    public void setOggettiAcquistati(ArrayList<Oggetti> acquistati) {
        this.oggettiAcquistati = acquistati;  
    }  
     
}

