package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.model_table2;
import models.modelsetget;

public class edit_task extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();              
        
        try {        
        
                        HttpSession sess = request.getSession(false);
                       
                       if (sess != null ){   
                            String UserInfo = (String)sess.getAttribute("UserInfo");
                            
                            model_table2 op = new model_table2();
                            int id = Integer.parseInt(request.getParameter("id"));

                            LinkedList<modelsetget> pre_list2 = op.Edit(UserInfo, id);

                            request.setAttribute("pre_list2", pre_list2);
                            request.setAttribute("id", id);

                            request.getRequestDispatcher("editing.jsp").forward(request, response);

			} else {                           
                        String incpass = "Incorrect Password/Username";
                        request.setAttribute("incpass", incpass);
                        request.getRequestDispatcher("index.jsp").forward(request, response);                      
                      }            
               
        } catch (SQLException e) {
            e.getStackTrace();
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
