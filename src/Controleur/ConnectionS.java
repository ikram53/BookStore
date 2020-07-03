package Controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnexionDB.Connexion;

public class ConnectionS extends HttpServlet{
	Connexion connect;
	@Override
	public void init() throws ServletException {
		connect=new Connexion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login=request.getParameter("login");
		String mdp=request.getParameter("mdp");
		
		 try {
			if(!connect.authentification(login,mdp)){
			     request.setAttribute("MdpErrone","Mot de Passe ou Login est incorrect");
			     request.getRequestDispatcher("Connexion.jsp").forward(request, response);
			 }
			 else{
			     HttpSession session=request.getSession();  
			     session.setAttribute("login",login);
			     session.setAttribute("login",mdp);
			 
			     response.sendRedirect("/SiteVenteLivre/acceuil");
			     
			     
			 }
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}         
        }
        
	
}
