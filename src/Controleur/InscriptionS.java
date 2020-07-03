package Controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConnexionDB.Connexion;
import Metier.ArticleDao;
import Metier.InscriptionForm;
import Model.Utilisateur;

public class InscriptionS extends HttpServlet{
	InscriptionForm inscription;
    Connexion connect;
  
    
	@Override
	public void init() throws ServletException {
		inscription=new InscriptionForm();
		connect=new Connexion();	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		    //request.setAttribute("InscriptionForm",new InscriptionForm());
		    String email = request.getParameter("email");
	        String motDePasse = request.getParameter("mdp");
	        String confirmation = request.getParameter("Cmdp");
	        String nom = request.getParameter("nom");
	      
	        
	    
	      Utilisateur user=inscription.inscrireUtilisateur(request);
	      //request.setAttribute("InscriptionForm",inscription);
	      request.setAttribute("erreur",inscription.getErreurs());
	
	     
	      if(user != null){
	    	  System.out.println("different de null");
	    	  int i=0;
	    	  try {
				i=connect.emailExist(user);}
			catch (SQLException e) {
				e.printStackTrace();} 
	    	  
	    	  if(i>0 &&  inscription.getChampsCorrect()==true){
	    		  System.out.println("hehoo");
	    		  LivreS.RemplirCatalogue(request);
		    	  request.getRequestDispatcher("Catalogue.jsp").include(request, response);
		      }
		      else if(i==0) {
		    	  request.setAttribute("emailExist","email existe deja , Veuillez le changer");
		    	  request.getRequestDispatcher("Inscription.jsp").include(request, response);
		      }
		     
	      }
	      
	     
	     
	      
	     /* 
	      /*InscriptionForm form=(InscriptionForm) request.getAttribute("InscriptionForm");
	      Map<String, String> erreur=(Map<String, String>) request.getAttribute("erreur");
	      out.println(form.getErreurs().get(email));*/
	  
	      else { request.getRequestDispatcher("Inscription.jsp").include(request, response);}
	}
    
	

}



