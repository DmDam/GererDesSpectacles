package fr.eseo.jee;

import java.io.IOException;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ville = request.getParameter("ville");
		String nom = request.getParameter("nom");
		
		String spectacle ="requ�te bdd";
		
		HttpSession session = request.getSession();
		session.setAttribute("spectacle",spectacle);
		RequestDispatcher disp = request.getRequestDispatcher("reservation.jsp");
		disp.forward(request, response);

	}

}
