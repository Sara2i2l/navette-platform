<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Mes Demandes de Navette" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<!--
<nav class="navbar navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
 -->

<div class="container">
    <h2 class="mb-4 text-center">Mes Demandes de Navette</h2>

    <c:if test="${not empty requests}">
        <ul class="list-group mb-4">
            <c:forEach var="r" items="${requests}">
                <li class="list-group-item">
                    <div>
                        <strong>${r.departureCity}</strong> → <strong>${r.arrivalCity}</strong><br/>
                        Du ${r.startDate} au ${r.endDate}, de ${r.departureTime} à ${r.arrivalTime}<br/>
                        <span class="text-muted">${r.interestedCount} personne(s) intéressée(s)</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty requests}">
        <div class="alert alert-info text-center">
            Vous n'avez pas encore exprimé de demande.
        </div>
    </c:if>

    <div class="text-center">
        <a href="${pageContext.request.contextPath}/searchOffers" class="btn btn-outline-primary">
            Rechercher des offres
        </a>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
