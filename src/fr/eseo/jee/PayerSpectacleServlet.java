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
 * Servlet implementation class PayerSpectacleServlet
 */
@WebServlet(name = "PayerSpectacle", urlPatterns = { "/PayerSpectacle" })
public class PayerSpectacleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerSpectacleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String idClient = (String) session.getAttribute("idClient");
		
		if(idClient!=null) {
			int i=0;
			SpectacleBDD spectacle = new SpectacleBDD();
			
			spectacle.connexion();
			spectacle.createStatement();
			
			session.removeAttribute("titre");
			session.removeAttribute("prix");
			session.removeAttribute("places");
			session.removeAttribute("id");
			session.removeAttribute("total");

			
			try {
				
				spectacle.getStnt().executeQuery("SELECT titreSpectacle, prixSpectacle, nombresPlaces, idReservation FROM Spectacles, Reservation, Client WHERE Client.idClient = "+idClient+" and Client.idClient = Reservation.idClient and Reservation.booleanPaiementEffectue = 0 and Reservation.idSpectacle = Spectacles.idSpectacle");
				
				
				while(spectacle.getRset().next()) {
					
					
					session.setAttribute("titre"+i, spectacle.getRset().getString("titreSpectacle"));
					session.setAttribute("prix"+i, spectacle.getRset().getString("prixSpectacle"));
					session.setAttribute("places"+i, spectacle.getRset().getString("nombresPlaces"));
					float total = Float.parseFloat((String)session.getAttribute("prix"+i))*Integer.parseInt((String)session.getAttribute("places"+i));
					session.setAttribute("id"+i, spectacle.getRset().getString("idReservation"));
					session.setAttribute("total"+i, total);
					System.out.println(spectacle.getRset().getString("titreSpectacle"));
					System.out.println("----------");
					i++;
					
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			spectacle.fermetureStatement();
			spectacle.fermetureConnexion();
			
			session.setAttribute("i", i);
			session.setAttribute("spectacle",spectacle);
			RequestDispatcher disp = request.getRequestDispatcher("payerSpectacle.jsp");
			disp.forward(request, response);			
			
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("connexion.jsp");
			disp.forward(request, response);
		}
		
	}


}
