<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>AnnulerSpectacle</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container" style="padding-top: 20px; padding-bottom: 20px;">
		<div class="row">
			<div class="col-lg-12" align="center">
				<fieldset>
					<legend>Réservation Spectacle</legend>
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
							<li class="nav-item"><a class="nav-link" href="trouverSpectacle.jsp">TrouverSpectacle</a></li>
							<li class="nav-item"><a class="nav-link" href="reserverSpectacle.jsp">ReserverSpectacle</a></li>
							<li class="nav-item"><a class="nav-link"
								href="PayerSpectacle">PayerSpectacle</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="AnnulerSpectacle">AnnulerSpectacle<span
									class="sr-only">(current)</span></a></li>
						</ul>
						<ul class="navbar-nav navbar-right">
							<li class="nav-item"><a class="nav-link" href="Deconnexion">Se
									Déconnecter</a></li>
						</ul>
					</div>
					</nav>
				</fieldset>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-12" align="center">
				<form method="post" action="AnnulerSpectacle">
					<fieldset>
						<legend>Vos Réservations</legend>
						<br>
						<%
							if (((int) session.getAttribute("nbReservation")) >= 1) {
						%>
						<div>
							<table>
								<%
									for (int i = 1; i <= ((int) session.getAttribute("nbReservation")); i++) {
								%>
								<tr>
									<td><input type="checkbox" name="reservation"
										value="<%=session.getAttribute("ReservationID" + i)%>" /></td>
									<%
										String[] reservationItems = ((String) session.getAttribute("Reservation" + i)).split("~");
												for (String item : reservationItems) {
									%>
									<td>&nbsp;<%=item%>&nbsp;
									</td>
									<%
										}
									%>
								</tr>
								<%
									}
								%>
							</table>
						</div>
						<br> <input type="submit" value="Valider" class="sansLabel" />
						<%
							} else if (((int) session.getAttribute("nbReservation")) == 0) {
						%>
						<p>Vous n'avez pas de réservation.</p>
						<%
							}
						%>
						<br>
						<%
							if (session.getAttribute("resultDELETE") != null) {
						%>
						<br>
						<p>
							Résultat : <strong><%=session.getAttribute("resultDELETE")%></strong>
						</p>
						<%
							session.removeAttribute("resultDELETE");
						%>
						<%
							}
						%>
					</fieldset>
				</form>
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