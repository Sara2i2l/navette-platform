<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="pageTitle" value="Recherche d'offres" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<!--
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
 -->

<div class="container">
    <h1 class="mb-4">Recherche des Offres de Navettes</h1>

    <form class="mb-4 p-3 bg-white rounded shadow-sm" method="get" action="${pageContext.request.contextPath}/searchOffers">
        <div class="form-group">
            <label for="departure">Ville de départ :</label>
            <input class="form-control" type="text" name="departure" id="departure" value="${param.departure}" required />
        </div>
        <div class="form-group">
            <label for="arrival">Ville d'arrivée :</label>
            <input class="form-control" type="text" name="arrival" id="arrival" value="${param.arrival}" required />
        </div>
        <button class="btn btn-primary" type="submit">Rechercher</button>
    </form>

    <c:if test="${not empty offers}">
        <h2 class="mb-3">Résultats de la recherche :</h2>
        <ul class="list-group">
            <c:forEach var="offer" items="${offers}">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div>
                        <strong>Départ:</strong> ${offer.departureCity} →
                        <strong>Arrivée:</strong> ${offer.arrivalCity}<br/>
                        <strong>Heure:</strong> ${offer.departureTime} → ${offer.arrivalTime}<br/>
                        <strong>Abonnés:</strong> ${offer.subscriberCount}
                    </div>
                    <div>
                        <c:choose>
                            <c:when test="${not empty sessionScope.loggedInUser}">
                                <form method="post" action="${pageContext.request.contextPath}/subscribe" class="mb-0">
                                    <input type="hidden" name="offerId" value="${offer.id}" />
                                    <button class="btn btn-success btn-sm" type="submit">S’abonner</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <a class="btn btn-outline-primary btn-sm" href="${pageContext.request.contextPath}/loginUser">
                                    Se connecter pour s’abonner
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty offers and not empty param.departure and not empty param.arrival}">
        <div class="alert alert-warning mt-4">
            <p>Aucune offre trouvée pour :</p>
            <ul>
                <li><strong>Départ :</strong> ${param.departure}</li>
                <li><strong>Arrivée :</strong> ${param.arrival}</li>
            </ul>
            <a href="${pageContext.request.contextPath}/createRequest?departure=${fn:escapeXml(param.departure)}&arrival=${fn:escapeXml(param.arrival)}"
               class="btn btn-outline-dark btn-sm mt-2">
                Exprimer une demande
            </a>
        </div>
    </c:if>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
