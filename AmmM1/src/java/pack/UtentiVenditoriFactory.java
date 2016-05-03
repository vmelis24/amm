/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;


public class UtentiVenditoriFactory {
  
    
    // Attributi
    private static UtentiVenditoriFactory singleton;
    public static UtentiVenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiVenditoriFactory();
        }
        return singleton;
    }
   
    private ArrayList<UtentiVenditori> listaVenditori = new ArrayList<UtentiVenditori>();
   
    /* Costruttore */
    private UtentiVenditoriFactory() {
           
                // venditori
        UtentiVenditori venditori_1 = new UtentiVenditori();
        venditori_1.setUsername("NeriGiuseppe");
        venditori_1.setPassword("3");
        venditori_1.setNome("Giuseppe");
        venditori_1.setCognome("Neri");
        venditori_1.setId(3);
        listaVenditori.add(venditori_1);
        
        UtentiVenditori venditori_2 = new UtentiVenditori();
        venditori_2.setUsername("MarioVerdi");
        venditori_2.setPassword("4");
        venditori_2.setNome("Mario");
        venditori_2.setCognome("Verdi");
        venditori_2.setId(4);
        listaVenditori.add(venditori_2);
        
        
        //dati relativi all’inserimento di un oggetto
        
        Oggetti oggetti_1=new Oggetti();
        oggetti_1.setNomeProdotto("iphone6");
        oggetti_1.setUrlProdotto("M2/img/iphone6.jpg");
        oggetti_1.setDescrizione("Fotocamera da 8 Megapixel Sistema Operativo iOS8 "
                                + "Display retina da 4,7 - Memoria interna 64 GB");
        oggetti_1.setPrezzo(779);
        oggetti_1.setQuantita(2);
        
        
        Oggetti oggetti_2=new Oggetti();
        oggetti_2.setNomeProdotto("samsungs7");
        oggetti_2.setUrlProdotto("M2/img/samsungs7.jpg");
        oggetti_2.setDescrizione("Fotocamera Dual Pixel da 12 Megapixel "
                                + "Android 6.0 Marshmallow - Memoria 32GB - GPS");
        oggetti_2.setPrezzo(769);
        oggetti_2.setQuantita(4);
    }    
      
     public ArrayList<UtentiVenditori> getUtentiVenditoriList()
    {
        return listaVenditori;
    }
        
    
    public ArrayList<UtentiVenditori> getUserList() 
    {
        ArrayList<UtentiVenditori> listaVenditori = new ArrayList<UtentiVenditori>();
        
        listaVenditori.addAll(listaVenditori);
       
        
        return listaVenditori;
    }
    
    
    public ArrayList<UtentiVenditori> getVenditoriList() 
    {
        ArrayList<UtentiVenditori> listaVenditori = new ArrayList<UtentiVenditori>();
        
        listaVenditori.addAll(listaVenditori);
       
        
        return listaVenditori;
    }
    
    
    
}
