
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="inscription" method="post">
  <h3> Inscription </h3>
  
    <label> Nom utilisateur  :</label>
    <input type="text" value="champs obligatoire" name="nom"/>
    <span class="erreur">${erreur["nom"]}</span> <br/>
    
    
    
    <label> Adresse Email      :</label>
    <input type="text" value="champs obligatoire"  name="email" /> 
    <span class="erreur" >${erreur["email"]}</span>
    <br/>
      
      
    <label>Mot de passe      :</label>
    <input type="password" name="mdp"/> 
    <span class="erreur">${erreur["mdp"]}</span>
      <br/>
  
    <label> Confirmation du mot de passe  :</label>
    <input type="password"  name="Cmdp"/>
    <span class="erreur"></span>
    <br/>
    
    
     <input type="submit" name="inscrip" value="Inscription"/> <br/>
     <br/>
     <br/>
     <h3>${emailExist}</h3>
     
  </form>

</body>
</html>