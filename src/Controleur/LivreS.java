package Controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.ArticleDao;
import Model.Articles;

public class LivreS extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RemplirCatalogue(request);
		getServletContext().getRequestDispatcher("/Catalogue.jsp").forward(request, response);
   
	}	
	public static void RemplirCatalogue(HttpServletRequest request) {
		ArrayList<Articles> articles=ArticleDao.findAll();
		HttpSession session=request.getSession();
		request.setAttribute("articles",articles);
	}

}
