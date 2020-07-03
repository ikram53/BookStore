<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="connection" method="post">
    
    <label> Login  :</label>
    <input type="text" name="login"/>
    <br/>
    
    <label>Mot de Passe: </label>
    <input type="password" name="mdp"/>
    <br/>
    
    <input type="submit" name="connecter" value="Se connecter"/>
    <h2>${MdpErrone}</h2>
 </form>

</body>
</html>