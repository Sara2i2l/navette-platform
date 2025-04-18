<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Demandes Clients" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">

<!--
<nav class="navbar navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
-->
<div class="container">
    <h1 class="mb-4">Demandes des Utilisateurs</h1>

    <c:if test="${not empty requests}">
        <ul class="list-group mb-4">
            <c:forEach var="r" items="${requests}">
                <li class="list-group-item">
                    <strong>${r.departureCity}</strong> → <strong>${r.arrivalCity}</strong><br/>
                    Du ${r.startDate} au ${r.endDate}, de ${r.departureTime} à ${r.arrivalTime}<br/>
                    <span class="text-muted">(${r.interestedCount} intéressé(s))</span>
                    <!-- Future action: “Prendre en charge” -->
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty requests}">
        <div class="alert alert-info">Aucune demande pour le moment.</div>
    </c:if>

    <a href="${pageContext.request.contextPath}/companyDashboard" class="btn btn-outline-primary">
        Retour au tableau de bord
    </a>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
