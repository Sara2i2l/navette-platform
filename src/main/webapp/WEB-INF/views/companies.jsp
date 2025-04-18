<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="pageTitle" value="Sociétés de Transport" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>

<div class="container">
    <h1 class="mb-4">Sociétés de Transport</h1>

    <form method="post" action="${pageContext.request.contextPath}/companies"
          class="bg-white p-3 rounded shadow-sm mb-4">
        <div class="form-group">
            <label for="name">Nom de la société :</label>
            <input type="text" name="name" id="name" required class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>

    <h2 class="mt-4">Liste des sociétés (${fn:length(companies)})</h2>
    <ul class="list-group mt-2">
        <c:forEach var="company" items="${companies}">
            <li class="list-group-item">
                <strong>ID:</strong> ${company.id} — <strong>Nom:</strong> ${company.name}
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
