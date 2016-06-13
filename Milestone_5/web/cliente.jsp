

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
        <h1>Prodotti disponibili</h1>
        <!-- tabella contenente i prodotti disponibili nel catalogo --> 
        <h3>Bentornato,$[cliente_autenticato.nome]$[cliente_autenticato.cognome]</h3>
        
        <h1>Filtra</h1>
        <textarea id="text"></textarea>
       
        <table>
            <tr class="intestazione">
                <th>Nome</th>
                <th>Foto</th>
                <th>Pezzi disponibili</th>
                <th>Prezzo</th>
                <th>Carrello</th>
                
            </tr>
            
            <tr class="dati_d">
                <td>Iphone 6s 16GB</td>
                <td><img src="img/iphone.jpg" class="foto" title="iphone" alt="iphone 6s"></td>
                <td class="pezzi">2 </td>
                <td>€ 729,00</td>
                <td class="carrello"><a href="riepilogo.jsp">Aggiugni al carrello</a></td>
            
            </tr>
            
            <tr class="dati_p">
                <td>Samsung Galaxy S6 Edge 64 GB</td>
                <td><img src="img/s6.jpg" class="foto" title="samsung s6" alt="samsung s6" ></td>
                <td class="pezzi">1</td>
                <td>€ 699,99</td>
                <td class="carrello"><a href="riepilogo.jsp">Aggiugni al carrello</a></td>
            
            </tr>
            
            
            
            <tr class="dati_d" >
                <td>Huawei mate 8 Grey</td>
                <td><img src="img/huawei.jpg" class="foto" title="huawei mate" alt="huawei mate" ></td>
                <td class="pezzi">3</td>
                <td>€ 599,99</td>
                <td class="carrello"><a href="riepilogo.jsp">Aggiugni al carrello</a></td>
            
            </tr>
            
            
            
            <tr class="dati_p">
                <td>Microsoft Lumia 950</td>
                <td><img src="img/microsoft.jpg" class="foto" title="microsoft lumia" alt="microsoft lumia"></td>
                <td class="pezzi">1</td>
                <td>€ 549,99</td>
                <td class="carrello"><a href="riepilogo.jsp">Aggiugni al carrello</a></td>
            
            </tr>
            
            
            
            <tr class="dati_d">
                <td>Sony xperia z5 white</td>
                <td><img src="img/sony.jpg" class="foto" title="sony xperia" alt="sony xperia"></td>
                <td class="pezzi">2</td>
                <td>€ 569,00</td>
                <td class="carrello"><a href="riepilogo.jsp">Aggiugni al carrello</a></td>
            
            </tr>
            
        </table>
        
        <!-- raggiungi la pagina descrizione.html e login.html -->
            </div>
            
            
              <jsp:include page="footer.jsp" />
        
        </div>
    </body>
</html>
