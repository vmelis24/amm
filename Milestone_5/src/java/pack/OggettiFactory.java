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
import java.util.logging.Level;
import java.util.logging.Logger;
public class OggettiFactory {
    
     // Attributi
    private static OggettiFactory singleton;
    private String connectionString;
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    
    private OggettiFactory() {
              
     }
     
    
    public ArrayList<Oggetti> getOggetti()
    {
        ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            Statement stmt = conn.createStatement();
            String query = "select * from oggetti";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Oggetti current = new Oggetti();
                current.setId(set.getInt("id"));
                current.setNomeProdotto(set.getString("nomeprodotto"));
                current.setUrlProdotto(set.getString("urlfoto"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getInt("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                listaOggetti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggetti;
    }
    
    public Oggetti getOggettiId(int id)
    {
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            String query = "select * from oggetti "
            + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
           
            ResultSet res = stmt.executeQuery();
           
             
            if(res.next()) 
            {
                Oggetti current = new Oggetti();
                current.setId(res.getInt("id"));
                current.setNomeProdotto(res.getString("nomeprodotto"));
                current.setUrlProdotto(res.getString("urlfoto"));
                current.setDescrizione(res.getString("descrizione"));
                current.setPrezzo(res.getInt("prezzo"));
                current.setQuantita(res.getInt("quantita"));
                
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
    
    public Oggetti getNewObject()
    {
        try {
                Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
               
               
                
                String sql = "insert into oggetti (id,nomeprodotto , urlfoto,descrizione,prezzo,quantita) "
                + "values (default,?,?,?,?,?)";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                int rows = stmt.executeUpdate(sql);
                if(rows == 1){
                System.out.println("Insert ok!");
                }
                
                stmt.close();
                conn.close();
                } catch (SQLException ex) {
                
                Logger.getLogger(Oggetti.class.getName()).log(Level.SEVERE, null, ex);
                } 
        
        return null;
    }
    
    
   public ArrayList<Oggetti> getUpdate()
    {
        ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
        try 
        {
         
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
               
                
                String sql = "UPDATE oggetti SET" +
                                "nomeprodotto = ?, urlfoto = ?,quantita=?,prezzo=?" +
                                "WHERE id = ? ";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                int rows = stmt.executeUpdate(sql);
                if(rows == 1){
                System.out.println("Update ok!");
                }
                
                stmt.close();
                conn.close();
                } catch (SQLException ex) {
                
                Logger.getLogger(Oggetti.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
        
        return listaOggetti;
    }
   
   
   public ArrayList<Oggetti> getDelete()
    {
        ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
        try 
        {
         
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
               
                
                String sql = "delete from oggetti" +
                              "WHERE id = ? ";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                int rows = stmt.executeUpdate(sql);
                if(rows == 1){
                System.out.println("Delete ok!");
                }
                
                stmt.close();
                conn.close();
                } catch (SQLException ex) {
                
                Logger.getLogger(Oggetti.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
        
        return listaOggetti;
    }
   
    // Restituisce la lista di tutti gli oggetti il cui nome e cognome contiene la stringa in input
    public ArrayList<Oggetti> getOggetti(String text)
    {
        ArrayList<Oggetti> lista = new ArrayList<Oggetti>();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
            String query = "select oggetti.nomeprodotto, oggetti.descrizione, oggetti.id " +
                           "from oggetti " + 
                           "where oggetti.nomeprodotto LIKE ? OR oggetti.descrizione LIKE ?";         
            PreparedStatement stmt = conn.prepareStatement(query);
            // Assegna dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            stmt.setString(2, text);
            ResultSet res = stmt.executeQuery();
            
            while(res.next())
            {
                Oggetti current = new Oggetti();
                current.setId(res.getInt("id"));
                current.setNomeProdotto(res.getString("nomeprodotto"));
                current.setDescrizione(res.getString("descrizione"));
                lista.add(current);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {}
        
        return lista;
    }
   
   
   public void compravenditaOggetto(int idOggetto,int idVenditore,
            int conto) throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                OggettiFactory.getInstance().getConnectionString(),
                "valentinamelis",
                "valentinamelis");
        
        PreparedStatement updateOggetti = null;
        PreparedStatement updateCreditoCliente = null;
        PreparedStatement updateCreditoVenditore = null;
        
        // Sql 
        String deleteOggetti = "delete from oggetti "
                + "where idvenditore = ? ";
        String updateCredito = "update saldo set "
                + "conto=(saldo.conto-oggetti.prezzo)where saldo.id=clienti.id and "
                + "clienti.id=oggetto.idcliente=?";
        
        String updateCredvenditore = "update saldo set "
                + "conto=(saldo.conto+oggetti.prezzo) where saldo.id=venditori.id and "
                + "venditori.id=oggetto.idvenditore=?";

        try
        {
           conn.setAutoCommit(false);
           updateOggetti = conn.
                   prepareStatement(deleteOggetti);
           updateCreditoCliente = conn.
                   prepareStatement(updateCredito);
            updateCreditoVenditore = conn.
                   prepareStatement(updateCredvenditore);
           
           
           updateOggetti.setInt(1, idVenditore);
           updateOggetti.setInt(2, idOggetto);
           
           updateCreditoCliente.setInt(1, idOggetto);
           updateCreditoCliente.setInt(2, conto);
           
           updateCreditoVenditore.setInt(1, idOggetto);
           updateCreditoVenditore.setInt(2, conto);
           
           int c1 = updateOggetti.executeUpdate();
           int c2 = updateCreditoCliente.executeUpdate();
           int c3 = updateCreditoVenditore.executeUpdate();
           
           if(c1 != 1 || c2 != 1 || c3 != 1)
               conn.rollback();
           
           conn.commit();           
        }catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(updateOggetti != null)
                updateOggetti.close();
            if(updateCreditoCliente != null)
                updateCreditoCliente.close();
            if(updateCreditoVenditore != null)
                updateCreditoVenditore.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
            
   
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
        
    public String getConnectionString(){
        return this.connectionString;
    }
    
    
}
