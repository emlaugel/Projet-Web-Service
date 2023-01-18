

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class modifier_artiste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String parametre;
	
    public modifier_artiste() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nom_alternatif = request.getParameter("nom_alternatif");		
		String nom_reel = request.getParameter("nom_reel");
		String type = request.getParameter("type");
		String nationalite = request.getParameter("nationalite");
		String sexe = request.getParameter("sexe");
		String naissance = request.getParameter("naissance");
		String status = request.getParameter("status");
		String debut = request.getParameter("debut");

		String[] genres_musicaux = request.getParameterValues("genres_musicaux[]");
		String resultat = "";
		if (genres_musicaux != null) {
			for (String string : genres_musicaux)
			{
				if (!StringUtils.isEmptyOrWhitespaceOnly(string)) {
					resultat = resultat  + string + "=";
				}
			}
		}
		
		String biographie = request.getParameter("biographie");
		
		String T1 = parametre + nom_alternatif + nom_reel + type + nationalite + sexe + naissance + status + debut + genres_musicaux + biographie;
		request.setAttribute("T1", T1);
		
		b.delArtiste(parametre);
		b.addArtiste(nom_alternatif, nom_reel, type, nationalite, sexe, naissance, status, debut, resultat, biographie);
		
		
		response.sendRedirect("artiste?parametre=" + nom_alternatif);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parametre = request.getParameter("parametre");		
		
		request.setAttribute("nom_alternatif", parametre);

		List<String> genres = b.recupererGenres();
		request.setAttribute("genres", genres);
		
		List<String> infos = b.infoArtiste(parametre);
		
		String nom_reel = infos.get(0);
		String type = infos.get(1);
		String nationalite = infos.get(2);
		String sexe = infos.get(3);
		String naissance = infos.get(4);
		String status = infos.get(5);
		String debut = infos.get(6);

		String biographie = infos.get(8);
		
		
		request.setAttribute("nom_reel", nom_reel);
		request.setAttribute("type", type);
		request.setAttribute("nationalite", nationalite);
		request.setAttribute("sexe", sexe);
		request.setAttribute("naissance", naissance);
		request.setAttribute("status", status);
		request.setAttribute("debut", debut);

		request.setAttribute("biographie", biographie);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_artiste.jsp").forward(request, response);		
	}
}
