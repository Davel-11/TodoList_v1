<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <%@include file="headers.jsp" %>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">
        
        <title>Loging Page</title>
        
        
    </head>
    <body>
    <div id="warp">    
        <h1>Welcome to Your 2 Do List</h1>               
        
        <h3>Create Reminders!</h3>
        
        <h3>Sing In</h3>
        <br />
        <form class="form-group" name="form1" method="post" action="<%=request.getContextPath()%>/sessioncontroller">
            <div class="form-group">
              <label for="exampleInputName2">Email</label>
              <input type="email" class="form-control" id="exampleInputName2" placeholder="Email@example.com" required="required" name="email">
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">Password</label>
              <input type="password" class="form-control" id="exampleInputEmail2" placeholder="Password" required="required" name="pass">
            </div>
            <button type="submit" class="btn btn-primary">Log in</button>
        </form>
            <br />
            
            <%         
                    if (request.getAttribute("incpass")==null) {
                    
                    } else {
                    out.print("<br />");
                    out.println("<p>Password/Username : "+request.getAttribute("incpass")+"</p>");
                    out.print("<br />");                                                                     
                    }    
            %>
        
        <br />
                       
            
        
        <h3>Sign Up</h3>
        <br />
        <form class="form-group" name="form2" method="post" action="<%=request.getContextPath()%>/adduser">
            <div class="form-group">
              <label for="exampleInputName2">Name or Nick Name</label>
              <input type="text" class="form-control" id="exampleInputName2" placeholder="Name" required="required" name="nom">
            </div>
            <div class="form-group">
              <label for="exampleInputName2">Email</label>
              <input type="email" class="form-control" id="exampleInputName2" placeholder="Email@example.com" required="required" name="email">
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">Password</label>
              <input type="password" class="form-control" id="exampleInputEmail2" placeholder="Password" required="required" name="pass">
              
            </div>
            <button type="submit" class="btn btn-success">Create Account</button>
        </form>
            
        <br />
            <% if(request.getAttribute("responseAddUser")==null){
            
                }else { out.println("<p>"+request.getAttribute("responseAddUser")+"</p>"); }
            %>
     
    </div>         
    </body>
</html>
