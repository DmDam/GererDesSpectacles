package fr.eseo.jee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReserverSpectacleServlet
 */
@WebServlet("/ReserverSpectacleServlet")
public class ReserverSpectacleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserverSpectacleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SpectacleBDD instanceBDD = new SpectacleBDD();
		String spectacle = "";
		instanceBDD.connexion();
		instanceBDD.createStatement();

		try {
			//instanceBDD.getStnt().executeQuery("'"+"';");
			instanceBDD.getStnt().executeQuery("SELECT * FROM `spectacles`;");

			while (instanceBDD.getRset().next()) {
				System.out.println(instanceBDD.getRset().getString("titreSpectacle"));
				System.out.println("----------");
				spectacle = instanceBDD.getRset().getString("titreSpectacle");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();
		
		HttpSession session = request.getSession();
		session.setAttribute("spectacle", spectacle);
		RequestDispatcher disp = request.getRequestDispatcher("outputReserverSpectacle.jsp");
		disp.forward(request, response);

	}

}
