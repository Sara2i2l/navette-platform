<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Connexion Utilisateur" />
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<body class="bg-light">
<!--
<nav class="navbar navbar-light bg-white shadow-sm mb-4">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navette</a>
</nav>
 -->

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-white p-4 rounded shadow-sm">
            <h2 class="mb-4 text-center">Connexion Utilisateur</h2>

            <c:if test="${not empty error}">
                <div class="alert alert-danger text-center">${error}</div>
            </c:if>

            <form method="post" action="${pageContext.request.contextPath}/loginUser">
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
                <a href="${pageContext.request.contextPath}/registerUser">Créer un compte</a>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
