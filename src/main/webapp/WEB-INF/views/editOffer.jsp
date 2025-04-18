<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<h1>Éditer l'Offre #${offer.id}</h1>
<form method="post" action="${pageContext.request.contextPath}/editOffer">
    <input type="hidden" name="id" value="${offer.id}" />

    <div class="form-group">
        <label>Ville départ :</label>
        <input class="form-control"
               type="text" name="departureCity"
               value="${offer.departureCity}" required/>
    </div>

    <div class="form-group">
        <label>Ville arrivée :</label>
        <input class="form-control"
               type="text" name="arrivalCity"
               value="${offer.arrivalCity}" required/>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Date début :</label>
            <input class="form-control"
                   type="date" name="startDate"
                   value="${offer.startDate}" required/>
        </div>
        <div class="form-group col-md-6">
            <label>Date fin :</label>
            <input class="form-control"
                   type="date" name="endDate"
                   value="${offer.endDate}" required/>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Heure départ :</label>
            <input class="form-control"
                   type="time" name="departureTime"
                   value="${offer.departureTime}" required/>
        </div>
        <div class="form-group col-md-6">
            <label>Heure arrivée :</label>
            <input class="form-control"
                   type="time" name="arrivalTime"
                   value="${offer.arrivalTime}" required/>
        </div>
    </div>

    <div class="form-group">
        <label>Description :</label>
        <textarea class="form-control"
                  name="autocarDescription" rows="3" required>${offer.autocarDescription}</textarea>
    </div>

    <div class="form-group">
        <label>Objectif abonnés :</label>
        <input class="form-control"
               type="number" name="subscriberTarget"
               value="${offer.subscriberTarget}"
               min="1" required/>
    </div>

    <button class="btn btn-primary" type="submit">Mettre à jour</button>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/companyDashboard">Annuler</a>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
