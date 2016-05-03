
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login utente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="username,login">
        <meta name="description" content="login del cliente">
        <link href="M2/css/style_css.css" rel="stylesheet" type="text/css" media="screen">
        
       
    </head>
    <body>
        
        <div id="page">
        
      <jsp:include page="header.jsp" />
            
            
              <jsp:include page="sidebar.jsp" />
            
            
            <!--contenuto-->
            <div id="content">
        
        <h2>Login</h2>
        <form method="POST" action="Login">
            
          <input type="hidden" name="login" value="Login">
          
          
            <div>
            <label for="Username">Username</label>
            <input type="text" name="Username" id="Username" >
            </div>
            
            
            <label for="pw">Password</label>
            <input  type="password" name="Password" id="pw" value="oscurato">
            
           
            
            <div>
                <input class="pulsante" type="submit" value="Invia">
                <input class="pulsante" type="reset" value="Cancella">
            </div>
           
           
             </form>
          
           
            </div>
            
             
              <jsp:include page="footer.jsp" />
            
        </div>
    </body>
</html>
