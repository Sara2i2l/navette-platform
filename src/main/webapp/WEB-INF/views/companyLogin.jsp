<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Connexion Société" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-white p-4 rounded shadow-sm">
            <h2 class="mb-4 text-center">Connexion Société</h2>

            <c:if test="${not empty companyName}">
                <p class="alert alert-info text-center">
                    Bonjour, ${companyName} !
                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-sm btn-outline-secondary ml-2">Se déconnecter</a>
                </p>
            </c:if>

            <c:if test="${not empty error}">
                <div class="alert alert-danger text-center">${error}</div>
            </c:if>

            <form method="post" action="${pageContext.request.contextPath}/loginCompany">
                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe :</label>
                    <input type="password" id="password" name="password" class="form-control" required />
                </div>
                <button type="submit" class="btn btn-primary btn-block">Se connecter</button>
            </form>

            <p class="mt-3 text-center">
                <a href="${pageContext.request.contextPath}/registerCompany">Créer un compte</a>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
