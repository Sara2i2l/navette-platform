<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Inscription - Société" />
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
            <h2 class="mb-4 text-center">Créer votre compte entreprise</h2>

            <form method="post" action="${pageContext.request.contextPath}/registerCompany">
                <div class="form-group">
                    <label for="name">Nom de la société :</label>
                    <input type="text" name="name" id="name" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="email">Adresse email :</label>
                    <input type="email" name="email" id="email" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="password">Mot de passe :</label>
                    <input type="password" name="password" id="password" class="form-control" required />
                </div>

                <button type="submit" class="btn btn-primary btn-block">Créer le compte</button>
            </form>

            <p class="mt-3 text-center">
                Déjà inscrit ? <a href="${pageContext.request.contextPath}/loginCompany">Se connecter</a>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
