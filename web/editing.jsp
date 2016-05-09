<%@page import="java.util.LinkedList"%>
<%@page import="models.modelsetget"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        
        <meta charset=UTF-8"/>
        <%@include file="headers.jsp" %>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">
        
        <title>Editing Item</title>
        
        <%            
        if ( (String)session.getAttribute("UserInfo") == null ) {
                    String incpass = "Incorrect Password/Username from editing jsp";
                    request.setAttribute("incpass", incpass);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {          
           out.print("Logged as: "+(String)session.getAttribute("UserInfo"));
        }
        %> 
        
    </head>
    <body>
    <div id="warp"> 
        
        <ol class="breadcrumb">
            <li><a href="<%= request.getContextPath()%>/home">Home</a></li>            
            <li class="active">Edit Task</li>
        </ol>
            
        <h1>Editing Item</h1>
        
        <%
            LinkedList<modelsetget> pre_list3 = (LinkedList)request.getAttribute("pre_list2");
            
            
            
        %>
        
       
        
        <form name="form3" method="post" action="<%=request.getContextPath()%>/edit_task2?id=<%out.print(request.getAttribute("id"));%>&task=<% out.print(pre_list3.get(0).getTask()); %>" >

                            
             <div class="form-group">                 
              <label >Select Priority</label>  
                            <p>previously Selected Priority was: <% out.print(pre_list3.get(0).getImportance()); %></p>
                            <select name="importance" class="form-control" required="required">
                                <option value="<% out.print(pre_list3.get(0).getImportance()); %>"><% out.print(pre_list3.get(0).getImportance()); %></option>
                                <option value="*">*</option>
                                <option value="* *">* *</option>
                                <option value="* * *">* * *</option>
                                <option value="* * * *">* * * *</option>
                                <option value="* * * * *">* * * * *</option>
                            </select>                      
             </div>

            <div class="form-group">
              <label>Selected Task</label>
               <p> <output type="text" name="task"><% out.print(pre_list3.get(0).getTask()); %></output></p>
            </div>

             <div class="form-group" >
              <label>What Needs to Be Done</label>
              <input type="text" class="form-control" id="exampleInputEmail1" value="<% out.print(pre_list3.get(0).getTodo()); %>" name="todo">
            </div>

            <div class="form-group">
              <label>Details</label>
              <textarea class="form-control" rows="3" value="<% out.print(pre_list3.get(0).getDetails()); %>" name="details"><% out.print(pre_list3.get(0).getDetails()); %></textarea>
            </div>
        
            <div class="form-group">
              <label>Budget</label>
              <input type="number" step="0.01" class="form-control" value="<% out.print(pre_list3.get(0).getBudget()); %>" name="budget">
            </div>

            <div class="form-group">
              <label for="exampleInputPassword1">Expected Date</label>
              
              <input type="text" onfocus="(this.type='date')" class="form-control" value="<%out.print(pre_list3.get(0).getEdate()); %>" name="edate">
            </div>
            
            <button type="submit" class="btn btn-default">Submit</button>
            <a href="<%= request.getContextPath()%>/home" class="btn btn-danger">Cancel</a>
    </form>  
        
        
        
            
        
    
      
        
        
    </div>   
    </body>
</html>
