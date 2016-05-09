<%@page import="java.util.LinkedList"%>
<%@page import="models.modelsetget"%>
<%@page import="models.model_table2"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <%      
        
               
        if ( (String)session.getAttribute("UserInfo") == null ) {
            
                    String incpass = "Incorrect Password/Username from indextodo";
                    request.setAttribute("incpass", incpass);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    
        } else {          
                     
           out.print("Logged As: "+session.getAttribute("UserInfo"));
        }
        %> 
        
        
        <meta charset=UTF-8"/>
        <%@include file="headers.jsp" %>     
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>        
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/func.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/jquery.tablesorter.js"></script>
        
        
        
        
        <title>ToDo List</title>
    </head>
    <body>
    <div id="warp">   
        
        <a href="<%= request.getContextPath()%>/sessioncontroller2" class="btn btn-warning">Logout</a>
        <h1>2 Do List</h1>
        <h4>Tasks I need to do, rember or accomplish</h4>
        
        <a href="<%= request.getContextPath()%>/add" class="btn btn-success">Add New Task</a>
        <br />
        <br /> 
        
             <table class="table table-bordered">
                 <tr>             
                        <form name="form1" method="post" action="<%= request.getContextPath()%>/additemlist">
                           
                           <td> <input type="text" name="item" required="required" placeholder="Type a New Task!"/></td>
                           <td><button type="submit" value="Add New Item" title="send" class="btn btn-success"/> New Task Item </button></td>                           
                       </form>                    
                 </tr>
                 
                 <tr>
                 <form name="form2" method="post" action ="<%= request.getContextPath()%>/removeitem">
                      
                     <td>                     
                         
                            <select name="select1">
                            <option >Remove Task From your List</option>
                             <%
                                ArrayList<Object> cont2 = (ArrayList)request.getAttribute("datolist");
                                Iterator<Object> it2 = cont2.iterator(); 
                                
                                ArrayList<Object> idlist = (ArrayList)request.getAttribute("gettingId");
                                Iterator<Object> itr = idlist.iterator();                                         
                                                     
                                    while(it2.hasNext())
                                    {
                                         Object element2 = it2.next();
                                         Object element3 = itr.next();                                         
                                         
                                         out.print("<option value ='" +element3+ "'  >");
                                         out.print(element2);
                                         out.print("</option>");
                                         out.println("<br>");
                                    }                                           
                             %>   
                             </select>
                        
                     </td>
                     <td>
                         <button type="submit" value="Remove List Item" class="btn btn-danger"/>Delete Task Item</button>
                     </td>                      
                 </form>
                </tr>      
                
            </table >                                   
                              
                      
           <br />   
                   
          
           <form  name="formFilter" method="post" action="<%= request.getContextPath() %>/filter">
                    <select name="selectFilter">
                            <option value="empty">No Filter Applied</option>
                            <%
                                //------------- informacion para seleccionar filtro ---------//
                                ArrayList<Object> FilterList = (ArrayList)request.getAttribute("CurrentTaskL");
                                Iterator<Object> it3 = FilterList.iterator();                                                                                                       
                                                     
                                    while(it3.hasNext())
                                    {
                                         Object element4 = it3.next();
                                         
                                         out.print("<option value ='"+element4+"'>");
                                         out.print(element4);
                                         out.print("</option>");
                                         out.println("<br />");
                                    }                                           
                             %>   
                    </select>
                    <br /><br />
                    <button type="submit" class="btn btn-primary">add/remove Filter</button>
           </form>
                    
                    <%
                    Boolean FilterData2 = (Boolean)session.getAttribute("FilterFinder");
                    if (FilterData2==null||FilterData2==false){
                        out.println("<p> </p>");
                     }  else {                       
                       out.println("<p>Filtering by Tasks --> "+(String)session.getAttribute("Ftask"));
                        out.println("</p>");                        
                    }
                    
                    %>
                
                    
                           
           <h2>Current Tasks</h2>       
           
           <table class="table table-striped" id="myTable" class="tablesorter">
                 <thead class="table table-bordered" id="myTable" class="tablesorter">
                    <th>Importance</th>
                    <th>Task</th>
                    <th>To - Do</th>                    
                    <th>Budget $</th>
                    <th>Expected Date</th>
                    <th>Delete</th>
                    <th>Edit</th>
                    <th>Details</th>
                    
                </thead>      
                
                   
                    
                
                <tbody>
                      <%
                          if (FilterData2==null||FilterData2==false){
                                
                                LinkedList<modelsetget> gdatos = (LinkedList)request.getAttribute("alldata");

                                for (int i=0; i <gdatos.size();i++){
                                    out.println("<tr>");                                                    
                                    out.println("<td>"+gdatos.get(i).getImportance()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getTask()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getTodo()+"</td>");
                                    //out.println("<td>"+gdatos.get(i).getDetails()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getBudget()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getEdate()+"</td>");                          
                                    out.println("<td><a href='"+request.getContextPath()+"/deletetask?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a></td>");
                                    out.println("<td><a href='"+request.getContextPath()+"/edit_task?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a></td>");  
                                    out.println("<td><a href='"+request.getContextPath()+"/view_task?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></a></td>");
                                    out.println("</tr>");
                                }
                          } else {
                              
                                                          
                              LinkedList<modelsetget> gdatos = (LinkedList)request.getAttribute("filterdata");
                              
                              for (int i=0; i <gdatos.size();i++){
                                    out.println("<tr>");                                                    
                                    out.println("<td>"+gdatos.get(i).getImportance()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getTask()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getTodo()+"</td>");
                                    //out.println("<td>"+gdatos.get(i).getDetails()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getBudget()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getEdate()+"</td>");                          
                                    out.println("<td><a href='"+request.getContextPath()+"/deletetask?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a></td>");
                                    out.println("<td><a href='"+request.getContextPath()+"/edit_task?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a></td>");  
                                    out.println("<td><a href='"+request.getContextPath()+"/view_task?id="+gdatos.get(i).getId()+"'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></a></td>");
                                    out.println("</tr>");
                                }
                              
                              
                          }

                      
                      %>
                      
                </tbody>
                
            </table>                                   
                      
    </div>                                    
    </body>
    
</html>

