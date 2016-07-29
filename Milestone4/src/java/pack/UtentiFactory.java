/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

public class UtentiFactory {
    
    private static UtentiFactory singleton;
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    private ArrayList<UtentiClienti> listaClienti = new ArrayList<UtentiClienti>();
    
    private ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
    
    private ArrayList<UtentiVenditori> listaVenditori = new ArrayList<UtentiVenditori>();
    
    
    private UtentiFactory() {
    
        Oggetti oggetti_1=new Oggetti();
        oggetti_1.setNomeProdotto("lumia");
        oggetti_1.setUrlProdotto("img/microsoft.jpg");
        oggetti_1.setDescrizione("549");
        oggetti_1.setPrezzo(549);
        oggetti_1.setQuantita(2);
        listaOggetti.add(oggetti_1);
        
        
        Oggetti oggetti_2=new Oggetti();
        oggetti_2.setNomeProdotto("samsungs7");
        oggetti_2.setUrlProdotto("img/samsungs7.jpg");
        oggetti_2.setDescrizione("Fotocamera Dual Pixel da 12 Megapixel "
                                + "Android 6.0 Marshmallow - Memoria 32GB - GPS");
        oggetti_2.setPrezzo(769);
        oggetti_2.setQuantita(4);
        listaOggetti.add(oggetti_2);
        
        Oggetti oggetti_3=new Oggetti();
        oggetti_3.setNomeProdotto("iphone6");
        oggetti_3.setUrlProdotto("img/iphone6.jpg");
        oggetti_3.setDescrizione("Fotocamera da 8 Megapixel Sistema Operativo iOS8 "
                                + "Display retina da 4,7 - Memoria interna 64 GB");
        oggetti_3.setPrezzo(779);
        oggetti_3.setQuantita(2);
        listaOggetti.add(oggetti_3);
        
        
         // Clienti
        UtentiClienti clienti_1 = new UtentiClienti();
        clienti_1.setUsername("MarioVerdi");
        clienti_1.setPassword("0");
        clienti_1.setNome("Mario");
        clienti_1.setCognome("Verdi");
        clienti_1.setId(0);
        ArrayList<Oggetti> arrayOggettiCliente_1 = new ArrayList<Oggetti>();
        arrayOggettiCliente_1.add(oggetti_1);
        arrayOggettiCliente_1.add(oggetti_3);
        clienti_1.setOggettiAcquistati(arrayOggettiCliente_1);
        listaClienti.add(clienti_1);
        
        UtentiClienti clienti_2 = new UtentiClienti();
        clienti_2.setUsername("MarioBianchi");
        clienti_2.setPassword("1");
        clienti_2.setNome("Mario");
        clienti_2.setCognome("Bianchi");
        clienti_2.setId(1);
        ArrayList<Oggetti> arrayOggettiCliente_2 = new ArrayList<Oggetti>();
        arrayOggettiCliente_2.add(oggetti_2);
        clienti_1.setOggettiAcquistati(arrayOggettiCliente_1);
        listaClienti.add(clienti_2);
        
        // venditori
        UtentiVenditori venditori_1 = new UtentiVenditori();
        venditori_1.setUsername("NeriGiuseppe");
        venditori_1.setPassword("3");
        venditori_1.setNome("Giuseppe");
        venditori_1.setCognome("Neri");
        venditori_1.setId(3);
        ArrayList<Oggetti> arrayOggettiVenditore_1 = new ArrayList<Oggetti>();
        arrayOggettiVenditore_1.add(oggetti_1);
        arrayOggettiVenditore_1.add(oggetti_2);
        venditori_1.setOggettiInseriti(arrayOggettiVenditore_1);
        listaVenditori.add(venditori_1);
        
        UtentiVenditori venditori_2 = new UtentiVenditori();
        venditori_2.setUsername("MarioVerdi");
        venditori_2.setPassword("4");
        venditori_2.setNome("Mario");
        venditori_2.setCognome("Verdi");
        venditori_2.setId(4);
        ArrayList<Oggetti> arrayOggettiVenditore_2 = new ArrayList<Oggetti>();
        arrayOggettiVenditore_2.add(oggetti_3);
        venditori_2.setOggettiInseriti(arrayOggettiVenditore_2);
        listaVenditori.add(venditori_2);
        
        
       
    }
    
     public ArrayList<UtentiClienti> getUtentiClientiList()
    {
        return listaClienti;
    }
     
      public ArrayList<UtentiVenditori> getUtentiVenditoriList()
    {
        return listaVenditori;
    }
      
       public Utenti getCliente(int id)
    {
        for(Utenti u : listaClienti)
        {
            if(u.id == id)
                return u;
        }
        
        return null;
    }  
       
       
       public Utenti getVenditori(int id)
    {
        for(Utenti u : listaVenditori)
        {
            if(u.id == id)
                return u;
        }
        
        return null;
    }   
      
      
      
    public ArrayList<Utenti> getUserList() 
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        listaUtenti.addAll(listaClienti);
        listaUtenti.addAll(listaVenditori);
        
        return listaUtenti;
    }
    
    
}
