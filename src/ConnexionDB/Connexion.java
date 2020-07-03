package ConnexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import Model.Utilisateur;

public class Connexion extends HttpServlet{
	
	private  Connection connexion=null;
	private   Statement stat=null;
	private ResultSet rs=null;


		public  Connection getConnexion() {
		return connexion;
		
	}

	  public  void setConnexion(Connection connexion) {
		connexion = connexion;
	}

		public  Connexion(){
			 try {
			      Class.forName( "com.mysql.cj.jdbc.Driver" );
			  } catch ( ClassNotFoundException e ) {
				 
			     
			  }
			
			  String url = "jdbc:mysql://localhost:3306/e-commerce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			  String utilisateur = "ikram";
			  String motDePasse = "ikram123";
			 
			  try {
			      connexion = DriverManager.getConnection( url, utilisateur, motDePasse );    
	              stat=connexion.createStatement();	
	            
	        } catch (Exception ex) {
	             ex.printStackTrace();
	            
	        }
	System.out.println("fin");
	        
	    }
		
	    
	    public int emailExist(Utilisateur user) throws SQLException {
	    	  
	    	  int i=0;
	          String email=user.getEmail();
	          String nom=user.getNom();
	          String mdp=user.getMotPasse();
			  String sql_1 = "SELECT * FROM clients WHERE email_client='"+email+"'";
	          String user_1 = null;
	       
	         ResultSet rs=stat.executeQuery(sql_1);
	              while(rs.next()){
	                  user_1 = rs.getString("email_client");   
	              }
	              if(user_1 == null){
	                String sql = "INSERT INTO clients(email_client,nom_client,motPasse)VALUES('"+email+"','"+nom+"','"+mdp+"')";
	                i= stat.executeUpdate(sql);
	              }          
	         return i;
	    }
	    
	    
	    
	    public Boolean authentification(String user,String pass) throws SQLException {
	            boolean var=false;  
	            String sql="SELECT email_client,motPasse FROM clients WHERE email_client='"+user+"' AND motPasse='"+pass+"'";
	            rs = stat.executeQuery(sql);
	            var = rs.next();
	            return var;
	        }
	    
		public  Statement getStat() {
			return stat;
		}

		public  void setStat(Statement stat) {
			this.stat = stat;
		}

		 

	}


