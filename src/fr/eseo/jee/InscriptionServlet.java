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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(name = "Inscription", urlPatterns = { "/Inscription" })
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
    }
    	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String email = (String) request.getParameter("email");
		String mdp = (String) request.getParameter("password");
		String adresse = (String) request.getParameter("adresse");
		
		boolean trouverClient = false;
		
		
		SpectacleBDD clientBDD = new SpectacleBDD();
		clientBDD.connexion();
		clientBDD.createStatement();		
		try {
			clientBDD.getStnt().executeQuery("SELECT * FROM Client");			
			
			while(clientBDD.getRset().next()) {
				String nomBDD = clientBDD.getRset().getString("nom");
				String prenomBDD = clientBDD.getRset().getString("prenom");
				String emailBDD = clientBDD.getRset().getString("email");
				if(nomBDD.equalsIgnoreCase(nom) && prenomBDD.equalsIgnoreCase(prenom) && emailBDD.equalsIgnoreCase(email)) {
					trouverClient = true;
					System.out.println("trouver");
				}
			}
			
			if(!trouverClient) {
				System.out.println("INSERT INTO Client(nom, prenom, email, motDePasse, adresse) VALUES ('"+nom+"','"+prenom+"','"+email+"','"+mdp+"','"+adresse+"')");
				clientBDD.getStnt().executeUpdate("INSERT INTO Client(nom, prenom, email, motDePasse, adresse) VALUES ('"+nom+"','"+prenom+"','"+email+"','"+mdp+"','"+adresse+"')");
				session.setAttribute("inscriptionClient", "true");
			}else if(trouverClient) {
				session.setAttribute("inscriptionClient", "Present");
			} else {
				session.setAttribute("inscriptionClient", "false");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		clientBDD.fermetureStatement();
		clientBDD.fermetureConnexion();
		
		
		RequestDispatcher disp = request.getRequestDispatcher("inscription.jsp");
		disp.forward(request, response);
	
	}

}
