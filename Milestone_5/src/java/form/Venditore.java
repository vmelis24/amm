/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import static javafx.beans.binding.Bindings.and;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.Oggetti;
import pack.OggettiFactory;
import pack.UtentiClienti;
import pack.UtentiFactory;
import pack.UtentiVenditori;


@WebServlet(name = "venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
            int id = Integer.parseInt(request.getParameter("OggettoId"));
         request.setAttribute("oggetti", OggettiFactory.getInstance().getOggettiId(id));
        request.setAttribute("venditore", UtentiFactory.getInstance().getUtentiVenditori((int)session.getAttribute("id")));
        
         if(request.getParameter("Submit") != null)
        {
            // Preleva i dati inviati
           
            String nomeprodotto = request.getParameter("nomeprodotto");
            String urlprodotto = request.getParameter("urlprodotto");
            String descrizione = request.getParameter("descrizione");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));
            
 
            
         
         request.setAttribute("listaOggetti", OggettiFactory.getInstance().getNewObject());
         
           }
         
          if(request.getParameter("Modifica") != null)
        {
        
            String nomeprodotto = request.getParameter("nomeprodotto");
            String urlprodotto = request.getParameter("urlprodotto");
            String descrizione = request.getParameter("descrizione");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));
            
             request.setAttribute("listaOggetti", OggettiFactory.getInstance().getUpdate());
        }
          
          else{
             request.setAttribute("listOggetti", OggettiFactory.getInstance().getDelete());
                    
          }
        }
     
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
