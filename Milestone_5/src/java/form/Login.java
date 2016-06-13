/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.OggettiFactory;
import pack.UtentiClienti;
import pack.UtentiClientiFactory;
import pack.UtentiVenditori;
import pack.UtentiVenditoriFactory;


@WebServlet(name = "Login", urlPatterns = {"/Login"}, loadOnStartup = 0)
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
    
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        OggettiFactory.getInstance().setConnectionString(dbConnection);
    }
    
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session=request.getSession(true);
        if(request.getParameter("submit")!=null)
                {
                 
                String username_c=request.getParameter("Username_c");
                String password_c=request.getParameter("Password_c");
                String username_v=request.getParameter("Username_v");
                String password_v=request.getParameter("Password_v");
                
                
                
                
             UtentiClienti c = UtentiClientiFactory.getInstance().getUtentiClienti(username_c, password_c);
            if(c != null)
            {
                session.setAttribute("loggedIn",true);
                session.setAttribute("id",c.getId());
                    
                    request.setAttribute("cliente_autenticato",c);
                    request.getRequestDispatcher("cliente.jsp").forward(request,response);              
            }
                  
               
             UtentiVenditori v = UtentiVenditoriFactory.getInstance().getUtentiVenditori(username_v, password_v);    
                    
                    if(v!=null){
                        
                            session.setAttribute("loggedIn",true);
                            session.setAttribute("id",v.getId());

                            request.setAttribute("venditore_autenticato",v);
                            request.getRequestDispatcher("venditore.jsp").forward(request,response);  
                
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

    private Object UtentiClientiFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


