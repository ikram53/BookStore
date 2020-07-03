package Metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Model.Utilisateur;

public class InscriptionForm {
	
	private Boolean champsCorrect=true;
	
	public void setChampsCorrect(Boolean champsCorrect) {
		this.champsCorrect = champsCorrect;
	}

  
    private Utilisateur utilisateur;
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
   
   public Utilisateur getUtilisateur() {
		return utilisateur;
	 }

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}



	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}


	private void validationEmail( String email ) throws Exception {
		String regex = "^(.+)@(.+)$";
	    if ( email != null ) {
	        if ( !email.matches( regex ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	

	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
	    if (motDePasse != null && confirmation != null ) {
	        if (!motDePasse.equals(confirmation)) {
	            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
	        } else if (motDePasse.trim().length() < 5) {
	            throw new Exception("Les mots de passe doivent contenir au moins 5 caractères.");
	        }
	    } else {
	        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	    }
	}
	
	
	private void validationNom( String nom ) throws Exception {
	    if (nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	   }
	}
	
	
	private void setErreur(String champ, String message ) {
	    erreurs.put(champ, message);
	}
	
	


	public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
		 System.out.println("form-1");
		erreurs.clear(); 
	    try {
	        validationEmail(request.getParameter("email"));
	        
	    } catch (Exception e) {
	        setErreur("email", e.getMessage() ); 
	    }
	   

	    try {
	        validationMotsDePasse(request.getParameter("mdp"), request.getParameter("Cmdp") );
	    } catch (Exception e) {
	        setErreur("mdp", e.getMessage() );
	        setErreur("cmdp", null );    
	    }
	   
	    try {
	        validationNom( request.getParameter("nom"));
	    } catch ( Exception e ) {
	        setErreur("nom", e.getMessage() );
	    }
	   

	    if ( erreurs.isEmpty() ) {
	        resultat = "Succès de l'inscription.";
	    } else {
	        resultat = "Échec de l'inscription.";
	        champsCorrect=false;
	    }
	    
	   if(champsCorrect==true) { 
       utilisateur=new Utilisateur(request.getParameter("email"),request.getParameter("mdp"),request.getParameter("nom"));
	   }
	   
       return utilisateur;
	}

	public boolean getChampsCorrect() {
	
		return champsCorrect;
	}
	
	
}



