<%@page import="java.util.LinkedList"%>
<%@page import="models.modelsetget"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8" />
        <title>View Details</title>
        
        <%@include file="headers.jsp" %>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">        
                
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
            <li class="active">View</li>
        </ol>
            
        <h1>View Details</h1>
        <br />
        
         <%
            LinkedList<modelsetget> pre_list3 = (LinkedList)request.getAttribute("pre_list2");                                  
        %>
        
        <table class="table table-bordered">
            <tr>
                <td>Importance</td>
                <td><% out.print(pre_list3.get(0).getImportance()); %></td>
            </tr>
                
            <tr>
                <td>Task</td>
                <td><% out.print(pre_list3.get(0).getTask()); %></td>
            </tr>    
            
            <tr>
                <td>To-Do</td>
                <td><% out.print(pre_list3.get(0).getTodo()); %></td>
            </tr>
            
            
            <tr>
                <td>Details!</td>
                <td><% out.print(pre_list3.get(0).getDetails()); %></td>
            </tr>
            
            
            <tr>
                <td>Budget</td>
                <td><% out.print(pre_list3.get(0).getBudget()); %></td>
            </tr>
            
            <tr>
                <td>To Be Done Expected Date</td>
                <td><% out.print(pre_list3.get(0).getEdate()); %></td>
            </tr>
            
            
            <tr>
                <td>Done</td>                
                <td><% out.print(pre_list3.get(0).getComplete()); %></td>
            </tr>
            
        </table>
        <br />    
        <a href="<%= request.getContextPath()%>/home" class="btn btn-primary">Back to Home</a>
        
    </div>        
    </body>
</html>
