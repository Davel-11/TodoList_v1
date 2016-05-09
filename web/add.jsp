<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        
        <meta  charset=UTF-8" />
        <%@include file="headers.jsp" %>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">
        
        
        <%            
         if ( (String)session.getAttribute("UserInfo") == null ) {
             
                    String incpass = "Incorrect Password/Username from add jsp";
                    request.setAttribute("incpass", incpass);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
        } 
        %> 
                
        <title>Adding a New Task</title>
    </head>
    <body>
    <div id="warp"> 
        
        <ol class="breadcrumb">
            <li><a href="<%= request.getContextPath()%>/home">Home</a></li>            
            <li class="active">Adding New user</li>            
        </ol>
            
        <% 
           out.print(" Logged As: "+(String)session.getAttribute("UserInfo"));%>    
        
        <h1>Adding a New Task</h1>                                                                       
                    
    <form name="form3" method="post" action="<%=request.getContextPath()%>/addTask" >

            <div class="form-group">
              <label >Select Priority</label>                        
                            <select name="importance" class="form-control" value="22">
                                <option value="*">*</option>
                                <option value="* *">* *</option>
                                <option value="* * *">* * *</option>
                                <option value="* * * *">* * * *</option>
                                <option value="* * * * *">* * * * *</option>
                            </select>                      
            </div>

            <div class="form-group">
              <label>Select Type</label>
                <%
                                  ArrayList<Object> cont3 = (ArrayList)request.getAttribute("datolist");
                                  Iterator<Object> it3 = cont3.iterator(); 
                                  
                                      out.println("<select name='select1' class='form-control' >");                   
                                      while(it3.hasNext())
                                      {
                                           Object element2 = it3.next();                                                                                
                                           out.print("<option value ='" +element2+ "' >");
                                           out.print(element2);
                                           out.print("</option>");
                                           out.println("<br>");
                                      }                     
                                     out.println("</select>"); 
                  %>
            </div>

            <div class="form-group" >
              <label>What Needs to Be Done</label>
              <input type="text" class="form-control" id="exampleInputEmail1" placeholder="To do" name="todo">
            </div>

            <div class="form-group">
              <label>Details</label>
              <textarea class="form-control" rows="3" name="details"></textarea>
            </div>
        
        <div class="form-group">
              <label>Budget</label>
              <input type="number" step="0.01" class="form-control" placeholder="$0.00" name="budget" value="0.00">
            </div>

            <div class="form-group">
              <label for="exampleInputPassword1">Expected Date</label>
              <input type="text" onfocus="(this.type='date')" class="form-control" required="required" value="2016-01-01" name="edate">
            </div>

            <button type="submit" class="btn btn-default">Submit</button>   
            <a href="<%= request.getContextPath()%>/home" class="btn btn-danger">Cancel</a>
    </form>       
            

    </div>    
    </body>
</html>
