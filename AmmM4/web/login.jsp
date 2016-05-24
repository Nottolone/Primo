<%-- 
    Document   : login
    Created on : 27-apr-2016, 18.00.39
    Author     : Matteo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Matteo Porcu">
        <meta name="description" content="Pagina per il login">
        <meta name="keywords" content="login, entra">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div id="content">
            <h2>Login</h2>
            
            <c:if test="${errore!=null}">
                <p>${errore}</p>
            </c:if>

            <form method="POST">
                <!-- Username e password -->
                <div>
                    <label for="nomeUtente">Username</label>
                    <input type="text" name="nomeUtente" id="nomeUtente"/>
                    <label for="pswd">Password</label>
                    <input type="password" name="pswd" id="pswd"/>
                </div>

                <!-- Submit e reset -->
                <div>
                    <input type="submit" value="Invia" name="Login"/>
                    <input type="reset" value="Reimposta" name="Reset"/>
                </div>
            </form>
        </div>
        
        <div id="navigazione">
            <h2>Navigazione</h2>
            <ul>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="cliente.html">Cliente</a></li>
                <li><a href="venditore.html">Venditore</a></li>
            </ul>
        </div>
        
        <jsp:include page="barradestra.jsp"/>
    </body>
</html>