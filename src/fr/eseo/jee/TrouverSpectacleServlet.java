package fr.eseo.jee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class TrouverSpectacleServlet
 */
@WebServlet("/TrouverSpectacleServlet")
public class TrouverSpectacleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrouverSpectacleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ville = request.getParameter("ville");

		SpectacleBDD instanceBDD = new SpectacleBDD();
		instanceBDD.connexion();
		instanceBDD.createStatement();

		try {
			instanceBDD.getStnt().executeQuery("SELECT titreSpectacle FROM Spectacles WHERE ville='"+ville+"';");

			while (instanceBDD.getRset().next()) {
				System.out.println(instanceBDD.getRset().getString("titreSpectacle"));
				System.out.println("----------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();

		String spectacle ="";
		
		HttpSession session = request.getSession();
		session.setAttribute("spectacle", spectacle);
		RequestDispatcher disp = request.getRequestDispatcher("reservation.jsp");
		disp.forward(request, response);

	}

}
