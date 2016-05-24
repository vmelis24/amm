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

public class UtentiClientiFactory {

    // Attributi
    private static UtentiClientiFactory singleton;
    private String connectionString;
    
    public static UtentiClientiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiClientiFactory();
        }
        return singleton;
    }
   
    /* Costruttore */
    private UtentiClientiFactory() {
       
    }    
   
   public UtentiClienti getUtentiClienti(String username_c, String password_c)
    {
        try
        {
            Connection conn = DriverManager
                    .getConnection(connectionString, 
                            "valentinamelis",
                            "valentinamelis");
            // sql command
            String query = "select * from clienti where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password_c);
            stmt.setString(2, username_c);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                UtentiClienti utenticlienti = new UtentiClienti();
                utenticlienti.id=set.getInt(set.getInt("id"));
                utenticlienti.nome=set.getString("nome");
                utenticlienti.cognome=set.getString("cognome");
                utenticlienti.username_c=set.getString("username");
                utenticlienti.password_c=set.getString("password");
               
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
    
    
    
    
    public UtentiClienti getUtentiClienti(int id)
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
                current.setUsername_c(res.getString("username"));
                current.setPassword_c(res.getString("password"));
                
               
               
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
    
    
    
    
     public void setConnectionString(String s){
	this.connectionString = s;
    }
        
    public String getConnectionString(){
        return this.connectionString;
    }
    
    
}