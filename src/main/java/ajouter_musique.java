

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class ajouter_musique extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private Base b;
	
    public ajouter_musique() {
        super();
        b = new Base();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();
		
		List<String> artistes = b.recupererArtistes();
		request.setAttribute("artistes", artistes);

		List<String> genres = b.recupererGenres();
		request.setAttribute("genres", genres);
		
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
			
		if (StringUtils.isEmptyOrWhitespaceOnly(nom)) {
			nom = null;
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_musique.jsp").forward(request, response);
		}
		else {
			response.setContentType("text/html");  
			PrintWriter pw = response.getWriter();  
			  
			response.sendRedirect("musiques");  
			  
			pw.close(); 
			
			b.addMusique(nom, album, duree, sortie, resultat_artiste, resultat_genre, lyrics);
		}		
	}
}
