<%-- 
    Document   : tabellaprodotti
    Created on : 24-mag-2016, 16.07.04
    Author     : Matteo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                            <table>
                                <tr>
                                    <th>Foto del prodotto</th>
                                    <th>Informazioni sul prodotto</th>
                                </tr>
                                <c:forEach var="p" items="${listaProdotti}" varStatus="i" >
                                    <c:choose>
                                        <c:when test="${i.index%2==1}"> <!-- L'indice parte da zero, quindi le righe pari sono quelle con indice dispari -->
                                            <tr class="pari">
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                        </c:otherwise>
                                    </c:choose>
                                        <td><img title="${p.nomeProdotto}" alt="${p.nomeProdotto}" src="${p.urlImmagine}"></td>
                                        <td>
                                            ${p.nomeProdotto} <br/>
                                            Pezzi disponibili: ${p.quantita} <br/>
                                            Prezzo: ${p.prezzo}&euro; <br/>
                                            <a href="cliente.html?idProdotto=${p.id}">Aggiungi al carrello</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
