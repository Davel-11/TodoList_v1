package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ModelTable1;


public class removeitem extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {               
            
		       HttpSession sess = request.getSession(false);
                                              
                       if (sess != null ){   
                           
                            String UserInfo = (String)sess.getAttribute("UserInfo");
                           
                            ModelTable1 op = new ModelTable1();
                            int id =Integer.parseInt(request.getParameter("select1"));

                            op.removeItem(UserInfo, id);                             
                            
                            response.sendRedirect(request.getContextPath()+"/home");

			} else {
                           
                        String incpass = "Incorrect Password/Username from remove item";
                        request.setAttribute("incpass", incpass);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                       
                      
			}
            
                        
        }catch( SQLException e)
        {
            e.printStackTrace();
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
