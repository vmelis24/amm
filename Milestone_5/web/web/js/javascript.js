/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#q").keyup(function()
    {  
        
        var text = $("#q").val();
       
        $.ajax(
        {
            url: "Filter",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaTabella(data);
            },
            error : function(data, state){
            }
        });
        
       
        function aggiornaTabella(listaOggetti)
        {
           
            for(var oggetti in listaOggetti)
            {
               
                var newtd = document.createElement("td");
                newtd.setAttribute("name", "oggetti");
                
                var text = document.createTextNode(listaOggetti[oggetti].nomeprodotto + 
                        " " + listaOggetti[oggetti].descrizione + " ");
                
                newtd.appendChild(text);
                
                var link = document.createElement("a");
                link.setAttribute("href", "Cliente?id="+listaOggetti[oggetti].id);
                var acquistaTxt = document.createTextNode("Acquista prodotto");
                link.appendChild(acquistaTxt);
                newtd.appendChild(link);
                
                $("#listaOggetti").append(newtd);
            }
        }
        
     }); 
});
