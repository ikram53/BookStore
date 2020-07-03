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

public class VisualiserPanierS extends HttpServlet{
	ArrayList<Articles> panierArticle;
	
	

	@Override
	public void init() throws ServletException {
		panierArticle=new ArrayList<Articles>();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		Articles articleChoisi=ArticleDao.findArticle(id);
		panierArticle.add(articleChoisi);
		session.setAttribute("panierChoisi",panierArticle);
		request.getRequestDispatcher("Panier.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
