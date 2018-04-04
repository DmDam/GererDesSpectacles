<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payer Spectacle</title>
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
							<li class="nav-item active"><a class="nav-link"
								href="PayerSpectacle">PayerSpectacle<span class="sr-only">(current)</span></a></li>
							<li class="nav-item"><a class="nav-link"
								href="AnnulerSpectacle">AnnulerSpectacle</a></li>
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
				<fieldset>
					<legend>Payer Spectacle</legend>
					<br>
					<%
						if ((int) session.getAttribute("i") == 0) {
					%>
					Tous vos spectacles ont déjà été payés !
					<%
						} else {
					%>
					Voici les spectacles qu'il vous reste à payer : <br>
					<br>
					<table style="text-align: center">
						<tr style="font-weight: bold">
							<td>&nbsp;Numéro de réservation&nbsp;</td>
							<td>&nbsp;Titre&nbsp;</td>
							<td>&nbsp;Prix&nbsp;</td>
							<td>&nbsp;Nombre(s) de place(s)&nbsp;</td>
							<td>&nbsp;Total à payer&nbsp;</td>
						</tr>
						<%
							for (int i = 0; i < ((int) session.getAttribute("i")); i++) {
						%>
						<%--"Numéro de réservation : " + session.getAttribute("id"+i) + "  Titre : " + request.getSession().getAttribute("titre"+i) + "  Prix : " + request.getSession().getAttribute("prix"+i) + "€  Nombre(s) de place(s) : "+ request.getSession().getAttribute("places"+i) + "  Total à payer : " + session.getAttribute("total"+i) +"€"--%>
						<tr>
							<td>&nbsp;<%=session.getAttribute("id" + i)%>&nbsp;
							</td>
							<td>&nbsp;<%=request.getSession().getAttribute("titre" + i)%>&nbsp;
							</td>
							<td>&nbsp;<%=request.getSession().getAttribute("prix" + i) + "€"%>&nbsp;
							</td>
							<td>&nbsp;<%=request.getSession().getAttribute("places" + i)%>&nbsp;
							</td>
							<td>&nbsp;<%=session.getAttribute("total" + i) + "€"%>&nbsp;
							</td>
							<td>
								<form method="post" action="PayerServlet">
									<input type="hidden" name="id"
										value='<%=session.getAttribute("id" + i)%>'>
									<dd>
										<input type="submit" value="Payer" class="sansLabel" /> <br />
								</form>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<%
						}
					%>
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