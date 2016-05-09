package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.modelusers;


public class sessioncontroller extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
             
                
             if (request.getParameter("pass")==null){
                 
                    response.sendRedirect(request.getContextPath()+"/index.jsp");

                } else {
                    
                    String email = request.getParameter("email");
                    String pass = request.getParameter("pass");
                   
                    modelusers op2 = new modelusers();
                    Boolean show = op2.Loggin(email, pass);
                    Boolean show2 = true;
                                        
                    if (show == show2 ){
                        
                        
                        HttpSession sess = request.getSession();          
                        
                        String UserInfo = request.getParameter("email");
                        sess.setAttribute("UserInfo", UserInfo);
                                                
                        //request.getRequestDispatcher("home").forward(request, response);                        
                        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/home");
                        dispatch.forward(request,response);
                        
                        

 		    } else {
                                                                        
                        String incpass = "Incorrect Password/Username from session cont1";
                        request.setAttribute("incpass", incpass);
                        request.getRequestDispatcher("index.jsp").forward(request, response);                        
                        
                     }         
                }
            
            
            
        } catch (SQLException e) {
            out.close();
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
