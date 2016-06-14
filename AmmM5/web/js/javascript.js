/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   $("#Filtra").keyup(function(){
        var query=$("#Filtra").val();
       
        $.ajax({
            url: "filter.json",
            data:{
              cmd: "filtra",
              q: query
            },
            dataType: 'json',
            success: function(data,state){
                aggiornaProdotti(data);
            },
            error: function(data,state){}
        });
        
        function aggiornaProdotti(listaProdotti){
            $("#tabellaProdotti").empty();
            $("#msg").remove();
            
            if(listaProdotti.length===0){
                $("#tabellaProdotti").after("<p id=\"msg\">Nessun oggetto trovato</p>");
            } else {
                var trH=document.createElement("tr");

                var th1=document.createElement("th");
                th1.appendChild(document.createTextNode("Foto del prodotto"));
                trH.appendChild(th1);

                var th2=document.createElement("th");
                th2.appendChild(document.createTextNode("Informazioni sul prodotto"));
                trH.appendChild(th2);

                $("#tabellaProdotti").append(trH);

                var i=1;
                for(var prodotto in listaProdotti){
                    var tr=document.createElement("tr");
                    if(i%2===0)
                        tr.setAttribute("class","pari");

                    var td1=document.createElement("td");
                    var img=document.createElement("img");
                    img.setAttribute("title", listaProdotti[prodotto].nome);
                    img.setAttribute("alt", listaProdotti[prodotto].nome);
                    img.setAttribute("src", listaProdotti[prodotto].urlImmagine);
                    td1.appendChild(img);

                    var td2=document.createElement("td");

                    var text1=document.createTextNode(listaProdotti[prodotto].nome);
                    td2.appendChild(text1);
                    td2.appendChild(document.createElement("br"));

                    var text2=document.createTextNode("Pezzi disponibili: "+listaProdotti[prodotto].quantita);
                    td2.appendChild(text2);
                    td2.appendChild(document.createElement("br"));

                    var text3=document.createTextNode("Prezzo: "+listaProdotti[prodotto].prezzo+"€");
                    td2.appendChild(text3);
                    td2.appendChild(document.createElement("br"));

                    var link=document.createElement("a");
                    link.setAttribute("href", "cliente.html?idProdotto="+listaProdotti[prodotto].id);
                    var aText= document.createTextNode("Aggiungi al carrello");
                    link.appendChild(aText);
                    td2.appendChild(link);

                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    $("#tabellaProdotti").append(tr);
                    i++;
                }
            }
        }
    }); 
});