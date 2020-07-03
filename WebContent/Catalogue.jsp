<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcoooome</h1>
<table>
  <tr>
    <div style="text-align: right;">
    Panier : <a href="Panier.jsp"><img src="image-livre/add-to-cart.png"/></a>
    </div>
  </tr>
  <tr>
  <th>Id</th><th>Description</th><th>Autheur</th><th>Prix</th><th>Photo</th>
  </tr>
  <form action="/SiteVenteLivre/panier" method="get">
  <c:forEach var="article" items="${articles}" >
  <tr>
   <td>${article.id}</td>
   <td>${article.description}</td>
    <td>${article.autheur}</td>
    <td>${article.prix}</td>
    <td><img src="<c:url value="${article.photo}"/>"></td>
    <td>
    <c:set var="idA" scope="session" value="${article.id}"/>
    <td><input type="submit" value=""><a name="id" href="/SiteVenteLivre/panier?id=<%=session.getAttribute("idA") %>">Ajouter Panier</a>
    </td>
  </tr>
  </c:forEach>
  </form>
</table>
</body>
</html>