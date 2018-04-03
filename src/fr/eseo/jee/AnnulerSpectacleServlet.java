package fr.eseo.jee;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnnulerSpectacleServlet
 */
@WebServlet(name = "AnnulerSpectacle", urlPatterns = { "/AnnulerSpectacle" })
public class AnnulerSpectacleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnulerSpectacleServlet() {
		super();
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String idClient = (String) session.getAttribute("idClient");

		if (idClient != null) {
			this.listReservation(session, idClient);

			RequestDispatcher disp = request.getRequestDispatcher("annulerSpectacle.jsp");
			disp.forward(request, response);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("connexion.jsp");
			disp.forward(request, response);
		}

	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String idClient = (String) session.getAttribute("idClient");

		String[] reservation = request.getParameterValues("reservation");

		if (reservation != null) {
			SpectacleBDD connexionBDD1 = new SpectacleBDD();
			connexionBDD1.connexion();
			connexionBDD1.createStatement();
			SpectacleBDD connexionBDD2 = new SpectacleBDD();
			connexionBDD2.connexion();
			for (String idReservation : reservation) {
				try {
					System.out.println("*1*Select booleanPaiementEffectue From Reservation Where idReservation="
							+ idReservation + " and idClient=" + idClient);
					connexionBDD1.getStnt()
							.executeQuery("Select booleanPaiementEffectue From Reservation Where idReservation="
									+ idReservation + " and idClient=" + idClient);

					while (connexionBDD1.getRset().next()) {
						String resultPaiementEffectue = connexionBDD1.getRset().getString("booleanPaiementEffectue");
						System.out.println(
								"ResultAchat : " + resultPaiementEffectue + " // " + resultPaiementEffectue.getClass());
						System.out.println("----------");

						if (resultPaiementEffectue.equalsIgnoreCase("0")) {
							System.out.println("*1*" + SpectacleBDD.DELETE_RESERVATION_SQL + idReservation);
							connexionBDD2.createStatement();
							connexionBDD2.getStnt().executeUpdate(SpectacleBDD.DELETE_RESERVATION_SQL + idReservation);
							connexionBDD2.fermetureStatement();
							System.out.println("ok");
							session.setAttribute("resultDELETE", "Suppression(s) - OK");
						} else if (resultPaiementEffectue.equalsIgnoreCase("1")) {
							System.out.println("Pas DELETE car payé");
							session.setAttribute("resultDELETE", "Réservation(s) déjà payée(s)");
						} else {
							System.out.println("PBif");
							session.setAttribute("resultDELETE", "Problème de suppression");
						}
					}
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
			}
			connexionBDD2.fermetureConnexion();
			connexionBDD1.fermetureStatement();
			connexionBDD1.fermetureConnexion();
		} else {
			session.setAttribute("resultDELETE", "Aucune sélection");
		}

		this.listReservation(session, idClient);

		RequestDispatcher disp = request.getRequestDispatcher("annulerSpectacle.jsp");
		disp.forward(request, response);
	}

	private void listReservation(HttpSession session, String idClient) {
		SpectacleBDD connexionBDDReservation = new SpectacleBDD();
		connexionBDDReservation.connexion();
		connexionBDDReservation.createStatement();
		int count = 0;
		try {
			connexionBDDReservation.getStnt().executeQuery(
					"SELECT Reservation.idReservation, titreSpectacle, typeSpectale, ville, dateSpectacle, Reservation.booleanPaiementEffectue FROM Spectacles, Reservation WHERE Spectacles.idSpectacle=Reservation.idSpectacle AND Reservation.idClient="
							+ idClient
							+ " ORDER BY Reservation.booleanPaiementEffectue DESC, Spectacles.dateSpectacle, Spectacles.titreSpectacle ");
			while (connexionBDDReservation.getRset().next()) {
				count++;

				String resultIdReservation = connexionBDDReservation.getRset().getString("Reservation.idReservation");
				String resultTitreSpectacle = connexionBDDReservation.getRset().getString("titreSpectacle");
				String resultTypeSpectale = connexionBDDReservation.getRset().getString("typeSpectale");
				String resultVille = connexionBDDReservation.getRset().getString("ville");
				String resultDateSpectacle = connexionBDDReservation.getRset().getString("dateSpectacle");
				String resultPaiementEffectue = connexionBDDReservation.getRset()
						.getString("Reservation.booleanPaiementEffectue");
				resultPaiementEffectue = (resultPaiementEffectue.equalsIgnoreCase("1")) ? "Payé" : "Non Payé";
				System.out.println("Result : " + resultTitreSpectacle + "  " + resultTypeSpectale);
				System.out.println("----------");
				session.setAttribute("ReservationID" + count, resultIdReservation);
				session.setAttribute("Reservation" + count, resultTitreSpectacle + "~" + resultTypeSpectale + "~"
						+ resultVille + "~" + resultDateSpectacle + "~" + resultPaiementEffectue);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connexionBDDReservation.fermetureStatement();
		connexionBDDReservation.fermetureConnexion();
		session.setAttribute("nbReservation", count);

	}

}
