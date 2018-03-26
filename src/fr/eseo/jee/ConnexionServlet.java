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
 * Servlet implementation class ConnexionServlet
 */
@WebServlet(name = "Connexion", urlPatterns = { "/Connexion" })
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String mdp = (String) request.getParameter("password");
		String connexionClient = "false";
		String idClient = null, nomClient = null, prenomClient = null;
		
		
		SpectacleBDD clientBDD = new SpectacleBDD();
		clientBDD.connexion();
		clientBDD.createStatement();		
		try {
			clientBDD.getStnt().executeQuery("SELECT * FROM Client");
			
			while(clientBDD.getRset().next()) {
				String emailBDD = clientBDD.getRset().getString("email");
				String mdpBDD = clientBDD.getRset().getString("motDePasse");
				System.out.println("***"+emailBDD+" "+mdpBDD);
				System.out.println("***"+email+" "+mdp);
				if(emailBDD.equalsIgnoreCase(email) && mdpBDD.equals(mdp)) {
					connexionClient = "true";
					idClient = clientBDD.getRset().getString("idClient");
					nomClient = clientBDD.getRset().getString("nom");
					prenomClient = clientBDD.getRset().getString("prenom");
					System.out.println("ok");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		clientBDD.fermetureStatement();
		clientBDD.fermetureConnexion();
		
		
		HttpSession session = request.getSession();
		
		if(connexionClient.equals("true")) {
			session = request.getSession();
			session.setAttribute("connexionClient", connexionClient);
			session.setAttribute("idClient", idClient);
			session.setAttribute("nomClient", nomClient);
			session.setAttribute("prenomClient", prenomClient);
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		} else {			
			session.setAttribute("connexionClient", connexionClient);
			RequestDispatcher disp = request.getRequestDispatcher("connexion.jsp");
			disp.forward(request, response);
		}
		
	}

}
