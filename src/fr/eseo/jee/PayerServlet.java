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
 * Servlet implementation class PayerServlet
 */
@WebServlet("/PayerServlet")
public class PayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		SpectacleBDD spectacle = new SpectacleBDD();
		
		spectacle.connexion();
		spectacle.createStatement();
		HttpSession session = request.getSession();
		
		try {
			spectacle.getStnt().executeUpdate("UPDATE Reservation SET booleanPaiementEffectue = '1' WHERE idReservation="+id );
			spectacle.getStnt().executeQuery("SELECT booleanPaiementEffectue FROM Reservation WHERE idReservation="+id);
			
			while(spectacle.getRset().next()) {
				session.setAttribute("paye", spectacle.getRset().getString("booleanPaiementEffectue"));
				
				System.out.println(spectacle.getRset().getString("booleanPaiementEffectue"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		spectacle.fermetureStatement();
		spectacle.fermetureConnexion();
		
		
		session.setAttribute("spectacle",spectacle);
		RequestDispatcher disp = request.getRequestDispatcher("Payer.jsp");
		disp.forward(request, response);
	}

}
