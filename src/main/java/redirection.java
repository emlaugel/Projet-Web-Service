

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bdd.Base;

public class redirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String parametre, valeur;
	private Base b;
    public redirection() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parametre = request.getParameter("parametre");
		valeur = request.getParameter("valeur");
		
		request.setAttribute("valeur", valeur);
		
		if (valeur.equals("produit"))
		{
			request.setAttribute("URL", "produits");
			b.delProduit(parametre);
		}
		/*
		else if (valeur.equals("genre"))
		{
			request.setAttribute("URL", "genres");
			b.delGenre(parametre);
		}*/
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/redirection.jsp").forward(request, response);
	}

}
