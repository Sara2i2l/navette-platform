<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Nouvelle Demande de Navette" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<!--
<nav class="navbar navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
-->

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 bg-white p-4 rounded shadow-sm">
            <h2 class="mb-4 text-center">Exprimer une Demande de Navette</h2>

            <form method="post" action="${pageContext.request.contextPath}/createRequest">
                <div class="form-group">
                    <label for="departureCity">Ville de départ :</label>
                    <input name="departureCity" id="departureCity" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="arrivalCity">Ville d'arrivée :</label>
                    <input name="arrivalCity" id="arrivalCity" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="startDate">Date de début :</label>
                    <input type="date" name="startDate" id="startDate" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="endDate">Date de fin :</label>
                    <input type="date" name="endDate" id="endDate" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="departureTime">Heure de départ :</label>
                    <input type="time" name="departureTime" id="departureTime" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="arrivalTime">Heure d'arrivée :</label>
                    <input type="time" name="arrivalTime" id="arrivalTime" class="form-control" required />
                </div>

                <button type="submit" class="btn btn-primary btn-block">Envoyer la demande</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
