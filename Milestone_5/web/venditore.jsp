
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Inserimento nuovo prodotto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="prodotto,url,prezzo">
        <meta name="description" content="inserimento nuovi prodotti">
        <link href="css/style_css.css" rel="stylesheet" type="text/css" media="screen">
    </head>
    <body>
        
         <div id="page">
        
            <jsp:include page="header.jsp" />
            
            <jsp:include page="sidebar.jsp" />
          
            
            
            
            <!--contenuto-->
            <div id="content">
        
        <h3>Bentornato,$[venditore_autenticato.nome]$[venditore_autenticato.cognome]</h3>
        
        <h1>Inserisci un nuovo prodotto</h1>
        
        <form method="POST" action="Venditore">
            
             <div>
                ${venditore.nome} ${venditore.cognome}                 
                <input type="hidden" name="id" id="id" value="${venditore.id}"/>   
            </div>
            
            
             <!-- inserimento nome prodotto, url immagine del prodotto,descrizione
             prezzo e quantità-->
             
            <label for="NomeProdotto">Nome del prodotto</label>
            <input type="text" name="nomeprodotto" id="NomeProdotto" value="nome prodotto">
            

            <div>
            <label for="UrlProdotto">URL dell'immagine del prodotto</label>
            <input type="text" name="urlprodotto" id="UrlProdotto" value="inserisci la url">
            </div>

             
            <label for="Descrizione">Descrizione prodotto</label>
            <textarea name="descrizione" id="Descrizione" cols="21" rows="5">Descrizone prodotto</textarea>
           
             
            <label for="Prezzo">Prezzo</label>
            <input type="number" name="prezzo" step="any" id="Prezzo" >
           

            
            <label for="Quantita">Quantit&agrave; prodotti disponibili</label>
            <input type="number" name="quantita" id="Quantita" >
             
            <div>
                <input class="pulsante" type="submit" name="submit" value="Invia">
                <input class="pulsante" type="submit" name="modifica" value="Modifica">
                <input class="pulsante" type="reset" name="cancella" value="Cancella">
            </div>
            
        </form>

        
            </div>
            
            
            <jsp:include page="footer.jsp" />
            
         </div>
        
    </body>
</html>
