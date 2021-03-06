<%-- 
    Document   : listaProdottiJson
    Created on : 11-giu-2016, 20.18.41
    Author     : Matteo
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="prodotto" items="${listaProdotti}">
        <json:object>
            <json:property name="id" value="${prodotto.id}"/>
            <json:property name="nome" value="${prodotto.nomeProdotto}"/>
            <json:property name="urlImmagine" value="${prodotto.urlImmagine}"/>
            <json:property name="prezzo" value="${prodotto.prezzo}"/>
            <json:property name="quantita" value="${prodotto.quantita}"/>
        </json:object>
    </c:forEach>
</json:array>
