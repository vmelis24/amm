/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

public class UtentiClientiFactory {

    // Attributi
    private static UtentiClientiFactory singleton;
    public static UtentiClientiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiClientiFactory();
        }
        return singleton;
    }
   
    private ArrayList<UtentiClienti> listaClienti = new ArrayList<UtentiClienti>();
   
    /* Costruttore */
    private UtentiClientiFactory() {
           
                // Clienti
        UtentiClienti clienti_1 = new UtentiClienti();
        clienti_1.setUsername("MelisValentina");
        clienti_1.setPassword("0");
        clienti_1.setNome("Valentina");
        clienti_1.setCognome("Melis");
        clienti_1.setId(0);
        listaClienti.add(clienti_1);
        
        UtentiClienti clienti_2 = new UtentiClienti();
        clienti_2.setUsername("MarioBianchi");
        clienti_2.setPassword("1");
        clienti_2.setNome("Mario");
        clienti_2.setCognome("Bianchi");
        clienti_2.setId(1);
        listaClienti.add(clienti_2);
    }    
      
     public ArrayList<UtentiClienti> getUtentiClientiList()
    {
        return listaClienti;
    }
        
    
    public ArrayList<UtentiClienti> getUserList() 
    {
        ArrayList<UtentiClienti> listaClienti = new ArrayList<UtentiClienti>();
        
        listaClienti.addAll(listaClienti);
       
        
        return listaClienti;
    }
    
    
    public ArrayList<UtentiClienti> getClientList() 
    {
        ArrayList<UtentiClienti> listaClienti = new ArrayList<UtentiClienti>();
        
        listaClienti.addAll(listaClienti);
       
        
        return listaClienti;
    }
    
    
    
    
    
}