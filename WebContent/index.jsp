<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<%! String connexionClient; %>
<%try{
	connexionClient = (session.getAttribute("connexionClient").equals("true"))?"true":"false";
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
				      <li class="nav-item active"><a class="nav-link" href="index.jsp">Accueil <span class="sr-only">(current)</span></a></li>
				      <li class="nav-item"><a class="nav-link" href="trouverSpectacle.jsp">TrouverSpectacle</a></li>
				      <li class="nav-item"><a class="nav-link" href="reserverSpectacle.jsp">ReserverSpectacle</a></li>
				      <li class="nav-item"><a class="nav-link" href="payerSpectacle.jsp">PayerSpectacle</a></li>
				      <li class="nav-item"><a class="nav-link" href="annulerSpectacle.jsp">AnnulerSpectacle</a></li>
				    </ul>
				    <ul class="navbar-nav navbar-right">
				      <% if(connexionClient.equals("true")) {%>
				      	<li class="nav-item"><a class="nav-link" href="Deconnexion">Se Déconnecter</a></li>
				      <% } else { %>
				      	<li class="nav-item"><a class="nav-link" href="inscription.jsp">S'inscrire</a></li>
				      	<li class="nav-item"><a class="nav-link" href="connexion.jsp">Se Connecter</a></li>
				      <% } %>
				    </ul>
				</div>
				</nav>
		</fieldset>
</div>
</div>
<br>
<div class="row">
<div class="col-lg-12" align="center">
		<fieldset>
			<% if(connexionClient.equals("true")) {%>
				<legend>Bienvenue <%= session.getAttribute("nomClient")+" "+session.getAttribute("prenomClient") %> </legend>
			<% } else { %>
				<legend>Bienvenue</legend>
				<p>Copyright © No rights reserved</p>
			<% } %>
		</fieldset>
</div>
</div>
</div>
<footer class="row">	
	<div class="col-lg-12" align="center" style="position: absolute;bottom: 0;">
	<hr width="90%">
		<p style="font-size: 12px;">JavaEE Project : Réservation Spectacle - NOUS</p>
	</div>	
</footer>
</body>
</html>