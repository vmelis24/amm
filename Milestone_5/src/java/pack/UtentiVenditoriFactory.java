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


public class UtentiVenditoriFactory {
  
    
    // Attributi
    private static UtentiVenditoriFactory singleton;
    private String connectionString;
    
    
    public static UtentiVenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiVenditoriFactory();
        }
        return singleton;
    }
   
    
      /* Costruttore */
    private UtentiVenditoriFactory() {
        
    }
    
    
    public UtentiVenditori getUtentiVenditori(String username_v, String password_v)
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
            stmt.setString(1, password_v);
            stmt.setString(2, username_v);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                
                UtentiVenditori utentivenditori = new UtentiVenditori();
                utentivenditori.id=set.getInt(set.getInt("id"));
                utentivenditori.nome=set.getString("nome");
                utentivenditori.cognome=set.getString("cognome");
                utentivenditori.username_v=set.getString("username");
                utentivenditori.password_v=set.getString("password");
               
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
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            
        }
        return null;
    }
    
    
    
    
   public UtentiVenditori getUtentiVenditori(int id)
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
                current.setUsername_v(res.getString("username"));
                current.setPassword_v(res.getString("password"));
                
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
    
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
        
    public String getConnectionString(){
        return this.connectionString;
    }
   
  
    
    
    
    
    
}
