<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<%! String connexionClient; %>
<%try{
	connexionClient = (session.getAttribute("connexionClient").equals("false"))?"false":"true";
} catch (Exception e){
	connexionClient = "";
}%>
<div class="container" style="padding-top: 20px;padding-bottom: 20px;">
<div class="row">
<div class="col-lg-12" align="center">
		<fieldset>
			<legend>Réservation Spectacle</legend>                               
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
				      <li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
				      <li class="nav-item"><a class="nav-link" href="trouverSpectacle.jsp">TrouverSpectacle</a></li>				    
				    </ul>
				    <ul class="navbar-nav navbar-right">
				      <li class="nav-item"><a class="nav-link" href="inscription.jsp">S'inscrire</a></li>
				      <li class="nav-item active"><a class="nav-link" href="connexion.jsp">Se Connecter<span class="sr-only">(current)</span></a></li>
				    </ul>
				</div>
				</nav>
		</fieldset>
</div>
</div>
<br>
<div class="row">
<div class="col-lg-12" align="center">
	<form method="post" action="Connexion">
		<fieldset>
			<legend>Connexion</legend>
                <br>
                <table>
                	<tr>
					<td><label for="email">Email </label></td>
					<td>&nbsp;<input type="email" name="email" value="" size="30" maxlength="45" required="required"/></td>
					</tr>
					<tr>
					<td><label for="email">Mot de passe </label></td>
					<td>&nbsp;<input type="password" name="password" value="" size="30" maxlength="30" required="required"/></td>
					</tr>
				</table>                
                <br>
                
                <% if(connexionClient.equals("false")) { %>
						<p><strong>Email ou mot de passe incorrect</strong></p>
						<br>
				<% } 
                session.removeAttribute("connexionClient"); %>
                
                <input type="submit" value="Se connecter" class="sansLabel" />
                <br>
                                
		</fieldset>
	</form>
	<br />
	<a href="inscription.jsp">Créer un compte</a>
	<br />
</div>
</div>
</div>
<footer class="row">	
	<div class="col-lg-12" align="center" style="position: absolute;bottom: 0;">
	<hr width="90%">
		<p style="font-size: 12px;">JavaEE Project : Réservation Spectacle - Charles-Alexandre Guillou, Wilfried Guyon, Damien Maymard, Jean Zwolinski</p>
	</div>	
</footer>
</body>

</html>