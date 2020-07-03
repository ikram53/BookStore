package Controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.ArticleDao;
import Model.Articles;

public class PanierS extends HttpServlet{
    private ArrayList<Articles> panierArticle;
	
	
	@Override
	public void init() throws ServletException {
		panierArticle=new ArrayList<Articles>();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		Articles articleChoisi=(Articles) ArticleDao.findArticle(id);
		panierArticle.add(articleChoisi);
		session.setAttribute("articlesChoisi", panierArticle);
		LivreS.RemplirCatalogue(request);
		request.getRequestDispatcher("Catalogue.jsp").forward(request, response);
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
