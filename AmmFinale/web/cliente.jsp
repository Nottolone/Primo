<%-- 
    Document   : cliente
    Created on : 27-apr-2016, 16.47.40
    Author     : Matteo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Matteo Porcu">
        <meta name="description" content="Pagina cliente">
        <meta name="keywords" content="cliente, prodotti">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
        <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/javascript.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div id="content">
            <h2>Pagina cliente</h2>
            
            <c:choose>
                <c:when test="${errore!=null}">
                    <p>${errore}</p>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${prodotto!=null}">
                            <p>Prodotto selezionato</p>
                            <jsp:include page="datiProdotto.jsp"/>
                            <form action="cliente.html">
                                <input type="hidden" name="idProdottoDaAcquistare" value="${prodotto.id}"/>
                                <input type="submit" value="Acquista" name="Buy"/>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${confermaAcquisto!=null}">
                                <p>Acquisto effettuato</p>
                            </c:if>
                            
                            <label for="Filtra">Filtra</label>
                            <input type="text" id="Filtra"/>
                            
                            <jsp:include page="tabellaprodotti.jsp"/>
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
