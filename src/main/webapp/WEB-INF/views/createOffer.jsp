<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Créer une Offre de Navette" />
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
            <h2 class="mb-4 text-center">Créer une Nouvelle Offre</h2>

            <form method="post" action="${pageContext.request.contextPath}/createOffer">
                <div class="form-group">
                    <label for="departureCity">Ville de départ :</label>
                    <input type="text" id="departureCity" name="departureCity" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="arrivalCity">Ville d'arrivée :</label>
                    <input type="text" id="arrivalCity" name="arrivalCity" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="startDate">Date de début :</label>
                    <input type="date" id="startDate" name="startDate" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="endDate">Date de fin :</label>
                    <input type="date" id="endDate" name="endDate" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="departureTime">Heure de départ :</label>
                    <input type="time" id="departureTime" name="departureTime" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="arrivalTime">Heure d'arrivée :</label>
                    <input type="time" id="arrivalTime" name="arrivalTime" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label for="autocarDescription">Description de l'autocar :</label>
                    <textarea id="autocarDescription" name="autocarDescription" class="form-control" rows="3" required></textarea>
                </div>

                <div class="form-group">
                    <label for="subscriberTarget">Nombre d'abonnés visés :</label>
                    <input type="number" id="subscriberTarget" name="subscriberTarget" min="1" class="form-control" required/>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Créer l'Offre</button>
            </form>

            <p class="mt-3 text-center">
                <a href="${pageContext.request.contextPath}/companyDashboard" class="btn btn-outline-primary">Retour au Dashboard</a>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
