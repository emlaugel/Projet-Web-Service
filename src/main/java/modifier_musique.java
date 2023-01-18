

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class modifier_musique extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String parametre;
	
    public modifier_musique() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String album = request.getParameter("album");		
		String duree = request.getParameter("duree");
		String sortie = request.getParameter("sortie");		
		
		String[] artistesLiStrings = request.getParameterValues("artistes[]");
		String resultat_artiste = "";
		if (artistesLiStrings != null) {
			for (String string : artistesLiStrings)
			{
				if (!StringUtils.isEmptyOrWhitespaceOnly(string)) {
					resultat_artiste = resultat_artiste  + string + "=";
				}
			}
		}
		
		String[] genres_musicaux = request.getParameterValues("genres_musicaux[]");
		String resultat_genre = "";
		if (genres_musicaux != null) {
			for (String string : genres_musicaux)
			{
				if (!StringUtils.isEmptyOrWhitespaceOnly(string)) {
					resultat_genre = resultat_genre  + string + "=";
				}
			}
		}
		
		String lyrics = request.getParameter("lyrics");
		
		b.delMusique(parametre);
		b.addMusique(nom, album, duree, sortie, resultat_artiste, resultat_genre, lyrics);
		
		
		response.sendRedirect("musique?parametre=" + nom);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parametre = request.getParameter("parametre");		
		
		List<String> artistes = b.recupererArtistes();
		request.setAttribute("artistes", artistes);
		
		List<String> genres = b.recupererGenres();
		request.setAttribute("genres", genres);
		
		request.setAttribute("nom", parametre);

		List<String> infos = b.infoMusique(parametre);
		String album = infos.get(0);
		String duree = infos.get(1);
		String sortie = infos.get(2);
		String artiste = infos.get(3);

		String lyrics = infos.get(5);
		
		request.setAttribute("album", album);
		request.setAttribute("duree", duree);
		request.setAttribute("sortie", sortie);
		request.setAttribute("artiste", artiste);

		request.setAttribute("lyrics", lyrics);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_musique.jsp").forward(request, response);		
	}

}
