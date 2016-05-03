/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.UtentiClienti;
import pack.UtentiClientiFactory;
import pack.UtentiVenditori;
import pack.UtentiVenditoriFactory;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
       
        HttpSession session=request.getSession(true);
        if(request.getParameter("submit")!=null)
                {
                 
                String username=request.getParameter("Username");
                String password=request.getParameter("Password");
                
                
                ArrayList<UtentiClienti> listaClienti = UtentiClientiFactory.getInstance().getUserList();
                ArrayList<UtentiVenditori> listaVenditori = UtentiVenditoriFactory.getInstance().getUserList();
              
               
                for(UtentiClienti u : listaClienti)
                
                    if(u.getUsername().equals(username) && 
                       u.getPassword().equals(password)){
                        
               session.setAttribute("loggedIn",true);
               session.setAttribute("id",u.getId());
                    
             
                if(u instanceof UtentiClienti){
                    request.setAttribute("utenticlienti",u);
                    request.setAttribute("listaClienti",UtentiClientiFactory .getInstance().getClientList());
                    request.getRequestDispatcher("cliente.jsp").forward(request,response);
                }
                else{
                    request.setAttribute("utentivenditori",u);
                    request.getRequestDispatcher("venditore.jsp").forward(request,response);}   
                
             
                }
                
                 if(session.getAttribute("isLogged").equals(false)){
                        request.getRequestDispatcher("errore.jsp").forward(request,response);
                    }     
                
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

    private Object UtentiFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

