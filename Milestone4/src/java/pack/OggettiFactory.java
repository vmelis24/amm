/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
import java.util.ArrayList;
public class OggettiFactory {
    
     // Attributi
    private static OggettiFactory singleton;
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    // Lista Oggetti
    private ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
    
    
     private OggettiFactory() {
              
    
     // Oggetti         
        Oggetti oggetti_1 = new Oggetti();
        oggetti_1.setNomeProdotto("iphone");
        oggetti_1.setPrezzo(729);
        oggetti_1.setQuantita(2);
        ArrayList<Oggetti> arrayOggettiCliente_1 = new ArrayList<Oggetti>();
        arrayOggettiCliente_1.add(oggetti_1);
        listaOggetti.add(oggetti_1);
        
        Oggetti oggetti_2 = new Oggetti();
        oggetti_2.setNomeProdotto("samsung");
        oggetti_2.setPrezzo(699);
        oggetti_2.setQuantita(1);
        ArrayList<Oggetti> arrayOggettiCliente_2 = new ArrayList<Oggetti>();
        arrayOggettiCliente_2.add(oggetti_2);
        listaOggetti.add(oggetti_2);
        
        Oggetti oggetti_3 = new Oggetti();
        oggetti_3.setNomeProdotto("huawei");
        oggetti_3.setPrezzo(599);
        oggetti_3.setQuantita(3);
        ArrayList<Oggetti> arrayOggettiCliente_3 = new ArrayList<Oggetti>();
        arrayOggettiCliente_3.add(oggetti_3);
        listaOggetti.add(oggetti_3);
        
        Oggetti oggetti_4 = new Oggetti();
        oggetti_4.setNomeProdotto("microsoft");
        oggetti_4.setPrezzo(549);
        oggetti_4.setQuantita(1);
        ArrayList<Oggetti> arrayOggettiCliente_4 = new ArrayList<Oggetti>();
        arrayOggettiCliente_1.add(oggetti_1);
        listaOggetti.add(oggetti_4);
        
        Oggetti oggetti_5 = new Oggetti();
        oggetti_5.setNomeProdotto("sony");
        oggetti_2.setPrezzo(569);
        oggetti_2.setQuantita(2);
        ArrayList<Oggetti> arrayOggettiCliente_5 = new ArrayList<Oggetti>();
        arrayOggettiCliente_1.add(oggetti_1);
        listaOggetti.add(oggetti_5);
     }
    
     
     public Oggetti getObjectId(int id)
    {
        for(Oggetti u : listaOggetti)
        {
            if(u.getId() == id)
                return u;
        }
        
        return null;
    }
     
     
     
     public ArrayList<Oggetti> getObjectList()
    {
        return listaOggetti;
    }
     
    
    
}
