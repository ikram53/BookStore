package Metier;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnexionDB.Connexion;
import Model.Articles;

public class ArticleDao {
	static ArrayList<String> url=new ArrayList<String>();
	Articles article=new Articles();
	
	 public static ArrayList<Articles> findAll()
	    {
	        String req = "SELECT* " + " FROM articles ";
	        Connexion conn=new Connexion();
	        Articles article=new Articles();
	        ArrayList<Articles> list=new ArrayList<Articles>();

	        try
	        {
	            Statement st = conn.getStat();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next()) {

	                article= new Articles(rs.getInt(1), rs.getDouble(2), rs.getString(3),
	                        rs.getString(4), rs.getString(5));
                    url.add(rs.getString(3));
	                list.add(article);
	        }
	        }
	          
	         catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        for(int i=0;i<url.size();i++) {
	        	   System.out.println(url.get(i));
	           }
	        return list;

	    }

	 public static Articles findArticle(int i)
	    {
	        String req = "SELECT * " + " FROM articles where id='"+i+"'" ;
	        Connexion conn=new Connexion();
	        Articles article=new Articles();
	       

	        try
	        {
	            Statement st = conn.getStat();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next()) {

	                article= new Articles(rs.getInt(1), rs.getDouble(2), rs.getString(3),
	                        rs.getString(4), rs.getString(5));
              
	                
	        }
	        }
	          
	         catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	       
	        return article;

	    }

	

	public static void setUrl(ArrayList<String> url) {
		ArticleDao.url = url;
	}

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	public static ArrayList<String> getUrl() {
		
		return url;
	}
}


