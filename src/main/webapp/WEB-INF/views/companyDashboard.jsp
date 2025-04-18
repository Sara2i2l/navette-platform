<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Tableau de bord - Société" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<!--
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm mb-4">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
-->

<div class="container">
  <h1 class="mb-4">Tableau de bord — Société de Transport</h1>

  <h2 class="mb-3">Offres de Navettes Créées</h2>

  <c:if test="${not empty offers}">
    <ul class="list-group mb-4">
      <c:forEach var="offer" items="${offers}">
        <li class="list-group-item">
          <div>
            <strong>ID:</strong> ${offer.id} —
            <strong>Départ:</strong> ${offer.departureCity} →
            <strong>Arrivée:</strong> ${offer.arrivalCity}<br/>
            <strong>Départ à:</strong> ${offer.departureTime} —
            <strong>Arrivée à:</strong> ${offer.arrivalTime}<br/>
            <strong>Abonnés:</strong> ${offer.subscriberCount}
          </div>
          <div class="mt-2">
            <a class="btn btn-sm btn-outline-primary"
               href="${pageContext.request.contextPath}/editOffer?id=${offer.id}">Éditer</a>
            <a class="btn btn-sm btn-outline-danger"
               href="${pageContext.request.contextPath}/deleteOffer?id=${offer.id}"
               onclick="return confirm('Supprimer cette offre ?');">Supprimer</a>
          </div>
        </li>
      </c:forEach>
    </ul>
  </c:if>

  <c:if test="${empty offers}">
    <div class="alert alert-info">Aucune offre n'a été créée pour le moment.</div>
  </c:if>

  <a href="${pageContext.request.contextPath}/createOffer" class="btn btn-primary">
    Créer une nouvelle offre
  </a>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
