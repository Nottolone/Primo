<%-- 
    Document   : venditore
    Created on : 27-apr-2016, 18.03.03
    Author     : Matteo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Matteo Porcu">
        <meta name="description" content="Pagina del venditore">
        <meta name="keywords" content="venditore, inserimento">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div id="content">
            <h2>Pagina venditore</h2>
            
            <c:choose>
                <c:when test="${errore!=null}">
                    <p>${errore}</p>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${prodotto!=null}">
                            <p>Prodotto inserito</p>
                            <jsp:include page="datiProdotto.jsp"/>
                        </c:when>
                        <c:otherwise>
                            <form action="venditore.html" method="POST">
                                <!-- Nome e imagine dell'oggetto -->
                                <div>
                                    <label for="nomeProdotto">Nome prodotto</label>
                                    <input type="text" name="nomeProdotto" id="nomeProdotto" />
                                    <label for="urlImmagine">Url immagine</label>
                                    <input type="url" name="urlImmagine" id="urlImmagine" />
                                </div>

                                <!-- Descrizione oggetto -->
                                <div>
                                    <label for="descrizione">Descrizione</label>
                                    <textarea name="descrizione" id="descrizione" rows="4" cols="20">Descrizione prodotto</textarea>
                                </div>

                                <!-- Prezzo e quantità dell'oggetto -->
                                <div>
                                    <label for="prezzo">Prezzo in euro</label>
                                    <input type="number" step="0.01" name="prezzo" id="prezzo" />
                                    <label for="quantitaProdotto">Quantit&aacute; oggetto</label>
                                    <input type="number" name="quantitaProdotto" id="quantitaProdotto" />
                                </div>

                                <!-- Submit e reset -->
                                <div>
                                    <input type="submit" value="Invia" name="Submit"/>
                                    <input type="reset" value="Reimposta" name="Reset"/>
                                </div>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </div>
        
        <div id="navigazione">
            <h2>Navigazione</h2>
            <ul>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="login.html">Login</a></li>
            </ul>
        </div>
        
        <jsp:include page="barradestra.jsp"/>
    </body>
</html>
