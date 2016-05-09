package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Model_List;
import models.TaskModel;
import models.model_table2;
import models.modelsetget;

public class home extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                              
        try {                    
                       HttpSession sess = request.getSession(false);                                                                    
                            
                            Model_List op = new Model_List();
                                                       
                            String UserInfo = (String)sess.getAttribute("UserInfo");
                            
                            Boolean sessVal = true;
                            sess.setAttribute("sessVal", sessVal);
                                                                           
                            ArrayList<Object> datolist = op.getList(UserInfo);
                            request.setAttribute("datolist", datolist);
                            
                            ArrayList<Object> gettingId = op.getIDs(UserInfo);                            
                            request.setAttribute("gettingId", gettingId);                                 
                            
                            //------------- informacion para seleccionar filtro ---------//
                            TaskModel op2 = new TaskModel();
                            ArrayList<Object> CurrentTaskL = op2.CurrentTask(UserInfo);
                            request.setAttribute("CurrentTaskL", CurrentTaskL);
                                                                   
                            //------- confirmar si hay filtro o no desde (Filter.java) ------------ /
                                Boolean FilterFinder = (Boolean)request.getAttribute("FilterFinder");                         
                               
                                model_table2 op3 = new model_table2();

                                LinkedList<modelsetget> alldata = op3.getTasks(UserInfo);
                                request.setAttribute("alldata", alldata);               
                            
                                String task = (String)sess.getAttribute("Ftask");                    
                                LinkedList<modelsetget> filterdata = op3.getTasksF(UserInfo, task);
                                
                                request.setAttribute("FilterFinder", FilterFinder); 
                                request.setAttribute("filterdata", filterdata);
                           
                            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/indextodo.jsp");
                            dispatch.forward(request,response);           
                                       
                        
        } catch(SQLException e){
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

