<%-- 
    Document   : barradestra
    Created on : 27-apr-2016, 16.46.52
    Author     : Matteo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
                                <ul>
                                    <li>Nome prodotto: ${prodotto.nomeProdotto}</li>
                                    <li>Indirizzo immagine: ${prodotto.urlImmagine}</li>
                                    <li>Descrizione: ${prodotto.descrizione}</li>
                                    <li>Prezzo: ${prodotto.prezzo}&euro;</li>
                                    <li>Quantit&aacute;: ${prodotto.quantita}</li>
                                </ul>