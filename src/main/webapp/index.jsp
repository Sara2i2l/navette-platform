<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<h1 class="mt-4">Bienvenue sur la plateforme Navette !</h1>
<p>Cette plateforme permet aux sociétés de transport de proposer des offres, et aux utilisateurs de s’abonner.</p>

<%@ page language="java" %>
<%
    response.sendRedirect("searchOffers");
%>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
