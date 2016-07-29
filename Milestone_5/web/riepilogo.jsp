<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Prodotti in vendita</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="iphone,samsung,microsoft,huawei,sony">
        <meta name="description" content="vendita smartphone online">
        <link href="css/style_css.css" rel="stylesheet" type="text/css" media="screen">
  
        
    </head>
    <body>
        
        <div id="page">
        
            <jsp:include page="header.jsp" />
            
             <jsp:include page="sidebar.jsp" />
            
            <!--contenuto-->
            <div id="content">
    
                <h3> Riepilogo ordine: </h3>
                
                <form action="Cliente" method="GET">
                        
                        <div>
                            <label>
                                Codice Prodotto:${oggetti_acquistati.id} 
                                Nome prodotto:${oggetti_acquistati.NomeProdotto} 
                                Descrizione:${oggetti_acquistati.Descrizione}  
                                Prezzo: ${oggetti_acquistati.Prezzo} 
                                Quantità:${oggetti_acquistati.Quantita} 
                            </label>
                                                       
                           
                        </div>                
                 
            </div>
           
              <jsp:include page="footer.jsp" />
        
        </div>
    </body>
</html>
