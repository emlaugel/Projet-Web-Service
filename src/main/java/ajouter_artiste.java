

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.mysql.cj.util.StringUtils;

import bdd.Base;

public class ajouter_artiste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Base b;
	private String nom_alternatif, nom_reel, type, nationalite, sexe, naissance, status, debut, biographie;
	
	
    public ajouter_artiste() {
        super();
        b = new Base();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.createdatabase();
		
		List<String> genres = b.recupererGenres();
		request.setAttribute("genres", genres);
		
		nom_alternatif = request.getParameter("nom_alternatif");
		nom_reel = request.getParameter("nom_reel");
		type = request.getParameter("type");
		nationalite = request.getParameter("nationalite");
		sexe = request.getParameter("sexe");
		naissance = request.getParameter("naissance");
		status = request.getParameter("status");
		debut = request.getParameter("debut");
		
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

		biographie = request.getParameter("biographie");
		
		if (StringUtils.isEmptyOrWhitespaceOnly(nom_alternatif)) {
			nom_alternatif = null;
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_artiste.jsp").forward(request, response);

			}
		
		else {
			response.setContentType("text/html");  
			PrintWriter pw = response.getWriter();  
			  
			response.sendRedirect("artiste?parametre=" + nom_alternatif);  
			  
			pw.close();  
			b.addArtiste(nom_alternatif, nom_reel, type, nationalite, sexe, naissance, status, debut, resultat, biographie);
		}
	}
}
