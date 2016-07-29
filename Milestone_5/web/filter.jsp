<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetti" items="${listaOggetti}">
        <json:object>
            <json:property name="nomeprodotto" value="${oggetti.nomeprodotto}"/>
            <json:property name="urlprodotto" value="${oggetti.urlprodotto}"/>
            <json:property name="quantita" value="${oggetti.quantita}"/>
             <json:property name="prezzo" value="${oggetti.prezzo}"/>
             <json:property name="carrello" value="${oggetti.carrello}"/> 
        </json:object>
    </c:forEach>
</json:array>