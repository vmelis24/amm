/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UtentiFactory {
    // Attributi
    // Singleton
    private static UtentiFactory singleton;
    String connectionString; 
   
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    /* Costruttore */
    private UtentiFactory() {

    }
    
    /* Metodi */  
        public Utenti getUtente(String username, String password)
    {
        try
        {
             Connection conn = DriverManager
                    .getConnection(connectionString, 
                            "valentinamelis",
                            "valentinamelis");
            // sql command
            String query = "select * from venditori where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                
                UtentiVenditori utentivenditori = new UtentiVenditori();
                utentivenditori.id=set.getInt(set.getInt("id"));
                utentivenditori.nome=set.getString("nome");
                utentivenditori.cognome=set.getString("cognome");
                utentivenditori.username=set.getString("username");
                utentivenditori.password=set.getString("password");
               
                query = "select oggetti.id, oggetti.nomeprodotto from oggetti "
                        + "join venditori "
                        + "on venditori.id = oggetti.idvenditore "
                        + "where oggetti.idvenditore="+utentivenditori.id;
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Oggetti o = new Oggetti();
                    o.setId(res2.getInt("id"));
                    o.setNomeProdotto(res2.getString("nomeprodotto"));
                    utentivenditori.oggettiInseriti.add(o);
                }
                st.close();
                stmt.close();
                conn.close();
                
                return utentivenditori;
            }
            
        
    
        
            // sql command
            query = "select * from clienti where "
                    + "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            if(set.next())
            {
                UtentiClienti utenticlienti = new UtentiClienti();
                utenticlienti.id=set.getInt(set.getInt("id"));
                utenticlienti.nome=set.getString("nome");
                utenticlienti.cognome=set.getString("cognome");
                utenticlienti.username=set.getString("username");
                utenticlienti.password=set.getString("password");
               
                query = "select oggetti.id, oggetti.nomeprodotto from oggetti "
                        + "join clienti "
                        + "on clienti.id = oggetti.idcliente "
                        + "where oggetti.idcliente="+utenticlienti.id;
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Oggetti o = new Oggetti();
                    o.setId(res2.getInt("id"));
                    o.setNomeProdotto(res2.getString("nomeprodotto"));
                    utenticlienti.oggettiAcquistati.add(o);
                }
                st.close();
                stmt.close();
                conn.close();
                
                return utenticlienti;
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            
        }
        return null;
    }
        
     public Utenti getUtentiVenditori(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            // Query
            String query = "select * from venditori where "
                    + " id=?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                UtentiVenditori current = new UtentiVenditori();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                
                // Corsi assegnati 
               
                query =  "select oggetti.id, oggetti.nomeprodotto from oggetti "
                        + "join venditori "
                        + "on venditori.id = oggetti.idvenditore "
                        + "where oggetti.idvenditore="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Oggetti o = new Oggetti();
                    o.setId(res2.getInt("id"));
                    o.setNomeProdotto(res2.getString("nomeprodotto"));
                    current.oggettiInseriti.add(o);
                }           
                
                st.close();
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
     
     public Utenti getUtentiClienti(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            // Query
            String query = "select * from clienti where "
                    + " id=?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                UtentiClienti current = new UtentiClienti();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                
               
               
                query =  "select oggetti.id, oggetti.nomeprodotto from oggetti "
                        + "join clienti "
                        + "on clienti.id = oggetti.idcliente "
                        + "where oggetti.idcliente="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Oggetti o = new Oggetti();
                    o.setId(res2.getInt("id"));
                    o.setNomeProdotto(res2.getString("nomeprodotto"));
                    current.oggettiAcquistati.add(o);
                }           
                
                st.close();
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
     
     //lista clienti
      public ArrayList<UtentiClienti> getClientiList()
    {
        ArrayList<UtentiClienti> listaClienti = new ArrayList<UtentiClienti>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            Statement stmt = conn.createStatement();
            String query = "select * from clienti";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                UtentiClienti current = new UtentiClienti();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                listaClienti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
     //lista venditori
      public ArrayList<UtentiVenditori> getVenditoriList()
    {
        ArrayList<UtentiVenditori> listaVenditori = new ArrayList<UtentiVenditori>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            Statement stmt = conn.createStatement();
            String query = "select * from venditori";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                UtentiVenditori current = new UtentiVenditori();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                listaVenditori.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}