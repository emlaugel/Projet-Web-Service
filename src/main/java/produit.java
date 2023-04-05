

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import bdd.Base;

public class produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base b;
	
    public produit() {
        super();
		b = new Base();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();
		String nom = request.getParameter("parametre");
		
		List<String> not_found_testList = b.recupererProduits(); 
		
		if (not_found_testList.contains(nom))
		{
		
			List<String> infos = b.infoProduit(nom);
			
			String prix = infos.get(0);
			String type = infos.get(1);
			String contenance = infos.get(2);
			String marque = infos.get(3);
			String couleur = infos.get(4);
			String support = infos.get(5);
			
			// List<String> genreList = Arrays.asList(genres_musicaux.split("="));			
			
			request.setAttribute("nom", nom);
			request.setAttribute("prix", prix);
			request.setAttribute("type", type);
			request.setAttribute("contenance", contenance);
			request.setAttribute("marque", marque);
			request.setAttribute("couleur", couleur);
			request.setAttribute("support", support);
	
			String resultat = request.getParameter("supprimer");
			
			request.setAttribute("T1", resultat);
			
			if (resultat == "Oui")
			{
				b.delProduit(nom);
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("not_found");	
		}
	}
}
