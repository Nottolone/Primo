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
                    var tr1=document.createElement("tr");console.log(i+" a");
                    if(i%2===0)
                        tr1.setAttribute("class","pari");

                    var td1=document.createElement("td");console.log(i+" b");
                    td1.setAttribute("class","immagine");console.log(i+" c");
                    td1.setAttribute("rowspan","4");console.log(i+" d");
                    var img=document.createElement("img");console.log(i+" e");
                    img.setAttribute("title", listaProdotti[prodotto].nome);console.log(i+" f");
                    img.setAttribute("alt", listaProdotti[prodotto].nome);console.log(i+" g");
                    img.setAttribute("src", listaProdotti[prodotto].urlImmagine);console.log(i+" h");
                    td1.appendChild(img);console.log(i+" i");

                    var td2=document.createElement("td");console.log(i+" l");
                    var text1=document.createTextNode(listaProdotti[prodotto].nome);console.log(i+" m");
                    td2.appendChild(text1);console.log(i+" n");

                    tr1.appendChild(td1);console.log(i+" o");
                    tr1.appendChild(td2);console.log(i+" p");
                    $("#tabellaProdotti").append(tr1);console.log(i+" q");
                    
                    
                    var tr2=document.createElement("tr");
                    if(i%2===0)
                        tr2.setAttribute("class","pari");

                    var td3=document.createElement("td");
                    var text2=document.createTextNode("Pezzi disponibili: "+listaProdotti[prodotto].quantita);
                    td3.appendChild(text2);

                    tr2.appendChild(td3);
                    $("#tabellaProdotti").append(tr2);
                    
                    
                    var tr3=document.createElement("tr");
                    if(i%2===0)
                        tr3.setAttribute("class","pari");

                    var td4=document.createElement("td");
                    var text3=document.createTextNode("Prezzo: "+listaProdotti[prodotto].prezzo+"€");
                    td4.appendChild(text3);

                    tr3.appendChild(td4);
                    $("#tabellaProdotti").append(tr3);
                    
                    
                    var tr4=document.createElement("tr");
                    if(i%2===0)
                        tr4.setAttribute("class","pari");

                    var td5=document.createElement("td");
                    var link=document.createElement("a");
                    link.setAttribute("href", "cliente.html?idProdotto="+listaProdotti[prodotto].id);
                    var aText= document.createTextNode("Aggiungi al carrello");
                    link.appendChild(aText);
                    td5.appendChild(link);

                    tr4.appendChild(td5);
                    $("#tabellaProdotti").append(tr4);
                    
                    i++;
                }
            }
        }
    }); 
});