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
     
    public Oggetti getNewObject()
    {
        try {
                Connection conn = DriverManager.getConnection(connectionString, "valentinamelis", "valentinamelis");
               
               
                
                String sql = "insert into oggetti (id,nomeprodotto , urlfoto,quantita,prezzo) "
                + "values (default,?,?,?,?)";
                
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
