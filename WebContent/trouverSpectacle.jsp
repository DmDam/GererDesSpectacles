<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher Un Spectacle</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
	<%!String connexionClient;%>
	<%
		try {
			connexionClient = (session.getAttribute("connexionClient").equals("true")) ? "true" : "false";
		} catch (Exception e) {
			connexionClient = "";
		}
	%>
	<div class="container" style="padding-top: 20px; padding-bottom: 20px;">
		<div class="row">
			<div class="col-lg-12" align="center">
				<fieldset>
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Accueil <span class="sr-only">(current)</span></a></li>
							<li class="nav-item"><a class="nav-link"
								href="trouverSpectacle.jsp">TrouverSpectacle</a></li>
							<li class="nav-item"><a class="nav-link"
								href="reserverSpectacle.jsp">ReserverSpectacle</a></li>
							<li class="nav-item"><a class="nav-link"
								href="PayerSpectacle">PayerSpectacle</a></li>
							<li class="nav-item"><a class="nav-link"
								href="AnnulerSpectacle">AnnulerSpectacle</a></li>
						</ul>
						<ul class="navbar-nav navbar-right">
							<%
								if (connexionClient.equals("true")) {
							%>
							<li class="nav-item"><a class="nav-link" href="Deconnexion">Se
									Déconnecter</a></li>
							<%
								} else {
							%>
							<li class="nav-item"><a class="nav-link"
								href="inscription.jsp">S'inscrire</a></li>
							<li class="nav-item"><a class="nav-link"
								href="connexion.jsp">Se Connecter</a></li>
							<%
								}
							%>
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
					<legend>Rechercher un spectacle</legend>
					<form action="TrouverSpectacleServlet">
						<br /> <label for="nom">Ville</label> <select name="ville">
							<option value="Angers">Angers</option>
							<option value="Bordeaux">Bordeaux</option>
							<option value="Lille">Lille</option>
							<option value="Lyon">Lyon</option>
							<option value="Marseille">Marseille</option>
							<option value="Nantes">Nantes</option>
							<option value="Nice">Nice</option>
							<option value="Paris">Paris</option>
							<option value="Toulouse">Toulouse</option>
						</select> <br /> <label for="nom">Type</label> <select name="type">
							<option value="Comique">Comique</option>
							<option value="Tragique">Tragique</option>
							<option value="Histoire">Histoire</option>
							<option value="SYFY">SYFY</option>
						</select> <br /> <label for="nom">Date</label> <input type="date"
							id="date" name="date"> <br /> <br /> <input
							type="submit" value="Rechercher" class="sansLabel" /> <br />
					</form>
				</fieldset>
			</div>
		</div>
	</div>
	<footer class="row">
	<div class="col-lg-12" align="center"
		style="position: absolute; bottom: 0;">
		<hr width="90%">
		<p style="font-size: 12px;">JavaEE Project : Réservation Spectacle
			- Charles-Alexandre Guillou, Wilfried Guyon, Damien Maymard, Jean Zwolinski</p>
	</div>
	</footer>
</body>
</html>