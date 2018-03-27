<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container" style="padding-top: 20px;padding-bottom: 20px;">
<div class="row">
<div class="col-lg-12" align="center">
		<fieldset>
			<legend>Réservation Spectacle</legend>                               
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
				      <li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
				      <li class="nav-item"><a class="nav-link" href="#">TrouverSpectacle</a></li>				    
				    </ul>
				    <ul class="navbar-nav navbar-right">
				      <li class="nav-item active"><a class="nav-link" href="inscription.jsp">S'inscrire<span class="sr-only">(current)</span></a></li>
				      <li class="nav-item"><a class="nav-link" href="connexion.jsp">Se Connecter</a></li>
				    </ul>
				</div>
				</nav>
		</fieldset>
</div>
</div>
<br>
<div class="row">
<div class="col-lg-12" align="center">
	<form method="post" action="Inscription">
		<fieldset>
			<legend>Enregistrer un nouveau client</legend>
				<br>
				<table>
					<tr>
					<td><label for="nom">Nom </label></td>
					<td>&nbsp;<input type="text" id="nom" name="nom" value="" size="30" maxlength="24" required="required"/></td>
					</tr>
					<tr>
					<td><label for="nom">Prenom </label></td>
					<td>&nbsp;<input type="text" id="prenom" name="prenom" value="" size="30" maxlength="24" required="required"/></td>
					</tr>
					<tr>
					<td><label for="email">Adresse email </label></td>
					<td>&nbsp;<input type="email" id="email" name="email" value="" size="30" maxlength="45" required="required"/></td>
					</tr>
					<tr>
					<td><label for="email">Mot de passe </label></td>
					<td>&nbsp;<input type="password" id="password" name="password" value="" size="30" maxlength="30" required="required"/></td>
					</tr>
					<tr>
					<td><label for="email">Adresse </label></td>
					<td>&nbsp;<input type="text" id="adresse" name="adresse" value="" size="30" maxlength="30" required="required"/></td>
					</tr>
				</table>
                <br>
                         
                <% try {
					String inscriptionClient = (String)session.getAttribute("inscriptionClient");         
                	if(inscriptionClient.equals("false")) { %>
						<p><strong>Problème lors de l'inscription</strong></p>
						<br>
				<% } else if(inscriptionClient.equals("true")) {%>
						<p><strong>Inscription réussite</strong></p>
						<br>
				<% }else if(inscriptionClient.equals("Present")) {%>
						<p><strong>Déjà inscrit(e)</strong></p>
						<br>
				<% }
                	session.removeAttribute("inscriptionClient");
				} catch(Exception event) { 
				} %>
                
                <input type="submit" value="S'inscrire" class="sansLabel" />

		</fieldset>
	</form>
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