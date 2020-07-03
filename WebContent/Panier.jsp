<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
  <thead >
    <tr>
      <th>Description</th>
      <th>Prix</th>
      <th>Autheur</th>
      <th>Photo</th>
     </tr>
   </thead>
  <tbody>
   
     <c:forEach var="panier" items="${articlesChoisi}" >
      <tr>
       <td>${panier.description}</td>
       <td>${panier.prix}</td>
       <td>${panier.autheur}</td>
       <td><img src="<c:url value="${panier.photo}"/>"></td>
       </tr>
     </c:forEach>
    
  </tbody>
 </table>
</body>
</html>