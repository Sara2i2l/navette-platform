<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <!-- Bootstrap CSS -->
  <link
          rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384‑JcKb8q3iqJ61gNVpCf0p3ZcJQGIQFeG1ZL18ll6Pq78P52xsf6K4iwY92RbkIv/+"
          crossorigin="anonymous"
  />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title><c:out value="${pageTitle != null ? pageTitle : 'Navette Platform'}"/></title>

  <style>
    :root {
      --primary-color: #ab89df;
      --primary-dark: #9C7BAA;
      --bg-light: #F5E9F3;
      --text-dark: #4B2E5D;
    }

    body {
      background-color: var(--bg-light);
      color: var(--text-dark);
    }

    .btn-primary {
      background-color: var(--primary-color) !important;
      border-color: var(--primary-color) !important;
      color: white !important;
    }

    .btn-primary:hover {
      background-color: var(--primary-dark) !important;
      border-color: var(--primary-dark) !important;
    }

    .btn-outline-primary {
      color: var(--primary-color) !important;
      border-color: var(--primary-color) !important;
    }

    .btn-outline-primary:hover {
      background-color: var(--primary-color) !important;
      color: white !important;
    }

    .navbar {
      background-color: white !important;
      border-bottom: 1px solid #ddd;
      padding: 0.7rem 1rem;
    }

    .navbar-brand {
      color: var(--primary-color) !important;
      font-weight: bold;
      font-size: 1.4rem;
    }

    .navbar-nav .nav-link {
      color: var(--primary-color) !important;
      font-weight: 500;
      margin-right: 10px;
    }

    .navbar-nav .nav-link:hover {
      color: var(--primary-dark) !important;
    }

    h1, h2, h3 {
      color: var(--text-dark);
    }

    a {
      color: var(--primary-color);
    }

    a:hover {
      color: var(--primary-dark);
    }

    .form-control:focus {
      border-color: var(--primary-color);
      box-shadow: 0 0 0 0.2rem rgba(180, 151, 189, 0.25);
    }
  </style>
</head>

<body>

<!--  Navbar -->
<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Navette</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navMenu"
          aria-controls="navMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-end" id="navMenu">
    <ul class="navbar-nav">
        <c:choose>

          <c:when test="${not empty sessionScope.loggedInUser}">
            <li class="nav-item">
              <span class="nav-link font-weight-bold">👤 ${sessionScope.loggedInUser.username}</span>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
            </li>
          </c:when>


          <c:when test="${not empty sessionScope.loggedInCompany}">
            <li class="nav-item">
              <span class="nav-link font-weight-bold">🏢 ${sessionScope.loggedInCompany.name}</span>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/companyRequests">Demandes Clients</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
            </li>
          </c:when>


          <c:otherwise>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/userDashboard">Utilisateur</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/companyDashboard">Société</a>
            </li>
          </c:otherwise>
        </c:choose>






    </ul>
  </div>
</nav>
