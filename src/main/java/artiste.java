

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import bdd.Base;

public class artiste extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base b;
	
    public artiste() {
        super();
		b = new Base();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();
		String nom_alternatif = request.getParameter("parametre");
		
		List<String> not_found_testList = b.recupererArtistes(); 
		
		if (not_found_testList.contains(nom_alternatif))
		{
		
			List<String> infos = b.infoArtiste(nom_alternatif);
			
			String nom_reel = infos.get(0);
			String type = infos.get(1);
			String nationalite = infos.get(2);
			String sexe = infos.get(3);
			String naissance = infos.get(4);
			String status = infos.get(5);
			String debut = infos.get(6);
			String genres_musicaux = infos.get(7); 
			List<String> genreList = Arrays.asList(genres_musicaux.split("="));
			
			String biographie = infos.get(8);
			
			
			request.setAttribute("nom_alternatif", nom_alternatif);
			request.setAttribute("nom_reel", nom_reel);
			request.setAttribute("type", type);
			request.setAttribute("nationalite", nationalite);
			request.setAttribute("sexe", sexe);
			request.setAttribute("naissance", naissance);
			request.setAttribute("status", status);
			request.setAttribute("debut", debut);
			request.setAttribute("genres", genreList);
			request.setAttribute("biographie", biographie);
			
	
			String resultat = request.getParameter("supprimer");
			
			request.setAttribute("T1", resultat);
			
			if (resultat == "Oui")
			{
				b.delArtiste(nom_alternatif);
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/artiste.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("not_found");	
		}
	}
}
