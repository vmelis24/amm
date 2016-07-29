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



@WebServlet(name = "Cliente", urlPatterns = {"/cliente.hmtl"})
public class Cliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession session=request.getSession();
        
        int id = Integer.parseInt(request.getParameter("OggettoId"));
         request.setAttribute("oggetti", OggettiFactory.getInstance().getOggettiId(id));
        request.setAttribute("cliente", UtentiFactory.getInstance().getUtentiClienti((int)session.getAttribute("id")));
        request.setAttribute("venditore", UtentiFactory.getInstance().getUtentiVenditori((int)session.getAttribute("id")));
        
       
        
        
        // Rimuove l'oggetto solo se l'utente ha premuto il tasto 'submit'
        if(request.getParameter("submit") != null)
        {
           
            
           // int idOggetto = OggettiFactory.getInstance().getUtentiVenditori(request.getParameter("listaOggetti")).getId();
            int idOggetto =Integer.parseInt(request.getParameter("id"));
            //int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idVenditore = Integer.parseInt(request.getParameter("idVenditore"));
            int conto = Integer.parseInt(request.getParameter("conto"));
           
            
            try
            {
                
                OggettiFactory.getInstance().compravenditaOggetto(idOggetto,idVenditore,
                        conto);
            }catch(SQLException e)
            {}
        }              
        
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
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