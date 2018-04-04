package fr.eseo.jee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

		Spectacle spectacle = new Spectacle();
		spectacle.setVilleSpectable(request.getParameter("ville"));
		spectacle.setTypeSpectable(request.getParameter("type"));
		
		GestionSpectacles var = new GestionSpectacles();
		Spectacle[] listeSpectacle = var.trouverSpectacle(spectacle);
		
		HttpSession session = request.getSession();
		session.setAttribute("listeSpectacle", listeSpectacle);
		RequestDispatcher disp = request.getRequestDispatcher("outputTrouverSpectacle.jsp");
		disp.forward(request, response);

	}

}
